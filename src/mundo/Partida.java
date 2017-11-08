package mundo;

public class Partida {
	private NaveEnemiga primera;
	private NaveUsuario nave;
	private int anchoPanel;
	private int altoPanel;
	private long esperaHiloNavesEnemigas;
	
	public Partida (int anchoPanel, int altoPanel){
		this.anchoPanel = anchoPanel;
		this.altoPanel = altoPanel;
		nave = new NaveUsuario((anchoPanel/2) - 35, altoPanel - 70, "./data/imagenes/Nave_Aliada.png", 70, 70);
		inicializarNaves();
		esperaHiloNavesEnemigas = 1000;
	}
	
	public long getEsperaHiloNavesEnemigas() {
		return esperaHiloNavesEnemigas;
	}

	public void setEsperaHiloNavesEnemigas(long esperaHiloNavesEnemigas) {
		this.esperaHiloNavesEnemigas = esperaHiloNavesEnemigas;
	}

	public void agregarNave(NaveEnemiga n){
		if (primera == null){
			primera = n;
		} else {
			NaveEnemiga actual = primera;
			while (actual.getSiguiente() != null){
				actual = actual.getSiguiente();
			}
			actual.setSiguiente(n);
		}
	}
	
	public void inicializarNaves (){
		for (int i = 0; i < 5; i++){
			NaveEscudo n =  new NaveEscudo(i*52 + 20, 55, "./data/imagenes/Imagen_NaveEnemiga.png", 52, 55, false, NaveEnemiga.DERECHA);
			agregarNave (n);
		}
		for (int i = 0; i < 5; i++){
			NaveNormal n = new NaveNormal(i*52 + 20, 5, "./data/imagenes/space.png", 52, 55, false, NaveEnemiga.DERECHA);
			agregarNave (n);
		}
	}
	
	public void moverNaves(){
		NaveEnemiga actual = primera;
		while (actual != null){
			actual.mover(NaveEnemiga.MOVIMIENTO, 0, altoPanel, anchoPanel);
			actual = actual.getSiguiente();
		}
	}
	
	public void dispararNaveAliada(){
		nave.disparar();
	}
	
	public void detenerDisparoAliado(){
		nave.detenerDisparo();
	}
	
	public boolean continuar(){
		boolean continuar = false;
		NaveEnemiga  actual = primera;
		while(actual!=null && !continuar){
			continuar = !actual.isEliminada();
			actual = actual.getSiguiente();
		}
		return continuar;
	}
	
	public void moverDisparo (){
		nave.getDisparo().mover(0, Disparo.MOVIMIENTO_DISPARO, altoPanel, anchoPanel);
		
		NaveEnemiga actual = primera;
		
		while(actual!=null && nave.isDisparando()){
			
			if(!actual.isEliminada()){
				
				int x1 = nave.getDisparo().getPosX();
				int y1 = nave.getDisparo().getPosY();		
				
				if(actual.recibioDisparo(x1, x1+Disparo.ANCHO_MISILES, y1, y1+Disparo.ALTO_MISILES)){
					actual.setEliminada(true);
					nave.detenerDisparo();
				}
			}
			actual = actual.getSiguiente();
		}
		
		if (nave.isDisparando() && (nave.getDisparo().getPosY() == 0 || nave.getDisparo().getPosY() + Disparo.ALTO_MISILES == altoPanel)){
			nave.detenerDisparo();
		}
	}
	
	
	
	
	
	public void empezarMovimientoNave(){
		nave.setEnMovimiento(true);
	}
	
	public void detenerNave(){
		nave.setEnMovimiento(false);
	}
	
	public void moverNaveUsuarioDerecha (){
		nave.mover(NaveUsuario.MOVIMIENTO, 0, altoPanel, anchoPanel);
	}
	
	public void moverNaveUsuarioIzquierda (){
		nave.mover(-NaveUsuario.MOVIMIENTO, 0, altoPanel, anchoPanel);
	}

	public NaveUsuario getNave() {
		return nave;
	}

	public void setNave(NaveUsuario nave) {
		this.nave = nave;
	}

	public NaveEnemiga getPrimera() {
		return primera;
	}

	public void setPrimera(NaveEnemiga primera) {
		this.primera = primera;
	}

	public int getAnchoPanel() {
		return anchoPanel;
	}

	public void setAnchoPanel(int anchoPanel) {
		this.anchoPanel = anchoPanel;
	}

	public int getAltoPanel() {
		return altoPanel;
	}

	public void setAltoPanel(int altoPanel) {
		this.altoPanel = altoPanel;
	}
	
	
}

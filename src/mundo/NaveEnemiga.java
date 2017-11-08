package mundo;

public abstract class NaveEnemiga extends Nave{
	public final static int MOVIMIENTO = 50;
	private boolean eliminada;
	private char direccion;
	private NaveEnemiga siguiente;
	
	
	
	public NaveEnemiga(int posX, int posY, String rutaImagen, int largo, int alto, boolean eliminada, char direccion) {
		super(posX, posY, rutaImagen, largo, alto);
		this.eliminada = eliminada;
		this.direccion = direccion;
	}


	public boolean isEliminada() {
		return eliminada;
	}


	public void setEliminada(boolean eliminada) {
		this.eliminada = eliminada;
	}
	
	public void moverAleatoriamente(){
		//TODO
	}
	
	@Override
	public void mover (int x, int y, int altoPanel, int anchoPanel){
		switch (direccion){
		case DERECHA:
			super.mover(x, 0, 0, 0);
			break;
		case IZQUIERDA:
			super.mover(-x, 0, 0, 0);
			break;
		}
		validarMovimiento(altoPanel, anchoPanel);
	}
	

	public void validarMovimiento (int alto, int ancho){
		if (getPosX() + getLargo() > ancho){
			direccion = IZQUIERDA;
			super.mover(-MOVIMIENTO, MOVIMIENTO, 0, 0);
		} else if (getPosX() < 0){
			direccion = DERECHA;
			super.mover(MOVIMIENTO, MOVIMIENTO, 0, 0);
		}
	}
	
	public void setSiguiente (NaveEnemiga n){
		siguiente = n;
	}
	
	public NaveEnemiga getSiguiente(){
		return siguiente;
	}
	
	
	
	
	

}

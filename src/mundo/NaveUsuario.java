package mundo;

public  class NaveUsuario extends Nave implements Disparador{
	public final static int MOVIMIENTO = 1;
	public final static int ESPERA_HILO = 5;
	
	private boolean enMovimiento;
	private boolean disparando;
	private Disparo disparo;
	
	public NaveUsuario(int posX, int posY, String rutaImagen, int largo, int ancho) {
		super(posX, posY, rutaImagen, largo, ancho);
		enMovimiento = false;
		disparando = false;
		disparo = null;
	}

	public boolean isEnMovimiento() {
		return enMovimiento;
	}

	public void setEnMovimiento(boolean enMovimiento) {
		this.enMovimiento = enMovimiento;
	}

	@Override
	public void mover(int x, int y, int altoPanel, int anchoPanel) {
		if ((getPosX() > 0 && x < 0) || (getPosX() + getLargo() < anchoPanel  && x > 0)){
			super.mover(x, 0, altoPanel, anchoPanel);
		}
	}

	@Override
	public void disparar() {
		disparando = true;
		disparo = new Disparo((2*getPosX() + getLargo())/2, getPosY(), Disparo.DISPARO_ALIADO);
	}
	
	public void detenerDisparo(){
		disparando = false;
		disparo = null;
	}

	public boolean isDisparando() {
		return disparando;
	}

	public void setDisparando(boolean disparando) {
		this.disparando = disparando;
	}

	public Disparo getDisparo() {
		return disparo;
	}

	public void setDisparo(Disparo disparo) {
		this.disparo = disparo;
	}
	
}

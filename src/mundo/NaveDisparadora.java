package mundo;

public class NaveDisparadora extends NaveEnemiga implements Disparador{

	public NaveDisparadora(int posX, int posY, String rutaImagen, int largo, int ancho, boolean eliminada, char direccion) {
		super(posX, posY, rutaImagen, largo, ancho, eliminada, direccion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean recibioDisparo (int x1, int x2, int y1, int y2){
		boolean recibio = super.recibioDisparo(x1, x2, y1, y2);
		if (recibio){
			setEliminada(true);
		}
		return recibio;
	}

}

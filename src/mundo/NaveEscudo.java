package mundo;

public class NaveEscudo extends NaveEnemiga{
	private int disparosRecibidos;
	
	public NaveEscudo(int posX, int posY, String rutaImagen, int largo, int ancho, boolean eliminada, char direccion) {
		super(posX, posY, rutaImagen, largo, ancho, eliminada, direccion);
		disparosRecibidos = 0;
	}
	
	@Override
	public boolean recibioDisparo(int x1, int x2, int y1, int y2){
		boolean recibio = super.recibioDisparo(x1, x2, y1, y2);
		if (recibio){
			if (disparosRecibidos == 0){
				disparosRecibidos++;
			} else {
				setEliminada(true);
			}
		}
		return recibio;
	}
	
	
	
}

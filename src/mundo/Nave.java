package mundo;

public abstract class Nave implements Movimiento{
	public final static char DERECHA = 'D';
	public final static char IZQUIERDA = 'I';
	
	int posX;
	int posY;
	int largo;
	int alto;
	String rutaImagen;
	
	public Nave (int posX, int posY, String rutaImagen, int largo, int alto)  {
		this.posX = posX;
		this.posY = posY;
		this.rutaImagen = rutaImagen;
		this.largo = largo;
		this.alto = alto;
	}
	
	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	public boolean recibioDisparo(int x1, int x2, int y1, int y2){
		boolean recibio = false;
		recibio = ((y1 <= posY + largo && y1 >= posY) || (y2 <= posY + largo && y2 >= posY)) &&
				((x1 >= posX && x1 <= posX + largo) || (x2 >= posX && x2 <= posX + largo));
		
		return recibio;
	}
	
	@Override
	public void mover (int x, int y, int altoPanel, int anchoPanel){
		posX += x;
		posY += y;
	}
		
	
}

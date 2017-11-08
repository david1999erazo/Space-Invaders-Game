package mundo;

import java.awt.Color;

public class Disparo implements Movimiento{
	public final static int MOVIMIENTO_DISPARO = 1;
	public final static char DISPARO_ENEMIGO = 'e';
	public final static char DISPARO_ALIADO = 'a';
	public final static int ALTO_MISILES = 30;
	public final static int ANCHO_MISILES = 10;
	
	private int posX;
	private int posY;
	private char tipoDisparo;
	private Color color;
	
	
	public Disparo (int x, int y, char tipoDisparo){
		posX = x;
		posY = y;
		this.tipoDisparo = tipoDisparo;
		if (tipoDisparo == DISPARO_ALIADO){
			color = Color.GREEN;
		} else {
			color = Color.RED;
		}
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


	public char getTipoDisparo() {
		return tipoDisparo;
	}


	public void setTipoDisparo(char tipoDisparo) {
		this.tipoDisparo = tipoDisparo;
	}


	@Override
	public void mover(int x, int y, int altoPanel, int anchoPanel){
		if (tipoDisparo == DISPARO_ALIADO){
			posY -= y;
		} else {
			posY += y;
		}
		
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}
	
	
}

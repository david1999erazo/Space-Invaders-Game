package mundo;

import java.util.Date;

public class Puntaje {
	private Jugador jugador;
	private int puntos;
	private Date fecha;
	public Puntaje (Jugador jugador, int puntos){
		this.jugador = jugador;
		this.puntos = puntos;
		fecha = new Date();
	}
	
	public int comparPuntos (Puntaje p){
		int retorno = 0;
		if (p == null){
			retorno = 1;
		} else {
			retorno = puntos - p.puntos;
		}
		return retorno;
	}
	
	public int compararNombre (Puntaje p){
		int retorno = 0;
		if (p == null){
			retorno = -1;
		} else {
			retorno = jugador.getNombre().compareToIgnoreCase(p.jugador.getNombre());
		}
		
		return retorno;
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getNombreJugador(){
		return jugador.getNombre();
	}

	
	
}

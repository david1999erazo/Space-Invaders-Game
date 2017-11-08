package mundo;

public class NoEstaEnMejoresPuntajesException extends Exception{
	
	public NoEstaEnMejoresPuntajesException(String nombreJugador){
		super("El jugador " + nombreJugador + " no tiene ning�n puntaje dentro del top "
				+ MenuPrincipal.TOP_PUNTAJES);
	}
}

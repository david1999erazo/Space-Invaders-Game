package hilos;

import interfaz.interfazInicio;
import mundo.Partida;

public class HiloDisparoEnemigo implements Runnable{

	private Partida partida;
	private interfazInicio ventana;
	
	public HiloDisparoEnemigo(Partida p, interfazInicio v) {
		partida = p;
		ventana = v;
	}
	
	
	@Override
	public void run() {
		
		
		
		
	}

}

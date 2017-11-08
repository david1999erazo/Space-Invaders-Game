package hilos;

import interfaz.interfazInicio;
import mundo.Partida;


public class HiloMoverDisparo implements Runnable{
	private interfazInicio ventana;
	private Partida partida;
	
	public HiloMoverDisparo (interfazInicio v, Partida p){
		ventana = v;
		partida = p;
	}
	
	
	@Override
	public void run() {
		while (partida.getNave().isDisparando()){
			partida.moverDisparo();
			ventana.refrescarPanel();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}

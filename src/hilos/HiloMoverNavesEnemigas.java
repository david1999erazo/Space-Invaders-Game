package hilos;

import interfaz.interfazInicio;
import mundo.Partida;


public class HiloMoverNavesEnemigas implements Runnable{
	private Partida partida;
	private interfazInicio ventana;
	
	public HiloMoverNavesEnemigas (Partida p, interfazInicio v){
		partida = p;
		ventana = v;
	}
	
	
	@Override
	public void run() {
		while (partida.continuar()){
			partida.moverNaves();
			ventana.refrescarPanel();
			try {
				Thread.sleep(partida.getEsperaHiloNavesEnemigas());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}

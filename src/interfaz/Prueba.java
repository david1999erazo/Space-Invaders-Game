package interfaz;

import java.awt.Menu;

import mundo.Jugador;
import mundo.MenuPrincipal;
import mundo.NoEstaEnMejoresPuntajesException;
import mundo.Puntaje;

public class Prueba {

	public static void main(String[] args) {
		MenuPrincipal menu = new MenuPrincipal();
		menu.aņadirPuntaje(new Puntaje(new Jugador("Daniel", null), 312));
		menu.aņadirPuntaje(new Puntaje(new Jugador("Daniel", null), 9000));
		menu.aņadirPuntaje(new Puntaje(new Jugador("Victor", null), 912));
		menu.aņadirPuntaje(new Puntaje(new Jugador("Steven", null), 50000));
		menu.aņadirPuntaje(new Puntaje(new Jugador("Daniel", null), 3321));

			
			try {
				System.out.println(menu.generarReporte(menu.busquedaBinariaPuntajePorJugador("Victor")));
			} catch (NoEstaEnMejoresPuntajesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}

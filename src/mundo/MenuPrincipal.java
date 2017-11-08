package mundo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MenuPrincipal {
	public final static int TOP_PUNTAJES = 10;
	
	private Puntaje [] mejoresPuntajes;
	private Partida partida;
	
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public MenuPrincipal (){
		mejoresPuntajes = new Puntaje[TOP_PUNTAJES];
	}
	
	public void ordenarPuntajesPorPuntos(){
		for (int i = 0; i < TOP_PUNTAJES; i++){
			if (mejoresPuntajes [i] != null){
			for (int j = i; j > 0 && mejoresPuntajes [j].comparPuntos(mejoresPuntajes[j-1]) > 0; j--){
				Puntaje temp = mejoresPuntajes [j];
				mejoresPuntajes [j] = mejoresPuntajes [j-1];
				mejoresPuntajes [j-1] = temp;
				}
				
			}
		}
	}
	
	public void ordenarPuntajesPorPuntos(ArrayList <Puntaje> puntos){
		for (int i = 0; i < puntos.size(); i++){	
			for (int j = i; j > 0 && puntos.get(j).comparPuntos(puntos.get(j-1)) > 0; j--){
				Puntaje temp = puntos.get(j);
				puntos.set(j, puntos.get(j-1));
				puntos.set(j - 1, temp);
			}
		}
	}
	
	public void ordenarPuntajesPorNombre(){
		for (int i = 0; i < TOP_PUNTAJES; i++){
			if (mejoresPuntajes [i] != null){
				for (int j = i; j > 0 && mejoresPuntajes[j].compararNombre(mejoresPuntajes[j-1]) < 0; j--){
					Puntaje temp = mejoresPuntajes [j];
					mejoresPuntajes [j] = mejoresPuntajes [j-1];
					mejoresPuntajes [j-1] = temp;
				}
			}
		}
	}
	
	public String generarReporte (){
		String reporte = "N°		Nombre		Fecha			Puntaje \n";
		DateFormat formato = new SimpleDateFormat("dd - MM - yy");
		for (int i = 0; i < TOP_PUNTAJES && mejoresPuntajes[i] != null; i++){
			reporte += i + 1 + ".		" + mejoresPuntajes[i].getNombreJugador()
					+ "		" + formato.format(mejoresPuntajes[i].getFecha()) + "		" + 
					mejoresPuntajes[i].getPuntos() + "\n";
		}
		return reporte;
	}
	
	public String generarReporte (ArrayList <Puntaje> puntajes){
		ordenarPuntajesPorPuntos(puntajes);
		String reporte = "N°		Nombre		Fecha			Puntaje \n";
		DateFormat formato = new SimpleDateFormat("dd - MM - yy");
		for (int i = 0; i < puntajes.size(); i++){
			reporte += i + 1 + ".		" + puntajes.get(i).getNombreJugador()
					+ "		" + formato.format(puntajes.get(i).getFecha()) + "		" + 
					puntajes.get(i).getPuntos() + "\n";
		}
		return reporte;
	}
	
	public Puntaje[] getMejoresPuntajes() {
		return mejoresPuntajes;
	}

	public void setMejoresPuntajes(Puntaje[] mejoresPuntajes) {
		this.mejoresPuntajes = mejoresPuntajes;
	}

	public String generarReporteTopPuntosPorPuntos(){
		ordenarPuntajesPorPuntos();
		return generarReporte();
	}
	
	public String generarReportTopNombre (){
		ordenarPuntajesPorNombre();
		return generarReporte();
	}
	
	public void añadirPuntaje (Puntaje p){
		ordenarPuntajesPorPuntos();
		if (mejoresPuntajes[TOP_PUNTAJES - 1] == null || mejoresPuntajes[TOP_PUNTAJES - 1].getPuntos() < p.getPuntos()){
			mejoresPuntajes[TOP_PUNTAJES - 1] = p;
			ordenarPuntajesPorPuntos();
		}
	}
	
	public ArrayList <Puntaje> busquedaBinariaPuntajePorJugador(String nombreJugador) throws NoEstaEnMejoresPuntajesException{
		ordenarPuntajesPorNombre();
		boolean encontrado = false;
		ArrayList <Puntaje> puntajesJugador = new ArrayList<Puntaje>();
		int inicio = 0;
		int fin = TOP_PUNTAJES;
		int medio = 0;
		while (!encontrado && inicio <= fin){
			medio = (inicio + fin) / 2;
			if (mejoresPuntajes [medio] == null){
				fin = medio - 1;
			}else if (nombreJugador.equals(mejoresPuntajes[medio].getNombreJugador())){
				encontrado = true;
			} else if (nombreJugador.compareTo(mejoresPuntajes[medio].getNombreJugador()) < 0){
				fin = medio - 1;
			} else {
				inicio = medio + 1;
			}
		}
		if (!encontrado){
			throw new NoEstaEnMejoresPuntajesException(nombreJugador);
		}
		for (int i = medio; i < TOP_PUNTAJES && mejoresPuntajes[i] != null && mejoresPuntajes[i].getNombreJugador().equals(nombreJugador); i++){
			puntajesJugador.add(mejoresPuntajes[i]);
		}
		
		for (int i = medio - 1; i >= 0 && mejoresPuntajes[i] != null && mejoresPuntajes[i].getNombreJugador().equals(nombreJugador); i--){
			puntajesJugador.add(mejoresPuntajes [i]);
		}
		
		return puntajesJugador;
	}
	
	public void nuevaPartida (int anchoPanel, int altoPanel) {
		partida = new Partida(anchoPanel, altoPanel);
	}
	
}

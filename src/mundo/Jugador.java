package mundo;

public class Jugador {
	private String nombre;
	private String contrase�a;
	public Jugador (String nombre, String contrase�a){
		this.nombre = nombre;
		this.contrase�a = contrase�a;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContrase�a() {
		return contrase�a;
	}
	
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	
}

package mundo;

public class Jugador {
	private String nombre;
	private String contraseña;
	public Jugador (String nombre, String contraseña){
		this.nombre = nombre;
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
}

package interfaz;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInformacionJugador extends JPanel {

	private JLabel labNombre;
	private JLabel labEdad;
	private JLabel labPuntaje;
	private JLabel labFecha;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtPuntaje;
	private JTextField txtFecha;	
	
	
	
	public PanelInformacionJugador() {
		
			labNombre = new JLabel("Nombre: ");
		labEdad = new JLabel("Edad: ");
		labPuntaje = new JLabel("Puntaje: ");
		labFecha = new JLabel("Fecha: ");
		
		txtNombre = new JTextField();
		txtEdad = new JTextField();
		txtPuntaje = new JTextField();
		txtFecha = new JTextField();
		
		
		
	}
	
}


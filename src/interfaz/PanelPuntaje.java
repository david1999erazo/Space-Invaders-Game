package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelPuntaje extends JPanel {
	
	private JTextArea areaJugadores;
	private JButton butOrdenar;
	private JButton butBuscarBinario;
	
	private PanelInformacionJugador panelInformacion;
	private PanelBotones panelBotones;
	
	public PanelPuntaje() {

		
		panelInformacion = new PanelInformacionJugador();
		panelBotones = new PanelBotones();
		
		

		areaJugadores = new JTextArea();
		
	
		
		
		
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		

		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, 1280, 1000);
	
		
		Font font = new Font("OCR A Extended", Font.BOLD, 100);
		g2.setColor(Color.ORANGE);
		g2.setFont(font);
		g2.drawString("Puntaje", 100, 100);

		
		
	}
	
	
	
	
	
}

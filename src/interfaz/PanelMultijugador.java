package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelMultijugador extends JPanel {

	
	public PanelMultijugador() {
		

		
		
	}
	
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, 1280, 1000);
	
		
		Font font = new Font("OCR A Extended", Font.BOLD, 100);
		g2.setColor(Color.ORANGE);
		g2.setFont(font);
		g2.drawString("Multiplayer", 100, 100);
		
	}
	
	
	
}

package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import mundo.Disparo;
import mundo.NaveEnemiga;
import mundo.NaveUsuario;

public class PanelJugar extends JPanel {

	
	private interfazInicio principal;
	
	public PanelJugar(interfazInicio v) {
		
		principal = v;
		setLayout (new BorderLayout());
		setPreferredSize (new Dimension (500, 600));
		setBackground(Color.BLACK);
		
		
	}
	
	
	@Override
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		NaveEnemiga actual = principal.getPartida().getPrimera();
		while (actual != null){
			if(!actual.isEliminada()) {				
				ImageIcon icon = new ImageIcon(actual.getRutaImagen());
				g2.drawImage(icon.getImage(), actual.getPosX(), actual.getPosY(), null);
			}
			
			actual = actual.getSiguiente();
		}
		NaveUsuario nave = principal.getPartida().getNave();
		ImageIcon icon = new ImageIcon (nave.getRutaImagen());
		g2.drawImage(icon.getImage(), nave.getPosX(), nave.getPosY(), null);
		if (principal.getPartida().getNave().isDisparando()){
			g2.setColor(principal.getPartida().getNave().getDisparo().getColor());
			g2.fillRect(principal.getPartida().getNave().getDisparo().getPosX(), principal.getPartida().getNave().getDisparo().getPosY(), Disparo.ANCHO_MISILES, Disparo.ALTO_MISILES);
		}
		
	}
	
	
}

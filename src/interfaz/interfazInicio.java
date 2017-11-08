package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.PasswordAuthentication;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import hilos.HiloMoverDisparo;
import hilos.HiloMoverNaveUsuario;
import hilos.HiloMoverNavesEnemigas;
import mundo.MenuPrincipal;
import mundo.Nave;
import mundo.Partida;


public class interfazInicio extends JFrame implements KeyListener{

	private PanelMenuJuego panelInicio;
	private PanelPuntaje panelPuntaje;
	private PanelMultijugador panelMultijugador;
	private PanelLogin panelLogin;
	private PanelJugar panel;
	
	
	private MenuPrincipal menu;//Conexion con el mundo
	
	private JPanel auxiliar;
	
	public interfazInicio() {

		setTitle("Space Invaders");
		setSize(1280, 1000);
		setLocationRelativeTo(null);
		setResizable(false);
		
		panelInicio = new PanelMenuJuego(this);
		panelPuntaje = new PanelPuntaje();
		panelMultijugador = new PanelMultijugador();
		panelLogin = new PanelLogin();
		
		menu = new MenuPrincipal();
		
		setLayout(new BorderLayout());
		
		auxiliar = new JPanel();
		auxiliar.setLayout(new BorderLayout());
	
		auxiliar.setPreferredSize(new Dimension(1100, 900));
		auxiliar.add(panelInicio, BorderLayout.CENTER);
		add(auxiliar, BorderLayout.CENTER);
		
		
		
	}


	public void inicializarHiloNaves (){
		Thread hilo = new Thread(new HiloMoverNavesEnemigas(menu.getPartida(), this));
		hilo.start();
	}
	
	public Partida getPartida() {
		return menu.getPartida();
	}
	
	public PanelJugar getPanel() {
		return panel;
	}
	public void setPanel(PanelJugar panel) {
		this.panel = panel;
	}
	
	public void refrescarPanel(){
		panel.repaint();
	}

	
	
	public void cambiarPuntaje() {
		auxiliar.remove(0);
		auxiliar.add(panelPuntaje);
		pack();
	}
	
	public void cambiarMultiplayer() {
		auxiliar.remove(0);
		auxiliar.add(panelMultijugador);
		pack();
	}
	
	public void cambiarJugar() {
		
		auxiliar.remove(0);
		panel = new PanelJugar(this);
		auxiliar.add(panel);		
		addKeyListener (this);		
		pack();
		menu.nuevaPartida(panel.getWidth(), panel.getHeight());
		inicializarHiloNaves();
		refrescarPanel();
		
	
	}
	
	public void cambiarLogin() {
		
	}

	

	@Override
	public void keyPressed(KeyEvent e) {
		
		int tecla = e.getKeyCode();
		if (!menu.getPartida().getNave().isEnMovimiento()){
			if (tecla == 39){
				menu.getPartida().empezarMovimientoNave();
				Thread hilo = new Thread (new HiloMoverNaveUsuario(menu.getPartida(), this, Nave.DERECHA));
				hilo.start();
			} else if (tecla == 37){
				menu.getPartida().empezarMovimientoNave();
				Thread hilo = new Thread (new HiloMoverNaveUsuario(menu.getPartida(), this, Nave.IZQUIERDA));
				hilo.start();
			}
		}
		if (!menu.getPartida().getNave().isDisparando()){
			if (tecla == 32){
				menu.getPartida().dispararNaveAliada();
				Thread hilo = new Thread(new HiloMoverDisparo(this, menu.getPartida()));
				hilo.start();
			}
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
	
		int tecla = e.getKeyCode();
		if (tecla == 39 || tecla == 37){
			menu.getPartida().detenerNave();
		}
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public static void main(String[] args) {
		interfazInicio vent = new interfazInicio();
		vent.setVisible(true);
	}
}


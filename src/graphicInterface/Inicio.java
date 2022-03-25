package graphicInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import auxPackage.Sound;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio {

	public JFrame frame;
	private JLabel background;
	private JButton btnStart;
	private JButton btnExit;
	private Sound sound = new Sound();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
					
//					Al iniciar el programa ejecutamos la canción del juego que se reproducirá en un loop
//					infinito mientras el juego esté ejecutándose.
					Sound song = new Sound();
					song.playMusic(Inicio.class.getResource("/audio/songGta.wav"));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Inicio() {
		initialize();
	}

	private void initialize() {
		
//		Frame de la pantalla de Inicio.
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Grand Theft Auto: Cards Edition | Creado por Jonatan García Barrera");
		ImageIcon logo = new ImageIcon(Inicio.class.getResource("/images/logo.png"));
		frame.setIconImage(logo.getImage());
		
//		Botón de iniciar el juego-
		btnStart = new JButton("");
		btnStart.setFocusPainted(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setBorderPainted(false);
		btnStart.setIcon(new ImageIcon(Game.class.getResource("/images/start.png")));
		btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStart.setForeground(Color.BLACK);
		btnStart.setBackground(new Color(0, 51, 102));
		btnStart.setFont(new Font("Yu Gothic UI", Font.BOLD, 29));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Al hacer click sobre el botón de iniciar creamos un nuevo objeto de la clase Game
//				y ponemos el frame de la pantalla de juego visible y ocultamos la pantalla de Inicio.
				sound.effectSound(Inicio.class.getResource("/audio/loadgun.wav"));
				Game game = new Game();
				game.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnStart.setBounds(421, 913, 166, 69);
		frame.getContentPane().add(btnStart);
		
//		Botón de salir del juego.
		btnExit = new JButton("");
		btnExit.setContentAreaFilled(false);
		btnExit.setFocusPainted(false);
		btnExit.setBorderPainted(false);
		btnExit.setIcon(new ImageIcon(Game.class.getResource("/images/exit.png")));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setForeground(Color.BLACK);
		btnExit.setBackground(new Color(0, 51, 102));
		btnExit.setFont(new Font("Yu Gothic UI", Font.BOLD, 29));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.effectSound(Inicio.class.getResource("/audio/loadgun.wav"));
				System.exit(0);		
			}
		});
		btnExit.setBounds(748, 913, 125, 69);
		frame.getContentPane().add(btnExit);
		
//		Fondo de la pantalla de Inicio.
		background = new JLabel("");
		background.setInheritsPopupMenu(false);
		background.setFocusable(false);
		background.setFocusTraversalKeysEnabled(false);
		background.setBounds(0,0, 1920, 1080);
		frame.getContentPane().add(background);
		background.setIcon(new ImageIcon(Game.class.getResource("/images/backgroundInicio.jpg")));
		
	}
	
}

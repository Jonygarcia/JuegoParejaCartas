package graphicInterface;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import auxPackage.RandomCards;
import auxPackage.Sound;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Cursor;

public class Game{
	
	public JFrame frame;
	private JLabel numIntentos;
	private JLabel background;
	private JButton btnRestart;
	private JButton btnExit;
	private JButton btnReturn;
	private JButton card1;
	private JButton card2;
	private JButton card3;
	private JButton card4;
	private JButton card5;
	private JButton card6;
	private JButton card7;
	private JButton card8;
	private JButton card9;
	private JButton card10;
	private JButton card11;
	private JButton card12;
	private JButton card13;
	private JButton card14;
	private JButton card15;
	private JButton card16;
	private JLabel imageCards;
	private RandomCards random = new RandomCards();
	private ImageIcon img1, img2;
	private JButton[] botonPulsado = new JButton[2];
	private boolean dosCartas = false, caraActiva = false;
	private int count = 0;
	private Sound sound = new Sound();

	public Game() {	
		initialize();
		
		setCards(random);		
	}

	private void initialize() {
	
//		Frame de la pantalla de Juego.
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Grand Theft Auto: Cards Edition | Creado por Jonatan García Barrera");
		ImageIcon logo = new ImageIcon(Game.class.getResource("/images/logo.png"));
		frame.setIconImage(logo.getImage());
		
//		Botón de reiniciar.
		btnRestart = new JButton("");
		btnRestart.setContentAreaFilled(false);
		btnRestart.setFocusPainted(false);
		btnRestart.setBorderPainted(false);
		btnRestart.setIcon(new ImageIcon(Game.class.getResource("/images/restart.png")));
		btnRestart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRestart.setForeground(Color.BLACK);
		btnRestart.setBackground(new Color(0, 51, 102));
		btnRestart.setFont(new Font("Yu Gothic UI", Font.BOLD, 29));
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.effectSound(Game.class.getResource("/audio/loadgun.wav"));
				reiniciar();
			}
		});
		btnRestart.setBounds(1144, 932, 218, 69);
		frame.getContentPane().add(btnRestart);
		
//		Botón de salir.
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
				sound.effectSound(Game.class.getResource("/audio/loadgun.wav"));
				System.exit(0);
			}
		});
		btnExit.setBounds(1729, 932, 125, 69);
		frame.getContentPane().add(btnExit);
		
//		Botón de volver.
		btnReturn = new JButton("");
		btnReturn.setContentAreaFilled(false);
		btnReturn.setFocusPainted(false);
		btnReturn.setBorderPainted(false);
		btnReturn.setIcon(new ImageIcon(Game.class.getResource("/images/return.png")));
		btnReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReturn.setForeground(Color.BLACK);
		btnReturn.setBackground(new Color(0, 51, 102));
		btnReturn.setFont(new Font("Yu Gothic UI", Font.BOLD, 29));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Al hacer click sobre el botón de volver creamos un nuevo objeto de la clase Inicio
//				y ponemos la pantalla de inicio visible y ocultamos la pantalla de juego.
				sound.effectSound(Game.class.getResource("/audio/loadgun.wav"));
				Inicio inicio = new Inicio();
				inicio.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnReturn.setBounds(1471, 932, 175, 69);
		frame.getContentPane().add(btnReturn);
		
//		Imagen decorativa logo GTA Cards Edition.
		imageCards = new JLabel("");
		imageCards.setIcon(new ImageIcon(Game.class.getResource("/images/gtaCards.png")));
		imageCards.setBounds(1632, 52, 234, 254);
		frame.getContentPane().add(imageCards);
		
//		Texto del número de intentos.
		numIntentos = new JLabel("Número de intentos: " + count);
		numIntentos.setForeground(Color.BLACK);
		numIntentos.setFont(new Font("Pricedown Bl", Font.BOLD, 40));
		numIntentos.setBounds(138, 52, 544, 56);
		frame.getContentPane().add(numIntentos);
		
//		Carta número 1.
		card1 = new JButton("");
		card1.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card1.setBackground(Color.WHITE);
		card1.setBounds(138, 119, 150, 150);
		card1.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card1.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card1);
			}
		});
		frame.getContentPane().add(card1);
		
//		Carta número 2.
		card2 = new JButton("");
		card2.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card2.setBackground(Color.WHITE);
		card2.setBounds(388, 119, 150, 150);
		card2.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card2.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card2);
			}
		});
		frame.getContentPane().add(card2);
		
//		Carta número 3.
		card3 = new JButton("");
		card3.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card3.setBackground(Color.WHITE);
		card3.setBounds(638, 119, 150, 150);
		card3.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card3.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card3);
			}
		});
		frame.getContentPane().add(card3);
		
//		Carta número 4.
		card4 = new JButton("");
		card4.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card4.setBackground(Color.WHITE);
		card4.setBounds(888, 119, 150, 150);
		card4.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card4.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card4);
			}
		});
		frame.getContentPane().add(card4);
		
//		Carta número 5.
		card5 = new JButton("");
		card5.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card5.setBackground(Color.WHITE);
		card5.setBounds(138, 344, 150, 150);
		card5.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card5.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card5);
			}
		});
		frame.getContentPane().add(card5);
		
//		Carta número 6.
		card6 = new JButton("");
		card6.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card6.setBackground(Color.WHITE);
		card6.setBounds(388, 344, 150, 150);
		card6.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card6.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card6);
			}
		});
		frame.getContentPane().add(card6);
		
//		Carta número 7.
		card7 = new JButton("");
		card7.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card7.setBackground(Color.WHITE);
		card7.setBounds(638, 344, 150, 150);
		card7.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card7.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card7);
			}
		});
		frame.getContentPane().add(card7);
		
//		Carta número 8.
		card8 = new JButton("");
		card8.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card8.setBackground(Color.WHITE);
		card8.setBounds(888, 344, 150, 150);
		card8.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card8.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card8);
			}
		});
		frame.getContentPane().add(card8);
		
//		Carta número 9.
		card9 = new JButton("");
		card9.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card9.setBackground(Color.WHITE);
		card9.setBounds(138, 569, 150, 150);
		card9.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card9.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card9);
			}
		});
		frame.getContentPane().add(card9);
		
//		Carta número 10.
		card10 = new JButton("");
		card10.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card10.setBackground(Color.WHITE);
		card10.setBounds(388, 569, 150, 150);
		card10.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card10.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card10);
			}
		});
		frame.getContentPane().add(card10);
		
//		Carta número 11.
		card11 = new JButton("");
		card11.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card11.setBackground(Color.WHITE);
		card11.setBounds(638, 569, 150, 150);
		card11.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card11.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card11);
			}
		});
		frame.getContentPane().add(card11);
		
//		Carta número 12.
		card12 = new JButton("");
		card12.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card12.setBackground(Color.WHITE);
		card12.setBounds(888, 569, 150, 150);
		card12.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card12.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card12);
			}
		});
		frame.getContentPane().add(card12);
		
//		Carta número 13.
		card13 = new JButton("");
		card13.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card13.setBackground(Color.WHITE);
		card13.setBounds(138, 794, 150, 150);
		card13.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card13.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card13);
			}
		});
		frame.getContentPane().add(card13);
		
//		Carta número 14.
		card14 = new JButton("");
		card14.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card14.setBackground(Color.WHITE);
		card14.setBounds(388, 794, 150, 150);
		card14.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card14.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card14);
			}
		});
		frame.getContentPane().add(card14);
		
//		Carta número 15.
		card15 = new JButton("");
		card15.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card15.setBackground(Color.WHITE);
		card15.setBounds(638, 794, 150, 150);
		card15.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card15.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card15);
			}
		});
		frame.getContentPane().add(card15);
		
//		Carta número 16.
		card16 = new JButton("");
		card16.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		card16.setBackground(Color.WHITE);
		card16.setBounds(888, 794, 150, 150);
		card16.setIcon(new ImageIcon(Game.class.getResource("/images/backcard.jpg")));
		card16.setRolloverIcon(new ImageIcon(Game.class.getResource("/images/backcardhover.jpg")));
		card16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				compararCartas();
			}
		});
		card16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaActiva(card16);
			}
		});
		frame.getContentPane().add(card16);
		
//		Imagen de fondo de la pantalla de Juego.
		background = new JLabel("");
		background.setBounds(0,0, 1920, 1080);
		frame.getContentPane().add(background);
		background.setIcon(new ImageIcon(Game.class.getResource("/images/backgroundGame.jpg")));
	}
	
	private void setCards(RandomCards logic) {
		// Con esta función llamamos a generar los números aleatorios de la clase RandomCards en el paquete auxPackage, que ya hemos
		// definido arriba "random" como objeto de RandomCards en private y generamos las cartas de forma aleatoria.
		int[] numeros = random.getCardNumbers();
		
		card1.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[0]+".jpg")));
		card2.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[1]+".jpg")));
		card3.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[2]+".jpg")));
		card4.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[3]+".jpg")));
		card5.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[4]+".jpg")));
		card6.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[5]+".jpg")));
		card7.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[6]+".jpg")));
		card8.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[7]+".jpg")));
		card9.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[8]+".jpg")));
		card10.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[9]+".jpg")));
		card11.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[10]+".jpg")));
		card12.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[11]+".jpg")));
		card13.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[12]+".jpg")));
		card14.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[13]+".jpg")));
		card15.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[14]+".jpg")));
		card16.setDisabledIcon(new ImageIcon(getClass().getResource("/images/image"+numeros[15]+".jpg")));
	}
	
	private void cartaActiva(JButton card) {
//		Metodo para dar la vuelta a la carta, si la cara no está activa ya, pondremos el setEnable a false y mostraremos
//		la imagen que hemos asignado anteriormente al setDisabledIcon.
		
//		Sonido al voltear la carta.
		sound.effectSound(Game.class.getResource("/audio/flipcard.wav"));
		

		if (!caraActiva) {
//			Si la primera carta no estába dada la vuelta, entraremos en el if y pondremos el booleano de la primera carta como
//			true, además haremos el getDisabledIcon para voltear la carta y la asignamos en la posición 0 del array que tenemos
//			para compararlas posteriormente. También pondremos el booleano de la segunda carta a false, para que en la siguiente
//			carta entre en el else.
			card.setEnabled(false);
			img1 = (ImageIcon) card.getDisabledIcon();
			botonPulsado[0] = card;
			caraActiva = true;
			dosCartas = false;
		} else {
//			Si la primera carta estaba volteada, entrará en el else haciendo la misma función con el getDisabledIcon y asignando
//			la segunda carta a la posición 1 del array para compararlas y ponemos a true el booleano de la segunda carta.
//			Llamamos también a la función msgWin para comprobar si quedan cartas por voltear o ya ha terminado la partida.
			card.setEnabled(false);
			img2 = (ImageIcon) card.getDisabledIcon();
			botonPulsado[1] = card;
			dosCartas = true;
			msgWin();
		}
	}
	
	private void compararCartas() {
//		Con este metodo comparamos la descripción de las cartas para ver si son iguales en el momento que quite el mouse de encima de
//		una de las cartas, pero solo se ejecutará la función si las dos cartas se han dado la vuelta.
		if (caraActiva && dosCartas) {
			if (img1.getDescription().compareTo(img2.getDescription()) != 0) {
//				Si ambas cartas no son iguales, las ponemos a enabled para mostrar la parte trasera de nuevo.
				botonPulsado[0].setEnabled(true);
				botonPulsado[1].setEnabled(true);
//				Llamamos a la función effectSound de la clase sound con el sonido de una percusión al fallar la pareja.
				sound.effectSound(Game.class.getResource("/audio/drum.wav"));
			} else {
//				Si ambas cartas son iguales, las ocultamos del tablero
				botonPulsado[0].setVisible(false);
				botonPulsado[1].setVisible(false);
//				Llamamos a la función effectSound de la clase Sound con el sonido de una campanita al acertar la pareja.
				sound.effectSound(Game.class.getResource("/audio/bell.wav"));
			}
			caraActiva = false;
			// Al comparar también sumamos los intentos y seteamos el texto.
			count++;
			numIntentos.setText("Número de intentos: " + count);	
		}
	}
	
	private void reiniciar() {
//		Al reiniciar ponemos a enabled todas las cartas para mostrar la cara trasera y las ponemos todas a visible.
		card1.setEnabled(true);
		card1.setVisible(true);
		card2.setEnabled(true);
		card2.setVisible(true);
		card3.setEnabled(true);
		card3.setVisible(true);
		card4.setEnabled(true);
		card4.setVisible(true);
		card5.setEnabled(true);
		card5.setVisible(true);
		card6.setEnabled(true);
		card6.setVisible(true);
		card7.setEnabled(true);
		card7.setVisible(true);
		card8.setEnabled(true);
		card8.setVisible(true);
		card9.setEnabled(true);
		card9.setVisible(true);
		card10.setEnabled(true);
		card10.setVisible(true);
		card11.setEnabled(true);
		card11.setVisible(true);
		card12.setEnabled(true);
		card12.setVisible(true);
		card13.setEnabled(true);
		card13.setVisible(true);
		card14.setEnabled(true);
		card14.setVisible(true);
		card15.setEnabled(true);
		card15.setVisible(true);
		card16.setEnabled(true);
		card16.setVisible(true);
		
//		Restauramos los valores de los booleanos, contador, seteamos el texto de intentos para que se vuelva a poner en 0
//		y llamamos a la función setCards con un nuevo objeto RandomCards para que las cartas se ordenen de forma aleatoria y no
//		coincidan con la posición que tenían en la partida anterior.
		caraActiva = false;
		dosCartas = false;
		count = 0;
		numIntentos.setText("Número de intentos: " + count);
		RandomCards randomRestart = new RandomCards();
		setCards(randomRestart);
	}
	
	private void msgWin(){
//		Si todas las cartas están habilitadas (se han dado la vuelta y no se han vuelto a ocultar) estarán todas las parejas formadas
//		y mostraremos un mensaje de que ha encontrado todas las parejas y reiniciamos el tablero llamando a la función reiniciar.
		if(!card1.isEnabled() && !card2.isEnabled() && !card3.isEnabled() && !card4.isEnabled() && !card5.isEnabled() &&
				!card6.isEnabled() && !card7.isEnabled() && !card8.isEnabled() && !card9.isEnabled() && !card10.isEnabled() &&
				!card11.isEnabled() && !card12.isEnabled() && !card13.isEnabled() && !card14.isEnabled() && !card15.isEnabled() &&
				!card16.isEnabled()) {
			sound.effectSound(Game.class.getResource("/audio/missioncompleted.wav"));
			JOptionPane.showMessageDialog(card1, "Enhorabuena, has encontrado todas las parejas!\nHas necesitado " + (count + 1) + " intentos");
			reiniciar();
		}
	}
	
}

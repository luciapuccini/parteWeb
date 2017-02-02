package uiDesktop;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Instrucciones1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instrucciones1 frame = new Instrucciones1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Instrucciones1() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JScrollPane scrollPane = new JScrollPane();
	    contentPane.add(scrollPane);
	    
	    JTextArea txtReglas = new JTextArea();
	    txtReglas.setText("Reglas\r\n\r\nAtaque: \r\n\r\nDurante su turno un jugador puedo optar por atacar al oponente, el jugador debe ingresar la cantidad de puntos de energ\u00EDa que se utilizar\u00E1n en el ataque. \r\nLos mismos deber\u00E1n restarse de su personaje (no podr\u00E1 exceder los que tiene) en cualquier caso.\"Durante el ataque se evaluar\u00E1 primero la probabilidad de evasi\u00F3n del personaje atacado(ver abajo), si el personaje evade el ataque no recibir\u00E1 da\u00F1o alguno. Si en cambio el ataque no es adido se restar\u00E1n los puntos de energ\u00EDa utilizados en el ataque de la vida del atacado.\r\nDefensa:\r\n\r\nLos puntos de defensa no podr\u00E1n exceder los 20 puntos.Si el jugador opta por defender no podr\u00E1 atacar en dicho turno, pero a cambio de ello el personaje recuperar\u00E1 un porcentaje \r\nde la energ\u00EDa y de la vida que ten\u00EDa al comenzar el juego. Calculado de la siguiente forma:\r\n\tenergiaARecupearar = energiaOriginal * defensa / 100 \r\n\t vidaARecuperar = vidaOriginal * defensa / 250 \r\n Los puntos de vida o energia recueperados se sumaran pero no podr\u00E1nsuperar los valores originales del comienzo de la partida.\r\nEvasi\u00F3n:\r\n\r\nAl crear el jugador se podr\u00E1n asignar puntos de evasi\u00F3n. Siendo el m\u00E1ximo 80 puntos.Cuando el personaje recibe un ataque se calcular\u00E1 si puede evadir el ataque con un n\u00FAmero aleatorio si se cumple la condici\u00F3n (numAleatorio*100)>puntosDeEvasion.En caso de evadir el ataque el personaje atacado no recibe da\u00F1o, pero el atacante igualmente pierde los puntos de energ\u00EDa utilizados.\r\nGanador:\r\n\r\nEl ganador ser\u00E1 quien quite todos los puntos de vida del oponente primero.Al finalizar el combate el ganador recibir\u00E1 como premio 10 puntos para su personaje que se sumar\u00E1n a los puntos totales que ya ten\u00EDa para as\u00ED poder asignarlos luego en la codificaci\u00F3n del personaje.\r\n Recuperaci\u00F3n: Adem\u00E1s a cada jugador se le restaurar\u00E1n los puntos de vida que ten\u00EDa antes del combate.");
	    txtReglas.setLineWrap(true);
	    scrollPane.setViewportView(txtReglas);
	 //   contentPane.pack();
	   // contentPane.setLocation(x, y);
	    contentPane.setVisible(true);
	    
	   
	}

}

package uiDesktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Tabla;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class frame21 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame21 frame = new frame21();
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
	public frame21() {
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCrearPersonaje = new JButton("Crear un nuevo personaje");
		btnCrearPersonaje.setBackground(new Color(102, 205, 170));
		btnCrearPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AsignacionPersonajes1.main(null);
			}
		});
		//------------------------------------------------------------------------------
		JButton btnUsarPersonaje = new JButton("Usar un personaje existente");
		btnUsarPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Tabla ventana = new Tabla();        
		        ventana.setVisible(true); 
			}
		});
		btnUsarPersonaje.setBackground(new Color(240, 128, 128));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(125)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCrearPersonaje, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnUsarPersonaje, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(130))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(69)
					.addComponent(btnCrearPersonaje, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnUsarPersonaje, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addGap(79))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

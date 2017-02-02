package datos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import entidades.Personaje;
import logica.Controlador;
import utils.ApplicationException;

@SuppressWarnings("serial")
public class modifica extends JFrame {
	
	private Controlador ctrl;
	private Personaje p;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEnergia;
	private JTextField txtVida;
	private JTextField txtDefensa;
	private JTextField txtEvasion;
	private JTextField txtPtosDisp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifica frame = new modifica();
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
	public modifica(){};
	public void ActualizaPtos(int b)
	{
			String str=txtPtosDisp.getText();
			int a=Integer.parseInt(str);
			int c=a-b;
			str=String.valueOf(c);
			txtPtosDisp.setText(str);
			p.setPuntos(c);
	}
	
	public modifica(Personaje p, Controlador ctrl) {
		this.p=p;
		this.ctrl=ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtNombre = new JTextField();
		txtNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setText(p.getNombre());
		
		
		txtEnergia = new JTextField();
		txtEnergia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=p.getEnergia();
				String st=txtEnergia.getText();
				int b=Integer.parseInt(st);
				String str=txtPtosDisp.getText();
				int d=Integer.parseInt(str);
				if(d>=b){
				int c=a+b;
				p.setEnergia(c);
				ActualizaPtos(b);}
				else {JOptionPane.showMessageDialog(null, "Puntos insuficientes");
					
				}
			}
		});
		txtEnergia.setColumns(10);
		
		txtVida = new JTextField();
		txtVida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=p.getVida();
				String st=txtVida.getText();
				
				int b=Integer.parseInt(st);
				String str=txtPtosDisp.getText();
				int d=Integer.parseInt(str);
				if(d>=b){
				int c=a+b;
				p.setVida(c);
				ActualizaPtos(b);}
				else {JOptionPane.showMessageDialog(null, "Puntos insuficientes");}
			}
		});
		txtVida.setColumns(10);
		
		txtDefensa = new JTextField();
		txtDefensa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=p.getDefensa();
				String st=txtDefensa.getText();
				int b=Integer.parseInt(st);
				String str=txtPtosDisp.getText();
				int d=Integer.parseInt(str);
				if(d>=b){
				int c=a+b;
				p.setDefensa(c);
				ActualizaPtos(b);}
				else {JOptionPane.showMessageDialog(null, "Puntos insuficientes");}
			}
		});
		txtDefensa.setColumns(10);
		
		txtEvasion = new JTextField();
		txtEvasion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=p.getEvasion();
				String st=txtEvasion.getText();
				int b=Integer.parseInt(st);
				String str=txtPtosDisp.getText();
				int d=Integer.parseInt(str);
				if(d>=b){
				int c=a+b;
				p.setEvasion(c);
				ActualizaPtos(b);}
				else {JOptionPane.showMessageDialog(null, "Puntos insuficientes");}
				
				
			}
		});
		txtEvasion.setColumns(10);
		
		txtPtosDisp = new JTextField();
		txtPtosDisp.setEditable(false);
		txtPtosDisp.setColumns(10);
		txtPtosDisp.setText(String.valueOf(p.getPuntos()));
		JTextArea txtrNombre = new JTextArea();
		txtrNombre.setText("Nombre");
		txtrNombre.setEditable(false);
		
		JTextArea txtrEnergia = new JTextArea();
		txtrEnergia.setText("Energia");
		txtrEnergia.setEditable(false);
		
		JTextArea txtrVida = new JTextArea();
		txtrVida.setText("Vida");
		txtrVida.setEditable(false);
		
		JTextArea txtrDefensa = new JTextArea();
		txtrDefensa.setText("Defensa");
		txtrDefensa.setEditable(false);
		
		JTextArea txtrEvasion = new JTextArea();
		txtrEvasion.setText("Evasion");
		txtrEvasion.setEditable(false);
		
		JTextArea txtrPtosDisp = new JTextArea();
		txtrPtosDisp.setText("Ptos Disp");
		txtrPtosDisp.setEditable(false);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					ctrl.modifica(p);
					System.out.println("Actualizando...");
				} catch (ApplicationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtrNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtrPtosDisp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
							.addComponent(txtPtosDisp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnAceptar)
							.addGap(25))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPtosDisp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrPtosDisp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtrEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtrVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtrDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtrEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(btnAceptar)))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

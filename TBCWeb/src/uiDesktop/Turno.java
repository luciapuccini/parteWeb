package uiDesktop;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**/
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import entidades.Personaje;
import logica.Controlador;

@SuppressWarnings("serial")
public class Turno extends JFrame 
{

	private JPanel contentPane;
	private JTextField txtEnergia1;
	private JTextField txtEnergia2;
	private JTextField txtEnergiaDisponible1;
	private JTextField txtVidaActual1;
	private JTextField txtVidaActual2;
	private JTextField txtEnergiaDisponible2;
	private JTextField txtP1;
	private JTextField txtP2;
	private JTextField txtTurno;

	
	Personaje p1;
	Personaje p2;
	Controlador ctrl;
	

	public Controlador getCtrl() 
	{
		return ctrl;
	}

	public void setCtrl(Controlador ctrl) 
	{
		this.ctrl = ctrl;
	}
	
	
	
	public Personaje getP1()
	{
		return p1;
	}

	public void setP1(Personaje p1) 
	{
		this.p1 = p1;
	}

	public Personaje getP2() {
		return p2;
	}

	public void setP2(Personaje p2) {
		this.p2 = p2;
	}

	public JTextField getTxtEnergiaAtaque1() {
		return txtEnergia1;
	}

	public void setTxtEnergiaAtaque1(JTextField txtEnergiaAtaque1) {
		this.txtEnergia1 = txtEnergiaAtaque1;
	}

	public JTextField getTxtEnergiaAtaque2() {
		return txtEnergia2;
	}

	public void setTxtEnergiaAtaque2(JTextField txtEnergiaAtaque2) {
		this.txtEnergia2 = txtEnergiaAtaque2;
	}

	public JTextField getTxtEnergiaDisponible1() {
		return txtEnergiaDisponible1;
	}

	public void setTxtEnergiaDisponible1(JTextField txtEnergiaDisponible1) {
		this.txtEnergiaDisponible1 = txtEnergiaDisponible1;
	}

	public JTextField getTxtVidaActual1() {
		return txtVidaActual1;
	}

	public void setTxtVidaActual1(JTextField txtVidaActual1) {
		this.txtVidaActual1 = txtVidaActual1;
	}

	public JTextField getTxtVidaActual2() {
		return txtVidaActual2;
	}

	public void setTxtVidaActual2(JTextField txtVidaActual2) {
		this.txtVidaActual2 = txtVidaActual2;
	}

	public JTextField getTxtEnergiaDisponible2() {
		return txtEnergiaDisponible2;
	}

	public void setTxtEnergiaDisponible2(JTextField txtEnergiaDisponible2) {
		this.txtEnergiaDisponible2 = txtEnergiaDisponible2;
	}

	
	
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Turno frame = new Turno();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void cuentaTurnos (boolean b, int ok) 
	{
			if (ok ==1)
			{		
				if (b)
				{
			txtTurno.setText("Jugador 1:" +p1.getNombre());
			}
			else
			{
			txtTurno.setText("Jugador 2:" +p2.getNombre());
			}
			}
	};
	
	
	public Turno(Controlador c) {
		
		
	
		this.setCtrl(c);
		p1=c.dameUno();
		p2=c.dameDos();
		p1.setVidaOriginal(p1.getVida());
		p2.setVidaOriginal(p2.getVida());
		p1.setEnergiaOriginal(p1.getEnergia());
		p2.setEnergiaOriginal(p2.getEnergia());
	
		//----------------------inicializo--------------------------------------
		if(p1.getVida()>0 || p2.getVida()>0){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblP1 = new JLabel("Personaje 1:");
		
		JLabel lblP2 = new JLabel("Personaje 2:");
		

		//-----------juego p1------------------//
		
		JButton btnAtaque1 = new JButton("Ataque");
		btnAtaque1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				int a=p1.atacar(Integer.parseInt(txtEnergia1.getText()), p2,ctrl);
					txtEnergiaDisponible1.setText(String.valueOf(p1.getEnergia()));
					txtVidaActual2.setText(String.valueOf(p2.getVida()));

				cuentaTurnos(false,a);
			}
		});
		
		JButton btnDefensa1 = new JButton("Defensa");
		btnDefensa1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(Integer.parseInt(txtEnergia1.getText())<= 20)
				{	
					int a=p1.defender(Integer.parseInt(txtEnergia1.getText()));
					txtVidaActual1.setText(String.valueOf(p1.getVida()));
					txtEnergiaDisponible1.setText(String.valueOf(p1.getEnergia()));
					cuentaTurnos(false,a);
				}
				else{JOptionPane.showMessageDialog(null,"la energia no puede superar 20 puntos");}
				
				}
		});
		//-------------------juego p2-------------------------
		JButton btnAtaque2 = new JButton("Ataque");
		btnAtaque2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int a=p2.atacar(Integer.parseInt(txtEnergia2.getText()), p1,ctrl);
					txtVidaActual1.setText(String.valueOf(p1.getVida()));
					txtEnergiaDisponible2.setText(String.valueOf(p2.getEnergia()));
				cuentaTurnos(true,a);
			}
		});
		
		JButton btnDefensa2 = new JButton("Defensa");
		btnDefensa2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(Integer.parseInt(txtEnergia2.getText())<= 20)
				{	
					int a=p2.defender(Integer.parseInt(txtEnergia2.getText()));
					txtVidaActual2.setText(String.valueOf(p2.getVida()));
					txtEnergiaDisponible2.setText(String.valueOf(p2.getEnergia()));
					cuentaTurnos(true,a);
				}
				else{JOptionPane.showMessageDialog(null,"la energia no puede superar 20 puntos");}
			}
		});
//----------------------labels------------------------------------------------------------------------------
		
		JLabel lblVida1 = new JLabel("Vida Actual:");
		
		JLabel lblEnergia1 = new JLabel("Energia Disponible:");
		
		JLabel lblVida2 = new JLabel("Vida Actual:");
		
		JLabel lblEnergia2 = new JLabel("Energia Disponible:");
		
		JLabel lblEnergiaAtaque1 = new JLabel("Ingrese Energia: ");
		
		txtEnergia1 = new JTextField();
		txtEnergia1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			
			}
		});
		txtEnergia1.setColumns(10);
		
		txtEnergia2 = new JTextField();
		txtEnergia2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		txtEnergia2.setColumns(10);
		
		JLabel lblEnergiaAtaque2 = new JLabel("Ingrese Energia:");
		
		txtEnergiaDisponible1 = new JTextField();
		txtEnergiaDisponible1.setText(String.valueOf(p1.getEnergia()));
		txtEnergiaDisponible1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		txtEnergiaDisponible1.setEditable(false);
		txtEnergiaDisponible1.setColumns(10);
		//-------------------vida1-----------------------
		txtVidaActual1 = new JTextField();
		txtVidaActual1.setText(String.valueOf(p1.getVida()));
				
		
		txtVidaActual1.setEditable(false);
		txtVidaActual1.setColumns(10);
		//-------------------vida2-----------------------
		txtVidaActual2 = new JTextField();
		txtVidaActual2.setText(String.valueOf(p2.getVida()));

	
		txtVidaActual2.setEditable(false);
		txtVidaActual2.setColumns(10);
		
		txtEnergiaDisponible2 = new JTextField();
		txtEnergiaDisponible2.setText(String.valueOf(p2.getEnergia()));
		txtEnergiaDisponible2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		txtEnergiaDisponible2.setEditable(false);
		txtEnergiaDisponible2.setColumns(10);
		
		
	
		//---------------------P1--------------------		
		txtP1 = new JTextField();
		txtP1.setEditable(false);
		txtP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		txtP1.setColumns(10);
		txtP1.setText(p1.getNombre());
		//---------------------P2--------------------
		txtP2 = new JTextField();
		txtP2.setEditable(false);
		txtP2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
			}
		});
		txtP2.setColumns(10);
		txtP2.setText(p2.getNombre());
		
		JLabel lblTurno = new JLabel("Turno:");
		
		txtTurno = new JTextField();
		
		
		txtTurno.setEditable(false);
		txtTurno.setColumns(10);
		
		
			
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAtaque1)
							.addGap(12)
							.addComponent(btnDefensa1)
							.addContainerGap(262, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEnergia1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtEnergiaDisponible1, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEnergiaAtaque1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEnergia1, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblP1)
										.addComponent(lblVida1))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addComponent(txtVidaActual1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
											.addGap(35))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtP1, 92, 92, 92)))
									.addGap(9))
								.addComponent(lblTurno, Alignment.TRAILING))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(53)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblEnergiaAtaque2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtEnergia2, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnAtaque2)
											.addGap(18)
											.addComponent(btnDefensa2))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblVida2)
												.addComponent(lblEnergia2)
												.addComponent(lblP2))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(18)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addComponent(txtEnergiaDisponible2, 0, 0, Short.MAX_VALUE)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addGap(29)
															.addComponent(txtVidaActual2, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(txtP2, 80, 80, 80)))))
									.addGap(20))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTurno)
						.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblP1)
						.addComponent(txtP1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblP2)
						.addComponent(txtP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVida2)
						.addComponent(txtVidaActual2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtVidaActual1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVida1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnergia1)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtEnergiaDisponible1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEnergia2)
							.addComponent(txtEnergiaDisponible2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnergiaAtaque1)
						.addComponent(lblEnergiaAtaque2)
						.addComponent(txtEnergia1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEnergia2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDefensa1)
						.addComponent(btnAtaque1)
						.addComponent(btnAtaque2)
						.addComponent(btnDefensa2))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		}  else
			{if(p1.getVida() <= 0)
				{
				p2.Actualizacion(ctrl);
				}
			else p1.Actualizacion(ctrl);
		
			}
		;
	
		}// fin controlador
}


	

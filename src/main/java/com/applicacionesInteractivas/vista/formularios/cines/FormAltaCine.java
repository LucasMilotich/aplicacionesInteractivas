package com.applicacionesInteractivas.vista.formularios.cines;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;

public class FormAltaCine extends JFrame{
	
	private JLabel lblCuit;
	private JTextField txtCuit;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDomicilio;
	private JTextField txtDomicilio;
	private JButton btnConfirm;
	
	private static final long serialVersionUID = -7869162737881219117L;
	public FormAltaCine() {
		
		this.setSize(320, 320);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		this.setTitle("Crear Cine");
		
		lblCuit = new JLabel();
		lblCuit.setText("CUIT");
		lblCuit.setBounds(21, 40, 180, 28);
		lblCuit.setHorizontalTextPosition(JLabel.RIGHT);
		getContentPane().add(lblCuit);
		
		txtCuit = new JTextField();
		txtCuit.setBounds(130, 40, 120, 28);
		this.txtCuit.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(txtCuit.getText().length() > 10)
					e.consume();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)
						|| (c == KeyEvent.VK_SLASH || c == KeyEvent.VK_COMMA || c == KeyEvent.VK_PERIOD))) {
					JOptionPane.showMessageDialog(null, "El campo 'CUIT' solo permite numeros");
					e.consume();
				}
			}
		});
		getContentPane().add(txtCuit);
		
		lblNombre = new JLabel();
		lblNombre.setText("Nombre Cine");
		lblNombre.setBounds(21, 80, 180, 28);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(130, 80, 120, 28);
		this.txtNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(txtNombre.getText().length() > 49)
					e.consume();
			}
		});
		getContentPane().add(txtNombre);

		lblDomicilio = new JLabel();
		lblDomicilio.setText("Domicilio");
		lblDomicilio.setBounds(21, 120, 180, 28);
		getContentPane().add(lblDomicilio);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setBounds(130, 120, 120, 28);
		this.txtDomicilio.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(txtDomicilio.getText().length() > 49)
					e.consume();
			}
		});
		getContentPane().add(txtDomicilio);
		
		btnConfirm = new JButton("Confirmar");
		btnConfirm.setBounds(110, 180, 123, 28);;
		getContentPane().add(btnConfirm);

		btnConfirm.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.crearCine(txtCuit.getText(),
					txtNombre.getText(),
					txtDomicilio.getText());
			JOptionPane.showMessageDialog(null,"Cine creado!");
			this.setVisible(false);
		});
	}
}

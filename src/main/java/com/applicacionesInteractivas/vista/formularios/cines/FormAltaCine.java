package com.applicacionesInteractivas.vista.formularios.cines;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.vista.formularios.utils.ValidadorCampo;

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
		this.txtCuit.addKeyListener(ValidadorCampo.numberValidator(10, "CUIT"));
		getContentPane().add(txtCuit);
		
		lblNombre = new JLabel();
		lblNombre.setText("Nombre Cine");
		lblNombre.setBounds(21, 80, 180, 28);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(130, 80, 120, 28);
		this.txtNombre.addKeyListener(ValidadorCampo.lengthValidador(49, "NOMBRE"));
		getContentPane().add(txtNombre);

		lblDomicilio = new JLabel();
		lblDomicilio.setText("Domicilio");
		lblDomicilio.setBounds(21, 120, 180, 28);
		getContentPane().add(lblDomicilio);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setBounds(130, 120, 120, 28);
		this.txtDomicilio.addKeyListener(ValidadorCampo.lengthValidador(49, "DOMICILIO"));
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

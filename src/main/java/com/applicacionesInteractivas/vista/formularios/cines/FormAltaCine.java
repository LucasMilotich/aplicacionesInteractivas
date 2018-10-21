package com.applicacionesInteractivas.vista.formularios.cines;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;

public class FormAltaCine extends JFrame{
	
	/**
	 * 
	 */
	private JPanel mainPanel;
	
	private JLabel lblCuit;
	private JTextField txtCuit;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDomicilio;
	private JTextField txtDomicilio;
	private JButton btnConfirm;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	
	private static final long serialVersionUID = -7869162737881219117L;
	public FormAltaCine() {
		
		this.setSize(320, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Crear Cine");
		
		lblCuit = new JLabel();
		lblCuit.setText("CUIT");
		this.add(lblCuit);
		
		txtCuit = new JTextField();
		txtCuit.setColumns(12);
		this.add(txtCuit);
		
		lblNombre = new JLabel();
		lblNombre.setText("Nombre Cine");
		this.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(12);
		this.add(txtNombre);

		lblDomicilio = new JLabel();
		lblDomicilio.setText("Domicilio");
		this.add(lblDomicilio);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(12);
		this.add(txtDomicilio);
		
		btnConfirm = new JButton("Confirmar");
		this.add(btnConfirm);
		
		panel1 = new JPanel();
		panel1.add(lblCuit);
		panel1.add(txtCuit);
		
		panel2 = new JPanel();
		panel2.add(lblNombre);
		panel2.add(txtNombre);
		
		panel3 = new JPanel();
		panel3.add(lblDomicilio);
		panel3.add(txtDomicilio);
		
		panel4 = new JPanel();
		panel4.add(btnConfirm);

		btnConfirm.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.crearCine(txtCuit.getText(),
					txtNombre.getText(),
					txtDomicilio.getText());
			JOptionPane.showMessageDialog(null,"Cine creado!");
			this.setVisible(false);
		});
		mainPanel = new JPanel();
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		
		getContentPane().add(mainPanel);
	}
}

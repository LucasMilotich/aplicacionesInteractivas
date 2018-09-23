package com.applicacionesInteractivas.vista.formularios;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.modelo.Cine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFormularioAltaCine extends JFrame{
	
	/**
	 * 
	 */
	private JPanel mainPanel;
	private static final long serialVersionUID = -7869162737881219117L;
	private Cine model = new Cine();
	public JFormularioAltaCine() {
		
		this.setSize(320, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Crear Cine");
		
		JLabel lblCuit = new JLabel();
		lblCuit.setText("CUIT");
		this.add(lblCuit);
		
		JTextField txtCuit = new JTextField();
		txtCuit.setColumns(12);
		this.add(txtCuit);
		
		JLabel lblNombre = new JLabel();
		lblNombre.setText("Nombre Cine");
		this.add(lblNombre);
		
		JTextField txtNombre = new JTextField();
		txtNombre.setColumns(12);
		this.add(txtNombre);

		JLabel lblDomicilio = new JLabel();
		lblDomicilio.setText("Domicilio");
		this.add(lblDomicilio);
		
		JTextField txtDomicilio = new JTextField();
		txtDomicilio.setColumns(12);
		this.add(txtDomicilio);
		
		JLabel lblCantSalas = new JLabel();
		lblCantSalas.setText("Cantidad Salas");
		this.add(lblCantSalas);
		
		JTextField txtCantSalas = new JTextField();
		txtCantSalas.setColumns(12);
		this.add(txtCantSalas);
		
		JLabel lblCapTotal = new JLabel();
		lblCapTotal.setText("Capacidad Total");
		this.add(lblCapTotal);
		
		JTextField txtCapTotal = new JTextField();
		txtCapTotal.setColumns(12);
		this.add(txtCapTotal);
		
		JButton btnConfirm = new JButton("Confirmar");
		this.add(btnConfirm);
		
		JPanel panel1 = new JPanel();
		panel1.add(lblCuit);
		panel1.add(txtCuit);
		
		JPanel panel2 = new JPanel();
		panel2.add(lblNombre);
		panel2.add(txtNombre);
		
		JPanel panel3 = new JPanel();
		panel3.add(lblDomicilio);
		panel3.add(txtDomicilio);
		
		JPanel panel4 = new JPanel();
		panel4.add(lblCantSalas);
		panel4.add(txtCantSalas);
		
		JPanel panel5 = new JPanel();
		panel5.add(lblCapTotal);
		panel5.add(txtCapTotal);
		
		JPanel panel6 = new JPanel();
		panel6.add(btnConfirm);

		btnConfirm.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.crearCine(txtCuit.getText(),
					txtNombre.getText(),
					txtDomicilio.getText(),
					Integer.parseInt(txtCantSalas.getText()),
					Integer.parseInt(txtCapTotal.getText()));
			JOptionPane.showMessageDialog(null,"Cine creado!");
			for (Cine c : cine.getCines()){
				model = c;
				JOptionPane.showMessageDialog(null,model.getNombre());
				model.setCuit("999999999999");
			}

		});
		mainPanel = new JPanel();
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		
		getContentPane().add(mainPanel);
	}
}

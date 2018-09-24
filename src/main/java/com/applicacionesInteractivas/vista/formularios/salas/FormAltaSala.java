package com.applicacionesInteractivas.vista.formularios.salas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;

public class FormAltaSala extends JFrame{

	private static final long serialVersionUID = 7042214256613114521L;
	private JLabel lblNombre;
	private JLabel lblCapacidad;
	private JTextField txtNombre;
	private JTextField txtCapacidad;
	private JButton btnConfirmar;
	private JPanel mainPanel;
	private JPanel panel1, panel2, panel3;

	public FormAltaSala() {
		
		this.setSize(320, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Crear Sala");
		
		lblNombre = new JLabel("Nombre");
		this.add(lblNombre);
		lblCapacidad = new JLabel("Capacidad");
		this.add(lblCapacidad);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(12);
		this.add(txtNombre);
		txtCapacidad = new JTextField();
		txtCapacidad.setColumns(12);
		this.add(txtCapacidad);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.crearSala(txtNombre.getText(),
						   Integer.parseInt(txtCapacidad.getText()));
			JOptionPane.showMessageDialog(null,"Sala creada!");
			this.setVisible(false);
		});
		
		mainPanel = new JPanel();
		
		panel1 = new JPanel();
		panel1.add(lblNombre);
		panel1.add(txtNombre);
		
		panel2 = new JPanel();
		panel2.add(lblCapacidad);
		panel2.add(txtCapacidad);
		
		panel3 = new JPanel();
		panel3.add(btnConfirmar);
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		
		getContentPane().add(mainPanel);
	}
}

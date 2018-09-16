package com.applicacionesInteractivas.vista.formularios;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFormularioAltaSala extends JFrame{

	/**
	 * 
	 */
	private JPanel mainPanel;
	private static final long serialVersionUID = 6088023940407136569L;

	public JFormularioAltaSala() {
		
		this.setSize(320, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Alta de Sala");
		
		JLabel lblNombre = new JLabel();
		lblNombre.setText("Nombre");
		this.add(lblNombre);
		
		JTextField txtNombre = new JTextField();
		txtNombre.setColumns(12);
		this.add(txtNombre);
		
		JLabel lblCapacidad = new JLabel();
		lblCapacidad.setText("Capacidad");
		this.add(lblCapacidad);
		
		JTextField txtCapacidad = new JTextField();
		txtCapacidad.setColumns(12);
		this.add(txtCapacidad);
		
		JButton btnConfirm = new JButton("Confirmar");
		this.add(btnConfirm);
		
		JPanel panel1 = new JPanel();
		panel1.add(lblNombre);
		panel1.add(txtNombre);
		
		JPanel panel2 = new JPanel();
		panel2.add(lblCapacidad);
		panel2.add(txtCapacidad);
		
		JPanel panel3 = new JPanel();
		panel3.add(btnConfirm);
		
		this.mainPanel = new JPanel();
		
		this.mainPanel.add(panel1);
		this.mainPanel.add(panel2);
		this.mainPanel.add(panel3);
		
		this.getContentPane().add(mainPanel);
	}
}

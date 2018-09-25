package com.applicacionesInteractivas.vista.formularios.funciones;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;

public class FormAltaFuncion extends JFrame{

	private static final long serialVersionUID = 362160396368097636L;
	private JLabel lblHorario;
	private JTextField txtHorario;
	private JLabel lblAsientos;
	private JTextField txtAsientos;
	private JButton btnConfirmar;
	private JPanel horarioContainer, asientoContainer, btnContainer;
	private JPanel mainPanel;
	
	public FormAltaFuncion() {
		
		this.setSize(320, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Crear Funcion");
		mainPanel = new JPanel();
		
		lblHorario = new JLabel("Horario");
		this.add(lblHorario);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(12);
		this.add(txtHorario);
		
		lblAsientos = new JLabel("Asientos");
		this.add(lblAsientos);
		
		txtAsientos = new JTextField();
		txtAsientos.setColumns(12);
		this.add(txtAsientos);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.crearFuncion(txtHorario.getText(),
							  txtAsientos.getText());
			JOptionPane.showMessageDialog(null,"Funcion creada!");
			this.setVisible(false);
		});
		this.add(btnConfirmar);
		
		horarioContainer = new JPanel();
		horarioContainer.add(lblHorario);
		horarioContainer.add(txtHorario);
		
		asientoContainer = new JPanel();
		asientoContainer.add(lblAsientos);
		asientoContainer.add(txtAsientos);
		
		btnContainer = new JPanel();
		btnContainer.add(btnConfirmar);
		
		mainPanel.add(horarioContainer);
		mainPanel.add(asientoContainer);
		mainPanel.add(btnContainer);
		
		getContentPane().add(mainPanel);
		
	}
}

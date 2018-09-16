package com.applicacionesInteractivas.vista.formularios;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFormularioAdminSalas extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9009185236775332074L;

	public JFormularioAdminSalas() {
		
		this.setSize(320, 240);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Administraci�n Salas");
		
		JButton btnAddSala = new JButton("Dar de alta Sala");
		this.add(btnAddSala);
		
		JButton btnUpdSala = new JButton("Modificar Sala");
		this.add(btnUpdSala);
		
		JButton btnDelSala = new JButton("Eliminar Sala");
		this.add(btnDelSala);
	}
}

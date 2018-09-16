package com.applicacionesInteractivas.vista.formularios;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFormularioAdminFunciones extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8049199133893510664L;

	public JFormularioAdminFunciones() {
		
		this.setSize(320, 240);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Administraci�n Funciones");
		
		JButton btnAddFuncion = new JButton("Dar de alta Funcion");
		this.add(btnAddFuncion);
		
		JButton btnUpdFuncion = new JButton("Modificar Funcion");
		this.add(btnUpdFuncion);
		
		JButton btnDelFuncion = new JButton("Eliminar Funcion");
		this.add(btnDelFuncion);
	}
}

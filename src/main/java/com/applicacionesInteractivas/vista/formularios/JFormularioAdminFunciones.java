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
		this.setTitle("Administracion Funciones");
		
		JButton btnAddFuncion = new JButton("Crear Funcion");
		this.add(btnAddFuncion);
		
		JButton btnUpdFuncion = new JButton("Modificar Funcion");
		this.add(btnUpdFuncion);
		
		JButton btnDelFuncion = new JButton("Eliminar Funcion");
		this.add(btnDelFuncion);
	}
}

package com.applicacionesInteractivas.vista.formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFormularioAdminCines extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4859825063578897901L;

	public JFormularioAdminCines() {
		
		this.setSize(320, 240);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Administracion Cines");
		
		JButton btnAddCine = new JButton("Crear Cine");
		btnAddCine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form2 = new JFormularioAltaCine();
				form2.setVisible(true);
			}
		});
		this.add(btnAddCine);
		
		JButton btnUpdCine = new JButton("Modificar Cine");
		this.add(btnUpdCine);
		
		JButton btnDelCine = new JButton("Eliminar Cine");
		this.add(btnDelCine);
	}
}

package com.applicacionesInteractivas.vista.formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.setTitle("Administracion Salas");
		
		JButton btnAddSala = new JButton("Crear Sala");
		btnAddSala.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form2 = new JFormularioAltaSala();
				form2.setVisible(true);
			}
		});
		this.add(btnAddSala);
		
		JButton btnUpdSala = new JButton("Modificar Sala");
		this.add(btnUpdSala);
		
		JButton btnDelSala = new JButton("Eliminar Sala");
		this.add(btnDelSala);
	}
}

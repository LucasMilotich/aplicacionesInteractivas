package com.applicacionesInteractivas.vista.formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFormularioAdminPeliculas extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3419041216351844575L;

	public JFormularioAdminPeliculas() {
		
		this.setSize(320, 240);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Administracion Peliculas");
		
		JButton btnAddPelicula = new JButton("Crear Pelicula");
		btnAddPelicula.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form2 = new JFormularioAltaPelicula();
				form2.setVisible(true);
			}
		});
		this.add(btnAddPelicula);
		
		JButton btnUpdPelicula = new JButton("Modificar Pelicula");
		this.add(btnUpdPelicula);
		
		JButton btnDelPelicula = new JButton("Eliminar Pelicula");
		this.add(btnDelPelicula);
	}
}

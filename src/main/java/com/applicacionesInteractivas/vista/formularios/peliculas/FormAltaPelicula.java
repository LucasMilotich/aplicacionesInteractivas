package com.applicacionesInteractivas.vista.formularios.peliculas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;

public class FormAltaPelicula extends JFrame{

	private JPanel mainPanel;
	private static final long serialVersionUID = -1575972637826323094L;
	private JLabel lblNombrePelicula;
	private JTextField txtNombrePelicula;
	private JLabel lblDirector;
	private JTextField txtDirector;
	private JLabel lblGenero;
	private JTextField txtGenero;
	private JLabel lblDuracion;
	private JTextField txtDuracion;
	private JLabel lblIdioma;
	private JTextField txtIdioma;
	private JLabel lblSubtitulos;
	private JTextField txtSubtitulos;
	private JLabel lblCalificacion;
	private JTextField txtCalificacion;
	private JLabel lblObservacion;
	private JTextField txtObservacion;
	private JButton btnConfirm;

	public FormAltaPelicula() {
		
		this.setSize(320, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Crear Pelicula");
		
		lblNombrePelicula = new JLabel();
		lblNombrePelicula.setText("Nombre");
		this.add(lblNombrePelicula);
		
		txtNombrePelicula = new JTextField();
		txtNombrePelicula.setColumns(12);
		this.add(txtNombrePelicula);
		
		lblDirector = new JLabel();
		lblDirector.setText("Director");
		this.add(lblDirector);
		
		txtDirector = new JTextField();
		txtDirector.setColumns(12);
		this.add(txtDirector);
		
		lblGenero = new JLabel();
		lblGenero.setText("Genero");
		this.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(12);
		this.add(txtGenero);
		
		lblDuracion = new JLabel();
		lblDuracion.setText("Duracion");
		this.add(lblDuracion);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(12);
		this.add(txtDuracion);
		
		lblIdioma = new JLabel();
		lblIdioma.setText("Idioma");
		this.add(lblIdioma);
		
		txtIdioma = new JTextField();
		txtIdioma.setColumns(12);
		this.add(txtIdioma);

		lblSubtitulos = new JLabel();
		lblSubtitulos.setText("Subtitulos");
		this.add(lblSubtitulos);
		
		txtSubtitulos = new JTextField();
		txtSubtitulos.setColumns(12);
		this.add(txtSubtitulos);
		
		lblCalificacion = new JLabel();
		lblCalificacion.setText("Calificacion");
		this.add(lblCalificacion);
		
		txtCalificacion = new JTextField();
		txtCalificacion.setColumns(12);
		this.add(txtCalificacion);
		
		lblObservacion = new JLabel();
		lblObservacion.setText("Observacion");
		this.add(lblObservacion);
		
		txtObservacion = new JTextField();
		txtObservacion.setColumns(12);
		this.add(txtObservacion);
		
		btnConfirm = new JButton("Confirmar");
		btnConfirm.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.crearPelicula(txtNombrePelicula.getText(),
							   txtDirector.getText(),
							   txtGenero.getText(),
							   txtDuracion.getText(), 
							   txtIdioma.getText(), 
							   txtSubtitulos.getText(),
							   Integer.parseInt(txtCalificacion.getText()),
							   txtObservacion.getText());
			JOptionPane.showMessageDialog(null,"Pelicula creada!");
			this.setVisible(false);
		});
		this.add(btnConfirm);
		
		JPanel nombreContainer = new JPanel();
		nombreContainer.add(lblNombrePelicula);
		nombreContainer.add(txtNombrePelicula);
		
		JPanel directorContainer = new JPanel();
		directorContainer.add(lblDirector);
		directorContainer.add(txtDirector);
		
		JPanel generoContainer = new JPanel();
		generoContainer.add(lblGenero);
		generoContainer.add(txtGenero);
		
		JPanel duracionContainer = new JPanel();
		duracionContainer.add(lblDuracion);
		duracionContainer.add(txtDuracion);
		
		JPanel idiomaContainer = new JPanel();
		idiomaContainer.add(lblIdioma);
		idiomaContainer.add(txtIdioma);
		
		JPanel subtitulosContainer = new JPanel();
		subtitulosContainer.add(lblSubtitulos);
		subtitulosContainer.add(txtSubtitulos);
		
		JPanel calificacionContainer = new JPanel();
		calificacionContainer.add(lblCalificacion);
		calificacionContainer.add(txtCalificacion);
		
		JPanel observacionContainer = new JPanel();
		observacionContainer.add(lblObservacion);
		observacionContainer.add(txtObservacion);
		
		JPanel btnContainer = new JPanel();
		btnContainer.add(btnConfirm);
		
		mainPanel = new JPanel();
		
		mainPanel.add(nombreContainer);
		mainPanel.add(directorContainer);
		mainPanel.add(generoContainer);
		mainPanel.add(duracionContainer);
		mainPanel.add(idiomaContainer);
		mainPanel.add(subtitulosContainer);
		mainPanel.add(calificacionContainer);
		mainPanel.add(observacionContainer);
		mainPanel.add(btnContainer);
		
		getContentPane().add(mainPanel);
	}
}

package com.applicacionesInteractivas.vista.formularios.peliculas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.vista.formularios.utils.ValidadorCampo;

public class FormAltaPelicula extends JFrame{

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
		
		this.setSize(400, 450);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		this.setTitle("Crear Pelicula");
		
		lblNombrePelicula = new JLabel();
		lblNombrePelicula.setText("Nombre");
		lblNombrePelicula.setBounds(21, 40, 120, 28);
		getContentPane().add(lblNombrePelicula);
		
		txtNombrePelicula = new JTextField();
		txtNombrePelicula.setBounds(130, 40, 120, 28);
		this.txtNombrePelicula.addKeyListener(ValidadorCampo.lengthValidador(49, "NOMBRE"));
		getContentPane().add(txtNombrePelicula);
		
		lblDirector = new JLabel();
		lblDirector.setText("Director");
		lblDirector.setBounds(21, 80, 120, 28);
		getContentPane().add(lblDirector);
		
		txtDirector = new JTextField();
		txtDirector.setBounds(130, 80, 120, 28);
		this.txtDirector.addKeyListener(ValidadorCampo.lengthValidador(49, "DIRECTOR"));
		getContentPane().add(txtDirector);
		
		lblGenero = new JLabel();
		lblGenero.setText("Genero");
		lblGenero.setBounds(21, 120, 120, 28);
		getContentPane().add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(130, 120, 120, 28);
		this.txtGenero.addKeyListener(ValidadorCampo.lengthValidador(29, "GENERO"));
		getContentPane().add(txtGenero);
		
		lblDuracion = new JLabel();
		lblDuracion.setText("Duracion");
		lblDuracion.setBounds(21, 160, 120, 28);
		getContentPane().add(lblDuracion);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(130, 160, 120, 28);
		this.txtDuracion.addKeyListener(ValidadorCampo.numberValidator(2, "DURACION"));
		getContentPane().add(txtDuracion);
		
		lblIdioma = new JLabel();
		lblIdioma.setText("Idioma");
		lblIdioma.setBounds(21, 200, 120, 28);
		getContentPane().add(lblIdioma);
		
		txtIdioma = new JTextField();
		txtIdioma.setBounds(130, 200, 120, 28);
		this.txtIdioma.addKeyListener(ValidadorCampo.lengthValidador(29, "IDIOMA"));
		getContentPane().add(txtIdioma);

		lblSubtitulos = new JLabel();
		lblSubtitulos.setText("Subtitulos");
		lblSubtitulos.setBounds(21, 240, 120, 28);
		getContentPane().add(lblSubtitulos);
		
		txtSubtitulos = new JTextField();
		txtSubtitulos.setBounds(130, 240, 120, 28);
		this.txtSubtitulos.addKeyListener(ValidadorCampo.lengthValidador(29, "SUBTITULOS"));
		getContentPane().add(txtSubtitulos);
		
		lblCalificacion = new JLabel();
		lblCalificacion.setText("Calificacion");
		lblCalificacion.setBounds(21, 280, 120, 28);
		getContentPane().add(lblCalificacion);
		
		txtCalificacion = new JTextField();
		txtCalificacion.setBounds(130, 280, 120, 28);
		this.txtCalificacion.addKeyListener(ValidadorCampo.numberValidator(4, "CALIFICACION"));
		getContentPane().add(txtCalificacion);
		
		lblObservacion = new JLabel();
		lblObservacion.setText("Observacion");
		lblObservacion.setBounds(21, 320, 120, 28);
		getContentPane().add(lblObservacion);
		
		txtObservacion = new JTextField();
		txtObservacion.setBounds(130, 320, 120, 28);
		this.txtObservacion.addKeyListener(ValidadorCampo.lengthValidador(99, "OBSERVACION"));
		getContentPane().add(txtObservacion);
		
		btnConfirm = new JButton("Confirmar");
		btnConfirm.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			String nombrePelicula = txtNombrePelicula.getText();
			String director = txtDirector.getText();
			String genero = txtGenero.getText();
			String duracion = txtDuracion.getText();
			String idioma = txtIdioma.getText();
			String subtitulos = txtSubtitulos.getText();
			String calificacion = txtCalificacion.getText();
			String observacion = txtObservacion.getText();
			if(nombrePelicula.equals("")) {
				JOptionPane.showMessageDialog(null, "El campo 'Nombre Pelicula' no puede estar vacio!", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			cine.crearPelicula(nombrePelicula,
							   director,
							   genero,
							   duracion, 
							   idioma, 
							   subtitulos,
							   Double.parseDouble(calificacion),
							   observacion);
			JOptionPane.showMessageDialog(null,"Pelicula creada!");
			this.setVisible(false);
		});
		btnConfirm.setBounds(130, 380, 120, 28);
		getContentPane().add(btnConfirm);
		
	}
}

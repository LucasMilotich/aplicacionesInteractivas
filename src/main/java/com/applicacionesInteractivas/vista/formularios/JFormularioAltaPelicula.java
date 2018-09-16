package com.applicacionesInteractivas.vista.formularios;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JFormularioAltaPelicula extends JFrame{

	/**
	 * 
	 */
	private JPanel mainPanel;
	private static final long serialVersionUID = -1575972637826323094L;

	public JFormularioAltaPelicula() {
		
		this.setSize(320, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Crear Pelicula");
		
		JLabel lblNombrePelicula = new JLabel();
		lblNombrePelicula.setText("Nombre");
		this.add(lblNombrePelicula);
		
		JTextField txtNombrePelicula = new JTextField();
		txtNombrePelicula.setColumns(12);
		this.add(txtNombrePelicula);
		
		JLabel lblDirector = new JLabel();
		lblDirector.setText("Director");
		this.add(lblDirector);
		
		JTextField txtDirector = new JTextField();
		txtDirector.setColumns(12);
		this.add(txtDirector);
		
		JLabel lblDuracion = new JLabel();
		lblDuracion.setText("Duracion");
		this.add(lblDuracion);
		
		JPasswordField txtDuracion = new JPasswordField();
		txtDuracion.setColumns(12);
		this.add(txtDuracion);
		
		JLabel lblIdioma = new JLabel();
		lblIdioma.setText("Idioma");
		this.add(lblIdioma);
		
		JTextField txtIdioma = new JTextField();
		txtIdioma.setColumns(12);
		this.add(txtIdioma);

		JLabel lblSubtitulos = new JLabel();
		lblSubtitulos.setText("Subtitulos");
		this.add(lblSubtitulos);
		
		JTextField txtSubtitulos = new JTextField();
		txtSubtitulos.setColumns(12);
		this.add(txtSubtitulos);
		
		JLabel lblCalificacion = new JLabel();
		lblCalificacion.setText("Calificacion");
		this.add(lblCalificacion);
		
		JTextField txtCalificacion = new JTextField();
		txtCalificacion.setColumns(12);
		this.add(txtCalificacion);
		
		JLabel lblObservacion = new JLabel();
		lblObservacion.setText("Observacion");
		this.add(lblObservacion);
		
		JTextField txtObservacion = new JTextField();
		txtObservacion.setColumns(12);
		this.add(txtObservacion);
		
		JButton btnConfirm = new JButton("Confirmar");
		this.add(btnConfirm);
		
		JPanel panel1 = new JPanel();
		panel1.add(lblNombrePelicula);
		panel1.add(txtNombrePelicula);
		
		JPanel panel2 = new JPanel();
		panel2.add(lblDirector);
		panel2.add(txtDirector);
		
		JPanel panel3 = new JPanel();
		panel3.add(lblDuracion);
		panel3.add(txtDuracion);
		
		JPanel panel4 = new JPanel();
		panel4.add(lblIdioma);
		panel4.add(txtIdioma);
		
		JPanel panel5 = new JPanel();
		panel5.add(lblSubtitulos);
		panel5.add(txtSubtitulos);
		
		JPanel panel6 = new JPanel();
		panel6.add(lblCalificacion);
		panel6.add(txtCalificacion);
		
		JPanel panel7 = new JPanel();
		panel7.add(lblObservacion);
		panel7.add(txtObservacion);
		
		JPanel panel8 = new JPanel();
		panel8.add(btnConfirm);
		
		mainPanel = new JPanel();
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		mainPanel.add(panel7);
		mainPanel.add(panel8);
		
		getContentPane().add(mainPanel);
	}
}

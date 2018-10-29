package com.applicacionesInteractivas.vista.formularios.peliculas;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaPeliculas;

public class FormModifPelicula extends JFrame{

	private static final long serialVersionUID = 7871061310727314681L;
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
	private JButton btnModificar;
	private TablaPeliculas tablaPeliculasModel;
	private JTable tablaPeliculas;
	private JScrollPane miBarra;
	private int idPelicula;
	private JPanel mainPanel;
	private JPanel nombreContainer,directorContainer,generoContainer,duracionContainer;
	private JPanel idiomaContainer,califContainer,obsContainer,subsContainer;
	private JPanel btnContainer;
	private JPanel tableContainer;
	
	public FormModifPelicula() {
		
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Modificar Pelicula");
		mainPanel = new JPanel();
		
		lblNombrePelicula = new JLabel();
		lblNombrePelicula.setText("Nombre");
		this.add(lblNombrePelicula);
		
		txtNombrePelicula = new JTextField();
		txtNombrePelicula.setColumns(12);
		txtNombrePelicula.setEditable(false);
		this.add(txtNombrePelicula);
		
		lblDirector = new JLabel();
		lblDirector.setText("Director");
		this.add(lblDirector);
		
		txtDirector = new JTextField();
		txtDirector.setColumns(12);
		txtDirector.setEditable(false);
		this.add(txtDirector);
		
		lblGenero = new JLabel();
		lblGenero.setText("Genero");
		this.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(12);
		txtGenero.setEditable(false);
		this.add(txtGenero);
		
		lblDuracion = new JLabel();
		lblDuracion.setText("Duracion");
		this.add(lblDuracion);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(12);
		txtDuracion.setEditable(false);
		this.add(txtDuracion);
		
		lblIdioma = new JLabel();
		lblIdioma.setText("Idioma");
		this.add(lblIdioma);
		
		txtIdioma = new JTextField();
		txtIdioma.setColumns(12);
		txtIdioma.setEditable(false);
		this.add(txtIdioma);

		lblSubtitulos = new JLabel();
		lblSubtitulos.setText("Subtitulos");
		this.add(lblSubtitulos);
		
		txtSubtitulos = new JTextField();
		txtSubtitulos.setColumns(12);
		txtSubtitulos.setEditable(false);
		this.add(txtSubtitulos);
		
		lblCalificacion = new JLabel();
		lblCalificacion.setText("Calificacion");
		this.add(lblCalificacion);
		
		txtCalificacion = new JTextField();
		txtCalificacion.setColumns(12);
		txtCalificacion.setEditable(false);
		this.add(txtCalificacion);
		
		lblObservacion = new JLabel();
		lblObservacion.setText("Observacion");
		this.add(lblObservacion);
		
		txtObservacion = new JTextField();
		txtObservacion.setColumns(12);
		txtObservacion.setEditable(false);
		this.add(txtObservacion);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.modificarPelicula(idPelicula,
							   txtNombrePelicula.getText(),
							   txtDirector.getText(),
							   txtGenero.getText(),
							   txtDuracion.getText(), 
							   txtIdioma.getText(),
							   txtSubtitulos.getText(),
							   Integer.parseInt(txtCalificacion.getText()),
							   txtObservacion.getText());
			JOptionPane.showMessageDialog(null,"Pelicula modificada!");
			this.setVisible(false);
		});
		btnModificar.setEnabled(false);
		this.add(btnModificar);
		
		tablaPeliculas = new JTable();
		tablaPeliculas.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tablaPeliculas.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            try{
		            	txtNombrePelicula.setText((String) table.getValueAt(row, 1));
		            	txtDirector.setText((String) table.getValueAt(row, 2));
		            	txtDirector.setEditable(true);
		            	txtGenero.setText((String) table.getValueAt(row, 3));
		            	txtGenero.setEditable(true);
		            	txtDuracion.setText((String) table.getValueAt(row, 4));
		            	txtDuracion.setEditable(true);
		            	txtIdioma.setText((String) table.getValueAt(row, 5));
		            	txtIdioma.setEditable(true);
		            	txtSubtitulos.setText((String) table.getValueAt(row, 6));
		            	txtSubtitulos.setEditable(true);
		            	txtCalificacion.setText(Integer.toString((int) table.getValueAt(row, 7)));
		            	txtCalificacion.setEditable(true);
		            	txtObservacion.setText((String) table.getValueAt(row, 8));
		            	txtObservacion.setEditable(true);
		            	idPelicula = (int)table.getValueAt(row, 0);
			            
			            btnModificar.setEnabled(true);
		            }
		            catch(Exception e){
		            	e.printStackTrace();
		            }
		        }
		    }
		});
		
		miBarra = new JScrollPane();
		miBarra.setBounds(40, 300, 400, 130);
		
		tablaPeliculasModel = new TablaPeliculas();
		tablaPeliculasModel.setPeliculas(CineController.getInstance().getPeliculas());
		
		tablaPeliculas.setModel(tablaPeliculasModel);
		miBarra.setViewportView(tablaPeliculas);
		
		nombreContainer = new JPanel();
		nombreContainer.add(lblNombrePelicula);
		nombreContainer.add(txtNombrePelicula);
		
		directorContainer = new JPanel();
		directorContainer.add(lblDirector);
		directorContainer.add(txtDirector);
		
		generoContainer = new JPanel();
		generoContainer.add(lblGenero);
		generoContainer.add(txtGenero);
		
		duracionContainer = new JPanel();
		duracionContainer.add(lblDuracion);
		duracionContainer.add(txtDuracion);
		
		idiomaContainer = new JPanel();
		idiomaContainer.add(lblIdioma);
		idiomaContainer.add(txtIdioma);
		
		subsContainer = new JPanel();
		subsContainer.add(lblSubtitulos);
		subsContainer.add(txtSubtitulos);
		
		califContainer = new JPanel();
		califContainer.add(lblCalificacion);
		califContainer.add(txtCalificacion);
		
		obsContainer = new JPanel();
		obsContainer.add(lblObservacion);
		obsContainer.add(txtObservacion);
		
		btnContainer = new JPanel();
		btnContainer.add(btnModificar);
		
		tableContainer = new JPanel();
		tableContainer.add(miBarra);
		
		mainPanel.add(nombreContainer);
		mainPanel.add(directorContainer);
		mainPanel.add(generoContainer);
		mainPanel.add(duracionContainer);
		mainPanel.add(idiomaContainer);
		mainPanel.add(subsContainer);
		mainPanel.add(califContainer);
		mainPanel.add(obsContainer);
		mainPanel.add(btnContainer);
		mainPanel.add(tableContainer);
		
		getContentPane().add(mainPanel);
	}
}

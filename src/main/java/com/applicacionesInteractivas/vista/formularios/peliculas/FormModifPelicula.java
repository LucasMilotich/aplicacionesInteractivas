package com.applicacionesInteractivas.vista.formularios.peliculas;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	
	public FormModifPelicula() {
		
		this.setSize(500, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		this.setTitle("Modificar Pelicula");
		
		lblNombrePelicula = new JLabel();
		lblNombrePelicula.setText("Nombre");
		lblNombrePelicula.setBounds(21, 40, 120, 28);
		getContentPane().add(lblNombrePelicula);
		
		txtNombrePelicula = new JTextField();
		txtNombrePelicula.setBounds(130, 40, 120, 28);
		this.txtNombrePelicula.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(txtNombrePelicula.getText().length() > 49)
					e.consume();
			}
		});
		getContentPane().add(txtNombrePelicula);
		
		lblDirector = new JLabel();
		lblDirector.setText("Director");
		lblDirector.setBounds(21, 80, 120, 28);
		getContentPane().add(lblDirector);
		
		txtDirector = new JTextField();
		txtDirector.setBounds(130, 80, 120, 28);
		this.txtDirector.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(txtDirector.getText().length() > 49)
					e.consume();
			}
		});
		getContentPane().add(txtDirector);
		
		lblGenero = new JLabel();
		lblGenero.setText("Genero");
		lblGenero.setBounds(21, 120, 120, 28);
		getContentPane().add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(130, 120, 120, 28);
		this.txtGenero.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(txtGenero.getText().length() > 29)
					e.consume();
			}
		});
		getContentPane().add(txtGenero);
		
		lblDuracion = new JLabel();
		lblDuracion.setText("Duracion");
		lblDuracion.setBounds(21, 160, 120, 28);
		getContentPane().add(lblDuracion);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(130, 160, 120, 28);
		this.txtDuracion.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(txtDuracion.getText().length() > 2)
					e.consume();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					JOptionPane.showMessageDialog(null, "El campo 'Duracion' solo permite numeros");
					e.consume();
				}
			}
		});
		getContentPane().add(txtDuracion);
		
		lblIdioma = new JLabel();
		lblIdioma.setText("Idioma");
		lblIdioma.setBounds(21, 200, 120, 28);
		getContentPane().add(lblIdioma);
		
		txtIdioma = new JTextField();
		txtIdioma.setBounds(130, 200, 120, 28);
		this.txtIdioma.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(txtIdioma.getText().length() > 29)
					e.consume();
			}
		});
		getContentPane().add(txtIdioma);

		lblSubtitulos = new JLabel();
		lblSubtitulos.setText("Subtitulos");
		lblSubtitulos.setBounds(21, 240, 120, 28);
		getContentPane().add(lblSubtitulos);
		
		txtSubtitulos = new JTextField();
		txtSubtitulos.setBounds(130, 240, 120, 28);
		this.txtSubtitulos.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(txtSubtitulos.getText().length() > 29)
					e.consume();
			}
		});
		getContentPane().add(txtSubtitulos);
		
		lblCalificacion = new JLabel();
		lblCalificacion.setText("Calificacion");
		lblCalificacion.setBounds(21, 280, 120, 28);
		getContentPane().add(lblCalificacion);
		
		txtCalificacion = new JTextField();
		txtCalificacion.setBounds(130, 280, 120, 28);
		this.txtCalificacion.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(txtCalificacion.getText().length() > 1)
					e.consume();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					JOptionPane.showMessageDialog(null, "El campo 'Calificacion' solo permite numeros");
					e.consume();
				}
			}
		});
		getContentPane().add(txtCalificacion);
		
		lblObservacion = new JLabel();
		lblObservacion.setText("Observacion");
		lblObservacion.setBounds(21, 320, 120, 28);
		getContentPane().add(lblObservacion);
		
		txtObservacion = new JTextField();
		txtObservacion.setBounds(130, 320, 120, 28);
		this.txtObservacion.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(txtObservacion.getText().length() > 99)
					e.consume();
			}
		});
		getContentPane().add(txtObservacion);
		
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
		btnModificar.setBounds(170, 370, 120, 28);;
		getContentPane().add(btnModificar);
		
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
		getContentPane().add(miBarra);
		miBarra.setBounds(20, 410, 440, 130);
		
		tablaPeliculasModel = new TablaPeliculas();
		tablaPeliculasModel.setPeliculas(CineController.getInstance().getPeliculas());
		
		tablaPeliculas.setModel(tablaPeliculasModel);
		miBarra.setViewportView(tablaPeliculas);
		
	}
}

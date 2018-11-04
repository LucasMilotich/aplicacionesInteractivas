package com.applicacionesInteractivas.vista.formularios.peliculas;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaPeliculas;

public class FormElimPelicula extends JFrame{

	private static final long serialVersionUID = -4223846769846167012L;
	private JButton btnEliminar;
	private JTable tablaPeliculas;
	private TablaPeliculas tablaPeliculasModel;
	private JScrollPane miBarra;
	private int idPelicula;
	
	public FormElimPelicula() {
		
		this.setSize(500, 280);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		this.setTitle("Eliminar Pelicula");
		
		btnEliminar = new JButton("Eliminar Pelicula");
		btnEliminar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			if(!cine.esPeliculaEliminable(idPelicula)) {
				JOptionPane.showMessageDialog(null,"No se puede eliminar la pelicula ya que tiene funciones activas!");
				return;
			}
			cine.eliminarPelicula(idPelicula);
			JOptionPane.showMessageDialog(null,"Pelicula eliminada!");
			this.setVisible(false);
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(170, 15, 123, 28);
		getContentPane().add(btnEliminar);
		
		tablaPeliculas = new JTable();
		tablaPeliculas.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tablaPeliculas.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
		            try{
		            	idPelicula = (int)table.getValueAt(row, 0);
			            btnEliminar.setEnabled(true);
		            }
		            catch(Exception e){
		            	e.printStackTrace();
		            }
		        }
		    }
		});
		
		miBarra = new JScrollPane();
		getContentPane().add(miBarra);
		miBarra.setBounds(20, 60, 450, 130);
		
		tablaPeliculasModel = new TablaPeliculas();
		tablaPeliculasModel.setPeliculas(CineController.getInstance().getPeliculas());
		
		tablaPeliculas.setModel(tablaPeliculasModel);
		tablaPeliculas.setDragEnabled(false);
		miBarra.setViewportView(tablaPeliculas);
	}
}

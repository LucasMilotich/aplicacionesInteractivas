package com.applicacionesInteractivas.vista.formularios.peliculas;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
	private JPanel mainPanel;
	private JPanel tableContainer;
	private JPanel btnContainer;
	
	public FormElimPelicula() {
		
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Eliminar Pelicula");
		mainPanel = new JPanel();
		
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.eliminarPelicula((String) tablaPeliculas.getValueAt(tablaPeliculas.getSelectedRow(), 0));
			JOptionPane.showMessageDialog(null,"Pelicula eliminada!");
			this.setVisible(false);
		});
		btnEliminar.setEnabled(false);
		this.add(btnEliminar);
		
		tablaPeliculas = new JTable();
		tablaPeliculas.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tablaPeliculas.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
		            try{
			            btnEliminar.setEnabled(true);
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
		tablaPeliculas.setDragEnabled(false);
		miBarra.setViewportView(tablaPeliculas);
		
		btnContainer = new JPanel();
		btnContainer.add(btnEliminar);
		
		tableContainer = new JPanel();
		tableContainer.add(miBarra);
		
		mainPanel.add(btnContainer);
		mainPanel.add(tableContainer);
		
		getContentPane().add(mainPanel);
	}
}

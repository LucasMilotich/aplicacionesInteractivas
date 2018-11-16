package com.applicacionesInteractivas.vista.formularios.cines;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaCines;

public class FormElimCine extends JFrame{

	private static final long serialVersionUID = -4718031332588416051L;
	private JButton btnEliminar;
	private JTable tabCines;
	private JScrollPane mibarra;
	private TablaCines tablaCines;
	
	public FormElimCine() {
		
		this.setSize(440, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		this.setTitle("Eliminar Cine");
		
		btnEliminar = new JButton("Eliminar Cine");
		btnEliminar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.eliminarCine((String) tabCines.getValueAt(tabCines.getSelectedRow(), 0));
			JOptionPane.showMessageDialog(null,"Cine eliminado!");
			this.setVisible(false);
		});
		btnEliminar.setBounds(170, 15, 123, 28);
		btnEliminar.setEnabled(false);
		getContentPane().add(btnEliminar);
		
		tabCines = new JTable();
		tabCines.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tabCines.addMouseListener(new MouseAdapter() {
		    @Override
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
		
		mibarra = new JScrollPane();
		getContentPane().add(mibarra);
		mibarra.setBounds(20, 60, 400, 130);
		
		tablaCines = new TablaCines();
		tablaCines.setCines(CineController.getInstance().getCines());
		
		tabCines.setModel(tablaCines);
		mibarra.setViewportView(tabCines);

	}
}

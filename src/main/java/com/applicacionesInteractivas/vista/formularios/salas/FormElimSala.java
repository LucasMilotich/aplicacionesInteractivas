package com.applicacionesInteractivas.vista.formularios.salas;

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
import com.applicacionesInteractivas.vista.formularios.tabla.TablaSalas;

public class FormElimSala extends JFrame{

	private static final long serialVersionUID = -3641650585964819767L;
	private JButton btnEliminar;
	private JTable tablaSalas;
	private TablaSalas tablaSalasModel;
	private JScrollPane mibarra;
	private int idSala;

	public FormElimSala() {
		this.setSize(440, 290);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		this.setTitle("Eliminar Sala");
		
		btnEliminar = new JButton("Eliminar Sala");
		btnEliminar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.eliminarSala(idSala);
			JOptionPane.showMessageDialog(null,"Sala eliminada!");
			this.setVisible(false);
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(170, 15, 123, 28);
		getContentPane().add(btnEliminar);
		
		tablaSalas = new JTable();
		tablaSalas.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tablaSalas.addMouseListener(new MouseAdapter() {
		    @Override
			public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
		            try{
		            	idSala = (int) table.getValueAt(row, 0);
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
		mibarra.setBounds(20, 60, 400, 150);
		
		tablaSalasModel = new TablaSalas();
		tablaSalasModel.setSalas(CineController.getInstance().getSalas());
		
		tablaSalas.setModel(tablaSalasModel);
		mibarra.setViewportView(tablaSalas);
	}
}

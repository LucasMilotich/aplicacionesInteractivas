package com.applicacionesInteractivas.vista.formularios.salas;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaCines;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaSalas;

public class FormElimSala extends JFrame{

	private static final long serialVersionUID = -3641650585964819767L;
	private JButton btnEliminar;
	private JTable tablaSalas;
	private TablaSalas tablaSalasModel;
	private JScrollPane mibarra;
	private JPanel mainPanel;

	public FormElimSala() {
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Eliminar Sala");
		mainPanel = new JPanel();
		
		btnEliminar = new JButton("Eliminar Sala");
		btnEliminar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.eliminarSala((String) tablaSalas.getValueAt(tablaSalas.getSelectedRow(), 0));
			JOptionPane.showMessageDialog(null,"Sala eliminada!");
			this.setVisible(false);
		});
		btnEliminar.setEnabled(false);
		
		JPanel btnContainer = new JPanel();
		btnContainer.add(btnEliminar);
		
		tablaSalas = new JTable();
		tablaSalas.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tablaSalas.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
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
		mibarra.setBounds(40, 300, 400, 130);
		
		tablaSalasModel = new TablaSalas();
		tablaSalasModel.setSalas(CineController.getInstance().getSalas());
		
		tablaSalas.setModel(tablaSalasModel);
		mibarra.setViewportView(tablaSalas);

		JPanel tablaSalasContainer = new JPanel();
		tablaSalasContainer.add(mibarra);
		
		mainPanel.add(tablaSalasContainer);
		mainPanel.add(btnContainer);
		
		getContentPane().add(mainPanel);
	}
}

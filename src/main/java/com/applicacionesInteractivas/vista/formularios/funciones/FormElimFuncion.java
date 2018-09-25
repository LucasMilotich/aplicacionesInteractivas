package com.applicacionesInteractivas.vista.formularios.funciones;

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
import com.applicacionesInteractivas.vista.formularios.tabla.TablaFunciones;

public class FormElimFuncion extends JFrame{

	private static final long serialVersionUID = 6560295143013798697L;
	private JButton btnEliminar;
	private JTable tablaFunciones;
	private TablaFunciones tablaFuncionesModel;
	private JScrollPane miBarra;
	private JPanel btnContainer, tableContainer;
	private JPanel mainPanel;

	public FormElimFuncion() {
		
		this.setSize(320, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Eliminar Funcion");
		mainPanel = new JPanel();
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.eliminarFuncion((String) tablaFunciones.getValueAt(tablaFunciones.getSelectedRow(), 0));
			JOptionPane.showMessageDialog(null,"Funcion modificada!");
			this.setVisible(false);
		});
		btnEliminar.setEnabled(false);
		this.add(btnEliminar);
		
		tablaFunciones = new JTable();
		tablaFunciones.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tablaFunciones.addMouseListener(new MouseAdapter() {
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
		
		miBarra = new JScrollPane();
		miBarra.setBounds(40, 300, 400, 130);
		
		tablaFuncionesModel = new TablaFunciones();
		tablaFuncionesModel.setFunciones(CineController.getInstance().getFunciones());
		
		tablaFunciones.setModel(tablaFuncionesModel);
		miBarra.setViewportView(tablaFunciones);
		
		btnContainer = new JPanel();
		btnContainer.add(btnEliminar);
		
		tableContainer = new JPanel();
		tableContainer.add(miBarra);
		
		mainPanel.add(btnContainer);
		mainPanel.add(tableContainer);
		
		getContentPane().add(mainPanel);
	}
}

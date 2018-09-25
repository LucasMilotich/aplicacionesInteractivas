package com.applicacionesInteractivas.vista.formularios.salas;

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
import com.applicacionesInteractivas.vista.formularios.tabla.TablaSalas;

public class FormModifSala extends JFrame{

	private static final long serialVersionUID = -8185511184999906353L;
	private JLabel lblNombre;
	private JLabel lblCapacidad;
	private JTextField txtNombre;
	private JTextField txtCapacidad;
	private JButton btnModificar;
	private JTable tablaSalas;
	private TablaSalas tablaSalasModel;
	private JScrollPane mibarra;
	private JPanel mainPanel;
	private JPanel nombreContainer, capaContainer, btnContainer, tableContainer;
	

	public FormModifSala() {
		
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Modificar Sala");
		mainPanel = new JPanel();
		
		lblNombre = new JLabel("Nombre");
		lblCapacidad = new JLabel("Capacidad");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(12);
		txtNombre.setEditable(false);
		txtCapacidad = new JTextField();
		txtCapacidad.setColumns(12);
		txtCapacidad.setEditable(false);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.modificarSala(txtNombre.getText(),
						   Integer.parseInt(txtCapacidad.getText()));
			JOptionPane.showMessageDialog(null,"Sala modificada!");
			this.setVisible(false);
		});
		
		tablaSalas = new JTable();
		tablaSalas.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tablaSalas.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            try{
		            	txtNombre.setText((String) table.getValueAt(row, 0));
			            txtCapacidad.setText(Integer.toString((int) table.getValueAt(row, 1)));
			            txtCapacidad.setEditable(true);
			            
			            btnModificar.setEnabled(true);
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
		
		nombreContainer = new JPanel();
		nombreContainer.add(lblNombre);
		nombreContainer.add(txtNombre);
		
		capaContainer = new JPanel();
		capaContainer.add(lblCapacidad);
		capaContainer.add(txtCapacidad);
		
		btnContainer = new JPanel();
		btnContainer.add(btnModificar);
		
		tableContainer = new JPanel();
		tableContainer.add(mibarra);
		
		mainPanel.add(nombreContainer);
		mainPanel.add(capaContainer);
		mainPanel.add(btnContainer);
		mainPanel.add(tableContainer);
		
		getContentPane().add(mainPanel);
	}
}

package com.applicacionesInteractivas.vista.formularios.funciones;

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
import com.applicacionesInteractivas.vista.formularios.tabla.TablaFunciones;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaPeliculas;

public class FormModifFuncion extends JFrame{

	private static final long serialVersionUID = 1785958213568294559L;
	private JLabel lblHorario;
	private JLabel lblAsientos;
	private JTextField txtHorario;
	private JTextField txtAsientos;
	private JButton btnModificar;
	private JTable tablaFunciones;
	private TablaFunciones tablaFuncionesModel;
	private JScrollPane miBarra;
	private JPanel horarioContainer, asientoContainer, btnContainer, tableContainer;
	private JPanel mainPanel;
	
	public FormModifFuncion() {
		
		this.setSize(320, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Modificar Funcion");
		mainPanel = new JPanel();
		
		lblHorario = new JLabel("Horario");
		this.add(lblHorario);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(12);
		txtHorario.setEditable(false);
		this.add(txtHorario);
		
		lblAsientos = new JLabel("Asientos");
		this.add(lblAsientos);
		
		txtAsientos = new JTextField();
		txtAsientos.setColumns(12);
		this.add(txtAsientos);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.modificarFuncion(txtHorario.getText(),
							  txtAsientos.getText());
			JOptionPane.showMessageDialog(null,"Funcion modificada!");
			this.setVisible(false);
		});
		btnModificar.setEnabled(false);
		this.add(btnModificar);
		
		tablaFunciones = new JTable();
		tablaFunciones.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tablaFunciones.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            try{
		            	txtHorario.setText((String) table.getValueAt(row, 0));
		            	txtAsientos.setText(Integer.toString((int)table.getValueAt(row, 1)));
		            	txtAsientos.setEditable(true);
		            	
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
		
		tablaFuncionesModel = new TablaFunciones();
		tablaFuncionesModel.setFunciones(CineController.getInstance().getFunciones());
		
		tablaFunciones.setModel(tablaFuncionesModel);
		miBarra.setViewportView(tablaFunciones);
		
		horarioContainer = new JPanel();
		horarioContainer.add(lblHorario);
		horarioContainer.add(txtHorario);
		
		asientoContainer = new JPanel();
		asientoContainer.add(lblAsientos);
		asientoContainer.add(txtAsientos);
		
		btnContainer = new JPanel();
		btnContainer.add(btnModificar);
		
		tableContainer = new JPanel();
		tableContainer.add(miBarra);
		
		mainPanel.add(horarioContainer);
		mainPanel.add(asientoContainer);
		mainPanel.add(btnContainer);
		mainPanel.add(tableContainer);
		
		getContentPane().add(mainPanel);
	}
}

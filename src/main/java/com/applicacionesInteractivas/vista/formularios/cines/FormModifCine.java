package com.applicacionesInteractivas.vista.formularios.cines;

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
import com.applicacionesInteractivas.vista.formularios.tabla.TablaCines;

public class FormModifCine extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7611922162786588565L;
	private JLabel lblCuit;
	private JTextField txtCuit;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDomicilio;
	private JTextField txtDomicilio;
	private JLabel lblCantSalas;
	private JTextField txtCantSalas;
	private JLabel lblCapTotal;
	private JTextField txtCapTotal;
	private JButton btnModificar;
	private JTable tabCines;
	private TablaCines tablaCines;
	private JPanel mainPanel;
	private JScrollPane mibarra;
	
	public FormModifCine() {
		
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Modificar Cine");
		mainPanel = new JPanel();
		
		lblCuit = new JLabel("CUIT");
		lblNombre = new JLabel("Nombre");
		lblDomicilio = new JLabel("Domicilio");
		lblCantSalas = new JLabel("Cant. Salas");
		lblCapTotal = new JLabel("Cap. Total");
		
		txtCuit = new JTextField();
		txtCuit.setColumns(12);
		txtCuit.setEnabled(false);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(12);
		txtNombre.setEnabled(false);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(12);
		txtDomicilio.setEnabled(false);
		
		txtCantSalas = new JTextField();
		txtCantSalas.setColumns(12);
		txtCantSalas.setEnabled(false);
		
		txtCapTotal = new JTextField();
		txtCapTotal.setColumns(12);
		txtCapTotal.setEnabled(false);
		
		btnModificar = new JButton("Modificar Cine");
		btnModificar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			cine.modificarCine(txtCuit.getText(),
					txtNombre.getText(),
					txtDomicilio.getText(),
					Integer.parseInt(txtCantSalas.getText()),
					Integer.parseInt(txtCapTotal.getText()));
			JOptionPane.showMessageDialog(null,"Cine modificado!");
			this.setVisible(false);
		});
		btnModificar.setEnabled(false);
		
		JPanel cuitContainer = new JPanel();
		cuitContainer.add(lblCuit);
		cuitContainer.add(txtCuit);
		
		JPanel nombreContainer = new JPanel();
		nombreContainer.add(lblNombre);
		nombreContainer.add(txtNombre);
		
		JPanel domContainer = new JPanel();
		domContainer.add(lblDomicilio);
		domContainer.add(txtDomicilio);
		
		JPanel cantContainer = new JPanel();
		cantContainer.add(lblCantSalas);
		cantContainer.add(txtCantSalas);
		
		JPanel capContainer = new JPanel();
		capContainer.add(lblCapTotal);
		capContainer.add(txtCapTotal);
		
		JPanel btnContainer = new JPanel();
		btnContainer.add(btnModificar);
		
		tabCines = new JTable();
		tabCines.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tabCines.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            try{
		            	txtCuit.setText((String) table.getValueAt(row, 0));
			            txtNombre.setText((String) table.getValueAt(row, 1));
			            txtNombre.setEnabled(true);
			            txtDomicilio.setText((String) table.getValueAt(row, 2));
			            txtDomicilio.setEnabled(true);
			            txtCantSalas.setText(Integer.toString((int)table.getValueAt(row, 3)));
			            txtCantSalas.setEnabled(true);
			            txtCapTotal.setText(Integer.toString((int)table.getValueAt(row, 4)));
			            txtCapTotal.setEnabled(true);
		            
			            btnModificar.setEnabled(true);
		            }
		            catch(Exception e){
		            	e.printStackTrace();
		            }
		        }
		    }
		});

		JPanel tablaCinesContainer = new JPanel();
		
		mibarra = new JScrollPane();
		mibarra.setBounds(40, 300, 400, 130);
		
		tablaCines = new TablaCines();
		tablaCines.setCines(CineController.getInstance().getCines());
		
		tabCines.setModel(tablaCines);
		mibarra.setViewportView(tabCines);
		
		tablaCinesContainer.add(mibarra);
		
		mainPanel.add(cuitContainer);
		mainPanel.add(nombreContainer);
		mainPanel.add(domContainer);
		mainPanel.add(cantContainer);
		mainPanel.add(capContainer);
		mainPanel.add(btnContainer);
		mainPanel.add(tablaCinesContainer);
		
		getContentPane().add(mainPanel);
		
	}
}

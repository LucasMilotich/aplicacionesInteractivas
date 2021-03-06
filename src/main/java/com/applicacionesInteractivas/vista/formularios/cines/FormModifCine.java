package com.applicacionesInteractivas.vista.formularios.cines;

import java.awt.Dimension;
import java.awt.Point;
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
import com.applicacionesInteractivas.vista.formularios.tabla.TablaCines;
import com.applicacionesInteractivas.vista.formularios.utils.ValidadorCampo;

public class FormModifCine extends JFrame{

	private static final long serialVersionUID = -7611922162786588565L;
	private JLabel lblCuit;
	private JTextField txtCuit;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDomicilio;
	private JTextField txtDomicilio;
	private JButton btnModificar;
	private JTable tabCines;
	private TablaCines tablaCines;
	private JScrollPane mibarra;
	
	public FormModifCine() {
		
		this.setSize(480, 380);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		this.setTitle("Modificar Cine");
		
		lblCuit = new JLabel("CUIT");
		lblCuit.setBounds(21, 40, 120, 28);
		getContentPane().add(lblCuit);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(21, 80, 120, 28);
		getContentPane().add(lblNombre);
		
		lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(21, 120, 120, 28);
		getContentPane().add(lblDomicilio);
		
		txtCuit = new JTextField();
		txtCuit.setBounds(130, 40, 120, 28);
		getContentPane().add(txtCuit);
		txtCuit.setEnabled(false);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(130, 80, 120, 28);
		this.txtNombre.addKeyListener(ValidadorCampo.lengthValidador(49, "NOMBRE"));
		getContentPane().add(txtNombre);
		txtNombre.setEnabled(false);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setBounds(130, 120, 120, 28);
		this.txtDomicilio.addKeyListener(ValidadorCampo.lengthValidador(49, "DOMICILIO"));
		getContentPane().add(txtDomicilio);
		txtDomicilio.setEnabled(false);
		
		btnModificar = new JButton("Modificar Cine");
		btnModificar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			String cuit = txtCuit.getText();
			String nombre = txtNombre.getText();
			String domicilio = txtDomicilio.getText();
			if(cuit.equals("") || nombre.equals("") || domicilio.equals("")) {
				JOptionPane.showMessageDialog(null, "Hay campos sin completar!", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			cine.modificarCine(cuit,nombre,domicilio);
			JOptionPane.showMessageDialog(null,"Cine modificado!");
			this.setVisible(false);
		});
		btnModificar.setBounds(180, 165, 123, 28);
		getContentPane().add(btnModificar);
		btnModificar.setEnabled(false);
		
		tabCines = new JTable();
		tabCines.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tabCines.addMouseListener(new MouseAdapter() {
		    @Override
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
		            
			            btnModificar.setEnabled(true);
		            }
		            catch(Exception e){
		            	e.printStackTrace();
		            }
		        }
		    }
		});

		mibarra = new JScrollPane();
		mibarra.setBounds(20, 210, 440, 130);
		getContentPane().add(mibarra);
		
		tablaCines = new TablaCines();
		tablaCines.setCines(CineController.getInstance().getCines());
		
		tabCines.setModel(tablaCines);
		mibarra.setViewportView(tabCines);
		
	}
}

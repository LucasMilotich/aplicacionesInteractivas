package com.applicacionesInteractivas.vista.formularios.salas;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.vista.formularios.utils.ValidadorCampo;

public class FormAltaSala extends JFrame{

	private static final long serialVersionUID = 7042214256613114521L;
	private JComboBox<String> comboCine;
	private Vector<String> listadoCines;
	private JLabel lblCine;
	private JLabel lblNombre;
	private JLabel lblFilas;
	private JLabel lblColumnas;
	private JTextField txtNombre;
	private JTextField txtFilas;
	private JTextField txtColumnas;
	private JButton btnConfirmar;

	public FormAltaSala() {
		
		this.setSize(380, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		this.setTitle("Crear Sala");
		
		lblCine = new JLabel("Cine");
		lblCine.setBounds(20, 40, 120, 28);
		getContentPane().add(lblCine);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 80, 120, 28);
		getContentPane().add(lblNombre);
		
		lblFilas = new JLabel("Filas");
		lblFilas.setBounds(20, 120, 120, 28);
		getContentPane().add(lblFilas);
		
		lblColumnas = new JLabel("Columnas");
		lblColumnas.setBounds(20, 160, 120, 28);
		getContentPane().add(lblColumnas);
		
		listadoCines = CineController.getInstance().getListadoCines();
		ComboBoxModel<String> cineModel = new DefaultComboBoxModel<String>(listadoCines);
		comboCine = new JComboBox<String>();
		comboCine.setBounds(130, 40, 200, 28);
		comboCine.setModel(cineModel);
		comboCine.setSelectedItem(null);
		getContentPane().add(comboCine);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(130, 80, 120, 28);
		this.txtNombre.addKeyListener(ValidadorCampo.lengthValidador(49, "NOMBRE"));
		getContentPane().add(txtNombre);
		
		txtFilas = new JTextField();
		txtFilas.setBounds(130, 120, 120, 28);
		this.txtFilas.addKeyListener(ValidadorCampo.numberValidator(1, "FILAS"));
		getContentPane().add(txtFilas);
		
		txtColumnas = new JTextField();
		txtColumnas.setBounds(130, 160, 120, 28);
		this.txtColumnas.addKeyListener(ValidadorCampo.numberValidator(1, "COLUMNAS"));
		getContentPane().add(txtColumnas);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(e -> {
			CineController cineController = CineController.getInstance();
			String cuit = String.valueOf(comboCine.getSelectedItem()).split(" - ")[0];
			String nombre = txtNombre.getText();
			String filas = txtFilas.getText();
			String columnas = txtColumnas.getText();
			if(cuit.equals("") || nombre.equals("") || filas.equals("") || columnas.equals("")) {
				JOptionPane.showMessageDialog(null, "Hay campos sin completar!", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			Cine c = cineController.getCine(cuit);
			cineController.crearSala(nombre,Integer.parseInt(filas),Integer.parseInt(columnas),c);
			JOptionPane.showMessageDialog(null,"Sala creada!");
			this.setVisible(false);
		});
		btnConfirmar.setBounds(120, 210, 120, 28);
		getContentPane().add(btnConfirmar);

	}
}

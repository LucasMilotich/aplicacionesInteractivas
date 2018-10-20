package com.applicacionesInteractivas.vista.formularios.salas;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.modelo.Cine;

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
	private JPanel mainPanel;
	private JPanel panel0, panel1, panel2, panel3, panel4;

	public FormAltaSala() {
		
		this.setSize(320, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Crear Sala");
		
		listadoCines = CineController.getInstance().getListadoCines();
		ComboBoxModel<String> cineModel = new DefaultComboBoxModel<String>(listadoCines);
		comboCine = new JComboBox<String>();
		comboCine.setModel(cineModel);
		comboCine.setSelectedItem(null);
		this.add(comboCine);
		
		lblCine = new JLabel("Cine");
		this.add(lblCine);
		lblNombre = new JLabel("Nombre");
		this.add(lblNombre);
		lblFilas = new JLabel("Filas");
		this.add(lblFilas);
		lblColumnas = new JLabel("Columnas");
		this.add(lblColumnas);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(12);
		this.add(txtNombre);
		
		txtFilas = new JTextField();
		txtFilas.setColumns(12);
		this.add(txtFilas);
		
		txtColumnas = new JTextField();
		txtColumnas.setColumns(12);
		this.add(txtColumnas);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(e -> {
			CineController cineController = CineController.getInstance();
			Cine c = cineController.getCine(String.valueOf(comboCine.getSelectedItem()).split(" - ")[0]);
			cineController.crearSala(txtNombre.getText(),
						   Integer.parseInt(txtFilas.getText()),
						   Integer.parseInt(txtColumnas.getText()),
						   c);
			JOptionPane.showMessageDialog(null,"Sala creada!");
			this.setVisible(false);
		});
		
		mainPanel = new JPanel();
		
		panel0 = new JPanel();
		panel0.add(lblCine);
		panel0.add(comboCine);
		
		panel1 = new JPanel();
		panel1.add(lblNombre);
		panel1.add(txtNombre);
		
		panel2 = new JPanel();
		panel2.add(lblFilas);
		panel2.add(txtFilas);
		
		panel3 = new JPanel();
		panel3.add(lblColumnas);
		panel3.add(txtColumnas);
		
		panel4 = new JPanel();
		panel4.add(btnConfirmar);

		mainPanel.add(panel0);
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		
		getContentPane().add(mainPanel);
	}
}

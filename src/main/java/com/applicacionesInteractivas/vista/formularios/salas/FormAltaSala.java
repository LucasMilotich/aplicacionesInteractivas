package com.applicacionesInteractivas.vista.formularios.salas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
		this.txtNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(txtNombre	.getText().length() > 49)
					e.consume();
			}
		});
		getContentPane().add(txtNombre);
		
		txtFilas = new JTextField();
		txtFilas.setBounds(130, 120, 120, 28);
		this.txtFilas.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(txtFilas.getText().length() > 1)
					e.consume();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					JOptionPane.showMessageDialog(null, "El campo 'Filas' solo permite numeros");
					e.consume();
				}
			}
		});
		getContentPane().add(txtFilas);
		
		txtColumnas = new JTextField();
		txtColumnas.setBounds(130, 160, 120, 28);
		this.txtColumnas.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(txtColumnas.getText().length() > 1)
					e.consume();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					JOptionPane.showMessageDialog(null, "El campo 'Columnas' solo permite numeros");
					e.consume();
				}
			}
		});
		getContentPane().add(txtColumnas);
		
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
		btnConfirmar.setBounds(120, 210, 120, 28);
		getContentPane().add(btnConfirmar);

	}
}

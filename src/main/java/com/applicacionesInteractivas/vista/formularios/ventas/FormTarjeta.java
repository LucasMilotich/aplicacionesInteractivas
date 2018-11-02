package com.applicacionesInteractivas.vista.formularios.ventas;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.applicacionesInteractivas.modelo.medioDePago.Tarjeta;
import com.applicacionesInteractivas.modelo.medioDePago.TarjetaCredito;
import com.applicacionesInteractivas.modelo.medioDePago.TarjetaDebito;

public class FormTarjeta extends JFrame{

	private static final long serialVersionUID = -7987651527844137711L;
	private JLabel lblTipoTarjeta;
	private JLabel lblNumero;
	private JLabel lblVencimiento;
	private JLabel lblCodigo;
	private JComboBox<String> cmbTipoTarjeta;
	private JTextField txtNumero;
	private JTextField txtVencimiento;
	private JTextField txtCodigo;
	private String[] listaTipos = {"AMEX", "MasterCard", "Visa"};
	private JButton btnGuardar;
	private JPanel mainPanel;
	private JPanel tipoContainer, numContainer, vencContainer, codContainer, btnContainer;
	
	public FormTarjeta() {
		this.setSize(400, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("TPO API 2C2018");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		lblTipoTarjeta = new JLabel("Tipo Tarjeta");
		this.add(lblTipoTarjeta);
		
		lblNumero = new JLabel("Numero Tarjeta");
		this.add(lblNumero);
		
		lblVencimiento = new JLabel("Vencimiento");
		this.add(lblVencimiento);
		
		lblCodigo = new JLabel("Codigo Seguridad");
		this.add(lblCodigo);
		
		cmbTipoTarjeta = new JComboBox<String>(listaTipos);
		this.add(cmbTipoTarjeta);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(20);
		this.add(txtNumero);
		
		txtVencimiento = new JTextField();
		txtVencimiento.setColumns(12);
		this.add(txtVencimiento);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(12);
		this.add(txtCodigo);
		
		btnGuardar = new JButton("Guardar y volver");
		btnGuardar.addActionListener(e -> {
			this.setVisible(false);
		});
		this.add(btnGuardar);
		
		mainPanel = new JPanel();
		
		tipoContainer = new JPanel();
		tipoContainer.add(lblTipoTarjeta);
		tipoContainer.add(cmbTipoTarjeta);
		
		numContainer = new JPanel();
		numContainer.add(lblNumero);
		numContainer.add(txtNumero);
		
		vencContainer = new JPanel();
		vencContainer.add(lblVencimiento);
		vencContainer.add(txtVencimiento);
		
		codContainer = new JPanel();
		codContainer.add(lblCodigo);
		codContainer.add(txtCodigo);
		
		btnContainer = new JPanel();
		btnContainer.add(btnGuardar);
		
		mainPanel.add(tipoContainer);
		mainPanel.add(numContainer);
		mainPanel.add(vencContainer);
		mainPanel.add(codContainer);
		mainPanel.add(btnContainer);
		
		getContentPane().add(mainPanel);
	}

	public Tarjeta getDatosTarjeta(String formaPago) {
		String tipo = (String)cmbTipoTarjeta.getSelectedItem();
		String numero = (String)txtNumero.getText();
		String vencimiento = (String)txtVencimiento.getText();
		String codigo = (String)txtCodigo.getText();
		Tarjeta tarjeta;
		if(formaPago.equals("TARJETA CREDITO"))
			tarjeta = new TarjetaCredito(tipo, numero, vencimiento, codigo);
		else
			tarjeta = new TarjetaDebito(tipo, numero, vencimiento, codigo);
		
		return tarjeta;
	}
	
}

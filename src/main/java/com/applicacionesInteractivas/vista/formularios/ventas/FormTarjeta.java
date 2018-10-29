package com.applicacionesInteractivas.vista.formularios.ventas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormTarjeta extends JFrame{

	private static final long serialVersionUID = -7987651527844137711L;
	private JLabel lblTipoTarjeta;
	private JLabel lblNumero;
	private JLabel lblVencimiento;
	private JLabel lblCodigo;
	private JTextField txtTipoTarjeta;
	private JTextField txtNumero;
	private JTextField txtVencimiento;
	private JTextField txtCodigo;
	private JPanel mainPanel;
	private JPanel tipoContainer, numContainer, vencContainer, codContainer;
	
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
		
		
		
	}
	
}

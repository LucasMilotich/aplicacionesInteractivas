package com.applicacionesInteractivas.vista.formularios.ventas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	
	public FormTarjeta() {
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("TPO API 2C2018");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		lblTipoTarjeta = new JLabel("Tipo Tarjeta");
		lblTipoTarjeta.setBounds(20, 40, 120, 28);
		getContentPane().add(lblTipoTarjeta);
		
		lblNumero = new JLabel("Numero Tarjeta");
		lblNumero.setBounds(20, 80, 120, 28);
		getContentPane().add(lblNumero);
		
		lblVencimiento = new JLabel("Vencimiento");
		lblVencimiento.setBounds(20, 120, 120, 28);
		getContentPane().add(lblVencimiento);
		
		lblCodigo = new JLabel("Codigo Seguridad");
		lblCodigo.setBounds(20, 160, 120, 28);
		getContentPane().add(lblCodigo);
		
		cmbTipoTarjeta = new JComboBox<String>(listaTipos);
		cmbTipoTarjeta.setBounds(130, 40, 120, 28);
		getContentPane().add(cmbTipoTarjeta);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(130, 80, 120, 28);
		this.txtNumero.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(txtNumero.getText().length() > 15)
					e.consume();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					JOptionPane.showMessageDialog(null, "El campo 'Numero Tarjeta' solo permite numeros.");
					e.consume();
				}
			}
		});
		getContentPane().add(txtNumero);
		
		txtVencimiento = new JTextField();
		txtVencimiento.setBounds(130, 120, 120, 28);
		this.txtVencimiento.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(txtVencimiento.getText().length() > 3)
					e.consume();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					JOptionPane.showMessageDialog(null, "El campo 'Vencimiento' solo permite numeros, en el formato MMAA(M:mes,A:anio).");
					e.consume();
				}
			}
		});
		getContentPane().add(txtVencimiento);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(130, 160, 120, 28);
		this.txtCodigo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				int cant;
				String tipo = (String)cmbTipoTarjeta.getSelectedItem();
				if(tipo.equals("AMEX"))
					cant = 4;
				else
					cant = 3;
				if(txtCodigo.getText().length() > cant - 1)
					e.consume();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					JOptionPane.showMessageDialog(null, "El campo 'Codigo Seguridad' solo permite numeros");
					e.consume();
				}
			}
		});
		getContentPane().add(txtCodigo);
		
		btnGuardar = new JButton("Guardar y volver");
		btnGuardar.addActionListener(e -> {
			this.setVisible(false);
		});
		btnGuardar.setBounds(120, 200, 140, 28);
		getContentPane().add(btnGuardar);
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

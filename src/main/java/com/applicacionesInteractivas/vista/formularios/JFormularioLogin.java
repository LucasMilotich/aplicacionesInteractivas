package com.applicacionesInteractivas.vista.formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.UsuarioController;

public class JFormularioLogin extends JFrame {

	/**
	 * 
	 */
	private JPanel mainPanel;
	private static final long serialVersionUID = -5455094967026569026L;
	
	public JFormularioLogin() {

		this.setSize(320, 240);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("TPO API 2C2018");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsuario = new JLabel();
		lblUsuario.setText("Usuario");
		this.add(lblUsuario);
		
		JTextField txtUsuario = new JTextField();
		txtUsuario.setColumns(12);
		this.add(txtUsuario);
		
		JLabel lblContrasena = new JLabel();
		lblContrasena.setText("Contrasena");
		this.add(lblContrasena);
		
		JPasswordField txtContrasena = new JPasswordField();
		txtContrasena.setColumns(12);
		this.add(txtContrasena);
		
		JButton btnConfirmar = new JButton();
		btnConfirmar.setText("Confirmar");
		btnConfirmar.addActionListener(e -> {
			UsuarioController usuarioController = UsuarioController.getInstance();
			String username = txtUsuario.getText();
			String password = String.copyValueOf(txtContrasena.getPassword());
			boolean acceso = usuarioController.validarAcceso(username, password);
			if (acceso) {
				JFormularioMenuPpal form2 = new JFormularioMenuPpal();
				this.setVisible(false);
				form2.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "El usuario y contrasenia ingresados son incorrectos. Por favor verifiquelos.");
			}
		});
		this.add(btnConfirmar);
		
		this.mainPanel = new JPanel();
		
		JPanel usuarioContainer = new JPanel();
		usuarioContainer.add(lblUsuario);
		usuarioContainer.add(txtUsuario);
		
		JPanel ContrasenaContainer = new JPanel();
		ContrasenaContainer.add(lblContrasena);
		ContrasenaContainer.add(txtContrasena);
		
		JPanel botonContainer = new JPanel();
		botonContainer.add(btnConfirmar);
		
		this.mainPanel.add(usuarioContainer);		
		this.mainPanel.add(ContrasenaContainer);
		this.mainPanel.add(botonContainer);
		
		getContentPane().add(mainPanel);
		
	}

}

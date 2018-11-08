package com.applicacionesInteractivas.vista.formularios;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.UsuarioController;
import com.applicacionesInteractivas.modelo.rol.IRol;

public class JFormularioLogin extends JFrame {

	private static final long serialVersionUID = -5455094967026569026L;
	
	public JFormularioLogin() {

		this.setSize(320, 240);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("TPO API 2C2018");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel();
		lblUsuario.setText("Usuario");
		lblUsuario.setBounds(40, 30, 120, 28);
		getContentPane().add(lblUsuario);
		
		JTextField txtUsuario = new JTextField();
		txtUsuario.setColumns(12);
		txtUsuario.setBounds(130, 30, 120, 28);
		getContentPane().add(txtUsuario);
		
		JLabel lblContrasena = new JLabel();
		lblContrasena.setText("Contrasena");
		lblContrasena.setBounds(40, 70, 120, 28);
		getContentPane().add(lblContrasena);
		
		JPasswordField txtContrasena = new JPasswordField();
		txtContrasena.setBounds(130, 70, 120, 28);
		getContentPane().add(txtContrasena);
		
		JButton btnConfirmar = new JButton();
		btnConfirmar.setText("Confirmar");
		btnConfirmar.addActionListener(e -> {
			UsuarioController usuarioController = UsuarioController.getInstance();
			String username = txtUsuario.getText();
			String password = String.copyValueOf(txtContrasena.getPassword());
			boolean acceso = usuarioController.validarAcceso(username, password);
			if (acceso) {
				List<IRol> rolesUsuario = usuarioController.getRoles(username);
				JFormularioMenuPpal form2 = new JFormularioMenuPpal(rolesUsuario);
				this.setVisible(false);
				form2.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "El usuario y contrasenia ingresados son incorrectos. Por favor verifiquelos.");
			}
		});
		btnConfirmar.setBounds(100, 130, 120, 28);
		getContentPane().add(btnConfirmar);
		
	}

}

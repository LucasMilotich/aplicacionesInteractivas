package uade.api.vista.formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
		
		JLabel lblContrase�a = new JLabel();
		lblContrase�a.setText("Contrase�a");
		this.add(lblContrase�a);
		
		JPasswordField txtContrase�a = new JPasswordField();
		txtContrase�a.setColumns(12);
		this.add(txtContrase�a);
		
		JButton btnConfirmar = new JButton();
		btnConfirmar.setText("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form2 = new JFormularioMenuPpal();
				form2.setVisible(true);
			}
		});
		this.add(btnConfirmar);
		
		this.mainPanel = new JPanel();
		
		JPanel usuarioContainer = new JPanel();
		usuarioContainer.add(lblUsuario);
		usuarioContainer.add(txtUsuario);
		
		JPanel contrase�aContainer = new JPanel();
		contrase�aContainer.add(lblContrase�a);
		contrase�aContainer.add(txtContrase�a);
		
		JPanel botonContainer = new JPanel();
		botonContainer.add(btnConfirmar);
		
		this.mainPanel.add(usuarioContainer);		
		this.mainPanel.add(contrase�aContainer);
		this.mainPanel.add(botonContainer);
		
		getContentPane().add(mainPanel);
		
	}

}

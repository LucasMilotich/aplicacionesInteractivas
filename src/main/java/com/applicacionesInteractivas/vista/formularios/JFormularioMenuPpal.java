package com.applicacionesInteractivas.vista.formularios;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.controllers.UsuarioController;
import com.applicacionesInteractivas.vista.formularios.usuarios.JFormABMUsuario;
import com.applicacionesInteractivas.vista.formularios.usuarios.JFormularioAltaUsuario;

import java.awt.FlowLayout;

import javax.swing.*;

public class JFormularioMenuPpal extends JFrame{

	/**
	 * 
	 */
	private JPanel mainPanel = new JPanel();
	private static final long serialVersionUID = -704300453015702288L;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuCine = new JMenu("Cine");
	private JMenuItem altaCineMenuItem = new JMenuItem("Alta cine");

	private JMenu usuarioMenu = new JMenu("Usuario");
	private JMenuItem crearUsuarioMenuItem = new JMenuItem("Crear usuario");
	private JMenuItem abmUsuarioMenuItem = new JMenuItem("ABM Usuario");


	
	public JFormularioMenuPpal() {
		
		this.setSize(800, 800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("TPO API 2C2018");
		this.getContentPane().setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		this.setJMenuBar(menuBar);
		mainPanel.add(menuCine);
		menuBar.add(menuCine);
		menuCine.add(altaCineMenuItem);


		usuarioInit();

		altaCineMenuItem.addActionListener(e -> {
			JFormularioAltaCine altaCineForm = new JFormularioAltaCine();
			CineController.getInstance().setFormularioAltaCine(altaCineForm);
			altaCineForm.setVisible(true);
		});

	}

	private void usuarioInit(){
		UsuarioController usuarioController = UsuarioController.getInstance();

		mainPanel.add(usuarioMenu);
		menuBar.add(usuarioMenu);
		usuarioMenu.add(crearUsuarioMenuItem);
		usuarioMenu.add(abmUsuarioMenuItem);

		crearUsuarioMenuItem.addActionListener(e -> {
			JFormularioAltaUsuario altaUsuarioForm = new JFormularioAltaUsuario();
			usuarioController.setFormularioAltaUsuariol(altaUsuarioForm);
			altaUsuarioForm.setVisible(true);
		});

		abmUsuarioMenuItem.addActionListener(e -> {
			JFormABMUsuario abmUsuario= new JFormABMUsuario();
			usuarioController.setAbmUsuario(abmUsuario);
			abmUsuario.setVisible(true);
		});
	}

}

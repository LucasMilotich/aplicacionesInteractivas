package com.applicacionesInteractivas.vista.formularios;

import com.applicacionesInteractivas.controllers.CineController;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		altaCineMenuItem.addActionListener(e -> {
			JFormularioAltaCine altaCineForm = new JFormularioAltaCine();
			CineController.getInstance().setFormularioAltaCine(altaCineForm);
			altaCineForm.setVisible(true);
		});


		


	}

}

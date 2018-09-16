package com.applicacionesInteractivas.vista.formularios;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFormularioMenuPpal extends JFrame{

	/**
	 * 
	 */
	private JPanel mainPanel;
	private static final long serialVersionUID = -704300453015702288L;
	
	public JFormularioMenuPpal() {
		
		this.setSize(320, 220);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("TPO API 2C2018");
		this.getContentPane().setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnUsuarioController = new JButton("Usuario Controller");
		btnUsuarioController.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form1 = new JFormularioAdminUsuarios();
				form1.setVisible(true);
			}
		});
		this.add(btnUsuarioController);
		
		JButton btnRolController = new JButton("Rol Controller");
		btnRolController.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form1 = new JFormularioAdminRoles();
				form1.setVisible(true);
			}
		});
		this.add(btnRolController);
		
		JButton btnCineController = new JButton("Cine Controller");
		btnCineController.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form1 = new JFormularioAdminCines();
				form1.setVisible(true);
			}
		});
		this.add(btnCineController);
		
		JButton btnSalaController = new JButton("Sala Controller");
		btnSalaController.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form1 = new JFormularioAdminSalas();
				form1.setVisible(true);
			}
		});
		this.add(btnSalaController);
		
		JButton btnPeliculaController = new JButton("Pelicula Controller");
		btnPeliculaController.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form1 = new JFormularioAdminPeliculas();
				form1.setVisible(true);
			}
		});
		this.add(btnPeliculaController);
		
		JButton btnFuncionController = new JButton("Funcion Controller");
		btnFuncionController.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form1 = new JFormularioAdminFunciones();
				form1.setVisible(true);
			}
		});
		this.add(btnFuncionController);
		
		JButton btnDescuentoController = new JButton("Descuento Controller");
		btnDescuentoController.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form1 = new JFormularioAdminDescuentos();
				form1.setVisible(true);
			}
		});
		this.add(btnDescuentoController);

	}

}

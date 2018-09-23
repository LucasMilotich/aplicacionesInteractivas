package com.applicacionesInteractivas.vista.formularios;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.controllers.UsuarioController;
import com.applicacionesInteractivas.vista.formularios.usuarios.JFormABMUsuario;
import com.applicacionesInteractivas.vista.formularios.usuarios.JFormularioAltaUsuario;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.vista.formularios.cines.FormAltaCine;
import com.applicacionesInteractivas.vista.formularios.cines.FormElimCine;
import com.applicacionesInteractivas.vista.formularios.cines.FormModifCine;
import com.applicacionesInteractivas.vista.formularios.funciones.FormAltaFuncion;
import com.applicacionesInteractivas.vista.formularios.funciones.FormElimFuncion;
import com.applicacionesInteractivas.vista.formularios.funciones.FormModifFuncion;
import com.applicacionesInteractivas.vista.formularios.peliculas.FormAltaPelicula;
import com.applicacionesInteractivas.vista.formularios.peliculas.FormElimPelicula;
import com.applicacionesInteractivas.vista.formularios.peliculas.FormModifPelicula;
import com.applicacionesInteractivas.vista.formularios.salas.FormAltaSala;
import com.applicacionesInteractivas.vista.formularios.salas.FormElimSala;
import com.applicacionesInteractivas.vista.formularios.salas.FormModifSala;

public class JFormularioMenuPpal extends JFrame{

	/**
	 * 
	 */
	private JPanel mainPanel = new JPanel();
	private static final long serialVersionUID = -704300453015702288L;
	private JMenuBar menuBar = new JMenuBar();

	// Cines
	private JMenu menuCine = new JMenu("Cine");
	private JMenuItem altaCineMenuItem = new JMenuItem("Alta Cine");
	private JMenuItem modifCineMenuItem = new JMenuItem("Modificar Cine");
	private JMenuItem elimCineMenuItem = new JMenuItem("Eliminar Cine");


	// Salas
	private JMenu menuSalas = new JMenu("Salas");
	private JMenuItem altaSalaMenuItem = new JMenuItem("Alta Sala");
	private JMenuItem modifSalaMenuItem = new JMenuItem("Modificar Sala");
	private JMenuItem elimSalaMenuItem = new JMenuItem("Eliminar Sala");

	// Peliculas
	private JMenu menuPeliculas = new JMenu("Peliculas");
	private JMenuItem altaPeliculaMenuItem = new JMenuItem("Alta Pelicula");
	private JMenuItem modifPeliculaMenuItem = new JMenuItem("Modificar Pelicula");
	private JMenuItem elimPeliculaMenuItem = new JMenuItem("Eliminar Pelicula");

	// Usuarios
    private JMenu usuarioMenu = new JMenu("Usuario");
    private JMenuItem crearUsuarioMenuItem = new JMenuItem("Crear usuario");
    private JMenuItem abmUsuarioMenuItem = new JMenuItem("ABM Usuario");



	// Funciones
	private JMenu menuFunciones = new JMenu("Funciones");
	private JMenuItem altaFuncionMenuItem = new JMenuItem("Alta Funcion");
	private JMenuItem modifFuncionMenuItem = new JMenuItem("Modificar Funcion");
	private JMenuItem elimFuncionMenuItem = new JMenuItem("Eliminar Funcion");

    public JFormularioMenuPpal() {
		
		this.setSize(800, 800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("TPO API 2C2018");
		this.getContentPane().setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(menuBar);

		cineInit();
		salasInit();
		peliculasInit();
		funcionesInit();
        usuarioInit();

	}

	private void cineInit() {
		mainPanel.add(menuCine);
		menuBar.add(menuCine);

		menuCine.add(altaCineMenuItem);




		altaCineMenuItem.addActionListener(e -> {
			FormAltaCine altaCineForm = new FormAltaCine();
			CineController.getInstance().setFormularioAltaCine(altaCineForm);
			altaCineForm.setVisible(true);
		});

		menuCine.add(modifCineMenuItem);
		modifCineMenuItem.addActionListener(e -> {
			FormModifCine modifCineForm = new FormModifCine();
			CineController.getInstance().setFormularioModifCine(modifCineForm);
			modifCineForm.setVisible(true);
		});

		menuCine.add(elimCineMenuItem);
		elimCineMenuItem.addActionListener(e -> {
			FormElimCine elimCineForm = new FormElimCine();
			CineController.getInstance().setFormularioElimCine(elimCineForm);
			elimCineForm.setVisible(true);
		});
	}


	private void salasInit() {
		mainPanel.add(menuSalas);
		menuBar.add(menuSalas);

		menuSalas.add(altaSalaMenuItem);
		altaSalaMenuItem.addActionListener(e -> {
			FormAltaSala altaSalaForm = new FormAltaSala();
			CineController.getInstance().setFormularioAltaSala(altaSalaForm);
			altaSalaForm.setVisible(true);
		});

		menuSalas.add(modifSalaMenuItem);
		modifSalaMenuItem.addActionListener(e -> {
			FormModifSala modifSalaForm = new FormModifSala();
			CineController.getInstance().setFormularioModifSala(modifSalaForm);
			modifSalaForm.setVisible(true);
		});

		menuSalas.add(elimSalaMenuItem);
		elimSalaMenuItem.addActionListener(e -> {
			FormElimSala elimSalaForm = new FormElimSala();
			CineController.getInstance().setFormularioElimSala(elimSalaForm);
			elimSalaForm.setVisible(true);
		});
	}


	private void peliculasInit() {
		mainPanel.add(menuPeliculas);
		menuBar.add(menuPeliculas);

		menuPeliculas.add(altaPeliculaMenuItem);
		altaPeliculaMenuItem.addActionListener(e -> {
			FormAltaPelicula altaPeliculaForm = new FormAltaPelicula();
			CineController.getInstance().setFormularioAltaPelicula(altaPeliculaForm);
			altaPeliculaForm.setVisible(true);
		});

		menuPeliculas.add(modifPeliculaMenuItem);
		modifPeliculaMenuItem.addActionListener(e -> {
			FormModifPelicula modifPeliculaForm = new FormModifPelicula();
			CineController.getInstance().setFormularioModifPelicula(modifPeliculaForm);
			modifPeliculaForm.setVisible(true);
		});

		menuPeliculas.add(elimPeliculaMenuItem);
		elimPeliculaMenuItem.addActionListener(e -> {
			FormElimPelicula elimPeliculaForm = new FormElimPelicula();
			CineController.getInstance().setFormularioElimPelicula(elimPeliculaForm);
			elimPeliculaForm.setVisible(true);
		});
	}

	private void funcionesInit() {
		mainPanel.add(menuFunciones);
		menuBar.add(menuFunciones);

		menuFunciones.add(altaFuncionMenuItem);
		altaFuncionMenuItem.addActionListener(e -> {
			FormAltaFuncion altaFuncionForm = new FormAltaFuncion();
			CineController.getInstance().setFormularioAltaFuncion(altaFuncionForm);
			altaFuncionForm.setVisible(true);
		});

		menuFunciones.add(modifFuncionMenuItem);
		modifFuncionMenuItem.addActionListener(e -> {
			FormModifFuncion modifFuncionForm = new FormModifFuncion();
			CineController.getInstance().setFormularioModifFuncion(modifFuncionForm);
			modifFuncionForm.setVisible(true);
		});

		menuFunciones.add(elimFuncionMenuItem);
		elimFuncionMenuItem.addActionListener(e -> {
			FormElimFuncion elimFuncionForm = new FormElimFuncion();
			CineController.getInstance().setFormularioElimFuncion(elimFuncionForm);
			elimFuncionForm.setVisible(true);
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

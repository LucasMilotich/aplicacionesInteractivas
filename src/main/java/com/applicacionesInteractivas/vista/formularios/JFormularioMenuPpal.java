package com.applicacionesInteractivas.vista.formularios;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.controllers.DescuentoController;
import com.applicacionesInteractivas.controllers.UsuarioController;
import com.applicacionesInteractivas.controllers.VentaController;
import com.applicacionesInteractivas.vista.formularios.descuentos.FormAltaDescuento;
import com.applicacionesInteractivas.vista.formularios.descuentos.FormElimDescuento;
import com.applicacionesInteractivas.vista.formularios.descuentos.FormModifDescuento;
import com.applicacionesInteractivas.vista.formularios.terminal.TerminalForm;
import com.applicacionesInteractivas.vista.formularios.usuarios.ABMUsuario;
import com.applicacionesInteractivas.vista.formularios.usuarios.AltaUsuario;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
import com.applicacionesInteractivas.vista.formularios.usuarios.EliminarUsuario;
import com.applicacionesInteractivas.vista.formularios.usuarios.roles.ABMRoles;
import com.applicacionesInteractivas.vista.formularios.ventas.VentaBoleteria;

public class JFormularioMenuPpal extends JFrame {

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
    private JMenuItem abmRoles = new JMenuItem("ABM Roles");
    private JMenuItem eliminarUsuario = new JMenuItem("Eliminar Usuario");

    // Funciones
    private JMenu menuFunciones = new JMenu("Funciones");
    private JMenuItem altaFuncionMenuItem = new JMenuItem("Alta Funcion");
    private JMenuItem modifFuncionMenuItem = new JMenuItem("Modificar Funcion");
    private JMenuItem elimFuncionMenuItem = new JMenuItem("Eliminar Funcion");

    //Ventas
    private JMenu menuVentas = new JMenu("Ventas");
    private JMenuItem ventaBoleteriaMenuItem = new JMenuItem("Venta boleteria");

    //Descuentos
    private JMenu menuDescuentos = new JMenu("Descuentos");
    private JMenuItem menuAltaDescuento = new JMenuItem("Alta Descuento");
    private JMenuItem menuModificarDescuento = new JMenuItem("Modificar descuento");
    private JMenuItem menuBajaDescuento = new JMenuItem("Baja descuento");

    //Terminal
    private JMenu menuTerminal = new JMenu("Terminal");
    private JMenuItem menuRetirarVenta = new JMenuItem("Retirar");

    public JFormularioMenuPpal() {

        this.setSize(600, 600);
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
        ventaInit();
        descuentoInit();
        terminalInit();

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

    private void usuarioInit() {
        UsuarioController usuarioController = UsuarioController.getInstance();

        mainPanel.add(usuarioMenu);
        menuBar.add(usuarioMenu);
        usuarioMenu.add(crearUsuarioMenuItem);
        usuarioMenu.add(abmUsuarioMenuItem);
        usuarioMenu.add(abmRoles);
        usuarioMenu.add(eliminarUsuario);

        crearUsuarioMenuItem.addActionListener(e -> {
            AltaUsuario altaUsuarioForm = new AltaUsuario();
            usuarioController.setFormularioAltaUsuario(altaUsuarioForm);
            altaUsuarioForm.setVisible(true);
        });

        abmUsuarioMenuItem.addActionListener(e -> {
            ABMUsuario abmUsuario = new ABMUsuario();
            usuarioController.setAbmUsuario(abmUsuario);
            abmUsuario.setVisible(true);
        });

        abmRoles.addActionListener(e -> {
            ABMRoles abmRoles = new ABMRoles();
            usuarioController.setAbmRoles(abmRoles);
            abmRoles.setVisible(true);
        });

        eliminarUsuario.addActionListener(e -> {
            EliminarUsuario eliminarUsuario = new EliminarUsuario();
            usuarioController.setEliminarUsuario(eliminarUsuario);
            eliminarUsuario.setVisible(true);
        });
    }

    private void ventaInit(){
        VentaController ventaController = VentaController.getInstance();

        mainPanel.add(menuVentas);
        menuBar.add(menuVentas);
        menuVentas.add(ventaBoleteriaMenuItem);
        
        ventaBoleteriaMenuItem.addActionListener(e -> {
        	VentaBoleteria ventaBoleteria = new VentaBoleteria();
//        	ventaController.setVentaBoleteria(ventaBoleteria);
        	ventaBoleteria.setVisible(true);
        });

    }

    private void descuentoInit(){

        DescuentoController usuarioController = DescuentoController.getInstance();

        mainPanel.add(menuDescuentos);
        menuBar.add(menuDescuentos);
        menuDescuentos.add(menuAltaDescuento);
        menuDescuentos.add(menuModificarDescuento);
        menuDescuentos.add(menuBajaDescuento);

        menuAltaDescuento.addActionListener(e -> {
            FormAltaDescuento altaUsuarioForm = new FormAltaDescuento ();
//            usuarioController.setFormularioAltaUsuario(altaUsuarioForm);
            altaUsuarioForm.setVisible(true);
        });

        menuModificarDescuento.addActionListener(e -> {
            FormModifDescuento altaUsuarioForm = new FormModifDescuento ();
//            usuarioController.setFormularioAltaUsuario(altaUsuarioForm);
            altaUsuarioForm.setVisible(true);
        });

        menuBajaDescuento.addActionListener(e -> {
            FormElimDescuento altaUsuarioForm = new FormElimDescuento ();
//            usuarioController.setFormularioAltaUsuario(altaUsuarioForm);
            altaUsuarioForm.setVisible(true);
        });

    }

    private void terminalInit(){
        mainPanel.add(menuTerminal);
        menuBar.add(menuTerminal);
        menuTerminal.add(menuRetirarVenta);
        menuRetirarVenta.addActionListener(e -> {
            TerminalForm terminalForm = new TerminalForm ();
//            usuarioController.setFormularioAltaUsuario(altaUsuarioForm);
            terminalForm.setVisible(true);
        });

    }
}

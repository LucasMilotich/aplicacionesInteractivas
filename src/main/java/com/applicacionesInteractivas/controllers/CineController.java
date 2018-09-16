package com.applicacionesInteractivas.controllers;

import com.applicacionesInteractivas.bd.CineDAO;
import com.applicacionesInteractivas.bd.FuncionDAO;
import com.applicacionesInteractivas.bd.PeliculaDAO;
import com.applicacionesInteractivas.bd.SalaDAO;
import com.applicacionesInteractivas.modelo.*;
import com.applicacionesInteractivas.modelo.medioDePago.MedioDePago;
import com.applicacionesInteractivas.vista.formularios.JFormularioAdminCines;
import com.applicacionesInteractivas.vista.formularios.JFormularioAdminPeliculas;
import com.applicacionesInteractivas.vista.formularios.JFormularioAdminSalas;

import java.util.Collection;
import java.util.List;

public class CineController {

    public CineController() {

        buildView();
        buildModel();
    }

    //    Modelo
    private List<Cine> cines;
    private List<Pelicula> peliculas;
    private List<Sala> salas;
    private List<Funcion> funciones;

    //    Vista
    private JFormularioAdminCines formularioAdminCines;
    private JFormularioAdminPeliculas formularioAdminPeliculas;
    private JFormularioAdminSalas formularioAdminSalas;


    private void buildView(){

        this.formularioAdminCines = new JFormularioAdminCines();
        this.formularioAdminPeliculas = new JFormularioAdminPeliculas();
        this.formularioAdminSalas = new JFormularioAdminSalas();

    }
    private void buildModel(){

        this.cines = CineDAO.getInstance().findAll();
        this.salas = SalaDAO.getInstance().findAll();
        this.peliculas = PeliculaDAO.getInstance().findAll();
        this.funciones = FuncionDAO.getInstance().findAll();

    }

    private Venta venderEntrada(Funcion funcion, Collection<AsientoFuncion> asientos, MedioDePago medioDePago){

        Venta venta;

        try {
           venta = new Venta().venderEntrada(funcion,asientos,medioDePago);
        } catch (Exception e){

        }

        return null;
    }
}

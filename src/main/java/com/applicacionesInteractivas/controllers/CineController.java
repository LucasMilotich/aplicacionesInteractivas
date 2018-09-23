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
import com.applicacionesInteractivas.vista.formularios.JFormularioAltaCine;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CineController {

    private static CineController instance;
    public static CineController getInstance(){
        if (instance == null){
            instance = new CineController();
        }
        return instance;
    }



    //    Modelo
    private Set<Cine> cines = new HashSet<Cine>();
    private List<Pelicula> peliculas;
    private List<Sala> salas;
    private List<Funcion> funciones;


    public Set<Cine> getCines() {
        return cines;
    }

    public void setCines(Set<Cine> cines) {
        this.cines = cines;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public List<Funcion> getFunciones() {
        return funciones;
    }

    public void setFunciones(List<Funcion> funciones) {
        this.funciones = funciones;
    }

    public JFormularioAltaCine getFormularioAltaCine() {
        return formularioAltaCine;
    }

    public void setFormularioAltaCine(JFormularioAltaCine formularioAltaCine) {
        this.formularioAltaCine = formularioAltaCine;
    }

    //    Vista
    private JFormularioAltaCine formularioAltaCine;




    private void buildModel(){

//        this.cines = CineDAO.getInstance().findAll();
        this.salas = SalaDAO.getInstance().findAll();
        this.peliculas = PeliculaDAO.getInstance().findAll();
        this.funciones = FuncionDAO.getInstance().findAll();

    }

    public void crearCine(String cuit, String nombre, String domicilio, int cantidadSalas, int capacidadTotal){
        Cine cine = new Cine(cuit,nombre,domicilio,cantidadSalas,capacidadTotal);
        this.cines.add(cine);
    }
    public void crearCine(Cine cine){

        this.cines.add(cine);
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

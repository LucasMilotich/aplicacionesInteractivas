package com.applicacionesInteractivas.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import com.applicacionesInteractivas.bd.CineDAO;
import com.applicacionesInteractivas.bd.FuncionDAO;
import com.applicacionesInteractivas.bd.PeliculaDAO;
import com.applicacionesInteractivas.bd.SalaDAO;
import com.applicacionesInteractivas.modelo.AsientoFuncion;
import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.modelo.Funcion;
import com.applicacionesInteractivas.modelo.Pelicula;
import com.applicacionesInteractivas.modelo.Sala;
import com.applicacionesInteractivas.modelo.Venta;
import com.applicacionesInteractivas.modelo.medioDePago.MedioDePago;
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

public class CineController {

    private static CineController instance;

    public static CineController getInstance() {
        if (instance == null) {
            instance = new CineController();
        }
        return instance;
    }

    //    Modelo
    private List<Cine> cines = new ArrayList<Cine>();
    private List<Pelicula> peliculas = new ArrayList<Pelicula>();
    private List<Sala> salas = new ArrayList<Sala>();
    private List<Funcion> funciones = new ArrayList<Funcion>();

    //    Vista
    // Cine
    private FormAltaCine formularioAltaCine;
    private FormModifCine formularioModifCine;
    private FormElimCine formularioElimCine;

    // Sala
    private FormAltaSala formularioAltaSala;
    private FormModifSala formularioModifSala;
    private FormElimSala formularioElimSala;

    // Pelicula
    private FormAltaPelicula formularioAltaPelicula;
    private FormModifPelicula formularioModifPelicula;
    private FormElimPelicula formularioElimPelicula;

    // Funciones
    private FormAltaFuncion formularioAltaFuncion;
    private FormModifFuncion formularioModifFuncion;
    private FormElimFuncion formularioElimFuncion;

    public List<Cine> getCines() {
        if (cines.size() == 0) {
            return cines = CineDAO.getInstance().findAll();
        } else {
            return cines;
        }

    }

    public Vector<String> getListadoCines() {
        Vector<String> listado = new Vector<String>();
        for (Cine c : getCines()) {
            listado.add(c.getCuit() + " - " + c.getNombre());
        }

        return listado;
    }

    public void setCines(List<Cine> cines) {
        this.cines = cines;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public Vector<String> getListadoPeliculas() {
        Vector<String> listado = new Vector<String>();
        for (Pelicula p : peliculas) {
            listado.add(p.getNombre());
        }

        return listado;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public List<Sala> getSalas() {
        if (salas.size() == 0) {
            return salas = SalaDAO.getInstance().findAll();
        } else {
            return salas;
        }
    }

    public Vector<String> getListadoSalas() {
        Vector<String> listado = new Vector<String>();
        for (Sala s : salas) {
            listado.add(s.getNombre());
        }
        return listado;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public List<Funcion> getFunciones() {
        if (funciones.size() == 0) {
            return funciones = FuncionDAO.getInstance().findAll();
        } else {
            return funciones;
        }
    }

    public Vector<String> getListadoFunciones() {
        Vector<String> listado = new Vector<String>();
        for (Funcion f : funciones) {
            listado.add(f.getHorario().toString());
        }
        return listado;
    }

    public void setFunciones(List<Funcion> funciones) {
        this.funciones = funciones;
    }

    public FormAltaCine getFormularioAltaCine() {
        return formularioAltaCine;
    }

    public void setFormularioAltaCine(FormAltaCine formularioAltaCine) {
        this.formularioAltaCine = formularioAltaCine;
    }

    public FormModifCine getFormularioModifCine() {
        return formularioModifCine;
    }

    public void setFormularioModifCine(FormModifCine formularioModifCine) {
        this.formularioModifCine = formularioModifCine;
    }

    public FormElimCine getFormularioElimCine() {
        return formularioElimCine;
    }

    public void setFormularioElimCine(FormElimCine formularioElimCine) {
        this.formularioElimCine = formularioElimCine;
    }

    public FormAltaSala getFormularioAltaSala() {
        return formularioAltaSala;
    }

    public void setFormularioAltaSala(FormAltaSala formularioAltaSala) {
        this.formularioAltaSala = formularioAltaSala;
    }

    public FormModifSala getFormularioModifSala() {
        return formularioModifSala;
    }

    public void setFormularioModifSala(FormModifSala formularioModifSala) {
        this.formularioModifSala = formularioModifSala;
    }

    public FormElimSala getFormularioElimSala() {
        return formularioElimSala;
    }

    public void setFormularioElimSala(FormElimSala formularioElimSala) {
        this.formularioElimSala = formularioElimSala;
    }

    public FormAltaPelicula getFormularioAltaPelicula() {
        return formularioAltaPelicula;
    }

    public void setFormularioAltaPelicula(FormAltaPelicula formularioAltaPelicula) {
        this.formularioAltaPelicula = formularioAltaPelicula;
    }

    public FormModifPelicula getFormularioModifPelicula() {
        return formularioModifPelicula;
    }

    public void setFormularioModifPelicula(FormModifPelicula formularioModifPelicula) {
        this.formularioModifPelicula = formularioModifPelicula;
    }

    public FormElimPelicula getFormularioElimPelicula() {
        return formularioElimPelicula;
    }

    public void setFormularioElimPelicula(FormElimPelicula formularioElimPelicula) {
        this.formularioElimPelicula = formularioElimPelicula;
    }

    public FormAltaFuncion getFormularioAltaFuncion() {
        return formularioAltaFuncion;
    }

    public void setFormularioAltaFuncion(FormAltaFuncion formularioAltaFuncion) {
        this.formularioAltaFuncion = formularioAltaFuncion;
    }

    public FormModifFuncion getFormularioModifFuncion() {
        return formularioModifFuncion;
    }

    public void setFormularioModifFuncion(FormModifFuncion formularioModifFuncion) {
        this.formularioModifFuncion = formularioModifFuncion;
    }

    public FormElimFuncion getFormularioElimFuncion() {
        return formularioElimFuncion;
    }

    public void setFormularioElimFuncion(FormElimFuncion formularioElimFuncion) {
        this.formularioElimFuncion = formularioElimFuncion;
    }

    private void buildModel() {

        this.cines = CineDAO.getInstance().findAll();
        this.salas = SalaDAO.getInstance().findAll();
        this.peliculas = PeliculaDAO.getInstance().findAll();
        this.funciones = FuncionDAO.getInstance().findAll();

    }

    public void crearCine(String cuit, String nombre, String domicilio, int cantidadSalas, int capacidadTotal) {

        this.cines.add(Cine.crearCine(cuit, nombre, domicilio, cantidadSalas, capacidadTotal));
    }

    public void modificarCine(String cuit, String nombre, String domicilio, int cantidadSalas, int capacidadTotal) {
        Cine c = this.getCine(cuit);
        Cine.modificarCine(c, cuit, nombre, domicilio, false);
    }

    public void eliminarCine(String cuit) {

        Cine c = this.getCine(cuit);
        if (c != null) {
            cines.remove(c);
            Cine.modificarCine(c, c.getCuit(), c.getNombre(), c.getDomicilio(), true);
        }


    }

    public Cine getCine(String cuit) {

        for (Cine c : cines) {
            if (c.esCine(cuit))
                return c;
        }

        return null;
    }

    public void crearSala(String nombre, int filas, int columnas, Cine cine) {
        this.salas.add(Sala.crearSala(nombre, filas, columnas, cine));
    }

    public void modificarSala(String cuit, String nombre, int filas, int columnas) {


        Sala s = this.getSala(cuit, nombre);

        Sala.modificarSala(s, nombre, filas, columnas,s.isDeleted());

    }

    public void eliminarSala(String cuit, String nombre) {


        Sala s = this.getSala(cuit, nombre);
        salas.remove(s);
        Sala.modificarSala(s, nombre, s.getFilas(), s.getColumnas(),true);


    }





    public void crearPelicula(String nombre, String director, String genero, 
                              String duracion, String idioma, String subtitulos,int calificacion, String observacion) {
    	this.peliculas.add(Pelicula.crearPelicula(nombre, director, genero, duracion, idioma, subtitulos, calificacion, observacion));
    }

    public void modificarPelicula(String nombre, String director, String genero,
                                  String duracion, String idioma, String subtitulos, int calificacion, String observacion) {
        Pelicula p = this.getPelicula(nombre);
        if (p != null) {
            p.setDirector(director);
            p.setDuracion(duracion);
            p.setIdioma(idioma);
            p.setCalificacion(calificacion);
            p.setObservacion(observacion);
        }
    }

    public void eliminarPelicula(String nombre) {
        Pelicula p = this.getPelicula(nombre);
        if (p != null)
            peliculas.remove(p);
    }

    public Pelicula getPelicula(String nombre) {
        for (Pelicula p : peliculas) {
            if (p.esPelicula(nombre))
                return p;
        }
        return null;
    }

    public void crearFuncion(Pelicula pelicula, Sala sala, LocalDateTime horario) {
        Funcion f = Funcion.crearFuncion(pelicula,sala,horario);
        this.funciones.add(f);
    }

    public void modificarFuncion(Pelicula pelicula, Sala sala,LocalDateTime horario) {

    }

    public void eliminarFuncion(String horario) {
        Funcion f = this.getFuncion(horario);
        if (f != null)
            funciones.remove(f);
    }

    private Funcion getFuncion(String horario) {
        for (Funcion f : funciones) {
            if (f.esFuncion(horario))
                return f;
        }
        return null;
    }

    public Sala getSala(String cuit, String nombreSala) {
        for (Sala s : salas) {
            if (s.esSala(nombreSala) && s.getCine().getCuit().equals(s.getCine().getCuit()) )
                return s;
        }
        return null;
    }

    private Sala getSala(String nombre, Cine cine) {
        for (Sala s : salas) {
            if (s.esSala(nombre) && s.getCine().getCuit().equals(cine.getCuit()))
                return s;
        }
        return null;
    }

}

package com.applicacionesInteractivas.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    public static CineController getInstance(){
        if (instance == null){
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
        return cines;
    }

    public void setCines(List<Cine> cines) {
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

    private void buildModel(){

        this.cines = CineDAO.getInstance().findAll();
        this.salas = SalaDAO.getInstance().findAll();
        this.peliculas = PeliculaDAO.getInstance().findAll();
        this.funciones = FuncionDAO.getInstance().findAll();

    }

    public void crearCine(String cuit, String nombre, String domicilio, int cantidadSalas, int capacidadTotal){
        Cine cine = new Cine(cuit,nombre,domicilio,cantidadSalas,capacidadTotal);
        this.cines.add(cine);
    }
    
    public void modificarCine(String cuit, String nombre, String domicilio, int cantidadSalas, int capacidadTotal) {
    	Cine c = this.getCine(cuit);
    	if(c != null) {
    		c.setNombre(nombre);
    		c.setDomicilio(domicilio);
    		c.setCantidadSalas(cantidadSalas);
    		c.setCapacidadTotal(capacidadTotal);
    	}
    }

	public void eliminarCine(String cuit) {
		
		Cine c = this.getCine(cuit);
		if(c != null)
			cines.remove(c);
	}
	
	public Cine getCine(String cuit) {

		for(Cine c : cines) {
			if(c.esCine(cuit))
				return c;
		}
		
		return null;
	}
	
    private Venta venderEntrada(Funcion funcion, Collection<AsientoFuncion> asientos, MedioDePago medioDePago){

        Venta venta;

        try {
           venta = new Venta().venderEntrada(funcion,asientos,medioDePago);
        } catch (Exception e){

        }

        return null;
    }

	public void crearSala(String nombre, int capacidad) {
		Sala sala = new Sala(nombre, capacidad);
		this.salas.add(sala);
	}

	public void modificarSala(String nombre, int capacidad) {
		Sala s = this.getSala(nombre);
    	if(s != null) {
    		s.setCapacidad(capacidad);
    	}
	}
	
	public void eliminarSala(String nombre) {
		Sala s = this.getSala(nombre);
		if(s != null)
			salas.remove(s);
	}

	private Sala getSala(String nombre) {
		for(Sala s : salas) {
			if(s.esSala(nombre))
				return s;
		}
		return null;
	}

}

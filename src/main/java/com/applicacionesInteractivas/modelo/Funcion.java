package com.applicacionesInteractivas.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.bd.FuncionDAO;

public class Funcion {
	
	private int id;
    private Pelicula pelicula;
    private Sala sala;
    private List<AsientoFuncion> asientoFunciones;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean deleted;

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<AsientoFuncion> getAsientoFunciones() {
        return asientoFunciones;
    }

    public void setAsientoFunciones(List<AsientoFuncion> asientoFunciones) {
        this.asientoFunciones = asientoFunciones;
    }

    public Funcion(Pelicula pelicula, Sala sala, LocalDate fecha, LocalTime hora) {
    	this.fecha = fecha;
    	this.hora = hora;
    	this.pelicula = pelicula;
    	this.sala = sala;
    	this.asientoFunciones = new ArrayList<AsientoFuncion>();
    	for(int i = 0; i < sala.getFilas(); i++) {
    		for(int j = 0; j < sala.getColumnas(); j++) {
    			this.asientoFunciones.add(new AsientoFuncion(false, new Asiento(i,j),this));
    		}
    	}
    }
    
    public Funcion(int id, Pelicula pelicula, Sala sala, LocalDate fecha, LocalTime hora) {
    	this.id = id;
    	this.fecha = fecha;
    	this.hora = hora;
    	this.pelicula = pelicula;
    	this.sala = sala;
    	this.deleted = false;
    	this.asientoFunciones = null;
    }

    public static Funcion crearFuncion(Pelicula pelicula, Sala sala, LocalDate fecha, LocalTime hora){
        Funcion f = new Funcion(pelicula, sala, fecha, hora);
        FuncionDAO.getInstance().insert(f) ;

        return f;
    }

	public static Funcion modificarFuncion(Funcion f, LocalDate fechaNueva, LocalTime horaNueva) {
		
		if (f != null) {
			f.setFecha(fechaNueva);
			f.setHora(horaNueva);
		}
		FuncionDAO.getInstance().update(f);
		
		return f;
	}
	
	public static Funcion eliminarFuncion(Funcion f) {
		
		if (f != null) {
			f.setDeleted(true);
		}
		FuncionDAO.getInstance().delete(f);
		return f;
	}
	
	public static boolean esFuncionEliminable(int id) {
		return FuncionDAO.getInstance().esFuncionEliminable(id);
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

package com.applicacionesInteractivas.modelo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.bd.FuncionDAO;

public class Funcion {

    private Pelicula pelicula;
    private Sala sala;
    private List<AsientoFuncion> asientoFunciones;
	private Timestamp horario;
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

    public Funcion(Pelicula pelicula, Sala sala, Timestamp horario) {
    	this.horario = horario;
    	this.pelicula = pelicula;
    	this.sala = sala;
    	this.asientoFunciones = new ArrayList<AsientoFuncion>();
    	for(int i = 0; i < sala.getFilas(); i++) {
    		for(int j = 0; j < sala.getColumnas(); j++) {
    			this.asientoFunciones.add(new AsientoFuncion(false, new Asiento(i,j),this));
    		}
    	}
    }

    public static Funcion crearFuncion(Pelicula pelicula, Sala sala, Timestamp horario){
        Funcion f = new Funcion(pelicula, sala, horario);
        FuncionDAO.getInstance().insert(f) ;

        return f;
    }

	public static Funcion modificarFuncion(Funcion f, Timestamp horarioNuevo) {
		FuncionDAO.getInstance().delete(f);
		if (f != null) {
			f.setHorario(horarioNuevo);
		}
		FuncionDAO.getInstance().insert(f);
		
		return f;
	}
	
	public static Funcion eliminarFuncion(Funcion f) {
		FuncionDAO.getInstance().delete(f);
		return f;
	}
	
    public Timestamp getHorario() {
        return horario;
    }

    public void setHorario(Timestamp horario) {
        this.horario = horario;
    }

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}

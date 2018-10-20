package com.applicacionesInteractivas.modelo;

import java.util.List;

public class Funcion {
    private String horario;
    private Pelicula pelicula;
    private Sala sala;
    private List<AsientoFuncion> asientoFunciones;

    public Funcion(Pelicula pelicula, Sala sala, String horario) {
    	this.horario = horario;
    	this.pelicula = pelicula;
    	this.sala = sala;
    	this.asientoFunciones = null;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public boolean esFuncion(String horario) {
    	return this.getHorario().equals(horario);
    }
}

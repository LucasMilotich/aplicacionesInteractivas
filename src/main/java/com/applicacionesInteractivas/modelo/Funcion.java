package com.applicacionesInteractivas.modelo;

import java.util.List;

public class Funcion {
    private String horario;
    private int asientos;
    private Pelicula pelicula;
    private Sala sala;
    private List<AsientoFuncion> asientoFunciones;

    public Funcion(String horario, int asientos) {
    	this.horario = horario;
    	this.asientos = asientos;
    	this.pelicula = null;
    	this.sala = null;
    	this.asientoFunciones = null;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }
    
    public boolean esFuncion(String horario) {
    	return this.getHorario().equals(horario);
    }
}

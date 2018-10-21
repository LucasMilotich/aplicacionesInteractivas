package com.applicacionesInteractivas.modelo;

import com.applicacionesInteractivas.bd.FuncionDAO;

import java.time.LocalDateTime;
import java.util.List;

public class Funcion {
    private LocalDateTime horario;

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

    private Pelicula pelicula;
    private Sala sala;
    private List<AsientoFuncion> asientoFunciones;

    public Funcion(Pelicula pelicula, Sala sala, LocalDateTime horario) {
    	this.horario = horario;
    	this.pelicula = pelicula;
    	this.sala = sala;
    	this.asientoFunciones = null;
    }

    public static Funcion crearFuncion(Pelicula pelicula, Sala sala, LocalDateTime horario){
        Funcion f = new Funcion(pelicula, sala, horario);
        FuncionDAO.getInstance().insert(f) ;

        return f;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }
    
    public boolean esFuncion(String horario) {
    	return this.getHorario().equals(horario);
    }
}

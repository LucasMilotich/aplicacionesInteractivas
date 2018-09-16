package com.applicacionesInteractivas.modelo;

import java.util.Date;
import java.util.List;

public class Funcion {
    private Date horario;
    private int asientos;
    private Pelicula pelicula;
    private Sala sala;
    private List<AsientoFuncion> asientoFunciones;


    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }
}

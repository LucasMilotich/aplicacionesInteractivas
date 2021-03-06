package com.applicacionesInteractivas.modelo;

public class AsientoFuncion {

    private boolean ocupado;
    private Asiento asiento;
    private Funcion funcion;

    public Asiento getAsiento() {
        return asiento;
    }

    public AsientoFuncion() {
        super();
    }

    public AsientoFuncion(boolean ocupado, Asiento asiento, Funcion funcion) {
        super();
        this.ocupado = ocupado;
        this.asiento = asiento;
        this.funcion = funcion;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }
}

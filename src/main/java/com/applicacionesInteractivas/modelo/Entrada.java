package com.applicacionesInteractivas.modelo;

import java.util.Random;

public class Entrada {

    public Entrada(){}
    public Entrada(AsientoFuncion asiento, Funcion funcion){
        this.asiento = asiento;
        this.funcion = funcion;
        this.estado = "VENDIDO";
        this.codAutenticacion = Double.toString(Math.random());

    }
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private  AsientoFuncion  asiento;
    private  String  estado;
    private  String  codAutenticacion  = Integer.toString((new Random()).nextInt());

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    private Funcion funcion;
    private Venta venta;

    public AsientoFuncion getAsiento() {
        return asiento;
    }

    public void setAsiento(AsientoFuncion asiento) {
        this.asiento = asiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodAutenticacion() {
        return codAutenticacion;
    }

    public void setCodAutenticacion(String codAutenticacion) {
        this.codAutenticacion = codAutenticacion;
    }
}

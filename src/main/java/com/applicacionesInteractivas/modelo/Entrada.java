package com.applicacionesInteractivas.modelo;

import java.util.Random;

public class Entrada {

    private int id;
    private AsientoFuncion asiento;
    private String  estado;
    private String  codAutenticacion  = Integer.toString((new Random()).nextInt());
    private Venta venta;

    public Entrada() {
		super();
	}

	public Entrada(AsientoFuncion asiento, Venta venta){
    	this.venta = venta;
        this.asiento = asiento;
        this.estado = "VENDIDO";
        this.codAutenticacion = Double.toString(Math.random());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public AsientoFuncion getAsientoFuncion() {
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

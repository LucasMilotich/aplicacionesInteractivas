package com.applicacionesInteractivas.modelo;

public class Entrada {

    private int id;
    private AsientoFuncion asiento;
    private String  estado;
    private Venta venta;

    public Entrada() {
		super();
	}

	public Entrada(AsientoFuncion asiento, Venta venta){
    	this.venta = venta;
        this.asiento = asiento;
        this.estado = "VENDIDO";
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

}

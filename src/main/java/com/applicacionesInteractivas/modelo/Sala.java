package com.applicacionesInteractivas.modelo;

public class Sala {

private String nombre;
private int  capacidad;
private Cine cine;

    public Sala(String nombre, int capacidad) {
		super();
		this.nombre = nombre;
		this.capacidad = capacidad;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public boolean esSala(String nombre) {
    	return this.getNombre().equals(nombre);
    }
}

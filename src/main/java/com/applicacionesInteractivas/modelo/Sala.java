package com.applicacionesInteractivas.modelo;

public class Sala {

private String nombre;
private int filas;
private int columnas;
private Cine cine;

    public Sala(String nombre, int filas, int columnas, Cine cine) {
		super();
		this.nombre = nombre;
		this.filas = filas;
		this.columnas = columnas;
		this.cine = cine;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public boolean esSala(String nombre) {
    	return this.getNombre().equals(nombre);
    }
}

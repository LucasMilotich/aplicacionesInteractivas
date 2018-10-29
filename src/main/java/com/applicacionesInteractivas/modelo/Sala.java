package com.applicacionesInteractivas.modelo;

import com.applicacionesInteractivas.bd.FuncionDAO;
import com.applicacionesInteractivas.bd.SalaDAO;

public class Sala {
	
	private int id;
    private String nombre;
    private int filas;
    private int columnas;
    private boolean deleted;
    private Cine cine;
    
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }
    
    public Sala(String nombre, int filas, int columnas, Cine cine) {
        super();
        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
        this.cine = cine;
        this.deleted = false;
    }

    public Sala(int id, String nombre, int filas, int columnas, Cine cine) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
        this.cine = cine;
        this.deleted = false;
    }

    public static Sala crearSala(String nombre, int filas, int columnas, Cine cine) {
        Sala sala = new Sala(nombre, filas, columnas, cine);
        SalaDAO.getInstance().insert(sala);
        return sala;
    }

    public static Sala modificarSala(Sala s, String nombre, int filas, int columnas, Boolean deleted) {

        if (s != null) {
        	s.setNombre(nombre);
            s.setFilas(filas);
            s.setColumnas(columnas);
        }

        SalaDAO.getInstance().update(s);
        return s;
    }
    
    public static Sala eliminarSala(Sala s) {
		
		if (s != null) {
			s.setDeleted(true);
		}
		SalaDAO.getInstance().delete(s);
		return s;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

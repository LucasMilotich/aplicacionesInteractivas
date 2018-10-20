package com.applicacionesInteractivas.modelo;

import com.applicacionesInteractivas.bd.CineDAO;

import java.util.ArrayList;
import java.util.List;

public class Cine {

    private String cuit;
    private String nombre;
    private String domicilio;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    private boolean deleted = false;

    private List<Pelicula> peliculas;
    private List<Funcion> funciones;
    private List<Sala> salas;

    public int getCantidadSalas(){
        return salas.size();
    }
    public int getCapacidadTotal(){
        return salas.stream().mapToInt(i -> i.getCapacidad()).sum();
    }

    public static Cine crearCine(String cuit, String nombre, String domicilio, int cantidadSalas, int capacidadTotal) {
        Cine cine = new Cine(cuit, nombre, domicilio);
        CineDAO.getInstance().insert(cine);
        return cine;
    }

    public static Cine modificarCine(Cine cine, String cuit, String nombre, String domicilio, boolean deleted) {
        if (cine != null) {
            cine.setNombre(nombre);
            cine.setDomicilio(domicilio);
            cine.setDeleted(deleted);
        }
        CineDAO.getInstance().update(cine);
        return cine;
    }

    public Cine(String cuit, String nombre, String domicilio) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.peliculas = new ArrayList<Pelicula>();
        this.funciones = new ArrayList<Funcion>();
        this.salas = new ArrayList<Sala>();
    }

    public Entrada retirarEntrada(String codAutenticacion) {
        return null;
    }

    public List<Funcion> consultarFunciones(Pelicula pelicula, String hora) {
        return null;
    }

    public Pelicula altaPelicula(String nombre, String director, int duracion, String idioma, String[] subtitulos, int calificacion, String obs) {
        return null;
    }

    public Pelicula modificarPelicula(String nombre, String director, int duracion, String idioma, String[] subtitulos, int calificacion, String obs) {
        return null;
    }

    public boolean eliminarPelicula(int idPelicula) {
        return false;
    }

    public Sala altaSala(String nombre, int capacidad) {
        return null;
    }

    public Sala modificarSala(String nombre, int capacidad) {
        return null;
    }

    public boolean eliminarSala(int idSala) {
        return false;
    }

    public Venta consultarVenta(String id) {
        return null;
    }


    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }


    public boolean esCine(String cuit) {
        return this.getCuit().equals(cuit);
    }
}

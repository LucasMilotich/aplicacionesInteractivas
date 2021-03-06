package com.applicacionesInteractivas.modelo;

import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.bd.CineDAO;

public class Cine {

    private String cuit;
    private String nombre;
    private String domicilio;
    private boolean deleted = false;
    private List<Sala> salas;
    
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getCantidadSalas(){
        return salas.size();
    }
    public int getCapacidadTotal(){
        return salas.stream().mapToInt(i -> i.getFilas() * i.getColumnas()).sum();
    }

    public static Cine crearCine(String cuit, String nombre, String domicilio) {
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
        this.salas = new ArrayList<Sala>();
    }
    public Cine(String cuit, String nombre, String domicilio, List<Sala> salas) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.salas = salas;
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

    public void agregarSala(Sala s) {
        this.salas.add(s);
    }

    public void eliminarSala(Sala s) {
        this.salas.remove(s);
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

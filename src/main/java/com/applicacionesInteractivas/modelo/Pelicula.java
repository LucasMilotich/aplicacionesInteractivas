package com.applicacionesInteractivas.modelo;

import java.util.List;

public class Pelicula {

    private String nombre;
    private String director;
    private String duracion;
    private String idioma;
    private List<String> subtitulos;
    private int calificacion;
    private String observacion;

    public Pelicula() {
    }

    public Pelicula(String nombre, String director, String duracion, String idioma, List<String> subtitulos, int calificacion, String observacion) {
        this.nombre = nombre;
        this.director = director;
        this.duracion = duracion;
        this.idioma = idioma;
        this.subtitulos = subtitulos;
        this.calificacion = calificacion;
        this.observacion = observacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public List<String> getSubtitulos() {
        return subtitulos;
    }

    public void setSubtitulos(List<String> subtitulos) {
        this.subtitulos = subtitulos;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}

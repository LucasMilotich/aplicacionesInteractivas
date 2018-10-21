package com.applicacionesInteractivas.modelo;

import com.applicacionesInteractivas.bd.PeliculaDAO;

public class Pelicula {

    private String nombre;
    private String director;
    private String genero;
    private String duracion;
    private String idioma;
    private String subtitulos;
    private int calificacion;
    private String observacion;

    public Pelicula() {
    }

    public Pelicula(String nombre, String director, String genero, String duracion, String idioma, String subtitulos, int calificacion, String observacion) {
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.idioma = idioma;
        this.subtitulos = subtitulos;
        this.calificacion = calificacion;
        this.observacion = observacion;
    }
    
    public static Pelicula crearPelicula(String nombre, String director, String genero, String duracion, String idioma, String subtitulos, int calificacion, String observacion) {
    	Pelicula pelicula = new Pelicula(nombre, director, genero, duracion, idioma, subtitulos, calificacion, observacion);
    	PeliculaDAO.getInstance().insert(pelicula);
    	return pelicula;
    }
    
    public static Pelicula modificarPelicula(Pelicula p, String nombre, String director, String genero,
    										String duracion, String idioma, String subtitulos, int calificacion, String observacion) {
    	if(p != null) {
    		p.setNombre(nombre);
    		p.setDirector(director);
    		p.setGenero(genero);
    		p.setDuracion(duracion);
    		p.setIdioma(idioma);
    		p.setSubtitulos(subtitulos);
    		p.setCalificacion(calificacion);
    		p.setObservacion(observacion);
    	}
    	PeliculaDAO.getInstance().update(p);
    	return p;
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

    public String getSubtitulos() {
        return subtitulos;
    }

    public void setSubtitulos(String subtitulos) {
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
    
    public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean esPelicula(String nombre) {
    	return this.getNombre().equals(nombre);
    }
}

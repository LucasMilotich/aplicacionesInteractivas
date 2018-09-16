package com.applicacionesInteractivas.bd;

import com.applicacionesInteractivas.modelo.Pelicula;

import java.util.List;

public class PeliculaDAO implements ICRUD<Pelicula> {

    private static PeliculaDAO instance;

    public static PeliculaDAO getInstance() {
        if (instance== null){
            instance = new PeliculaDAO();
        }
        return instance;
    }

    @Override
    public boolean save(Pelicula pelicula) {
        return false;
    }

    @Override
    public boolean delete(Pelicula pelicula) {
        return false;
    }

    @Override
    public boolean update(Pelicula pelicula) {
        return false;
    }

    @Override
    public Pelicula get(Pelicula pelicula) {
        return null;
    }

    @Override
    public Pelicula findBy(int id) {
        return null;
    }

    @Override
    public List<Pelicula> findAll() {
        return null;
    }
}

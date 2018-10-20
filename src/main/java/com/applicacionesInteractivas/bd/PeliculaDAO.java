package com.applicacionesInteractivas.bd;

import com.applicacionesInteractivas.modelo.Pelicula;

import java.sql.ResultSet;
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
    public void insert(Pelicula pelicula) {
        
    }

    @Override
    public void delete(Pelicula pelicula) {
        
    }

    @Override
    public void update(Pelicula pelicula) {
        
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

    @Override
    public Pelicula mapToEntity(ResultSet rs) {
        return null;
    }
}

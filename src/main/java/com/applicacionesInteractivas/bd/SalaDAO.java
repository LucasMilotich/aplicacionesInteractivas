package com.applicacionesInteractivas.bd;

import com.applicacionesInteractivas.modelo.Sala;

import java.sql.ResultSet;
import java.util.List;

public class SalaDAO implements ICRUD<Sala> {

    private static SalaDAO instance;

    public static SalaDAO getInstance() {
        if (instance== null){
            instance = new SalaDAO();
        }
        return instance;
    }

    @Override
    public void insert(Sala funcion) {
        
    }

    @Override
    public void delete(Sala funcion) {
        
    }

    @Override
    public void update(Sala funcion) {
        
    }

    @Override
    public Sala get(Sala funcion) {
        return null;
    }

    @Override
    public Sala findBy(int id) {
        return null;
    }

    @Override
    public List<Sala> findAll() {
        return null;
    }

    @Override
    public Sala mapToEntity(ResultSet rs) {
        return null;
    }

}

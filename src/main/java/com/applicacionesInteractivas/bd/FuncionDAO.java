package com.applicacionesInteractivas.bd;

import com.applicacionesInteractivas.modelo.Funcion;

import java.util.List;

public class FuncionDAO implements ICRUD<Funcion> {

    private static FuncionDAO instance;

    public static FuncionDAO getInstance() {
        if (instance== null){
            instance = new FuncionDAO();
        }
        return instance;
    }

    @Override
    public void insert(Funcion funcion) {
        
    }

    @Override
    public void delete(Funcion funcion) {
    	
    }

    @Override
    public void update(Funcion funcion) {
        
    }

    @Override
    public Funcion get(Funcion funcion) {
        return null;
    }

    @Override
    public Funcion findBy(int id) {
        return null;
    }

    @Override
    public List<Funcion> findAll() {
        return null;
    }
}

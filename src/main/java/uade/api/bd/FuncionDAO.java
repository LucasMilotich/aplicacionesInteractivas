package uade.api.bd;

import uade.api.modelo.Funcion;

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
    public boolean save(Funcion funcion) {
        return false;
    }

    @Override
    public boolean delete(Funcion funcion) {
        return false;
    }

    @Override
    public boolean update(Funcion funcion) {
        return false;
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

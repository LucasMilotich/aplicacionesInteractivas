package uade.api.bd;

import uade.api.modelo.Sala;

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
    public boolean save(Sala funcion) {
        return false;
    }

    @Override
    public boolean delete(Sala funcion) {
        return false;
    }

    @Override
    public boolean update(Sala funcion) {
        return false;
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

}

package uade.api.bd;

import uade.api.modelo.Cine;

import java.util.List;

public class CineDAO implements ICRUD<Cine> {

    private static CineDAO instance;

    public static CineDAO getInstance() {
        if (instance== null){
            instance = new CineDAO();
        }
        return instance;
    }

    @Override
    public boolean save(Cine cine) {
        return false;
    }

    @Override
    public boolean delete(Cine cine) {
        return false;
    }

    @Override
    public boolean update(Cine cine) {
        return false;
    }

    @Override
    public Cine get(Cine cine) {
        return null;
    }

    @Override
    public Cine findBy(int id) {
        return null;
    }

    @Override
    public List<Cine> findAll() {
        return null;
    }
}

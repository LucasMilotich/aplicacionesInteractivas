package uade.api;

import uade.api.bd.ICRUD;

public class CRUD implements ICRUD {

    @Override
    public <T> boolean save(T t) {
        return false;
    }

    @Override
    public <T> boolean delete(T t) {
        return false;
    }

    @Override
    public <T> boolean update(T t) {
        return false;
    }

    @Override
    public <T> T get(T t) {
        return null;
    }

    @Override
    public <T> T findBy(int id) {
        return null;
    }
}

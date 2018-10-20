package com.applicacionesInteractivas.bd;

import com.applicacionesInteractivas.modelo.Funcion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".funcion values (?,?,?,?)");
            s.setString(1, funcion.getSala().getCine().getCuit());

            s.setDate(2, Date.valueOf(funcion.getHorario().toLocalDate()));
            s.setString(3, funcion.getSala().getNombre());
            s.setString(4, funcion.getPelicula().getNombre());


            s.execute();
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        return new ArrayList<Funcion>();
    }

    @Override
    public Funcion mapToEntity(ResultSet rs) {
        return null;
    }
}

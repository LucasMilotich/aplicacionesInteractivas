package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.modelo.Funcion;

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
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".funcion values (?,?,?,?,?)");
            s.setString(1, funcion.getSala().getCine().getCuit());
            s.setString(2, funcion.getPelicula().getNombre());
            s.setString(3, funcion.getSala().getNombre());
            s.setDate(4, Date.valueOf(funcion.getHorario().toLocalDate()));
            s.setBoolean(5, false);
            
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
    	Connection con = null;
        ArrayList<Funcion> result = new ArrayList<>();
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".funcion where deleted = false");
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                result.add(mapToEntity(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) PoolConnection.getPoolConnection().releaseConnection(con);
        }
        return result;
    }

    @Override
    public Funcion mapToEntity(ResultSet rs) throws SQLException{
    	return new Funcion(
                CineController.getInstance().getPelicula(rs.getString(2)),
                CineController.getInstance().getSala(rs.getString(1),rs.getString(3)),
                LocalDateTime.parse(rs.getString(4), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        );
    }
}

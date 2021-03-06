package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.applicacionesInteractivas.modelo.Asiento;
import com.applicacionesInteractivas.modelo.AsientoFuncion;

public class AsientoFuncionDAO implements ICRUD<AsientoFuncion> {
    private static AsientoFuncionDAO instance;

    public static AsientoFuncionDAO getInstance() {
        if (instance== null){
            instance = new AsientoFuncionDAO();
        }
        return instance;
    }

    @Override
    public void insert(AsientoFuncion asientoFuncion) {
    	try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".asiento_funcion(id_funcion, fila, columna, ocupado) "+
            											"values(?,?,?,?)");
            
            s.setInt(1, asientoFuncion.getFuncion().getId());
            s.setInt(2, asientoFuncion.getAsiento().getPosx());
            s.setInt(3, asientoFuncion.getAsiento().getPosY());
            s.setBoolean(4, asientoFuncion.isOcupado());
            s.execute();
            
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(AsientoFuncion asientoFuncion) {

    }

    @Override
    public void update(AsientoFuncion asientoFuncion) {
    	try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("update " + PoolConnection.dbName + ".asiento_funcion "+
            											"set ocupado = ? where id_funcion = ? and fila = ? and columna = ?");
            
            s.setBoolean(1, asientoFuncion.isOcupado());
            s.setInt(2, asientoFuncion.getFuncion().getId());
            s.setInt(3, asientoFuncion.getAsiento().getPosx());
            s.setInt(4, asientoFuncion.getAsiento().getPosY());
            s.execute();
            
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AsientoFuncion get(AsientoFuncion asientoFuncion) {
        return null;
    }

    @Override
    public AsientoFuncion findBy(int id) throws SQLException {
        return null;
    }

    public AsientoFuncion findBy(int id_funcion, int fila, int columna) throws SQLException {
        Connection con = null;
        ResultSet rs = null;
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".asiento_funcion where id_funcion = ? and fila = ?  and columna = ? ");
            s.setInt(1, id_funcion);
            s.setInt(2, fila);
            s.setInt(3, columna);
            rs = s.executeQuery();
            rs.next();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) PoolConnection.getPoolConnection().releaseConnection(con);
        }

        return mapToEntity(rs);
    }

    @Override
    public List<AsientoFuncion> findAll() {
        return null;
    }

    @Override
    public AsientoFuncion mapToEntity(ResultSet rs) throws SQLException {
        AsientoFuncion af = new AsientoFuncion();
        Asiento a = new Asiento(rs.getInt(2), rs.getInt(3));
        af.setAsiento(a);
        af.setFuncion(FuncionDAO.getInstance().findBy(rs.getInt(1)));
        af.setOcupado(rs.getBoolean(4));
        return af;

    }
}

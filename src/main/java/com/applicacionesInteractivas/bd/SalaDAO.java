package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.modelo.Sala;

public class SalaDAO implements ICRUD<Sala> {

    private static SalaDAO instance;

    public static SalaDAO getInstance() {
        if (instance == null) {
            instance = new SalaDAO();
        }
        return instance;
    }

    @Override
    public void insert(Sala sala) {
        try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".sala(nombre, filas, columnas, cuit, deleted)"+
            											"values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            s.setString(1, sala.getNombre());
            s.setInt(2, sala.getFilas());
            s.setInt(3, sala.getColumnas());
            s.setString(4, sala.getCine().getCuit());
            s.setBoolean(5, false);
            s.execute();
            
            ResultSet keys = s.getGeneratedKeys();
            keys.next();
            int idSala = keys.getInt(1);
            sala.setId(idSala);
            
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Sala sala) {
    	try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("update " + PoolConnection.dbName + ".sala set deleted = ? where id_sala = ?");
            s.setBoolean(1, sala.isDeleted());
            s.setInt(2, sala.getId());
            s.execute();
            
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Sala sala) {
        try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("update " + PoolConnection.dbName + ".sala set nombre = ?, filas = ?, columnas = ? where id_sala = ?");
            s.setString(1, sala.getNombre());
            s.setInt(2, sala.getFilas());
            s.setInt(3, sala.getColumnas());
            s.setInt(4, sala.getId());
            s.execute();
            
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Sala get(Sala sala) {
        return null;
    }

    @Override
    public Sala findBy(int id) {
        return null;
    }

    @Override
    public List<Sala> findAll() {
        Connection con = null;
        ArrayList<Sala> result = new ArrayList<>();
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".sala where deleted = false");
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
    public Sala mapToEntity(ResultSet rs) throws SQLException {
        return new Sala(
        		rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4),
                CineDAO.getInstance().findByCuit(rs.getString(5))
        );
    }

}

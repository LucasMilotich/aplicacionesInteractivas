package com.applicacionesInteractivas.bd;

import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.modelo.Sala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".sala values (?,?,?,?,?)");
            s.setString(1, sala.getNombre());
            s.setInt(2, sala.getFilas());
            s.setInt(3, sala.getColumnas());
            s.setString(4, sala.getCine().getCuit());
            s.setBoolean(5, false);

            s.execute();
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Sala funcion) {

    }

    @Override
    public void update(Sala sala) {
        try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("update " + PoolConnection.dbName + ".sala set nombre = ?, filas = ?, columnas = ?, cuit = ?, deleted = ? where cuit = ? and nombre = ?");
            s.setString(1, sala.getNombre());
            s.setInt(2, sala.getFilas());
            s.setInt(3, sala.getColumnas());
            s.setString(4, sala.getCine().getCuit());
            s.setBoolean(5, sala.isDeleted());
            s.setString(6, sala.getCine().getCuit());
            s.setString(7, sala.getNombre());

            s.execute();
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                rs.getString(1),
                rs.getInt(2),
                rs.getInt(3),
                CineDAO.getInstance().findByCuit(rs.getString(4))
        );
    }

}

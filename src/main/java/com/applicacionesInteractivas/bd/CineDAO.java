package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.modelo.Usuario;
import com.applicacionesInteractivas.vista.formularios.usuarios.Columns;

public class CineDAO implements ICRUD<Cine> {

    private static CineDAO instance;

    public static CineDAO getInstance() {
        if (instance == null) {
            instance = new CineDAO();
        }
        return instance;
    }

    @Override
    public void insert(Cine d) {
        try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".cine values (?,?,?,?)");
            s.setString(1, d.getCuit());

            s.setString(2, d.getNombre());
            s.setString(3, d.getDomicilio());
            s.setBoolean(4, false);


            s.execute();
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Cine d) {
        try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("delete from " + PoolConnection.dbName + ".cine where cuit = ?");
            s.setString(1, d.getCuit());
            s.execute();
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cine cine) {
        try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("update " + PoolConnection.dbName + ".cine set cuit = ?, nombre = ?, domicilio = ?, deleted = ?");
            s.setString(1, cine.getCuit());

            s.setString(2, cine.getNombre());
            s.setString(3, cine.getDomicilio());
            s.setBoolean(4, cine.isDeleted());

            s.execute();
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        Connection con = null;
        ArrayList<Cine> result = new ArrayList<>();
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".cine");
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
    public Cine mapToEntity(ResultSet rs) throws SQLException {
        return new Cine(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3)
                );
    }
}

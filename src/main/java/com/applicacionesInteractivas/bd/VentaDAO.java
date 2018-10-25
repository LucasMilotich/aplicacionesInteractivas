package com.applicacionesInteractivas.bd;

import com.applicacionesInteractivas.modelo.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VentaDAO implements ICRUD<Venta> {

    private static VentaDAO instance;

    public static VentaDAO getInstance() {
        if (instance == null) {
            instance = new VentaDAO();
        }
        return instance;
    }

    @Override
    public void insert(Venta venta) {
        try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".venta values (?,?,?,?,?)");
            s.setInt(1, venta.getCantidad());

            s.setDouble(2, venta.getPrecioUnitario());
            s.setDouble(3, venta.getTotal());
            s.setString(4, venta.getMedioDePago());
            s.setString(5,venta.getCine().getCuit());

            s.execute();
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Venta venta) {

    }

    @Override
    public void update(Venta venta) {

    }

    @Override
    public Venta get(Venta venta) {
        return null;
    }

    @Override
    public Venta findBy(int id) {
        return null;
    }

    @Override
    public List<Venta> findAll() {
        return null;
    }

    @Override
    public Venta mapToEntity(ResultSet rs) throws SQLException {
        return null;
    }
}

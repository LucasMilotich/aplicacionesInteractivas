package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.modelo.Entrada;
import com.applicacionesInteractivas.modelo.Venta;

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
            s.setInt(4, getMedioDePagoParaDB(venta.getMedioDePago()));
            s.setString(5, venta.getCine().getCuit());

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
    public Venta findBy(int id) throws SQLException {
        Connection con = null;
        ResultSet rs = null;
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".venta where id_venta = ?");
            s.setInt(1, id);
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
    public List<Venta> findAll() {
        Connection con = null;
        ArrayList<Venta> result = new ArrayList<>();
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".venta where deleted = false");
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
    public Venta mapToEntity(ResultSet rs) throws SQLException {
        Venta venta = new Venta();
        venta.setId(rs.getInt(1));
        venta.setCine(CineDAO.getInstance().findByCuit(rs.getString(2)));
        venta.setCantidad(rs.getInt(3));
        switch (rs.getInt(4)) {
            case 1:
                venta.setMedioDePago("EFECTIVO");
                break;
            case 2:
                venta.setMedioDePago("TARJETA DE CREDITO");
                break;
            case 3:
                venta.setMedioDePago("TARJETA DE DEBITO");
                break;
        }
        venta.setPrecioUnitario(rs.getDouble(5));
        venta.setTotal(rs.getDouble(6));
        venta.setEntradas(EntradaDAO.getInstance().findByIdVenta(venta.getId()));
        return venta;
    }

    private int getMedioDePagoParaDB(String medioDePago){
        if (medioDePago.equals("EFECTIVO")) return 1;
        if (medioDePago.equals("TARJETA DE CREDITO")) return 2;
        if (medioDePago.equals("ARJETA DE DEBITO")) return 3;
        return 1;
    }
}

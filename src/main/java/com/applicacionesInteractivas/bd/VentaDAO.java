package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.modelo.Venta;
import com.applicacionesInteractivas.modelo.medioDePago.Contado;
import com.applicacionesInteractivas.modelo.medioDePago.MedioDePago;
import com.applicacionesInteractivas.modelo.medioDePago.TarjetaCredito;
import com.applicacionesInteractivas.modelo.medioDePago.TarjetaDebito;

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
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".venta(cuit, cantidad, metodo_pago, precio_unitario, total)"+
            											"values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            
            s.setString(1, venta.getCine().getCuit());
            s.setInt(2, venta.getCantidad());
            s.setInt(3, this.getMedioDePagoParaDB(venta.getMedioDePago().toString()));
            s.setDouble(4, venta.getPrecioUnitario());
            s.setDouble(5, venta.getTotal());
            s.execute();
            
            ResultSet keys = s.getGeneratedKeys();
            keys.next();
            int idVenta = keys.getInt(1);
            venta.setId(idVenta);
            
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
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".venta where id_venta = ? and estado not like 'RETIRADA'");
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
        MedioDePago medioDePago;
        venta.setId(rs.getInt(1));
        venta.setCine(CineDAO.getInstance().findByCuit(rs.getString(2)));
        venta.setCantidad(rs.getInt(3));
        switch (rs.getInt(4)) {
            case 1:
            	medioDePago = new Contado();
                venta.setMedioDePago(medioDePago);
                break;
            case 2:
            	medioDePago = TarjetaDAO.getInstance().findBy(venta.getId());
                venta.setMedioDePago((TarjetaCredito)medioDePago);
                break;
            case 3:
            	medioDePago = TarjetaDAO.getInstance().findBy(venta.getId());
                venta.setMedioDePago((TarjetaDebito)medioDePago);
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
        if (medioDePago.equals("TARJETA DE DEBITO")) return 3;
        return 1;
    }

    public void retirar(int id){
        try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("update " + PoolConnection.dbName + ".venta set estado = 'RETIRADA' where id_venta  = ? ");
            s.setInt(1, id);
            s.execute();

            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

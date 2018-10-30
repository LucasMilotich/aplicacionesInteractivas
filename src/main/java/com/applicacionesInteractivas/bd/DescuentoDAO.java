package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.modelo.descuento.Descuento;
import com.applicacionesInteractivas.modelo.descuento.DosPorUno;
import com.applicacionesInteractivas.modelo.descuento.PorcentajeSobreVenta;
import com.mysql.cj.jdbc.result.ResultSetImpl;

public class DescuentoDAO implements ICRUD<Descuento> {

    private static DescuentoDAO instance;

    public static DescuentoDAO getInstance() {
        if (instance == null) {
            instance = new DescuentoDAO();
        }
        return instance;
    }

    @Override
    public void insert(Descuento descuento) {
        try {

            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".descuento values (?,?,?,?,?,?,?,?)");

            s.setString(1, descuento.getCine().getCuit());
            s.setString(2, descuento.getNombre());
            s.setDate(3, Date.valueOf(descuento.getVigenciaDesde()));
            s.setDate(4, Date.valueOf(descuento.getVigenciaHasta()));

            getDescuentoVariable(descuento, s);
            s.setBoolean(8, false);

            s.execute();
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Descuento descuento) {

    }

    @Override
    public void update(Descuento descuento) {
        try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("update " + PoolConnection.dbName + ".descuento set cuit = ?, "+
                "nombre = ?, vigencia_desde = ?, vigencia_hasta = ? , cant_prod_requeridos= ? , cant_prod_a_pagar=? , porcentaje_descuento=?, deleted=? where cuit = ? and nombre =?");
            s.setString(1, descuento.getCine().getCuit());

            s.setString(2, descuento.getNombre());
            s.setDate(3, Date.valueOf(descuento.getVigenciaDesde()));
            s.setDate(4,Date.valueOf( descuento.getVigenciaHasta()));

            getDescuentoVariable(descuento, s);

            s.setBoolean(8, descuento.isDeleted());
            s.setString(9, descuento.getCine().getCuit());
            s.setString(10, descuento.getNombre());


            s.execute();
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getDescuentoVariable(Descuento descuento, PreparedStatement s) throws SQLException {
        if (descuento.isDosPorUno()) {
            DosPorUno dosPorUno = (DosPorUno) descuento;
            s.setInt(5, dosPorUno.getCantidadProductosRequeridos());
            s.setInt(6, dosPorUno.getCantidadProductosAPagar());
            s.setInt(7, 0);
        } else if (descuento.isPorcentaje()) {
            PorcentajeSobreVenta porcentajeSobreVenta = (PorcentajeSobreVenta) descuento;
            s.setInt(5, 0);
            s.setInt(6, 0);
            s.setInt(7, porcentajeSobreVenta.getPorcentajeSobreVenta());
        }
    }

    @Override
    public Descuento get(Descuento descuento) {
        return null;
    }

    @Override
    public Descuento findBy(int id) {
        return null;
    }

    @Override
    public List<Descuento> findAll() {
        Connection con = null;
        ArrayList<Descuento> result = new ArrayList<>();
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".descuento where deleted = false");
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
    
    public List<Descuento> findAllByCuit(String cuit){
    	Connection con = null;
        ArrayList<Descuento> result = new ArrayList<>();
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".descuento where deleted = false and cuit = ?");
            s.setString(1, cuit);
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
    public Descuento mapToEntity(ResultSet rs) throws SQLException {
        Descuento descuento = null;
        if (rs.getInt(5) == 0) {
            // descuento %
            descuento = new PorcentajeSobreVenta();

            ((PorcentajeSobreVenta) descuento).setPorcentajeSobreVenta(rs.getInt(7));
        } else {
            // 2x1
            descuento = new DosPorUno();

            ((DosPorUno) descuento).setCantidadProductosRequeridos(rs.getInt(5));
            ((DosPorUno) descuento).setCantidadProductosAPagar(rs.getInt(6));

        }

        descuento.setCine(CineController.getInstance().getCine(rs.getString(1)));
        descuento.setNombre(rs.getString(2));
        descuento.setVigenciaDesde(((ResultSetImpl) rs).getLocalDate(3));
        descuento.setVigenciaHasta(((ResultSetImpl) rs).getLocalDate(4));
        descuento.setDeleted(rs.getBoolean(8));
        return descuento;
    }
}

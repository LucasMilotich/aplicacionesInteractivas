package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.modelo.Entrada;

public class EntradaDAO implements ICRUD<Entrada> {

    private static EntradaDAO instance;

    public static EntradaDAO getInstance() {
        if (instance == null) {
            instance = new EntradaDAO();
        }
        return instance;
    }

    @Override
    public void insert(Entrada entrada) {
        try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".entrada(id_venta, estado, fila, columna, id_funcion)"+
            											"values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            
            s.setInt(1, entrada.getVenta().getId());
            s.setString(2, entrada.getEstado());
            //s.setString(2, entrada.getCodAutenticacion());
            s.setInt(3, entrada.getAsientoFuncion().getAsiento().getPosx());
            s.setInt(4, entrada.getAsientoFuncion().getAsiento().getPosY());
            s.setInt(5, entrada.getAsientoFuncion().getFuncion().getId());
            s.execute();

            ResultSet keys = s.getGeneratedKeys();
            keys.next();
            int idEntrada = keys.getInt(1);
            entrada.setId(idEntrada);
            
            AsientoFuncionDAO.getInstance().update(entrada.getAsientoFuncion());

            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Entrada entrada) {

    }

    @Override
    public void update(Entrada entrada) {

    }

    @Override
    public Entrada get(Entrada entrada) {
        return null;
    }

    @Override
    public Entrada findBy(int id) throws SQLException {
    	Connection con = null;
        ResultSet rs = null;
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".entrada where id_entrada = ?");
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
    public List<Entrada> findAll() {
        return null;
    }

    public List<Entrada> findByIdVenta(int id) {
        Connection con = null;
        ArrayList<Entrada> result = new ArrayList<>();
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".entrada where id_venta = ?");
            s.setInt(1, id);

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
    public Entrada mapToEntity(ResultSet rs) throws SQLException {
        Entrada entrada = new Entrada();
        
        entrada.setId(rs.getInt(1));
        entrada.setVenta(VentaDAO.getInstance().findBy(rs.getInt(2)));
        entrada.setEstado(rs.getString(3));
        entrada.setAsiento(AsientoFuncionDAO.getInstance().findBy(rs.getInt(6), rs.getInt(4), rs.getInt(5)));
        
        return entrada;
    }
}

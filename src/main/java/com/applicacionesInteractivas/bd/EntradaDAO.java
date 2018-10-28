package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.modelo.AsientoFuncion;
import com.applicacionesInteractivas.modelo.Entrada;
import com.applicacionesInteractivas.modelo.Venta;

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
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".entrada values (?,?,?,?,?,?)");
            s.setString(1, entrada.getEstado());

            s.setString(2, entrada.getCodAutenticacion());
            s.setString(3, entrada.getFuncion().getSala().getCine().getCuit());
            s.setString(4, entrada.getFuncion().getSala().getNombre());
            s.setString(5, entrada.getFuncion().getPelicula().getNombre());
            s.setString(5, Integer.toString(entrada.getAsiento().getAsiento().getPosx()) + ";" +Integer.toString(entrada.getAsiento().getAsiento().getPosY()));
//            s.setTimestamp(6, entrada.getFuncion().getHorario());
            s.execute();

            s = con.prepareStatement("SELECT LAST_INSERT_ID()");

            ResultSet rs = s.executeQuery();
            int idEntrada = rs.getInt(0);
            entrada.setId(idEntrada);

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
    public Entrada findBy(int id) {
        return null;
    }

    @Override
    public List<Entrada> findAll() {
        return null;
    }

    public List<Entrada> findByIdVenta(int id){
        Connection con = null;
        ArrayList<Entrada> result = new ArrayList<>();
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".entrada where id_venta = ?");
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
        entrada.setVenta(VentaDAO.getInstance().findBy(rs.getInt(1)));
        entrada.setEstado(rs.getString(3));
        // TODO ASientofuncionDAO
        entrada.setAsiento(null);
        entrada.setFuncion(FuncionDAO.getInstance().findBy(rs.getInt(5)));
        return entrada;
    }
}

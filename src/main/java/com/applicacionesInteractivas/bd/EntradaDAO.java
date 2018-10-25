package com.applicacionesInteractivas.bd;

import com.applicacionesInteractivas.modelo.AsientoFuncion;
import com.applicacionesInteractivas.modelo.Entrada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".entrada values (?,?,?,?,?)");
            s.setString(1, entrada.getEstado());

            s.setString(2, entrada.getCodAutenticacion());
            s.setString(3, entrada.getFuncion().getSala().getCine().getCuit());
            s.setString(4, entrada.getFuncion().getSala().getNombre());
            s.setString(5, entrada.getFuncion().getPelicula().getNombre());
            s.setInt(5, entrada.getAsiento().getId());
            s.setTimestamp(6,entrada.getFuncion().getHorario());
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

    @Override
    public Entrada mapToEntity(ResultSet rs) throws SQLException {
        return null;
    }
}

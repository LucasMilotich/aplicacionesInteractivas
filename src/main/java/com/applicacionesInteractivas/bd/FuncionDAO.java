package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.modelo.Asiento;
import com.applicacionesInteractivas.modelo.AsientoFuncion;
import com.applicacionesInteractivas.modelo.Funcion;

public class FuncionDAO implements ICRUD<Funcion> {

    private static FuncionDAO instance;

    public static FuncionDAO getInstance() {
        if (instance== null){
            instance = new FuncionDAO();
        }
        return instance;
    }

    @Override
    public void insert(Funcion funcion) {
        try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".funcion values (?,?,?,?,?)");
            s.setString(1, funcion.getSala().getCine().getCuit());
            s.setString(2, funcion.getPelicula().getNombre());
            s.setString(3, funcion.getSala().getNombre());
            s.setTimestamp(4,  funcion.getHorario());
            s.setBoolean(5, false);
            s.execute();
            
            for(AsientoFuncion af : funcion.getAsientoFunciones()) {
            	PreparedStatement ss = con.prepareStatement("insert into " + PoolConnection.dbName + ".asiento_funcion "+
            												"values (?,?,?,?,?,?,?)");
            	ss.setString(1, funcion.getSala().getCine().getCuit());
                ss.setString(2, funcion.getPelicula().getNombre());
                ss.setString(3, funcion.getSala().getNombre());
                ss.setTimestamp(4,  funcion.getHorario());
                ss.setInt(5, af.getAsiento().getPosx());
                ss.setInt(6, af.getAsiento().getPosY());
                ss.setBoolean(7, false);
                ss.execute();
            }
            
            
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Funcion f) {
    	try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("update " + PoolConnection.dbName + ".funcion set deleted = ?"
            										 + " where cuit = ? and pelicula = ? and sala = ? and horario = ?");
            s.setBoolean(1, true);
            s.setString(2, f.getSala().getCine().getCuit());
            s.setString(3, f.getPelicula().getNombre());
            s.setString(4, f.getSala().getNombre());
            s.setTimestamp(5, f.getHorario());
            s.execute();
            
            for(AsientoFuncion af : f.getAsientoFunciones()) {
            	PreparedStatement ss = con.prepareStatement("update " + PoolConnection.dbName + ".funcion set deleted = ?"
										 				+ " where cuit = ? and pelicula = ? and sala = ? and horario = ?"
            											+ " and fila = ? and columna = ?");
				ss.setBoolean(1, true);
				ss.setString(2, f.getSala().getCine().getCuit());
				ss.setString(3, f.getPelicula().getNombre());
				ss.setString(4, f.getSala().getNombre());
				ss.setTimestamp(5, f.getHorario());
				ss.setInt(6, af.getAsiento().getPosx());
				ss.setInt(7, af.getAsiento().getPosY());
				ss.execute();
            }
            
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Funcion f) {
    	
    }

    @Override
    public Funcion get(Funcion funcion) {
        return null;
    }

    @Override
    public Funcion findBy(int id) {
        return null;
    }

    @Override
    public List<Funcion> findAll() {
    	Connection con = null;
        ArrayList<Funcion> result = new ArrayList<>();
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".funcion where deleted = false");
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
            	Funcion f = mapToEntity(rs);
            	ArrayList<AsientoFuncion> asientos = new ArrayList<AsientoFuncion>();
            	PreparedStatement ss = con.prepareStatement("select fila, columna, deleted from " + PoolConnection.dbName + ".asiento_funcion where "
            												+"cuit = ? and pelicula = ? and sala = ? and horario = ? ");
            	ss.setString(1, rs.getString(1));
            	ss.setString(2, rs.getString(2));
            	ss.setString(3, rs.getString(3));
            	ss.setTimestamp(4, rs.getTimestamp(4));
            	ResultSet rs2 = ss.executeQuery();
            	
            	while(rs2.next()){
            		asientos.add(new AsientoFuncion(rs2.getBoolean(3), new Asiento(rs.getInt(1), rs.getInt(2)), f));
            	}
            	
            	f.setAsientoFunciones(asientos);
                result.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) PoolConnection.getPoolConnection().releaseConnection(con);
        }
        return result;
    }

    @Override
    public Funcion mapToEntity(ResultSet rs) throws SQLException{
    	return new Funcion(
                CineController.getInstance().getPelicula(rs.getString(2)),
                CineController.getInstance().getSala(rs.getString(1),rs.getString(3)),
                rs.getTimestamp(4)
        );
    }
}

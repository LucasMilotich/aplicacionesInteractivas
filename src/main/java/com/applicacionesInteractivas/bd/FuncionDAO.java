package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
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
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".funcion(cuit,id_pelicula,id_sala,fecha,hora,deleted)"
            											+"values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            s.setString(1, funcion.getSala().getCine().getCuit());
            s.setInt(2, funcion.getPelicula().getId());
            s.setInt(3, funcion.getSala().getId());
            s.setDate(4,  Date.valueOf(funcion.getFecha()));
            s.setTime(5, Time.valueOf(funcion.getHora()));
            s.setBoolean(6, false);
            s.execute();

            ResultSet keys = s.getGeneratedKeys();
            keys.next();
            int idFuncion = keys.getInt(1);
            funcion.setId(idFuncion);
            
            for(AsientoFuncion af : funcion.getAsientoFunciones()) {
            	PreparedStatement ss = con.prepareStatement("insert into " + PoolConnection.dbName + ".asiento_funcion "+
            												"values (?,?,?,?)");
            	ss.setInt(1,  funcion.getId());
                ss.setInt(2, af.getAsiento().getPosx());
                ss.setInt(3, af.getAsiento().getPosY());
                ss.setBoolean(4, false);
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
            										 + " where id_funcion = ?");
            s.setBoolean(1, f.isDeleted());
            s.setInt(2, f.getId());
            s.execute();
            
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Funcion f) {
    	try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("update " + PoolConnection.dbName + ".funcion set fecha = ?, hora = ?"
            										 + " where id_funcion = ?");
            s.setDate(1, Date.valueOf(f.getFecha()));
            s.setTime(2, Time.valueOf(f.getHora()));
            s.setInt(3, f.getId());
            s.execute();
            
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            	PreparedStatement ss = con.prepareStatement("select fila, columna, ocupado from " + PoolConnection.dbName + ".asiento_funcion where "
            												+"id_funcion = ? ");
            	ss.setInt(1, rs.getInt(1));
            	ResultSet rs2 = ss.executeQuery();
            	
            	while(rs2.next()){
            		asientos.add(new AsientoFuncion(rs2.getBoolean(3), new Asiento(rs2.getInt(1), rs2.getInt(2)), f));
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
    			rs.getInt(1),
                CineController.getInstance().getPelicula(rs.getInt(3)),
                CineController.getInstance().getSala(rs.getInt(4)),
                rs.getDate(5).toLocalDate(),
                rs.getTime(6).toLocalTime()
        );
    }
}

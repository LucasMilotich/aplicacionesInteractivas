package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.applicacionesInteractivas.modelo.Cine;

public class CineDAO implements ICRUD<Cine> {

    private static CineDAO instance;

    public static CineDAO getInstance() {
        if (instance== null){
            instance = new CineDAO();
        }
        return instance;
    }

    @Override
    public void insert(Cine d) {
    	try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".Cines values (?,?,?,?)");
			/*s.setInt(1,a.getCodigo());
			s.setString(2, a.getNombre());
			s.setFloat(3,a.getPrecio());
			s.setDate(4, new java.sql.Date(a.getVigencia().getTime()));*/
			s.execute();
			PoolConnection.getPoolConnection().releaseConnection(con);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    }

    @Override
    public void delete(Cine d) {
    	try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("delete from " + PoolConnection.dbName + ".Cines where cuit = ?");
			s.setString(1, d.getCuit());
			s.execute();
			PoolConnection.getPoolConnection().releaseConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void update(Cine cine) {
        
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
        return null;
    }

    @Override
    public Cine mapToEntity(ResultSet rs) {
        return null;
    }
}

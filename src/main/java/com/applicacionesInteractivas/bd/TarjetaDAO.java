package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.applicacionesInteractivas.modelo.medioDePago.Tarjeta;

public class TarjetaDAO implements ICRUD<Tarjeta>{

	private static TarjetaDAO instance;

    public static TarjetaDAO getInstance() {
        if (instance == null) {
            instance = new TarjetaDAO();
        }
        return instance;
    }
    
	@Override
	public void insert(Tarjeta t) {
		try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".datos_tarjeta(id_venta,tipo_tarjeta,numero,vencimiento,codigo_seg)"
            											+"values (?,?,?,?,?)");
            s.setInt(1, t.getVenta().getId()); 
            s.setInt(2, this.getTipoTarjetaParaDB(t.getTipo()));
            s.setString(3, t.getNumero());
            s.setString(4,  t.getVencimiento());
            s.setString(5, t.getCodigo());
            s.execute();
            
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public void delete(Tarjeta t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Tarjeta t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tarjeta get(Tarjeta t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tarjeta findBy(int id) throws SQLException {
		Connection con = null;
        ResultSet rs = null;
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".datos_tarjeta where id_venta = ?");
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
	public List<Tarjeta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tarjeta mapToEntity(ResultSet rs) throws SQLException {
		return new Tarjeta(rs.getString(2), 
						   rs.getString(3), 
						   rs.getString(4), 
						   rs.getString(5));
	}
	
	private int getTipoTarjetaParaDB(String tipoTarjeta){
        if (tipoTarjeta.equals("AMEX")) return 1;
        if (tipoTarjeta.equals("MasterCard")) return 2;
        if (tipoTarjeta.equals("Visa")) return 3;
        return 1;
    }

}

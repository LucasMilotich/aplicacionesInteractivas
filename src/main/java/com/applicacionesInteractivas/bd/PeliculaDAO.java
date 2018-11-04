package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.modelo.Pelicula;

public class PeliculaDAO implements ICRUD<Pelicula> {

    private static PeliculaDAO instance;

    public static PeliculaDAO getInstance() {
        if (instance== null){
            instance = new PeliculaDAO();
        }
        return instance;
    }

    @Override
    public void insert(Pelicula p) {
    	try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".pelicula"+
            						"(nombre, director, genero, duracion, idioma, subtitulos, calificacion, observaciones, deleted)"+
            						" values (?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            s.setString(1, p.getNombre());
            s.setString(2, p.getDirector());
            s.setString(3, p.getGenero());
            s.setString(4, p.getDuracion());
            s.setString(5, p.getIdioma());
            s.setString(6, p.getSubtitulos());
            s.setInt(7, p.getCalificacion());
            s.setString(8, p.getObservacion());
            s.setBoolean(9, false);
            s.execute();
            
            ResultSet keys = s.getGeneratedKeys();
            keys.next();
            int idPelicula = keys.getInt(1);
            p.setId(idPelicula);
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Pelicula pelicula) {
    	try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("update " + PoolConnection.dbName + ".pelicula set deleted = ? where id_pelicula = ?");
            s.setBoolean(1, pelicula.isDeleted());
            s.setInt(2, pelicula.getId());
            s.execute();
            
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pelicula p) {
    	try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("update " + PoolConnection.dbName + ".pelicula set nombre = ?, director = ?, "
            										 + "genero = ?, duracion = ?, idioma = ?, subtitulos = ?, calificacion = ?, "
            										 + "observaciones = ? where id_pelicula = ?");
            s.setString(1, p.getNombre());
            s.setString(2, p.getDirector());
            s.setString(3, p.getGenero());
            s.setString(4, p.getDuracion());
            s.setString(5, p.getIdioma());
            s.setString(6, p.getSubtitulos());
            s.setInt(7, p.getCalificacion());
            s.setString(8, p.getObservacion());
            s.setInt(9, p.getId());
            s.execute();
            
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pelicula get(Pelicula pelicula) {
        return null;
    }

    @Override
    public Pelicula findBy(int id) {
        return null;
    }

    @Override
    public List<Pelicula> findAll() {
    	Connection con = null;
        ArrayList<Pelicula> result = new ArrayList<>();
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".pelicula where deleted = false");
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
    public Pelicula mapToEntity(ResultSet rs) throws SQLException {
    	return new Pelicula(
    			rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getInt(8),
                rs.getString(9)
        );
    }

	public boolean esPeliculaEliminable(int id) {
		Connection con = null;
        boolean result = false;
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select IF(COUNT(1) > 0, 0, 1) from " + PoolConnection.dbName + ".funcion where " +
            											"id_pelicula = ? and deleted = false");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                result = rs.getBoolean(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) PoolConnection.getPoolConnection().releaseConnection(con);
        }
        return result;
	}
}

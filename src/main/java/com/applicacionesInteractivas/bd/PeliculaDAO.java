package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".pelicula values (?,?,?,?,?,?,?,?,?)");
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
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Pelicula pelicula) {
        
    }

    @Override
    public void update(Pelicula p) {
    	try {
            Connection con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("update " + PoolConnection.dbName + ".pelicula set nombre = ?, director = ?, "
            										 + "genero = ?, duracion = ?, idioma = ?, subtitulos = ?, calificacion = ?, "
            										 + "observaciones = ?, deleted = ? where nombre = ?");
            s.setString(1, p.getNombre());
            s.setString(2, p.getDirector());
            s.setString(3, p.getGenero());
            s.setString(4, p.getDuracion());
            s.setString(5, p.getIdioma());
            s.setString(6, p.getSubtitulos());
            s.setInt(7, p.getCalificacion());
            s.setString(8, p.getObservacion());
            s.setBoolean(9, p.isDeleted());
            s.setString(10, p.getNombre());

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
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getInt(7),
                rs.getString(8)
        );
    }
}

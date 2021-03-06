package com.applicacionesInteractivas.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.modelo.Usuario;
import com.applicacionesInteractivas.modelo.rol.Administrador;
import com.applicacionesInteractivas.modelo.rol.AgenteComercial;
import com.applicacionesInteractivas.modelo.rol.Cliente;
import com.applicacionesInteractivas.modelo.rol.IRol;
import com.applicacionesInteractivas.modelo.rol.Operador;
import com.applicacionesInteractivas.modelo.rol.Vendedor;
import com.applicacionesInteractivas.vista.formularios.usuarios.Columns;

public class UsuarioDAO implements ICRUD<Usuario> {

    private static UsuarioDAO instance;

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    @Override
    public void insert(Usuario u) {
        Connection con = null;
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("insert into " + PoolConnection.dbName + ".usuario values (?,?,?,?,?,?,?,?)");
            s.setString(Columns.DNI + 1, u.getDni());
            s.setString(Columns.NOMBREUSUARIO + 1, u.getNombreUsuario());
            s.setString(Columns.NOMBRE + 1, u.getNombre());
            s.setString(Columns.DOMICILIO + 1, u.getDomicilio());
            s.setString(Columns.PASSWORD + 1, u.getPassword());
            s.setString(Columns.EMAIL + 1, u.getEmail());
            s.setDate(Columns.FECHANACIMIENTO + 1, Date.valueOf(u.getFechaNacimiento()));
            s.setBoolean(8, false);
            s.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) PoolConnection.getPoolConnection().releaseConnection(con);
        }
    }

    @Override
    public void delete(Usuario d) {
        Connection con = null;
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("delete from " + PoolConnection.dbName + ".Cines where cuit = ?");
            //s.setString(1, d.getCuit());
            s.execute();
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) PoolConnection.getPoolConnection().releaseConnection(con);
        }
    }

    @Override
    public void update(Usuario u) {
        Connection con = null;
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("update " + PoolConnection.dbName + ".usuario set " +
                " dni = ?, nombre  = ?,  domicilio= ?, nombre_usuario= ?,email= ?, fecha_nacimiento = ?,  password  = ?, deleted = ?");
            s.setString(Columns.DNI + 1, u.getDni());
            s.setString(Columns.NOMBREUSUARIO + 1, u.getNombreUsuario());
            s.setString(Columns.NOMBRE + 1, u.getNombre());
            s.setString(Columns.DOMICILIO + 1, u.getDomicilio());
            s.setString(Columns.PASSWORD + 1, u.getPassword());
            s.setString(Columns.EMAIL + 1, u.getEmail());
            s.setDate(Columns.FECHANACIMIENTO + 1, Date.valueOf(u.getFechaNacimiento()));
            s.setBoolean(Columns.DELETED + 1, u.isDeleted());
            System.out.printf("The query is %s ", s.toString());
            s.execute();
            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) PoolConnection.getPoolConnection().releaseConnection(con);
        }

    }

    @Override
    public Usuario get(Usuario cine) {
        return null;
    }

    @Override
    public Usuario findBy(int id) {
        return null;
    }

    public boolean validarAcceso(String username, String password) {
        Connection con = null;
        boolean result = false;
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select IF(COUNT(1) > 0, 1, 0) from " + PoolConnection.dbName + ".usuario where " +
                "nombre_usuario = ? and password = ? and deleted = false");
            s.setString(1, username);
            s.setString(2, password);
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

    @Override
    public List<Usuario> findAll() {
        Connection con = null;
        ArrayList<Usuario> result = new ArrayList<>();
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select * from " + PoolConnection.dbName + ".usuario");
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
            	Usuario u = mapToEntity(rs);
            	PreparedStatement ss = con.prepareStatement("select * from " + PoolConnection.dbName + ".rol_usuario"+
            												" where nombre_usuario = ?");
            	ss.setString(1, u.getNombreUsuario());
            	ResultSet rs2 = ss.executeQuery();
            	List<IRol> roles = new ArrayList<IRol>();
            	while(rs2.next()) {
            		switch(rs2.getString(2)) {
            			case "ADMINISTRADOR":
            				roles.add(new Administrador());
            				break;
            			case "AGENTE COMERCIAL":
            				roles.add(new AgenteComercial());
            				break;
            			case "VENDEDOR":
            				roles.add(new Vendedor());
            				break;
            			case "CLIENTE":
            				roles.add(new Cliente());
            				break;
            			case "OPERADOR":
            				roles.add(new Operador());
            				break;
            		}
            	}
            	u.setRoles(roles);
                result.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) PoolConnection.getPoolConnection().releaseConnection(con);
        }
        return result;
    }

    @Override
    public Usuario mapToEntity(ResultSet rs) throws SQLException {
        return new Usuario(
            rs.getString(Columns.NOMBREUSUARIO + 1),
            rs.getString(Columns.EMAIL + 1),
            rs.getString(Columns.PASSWORD + 1),
            rs.getString(Columns.NOMBRE + 1),
            rs.getString(Columns.DOMICILIO + 1),
            rs.getString(Columns.DNI + 1),
            rs.getDate(Columns.FECHANACIMIENTO + 1).toLocalDate(),
            rs.getBoolean(Columns.DELETED + 1));
    }

    public void modificarRoles(Usuario usuario) {

        Connection con = null;
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("delete from " + PoolConnection.dbName + ".rol_usuario " +
                " where nombre_usuario = ?");
            s.setString(1, usuario.getNombreUsuario());
            System.out.printf("The query is %s ", s.toString());
            s.execute();

            for (IRol rol : usuario.getRoles()) {
                s = con.prepareStatement("insert into " + PoolConnection.dbName + ".rol_usuario values (?,?)");
                s.setString(1, usuario.getNombreUsuario());
                s.setString(2, rol.nombre());
                System.out.printf("The query is %s ", s.toString());
                s.execute();
            }


            PoolConnection.getPoolConnection().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) PoolConnection.getPoolConnection().releaseConnection(con);
        }


    }

	public List<IRol> getRoles(String username) {
		Connection con = null;
        ArrayList<IRol> result = new ArrayList<IRol>();
        try {
            con = PoolConnection.getPoolConnection().getConnection();
            PreparedStatement s = con.prepareStatement("select rol from " + PoolConnection.dbName + ".rol_usuario where nombre_usuario = ?");
            s.setString(1, username);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
            	switch(rs.getString(1)) {
        			case "ADMINISTRADOR":
        				result.add(new Administrador());
        				break;
        			case "AGENTE COMERCIAL":
        				result.add(new AgenteComercial());
        				break;
        			case "VENDEDOR":
        				result.add(new Vendedor());
        				break;
        			case "CLIENTE":
        				result.add(new Cliente());
        				break;
        			case "OPERADOR":
        				result.add(new Operador());
        				break;
        		}
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) PoolConnection.getPoolConnection().releaseConnection(con);
        }
        return result;
	}
}

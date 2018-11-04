package com.applicacionesInteractivas.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.applicacionesInteractivas.bd.UsuarioDAO;
import com.applicacionesInteractivas.modelo.Usuario;
import com.applicacionesInteractivas.modelo.rol.Administrador;
import com.applicacionesInteractivas.modelo.rol.AgenteComercial;
import com.applicacionesInteractivas.modelo.rol.Cliente;
import com.applicacionesInteractivas.modelo.rol.IRol;
import com.applicacionesInteractivas.modelo.rol.Operador;
import com.applicacionesInteractivas.modelo.rol.Vendedor;
import com.applicacionesInteractivas.vista.formularios.usuarios.ABMUsuario;
import com.applicacionesInteractivas.vista.formularios.usuarios.AltaUsuario;
import com.applicacionesInteractivas.vista.formularios.usuarios.EliminarUsuario;
import com.applicacionesInteractivas.vista.formularios.usuarios.roles.ABMRoles;

public class UsuarioController {

    private static UsuarioController instance;
    private List<IRol> roles = new ArrayList<>();

    private ABMUsuario abmUsuario;
    private ABMRoles abmRoles;

    public EliminarUsuario getEliminarUsuario() {
        return eliminarUsuario;
    }

    public void setEliminarUsuario(EliminarUsuario eliminarUsuario) {
        this.eliminarUsuario = eliminarUsuario;
    }

    private EliminarUsuario eliminarUsuario;

    private List<Usuario> usuarios = new ArrayList<>();

    private AltaUsuario formularioAltaUsuariol;


    private UsuarioController() {
        roles.add(new Administrador());
        roles.add(new AgenteComercial());
        roles.add(new Cliente());
        roles.add(new Operador());
        roles.add(new Vendedor());
    }

    public static UsuarioController getInstance() {
        if (instance == null) {
            instance = new UsuarioController();
        }
        return instance;
    }

    public List<Usuario> getUsuarios() {
        if (usuarios.size() == 0) {
            return usuarios = UsuarioDAO.getInstance().findAll();
        } else {
            return usuarios.stream().filter(it -> !it.isDeleted()).collect(Collectors.toList());
        }

    }

    public List<IRol> getRoles() {
        return roles;
    }


    public void setAbmUsuario(ABMUsuario abmUsuario) {
        this.abmUsuario = abmUsuario;
    }

    public void setAbmRoles(ABMRoles abmRoles) {
        this.abmRoles = abmRoles;
    }


    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public static void setInstance(UsuarioController instance) {
        UsuarioController.instance = instance;
    }

    public AltaUsuario getFormularioAltaUsuario() {
        return formularioAltaUsuariol;
    }

    public void setFormularioAltaUsuario(AltaUsuario formularioAltaUsuariol) {
        this.formularioAltaUsuariol = formularioAltaUsuariol;
    }


    public void modificarUsuario(String nombreUsuario, String email, String password, String nombre, String domicilio, String dni, LocalDate fechaNacimiento, boolean deleted) {
        Usuario usuario = this.getUsuario(nombreUsuario);

        Usuario.modificarUsuario(usuario, nombreUsuario, email, password, nombre, domicilio, dni, fechaNacimiento,deleted);

    }

    public void crearUsuario(String nombreUsuario, String email, String password, String nombre, String domicilio, String dni, LocalDate fechaNacimiento, boolean deleted) {
        this.usuarios.add(Usuario.crearUsuario(nombreUsuario, email, password, nombre, domicilio, dni, fechaNacimiento,deleted));
    }

    public Usuario getUsuario(String nombreUsuario) {
        for (Usuario u : getUsuarios()) {
            if (u.getNombreUsuario().equals(nombreUsuario))
                return u;
        }

        return null;

    }

    public void modificarRoles(List<String> rolesToUpdate, String username) {

        Usuario usuario = getUsuario(username);
        List<IRol> nuevosRoles =
                rolesToUpdate.stream().map(nombreRol -> {
                            IRol rol = roles.stream().filter(auxRol ->
                                    auxRol.nombre().equals(nombreRol)
                            ).findFirst().get();
                            return rol;
                        }
                ).collect(Collectors.toList());

        Usuario.modificarRoles(usuario,nuevosRoles);


    }

    public void eliminarUsuario(String username) {
        Usuario usuario = getUsuario(username);
        usuario.setDeleted(true);
        Usuario.modificarUsuario(usuario,usuario.getNombreUsuario(),usuario.getEmail(),usuario.getPassword(),usuario.getNombre(),usuario.getDomicilio(),usuario.getDni(),usuario.getFechaNacimiento(),usuario.isDeleted());
    }
    
    public boolean validarAcceso(String username, String password) {
    	return Usuario.validarAcceso(username, password);
    }
}

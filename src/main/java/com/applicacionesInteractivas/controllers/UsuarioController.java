package com.applicacionesInteractivas.controllers;

import com.applicacionesInteractivas.modelo.Usuario;
import com.applicacionesInteractivas.modelo.rol.*;
import com.applicacionesInteractivas.vista.formularios.usuarios.ABMUsuario;
import com.applicacionesInteractivas.vista.formularios.usuarios.AltaUsuario;
import com.applicacionesInteractivas.vista.formularios.usuarios.EliminarUsuario;
import com.applicacionesInteractivas.vista.formularios.usuarios.roles.ABMRoles;

import java.util.*;
import java.util.stream.Collectors;

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
        return usuarios.stream().filter(it -> !it.isDeleted()).collect(Collectors.toList());
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


    public void modificarUsuario(String nombreUsuario, String email, String password, String nombre, String domicilio, String dni, Date fechaNacimiento) {
        Usuario usuario = this.getUsuario(nombreUsuario);

        usuario.setDni(dni);
        usuario.setDomicilio(domicilio);
        usuario.setEmail(email);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setNombre(nombre);
        usuario.setPassword(password);


    }

    public void crearUsuario(String nombreUsuario, String email, String password, String nombre, String domicilio, String dni, Date fechaNacimiento) {
        Usuario usuario = new Usuario(nombreUsuario, email, password, nombre, domicilio, dni, fechaNacimiento);
        this.usuarios.add(usuario);

    }

    public Usuario getUsuario(String nombreUsuario) {
        for (Usuario u : usuarios) {
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
        usuario.setRoles(nuevosRoles);

    }

    public void eliminarUsuario(String username){
        getUsuario(username).setDeleted(true);
    }
}

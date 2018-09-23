package com.applicacionesInteractivas.controllers;

import com.applicacionesInteractivas.modelo.Usuario;
import com.applicacionesInteractivas.vista.formularios.usuarios.JFormABMUsuario;
import com.applicacionesInteractivas.vista.formularios.usuarios.JFormularioAltaUsuario;

import java.util.*;

public class UsuarioController {

    private static UsuarioController instance;


    public static UsuarioController getInstance(){
        if (instance == null){
            instance = new UsuarioController();
        }
        return instance;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    private List<Usuario> usuarios = new ArrayList<>();

    private JFormularioAltaUsuario formularioAltaUsuariol;

    public void setAbmUsuario(JFormABMUsuario abmUsuario) {
        this.abmUsuario = abmUsuario;
    }

    private JFormABMUsuario abmUsuario;

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public static void setInstance(UsuarioController instance) {
        UsuarioController.instance = instance;
    }

    public JFormularioAltaUsuario getFormularioAltaUsuariol() {
        return formularioAltaUsuariol;
    }

    public void setFormularioAltaUsuariol(JFormularioAltaUsuario formularioAltaUsuariol) {
        this.formularioAltaUsuariol = formularioAltaUsuariol;
    }

    public void crearUsuario(String nombreUsuario, String email, String password, String nombre, String domicilio, String dni, Date fechaNacimiento){
        Usuario usuario = new Usuario(nombreUsuario,email,password,nombre,domicilio,dni,fechaNacimiento);
        this.usuarios.add(usuario);

    }
}

package com.applicacionesInteractivas.modelo;

import com.applicacionesInteractivas.bd.UsuarioDAO;
import com.applicacionesInteractivas.modelo.rol.IRol;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Usuario {

    private List<IRol> roles;

    public Usuario(String nombreUsuario, String email, String password, String nombre, String domicilio, String dni, LocalDate fechaNacimiento, boolean deleted) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.deleted = deleted;
    }

    public static Usuario crearUsuario(String nombreUsuario, String email, String password, String nombre, String domicilio, String dni, LocalDate fechaNacimiento,boolean deleted) {
        Usuario usuario = new Usuario(nombreUsuario, email, password, nombre, domicilio, dni, fechaNacimiento, deleted);
        UsuarioDAO.getInstance().insert(usuario);
        return usuario;
    }

    public static Usuario modificarUsuario(Usuario usuario, String nombreUsuario, String email, String password, String nombre, String domicilio, String dni, LocalDate fechaNacimiento, boolean deleted
    ){
        usuario.setDni(dni);
        usuario.setDomicilio(domicilio);
        usuario.setEmail(email);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setNombre(nombre);
        usuario.setPassword(password);
        usuario.setDeleted(deleted);

        UsuarioDAO.getInstance().update(usuario);
        return usuario;
    }

    public static void  modificarRoles(Usuario usuario, List<IRol> roles){
        usuario.setRoles(roles);
        UsuarioDAO.getInstance().modificarRoles(usuario);

    }

    private String nombreUsuario;
    private String email;
    private String password;
    private String nombre;
    private String domicilio;
    private String dni;
    private LocalDate fechaNacimiento;
    private boolean deleted = false;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }



    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<IRol> getRoles() {
        return roles;
    }

    public void setRoles(List<IRol> roles) {
        this.roles = roles;
    }

}

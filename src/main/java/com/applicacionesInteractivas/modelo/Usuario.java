package com.applicacionesInteractivas.modelo;

import com.applicacionesInteractivas.modelo.rol.IRol;

import java.util.Date;
import java.util.List;

public class Usuario {

    private List<IRol> roles;



    private String nombreUsuario;
    private String email;
    private String password;
    private String nombre;
    private String domicilio;
    private String dni;
    private Date fechaNacimiento;

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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public List<IRol> getRoles() {
        return roles;
    }

    public void setRoles(List<IRol> roles) {
        this.roles = roles;
    }

}

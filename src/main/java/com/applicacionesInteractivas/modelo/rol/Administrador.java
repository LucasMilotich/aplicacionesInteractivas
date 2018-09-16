package com.applicacionesInteractivas.modelo.rol;

public class Administrador implements IRol{
    @Override
    public boolean puedeOperar(String accion) {
        return false;
    }
}

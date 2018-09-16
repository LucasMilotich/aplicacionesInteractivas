package com.applicacionesInteractivas.modelo.rol;

public class Vendedor implements IRol{
    @Override
    public boolean puedeOperar(String accion) {
        return false;
    }
}

package com.applicacionesInteractivas.modelo.rol;

public class AgenteComercial implements IRol {
    @Override
    public boolean puedeOperar(String accion) {
        return false;
    }
}

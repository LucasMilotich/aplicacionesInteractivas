package com.applicacionesInteractivas.modelo.rol;

public class Cliente implements IRol {
    @Override
    public boolean puedeOperar(String accion) {
        return accion.equals(this.nombre());
    }

    @Override
    public String nombre() {
        return "CLIENTE";
    }
}

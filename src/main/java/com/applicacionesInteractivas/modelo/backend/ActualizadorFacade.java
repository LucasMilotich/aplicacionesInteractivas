package com.applicacionesInteractivas.modelo.backend;

import com.applicacionesInteractivas.modelo.Terminal;
import com.applicacionesInteractivas.modelo.Venta;

public class ActualizadorFacade {
    private static ActualizadorFacade instance;

    public static ActualizadorFacade getInstance() {
        if (instance == null) {
            instance = new ActualizadorFacade();
        }
        return instance;
    }

    public void notificarVenta(Venta venta){

        Terminal.getVentas().add(venta);
    }
}

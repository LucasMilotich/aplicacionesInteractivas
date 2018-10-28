package com.applicacionesInteractivas.modelo.backend;

import com.applicacionesInteractivas.modelo.Venta;

public class NovedadesObserver implements  IObserver {

    @Override
    public void notificarVenta(Venta venta) {
        ActualizadorFacade.getInstance().notificarVenta(venta);
    }
}

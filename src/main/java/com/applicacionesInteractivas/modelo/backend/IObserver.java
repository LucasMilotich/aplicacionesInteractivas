package com.applicacionesInteractivas.modelo.backend;

import com.applicacionesInteractivas.modelo.Venta;

public interface IObserver {
    void notificarVenta(Venta venta);
}

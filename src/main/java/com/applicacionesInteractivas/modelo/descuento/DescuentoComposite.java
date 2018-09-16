package com.applicacionesInteractivas.modelo.descuento;

import java.util.List;

public class DescuentoComposite extends Descuento {

    private List<Descuento> descuentos;

    public List<Descuento> getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(List<Descuento> descuentos) {
        this.descuentos = descuentos;
    }

    @Override
    public double aplicarDescuento() {
        return 0;
    }
}

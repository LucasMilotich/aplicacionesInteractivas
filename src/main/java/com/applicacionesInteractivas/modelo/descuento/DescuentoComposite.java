package com.applicacionesInteractivas.modelo.descuento;

import com.applicacionesInteractivas.modelo.Venta;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DescuentoComposite extends Descuento {

    private List<Descuento> descuentos;

    public DescuentoComposite() {
        super();
        this.descuentos = new ArrayList<Descuento>();
    }

    public List<Descuento> getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(List<Descuento> descuentos) {
        this.descuentos = descuentos;
    }

    @Override
    public boolean isDosPorUno() {
        return false;
    }

    @Override
    public boolean isPorcentaje() {
        return false;
    }

    @Override
    public double aplicarDescuento() {
        return 0;
    }

    @Override
    public double aplicar(int cantidad, Venta venta) {
        return descuentos.stream().sorted(new Comparator<Descuento>() {
            @Override
            public int compare(Descuento o1, Descuento o2) {
                if (o1.isDosPorUno()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }).map(descuento -> descuento.aplicar(cantidad, venta)).reduce(0.0, (montoDescontado1, montoDescontado2) -> montoDescontado1 + montoDescontado2);
    }
}

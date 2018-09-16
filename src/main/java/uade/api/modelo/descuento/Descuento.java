package uade.api.modelo.descuento;

import uade.api.modelo.Cine;

import java.util.Date;

public abstract class Descuento {

    private Date vigencia;
    private Cine cine;

    public DescuentoComposite getDescuentoComposite() {
        return descuentoComposite;
    }

    public void setDescuentoComposite(DescuentoComposite descuentoComposite) {
        this.descuentoComposite = descuentoComposite;
    }

    private DescuentoComposite descuentoComposite;

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    protected abstract double aplicarDescuento();
}

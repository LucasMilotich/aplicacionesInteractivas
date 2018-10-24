package com.applicacionesInteractivas.modelo.descuento;

import com.applicacionesInteractivas.bd.DescuentoDAO;
import com.applicacionesInteractivas.modelo.Cine;

import java.time.LocalDate;
import java.util.Date;

public abstract class Descuento {

    public LocalDate getVigenciaDesde() {
        return vigenciaDesde;
    }

    public void setVigenciaDesde(LocalDate vigenciaDesde) {
        this.vigenciaDesde = vigenciaDesde;
    }

    public LocalDate getVigenciaHasta() {
        return vigenciaHasta;
    }

    public void setVigenciaHasta(LocalDate vigenciaHasta) {
        this.vigenciaHasta = vigenciaHasta;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    private LocalDate vigenciaDesde;
    private LocalDate vigenciaHasta;
    private Cine cine;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;
    private boolean deleted;

    public DescuentoComposite getDescuentoComposite() {
        return descuentoComposite;
    }

    public void setDescuentoComposite(DescuentoComposite descuentoComposite) {
        this.descuentoComposite = descuentoComposite;
    }

    private DescuentoComposite descuentoComposite;

    public abstract boolean isDosPorUno();
    public abstract boolean isPorcentaje();

    protected abstract double aplicarDescuento();

    public static Descuento modificarDescuento(Descuento d, LocalDate vigenciaDesde, LocalDate vigenciaHasta, int cantidadRequeridosDeProductos, int cantidadACobrar, int porcentaje, boolean deleted){
        d.setVigenciaDesde(vigenciaDesde);
        d.setVigenciaHasta(vigenciaHasta);
        if (cantidadACobrar > 0 && cantidadRequeridosDeProductos > 0 && porcentaje == 0){
            ((DosPorUno) d).setCantidadProductosAPagar(cantidadACobrar);
            ((DosPorUno) d).setCantidadProductosRequeridos(cantidadACobrar);
        }else if (cantidadACobrar == 0 && cantidadRequeridosDeProductos == 0 && porcentaje > 0){
            ((PorcentajeSobreVenta) d).setPorcentajeSobreVenta(porcentaje);
        }
        d.setDeleted(deleted);
        DescuentoDAO.getInstance().update(d);

        return d;
    }
}

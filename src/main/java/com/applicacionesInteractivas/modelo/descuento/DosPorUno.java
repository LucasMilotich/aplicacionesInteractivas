package com.applicacionesInteractivas.modelo.descuento;

import java.time.LocalDate;

import com.applicacionesInteractivas.bd.DescuentoDAO;
import com.applicacionesInteractivas.modelo.Cine;

public class DosPorUno extends Descuento {

    private int cantidadProductosRequeridos =0;
    private int cantidadProductosAPagar =0;

    public int getCantidadProductosRequeridos() {
        return cantidadProductosRequeridos;
    }

    public void setCantidadProductosRequeridos(int cantidadProductosRequeridos) {
        this.cantidadProductosRequeridos = cantidadProductosRequeridos;
    }

    public int getCantidadProductosAPagar() {
        return cantidadProductosAPagar;
    }

    public void setCantidadProductosAPagar(int cantidadProductosAPagar) {
        this.cantidadProductosAPagar = cantidadProductosAPagar;
    }

    public static DosPorUno crearDosPorUno(Cine cine, String nombre, LocalDate vigenciaDesde, LocalDate vigenciaHasta, int cantidadRequeridosDeProductos, int cantidadACobrar) {

        DosPorUno dosPorUno = new DosPorUno();
        dosPorUno.setCine(cine);
        dosPorUno.setNombre(nombre);
        dosPorUno.setVigenciaDesde(vigenciaDesde);
        dosPorUno.setVigenciaHasta(vigenciaHasta);
        dosPorUno.setDeleted(false);
        dosPorUno.setCantidadProductosRequeridos(cantidadRequeridosDeProductos);
        dosPorUno.setCantidadProductosAPagar(cantidadACobrar);

        DescuentoDAO.getInstance().insert(dosPorUno);

        return dosPorUno;


    }

    @Override
    public boolean isDosPorUno() {
        return true;
    }

    @Override
    public boolean isPorcentaje() {
        return false;
    }

    @Override
    public double aplicarDescuento() {
        return 0;
    }
}

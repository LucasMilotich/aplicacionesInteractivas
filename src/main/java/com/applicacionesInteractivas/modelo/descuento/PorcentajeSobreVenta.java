package com.applicacionesInteractivas.modelo.descuento;

import java.time.LocalDate;

import com.applicacionesInteractivas.bd.DescuentoDAO;
import com.applicacionesInteractivas.controllers.VentaController;
import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.modelo.Venta;

public class PorcentajeSobreVenta extends Descuento {

    private int porcentajeSobreVenta = 0;

    public int getPorcentajeSobreVenta() {
        return porcentajeSobreVenta;
    }

    public void setPorcentajeSobreVenta(int porcentajeSobreVenta) {
        this.porcentajeSobreVenta = porcentajeSobreVenta;
    }

    @Override
    public boolean isDosPorUno() {
        return false;
    }

    @Override
    public boolean isPorcentaje() {
        return true;
    }

    @Override
    public double aplicarDescuento() {
        return 0;
    }

    @Override
    public double aplicar(int cantidad, Venta venta) {
        if (porcentajeSobreVenta == 0) return 0;
        venta.setTotal(venta.getTotal() - cantidad * VentaController.precioUnitario * ((double) porcentajeSobreVenta / 100));
        return cantidad * VentaController.precioUnitario * ((double) porcentajeSobreVenta / 100);
    }

    public static PorcentajeSobreVenta crearPorcentajeSobreVenta(Cine cine, String nombre, LocalDate vigenciaDesde, LocalDate vigenciaHasta, int porcentajeSobreVenta){

        PorcentajeSobreVenta porcentajeSobreVta = new PorcentajeSobreVenta();
        porcentajeSobreVta.setCine(cine);
        porcentajeSobreVta.setNombre(nombre);
        porcentajeSobreVta.setVigenciaDesde(vigenciaDesde);
        porcentajeSobreVta.setVigenciaHasta(vigenciaHasta);
        porcentajeSobreVta.setDeleted(false);
        porcentajeSobreVta.setPorcentajeSobreVenta(porcentajeSobreVenta);

        DescuentoDAO.getInstance().insert(porcentajeSobreVta);

        return porcentajeSobreVta;



    }

}


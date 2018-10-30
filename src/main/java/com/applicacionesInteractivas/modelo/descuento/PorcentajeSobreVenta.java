package com.applicacionesInteractivas.modelo.descuento;

import java.time.LocalDate;

import com.applicacionesInteractivas.bd.DescuentoDAO;
import com.applicacionesInteractivas.modelo.Cine;

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


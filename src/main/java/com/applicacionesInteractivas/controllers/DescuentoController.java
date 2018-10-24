package com.applicacionesInteractivas.controllers;

import com.applicacionesInteractivas.bd.CineDAO;
import com.applicacionesInteractivas.bd.DescuentoDAO;
import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.modelo.descuento.Descuento;
import com.applicacionesInteractivas.modelo.descuento.DosPorUno;
import com.applicacionesInteractivas.modelo.descuento.PorcentajeSobreVenta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DescuentoController {

    private static DescuentoController instance;
    private List<Descuento> descuentos = new ArrayList<>();

    public List<Descuento> getDescuentos() {
        if (descuentos.size() == 0) {
            return descuentos = DescuentoDAO.getInstance().findAll();
        } else {
            return descuentos;
        }

    }

    public Descuento getDescuento(String cuil, String nombre) {
        for (Descuento c : getDescuentos()) {
            if (c.getCine().getCuit().equals(cuil) && c.getNombre().equals(nombre))
                return c;
        }

        return null;
    }

    public static DescuentoController getInstance() {
        if (instance == null) {
            instance = new DescuentoController();
        }
        return instance;
    }

    public void eliminarDescuento(String cineCuil, String nombre) {
        Descuento d = getDescuento(cineCuil, nombre);
        if (d.isPorcentaje()) {
            Descuento.modificarDescuento(d, d.getVigenciaDesde(), d.getVigenciaHasta(), 0, 0, ((PorcentajeSobreVenta) d).getPorcentajeSobreVenta(), true);
        } else if (d.isDosPorUno()) {
            Descuento.modificarDescuento(d, d.getVigenciaDesde(), d.getVigenciaHasta(), ((DosPorUno) d).getCantidadProductosRequeridos(), ((DosPorUno) d).getCantidadProductosAPagar(), 0, true);
        }
        descuentos.remove(d);
    }

    public void modificarDescuento(String cineCuil, String nombre, String vigenciaDesde, String vigenciaHasta, int cantProdAComprar, int cantProdAPagar, int porcentaje) {
        Descuento d = getDescuento(cineCuil, nombre);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Descuento.modificarDescuento(d, LocalDate.parse(vigenciaDesde, dtf), LocalDate.parse(vigenciaHasta, dtf), cantProdAComprar, cantProdAPagar, porcentaje, false);
    }

    public void crearDescuento(String cineCuil, String nombre, String vigenciaDesde, String vigenciaHasta, String tipoDescuento) {

        if (tipoDescuento.contains("%")) {
            crearPorcentaje(cineCuil, nombre, vigenciaDesde, vigenciaHasta, Integer.parseInt(tipoDescuento.substring(0, tipoDescuento.length() - 1)));
        } else if (tipoDescuento.contains("x")) {
            int cantProdReq;
            int cantACobrar;
            String[] values = tipoDescuento.split("x");
            cantProdReq = Integer.parseInt(values[0]);
            cantACobrar = Integer.parseInt(values[1]);
            crearDosPorUno(cineCuil, nombre, vigenciaDesde, vigenciaHasta, cantProdReq, cantACobrar);
        }


    }

    private void crearDosPorUno(String cineCuil, String nombre, String vigenciaDesde, String vigenciaHasta, int cantidadRequeridosDeProductos, int cantidadACobrar) {
        Cine cine = CineController.getInstance().getCine(cineCuil);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DosPorUno dosPorUno = DosPorUno.crearDosPorUno(cine, nombre, LocalDate.parse(vigenciaDesde, dtf), LocalDate.parse(vigenciaHasta, dtf), cantidadRequeridosDeProductos, cantidadACobrar);
        descuentos.add(dosPorUno);
    }

    private void crearPorcentaje(String cineCuil, String nombre, String vigenciaDesde, String vigenciaHasta, int porcentaje) {
        Cine cine = CineController.getInstance().getCine(cineCuil);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        PorcentajeSobreVenta porcentajeSobreVenta = PorcentajeSobreVenta.crearPorcentajeSobreVenta(cine, nombre, LocalDate.parse(vigenciaDesde, dtf), LocalDate.parse(vigenciaHasta, dtf), porcentaje);
        descuentos.add(porcentajeSobreVenta);
    }
}

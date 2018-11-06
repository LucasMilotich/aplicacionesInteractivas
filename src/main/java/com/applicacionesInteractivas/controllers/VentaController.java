package com.applicacionesInteractivas.controllers;

import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.bd.VentaDAO;
import com.applicacionesInteractivas.excepciones.AsientoFuncionNoDefinido;
import com.applicacionesInteractivas.modelo.AsientoFuncion;
import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.modelo.Terminal;
import com.applicacionesInteractivas.modelo.Venta;
import com.applicacionesInteractivas.modelo.descuento.Descuento;
import com.applicacionesInteractivas.modelo.descuento.DescuentoComposite;
import com.applicacionesInteractivas.modelo.medioDePago.MedioDePago;
import com.applicacionesInteractivas.vista.formularios.ventas.VentaBoleteria;

public class VentaController {

    private static VentaController instance;
    private VentaBoleteria ventaBoleteria;
    public static double precioUnitario = 10D;

    public static VentaController getInstance() {
        if (instance == null) {
            instance = new VentaController();
        }
        return instance;
    }


    public VentaBoleteria getVentaBoleteria() {
        return ventaBoleteria;
    }

    public List<Venta> getVentas() {
        if (ventas.size() == 0) {
            return ventas = VentaDAO.getInstance().findAll();
        } else {
            return ventas;
        }
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    private List<Venta> ventas = new ArrayList<>();

    public void setVentaBoleteria(VentaBoleteria ventaBoleteria) {
        this.ventaBoleteria = ventaBoleteria;
    }

    public Venta venderBoleteria(String cineCuit, int idFuncion, double total, MedioDePago medioDePago, List<AsientoFuncion> asientos) {

        Cine cine = CineController.getInstance().getCine(cineCuit);

        try {
            return Venta.venderEntrada(cine, asientos, total, medioDePago);
        } catch (AsientoFuncionNoDefinido asientoFuncionNoDefinido) {
            asientoFuncionNoDefinido.printStackTrace();
        }


        return null;
    }

    public double calcularPrecioFinal(int cantidad, List<Descuento> descuentos) {
        double result = 0d;
        Descuento descuentoComposite = this.buildCompositeDescuento(descuentos);

        Venta ventaTemporal = new Venta();

        ventaTemporal.setTotal(precioUnitario * cantidad);
        result = precioUnitario * cantidad - descuentoComposite.aplicar(cantidad, ventaTemporal);

        return ventaTemporal.getTotal();
    }


    public Descuento buildCompositeDescuento(List<Descuento> descuentos) {
        DescuentoComposite d = new DescuentoComposite();
        for (Descuento desc : descuentos) {
            d.getDescuentos().add(desc);
        }

        return d;
    }

    public Venta retirarVentaPorTerminal(int idVenta) {
        Venta venta = null;
        venta = Terminal.getVentas().stream().filter(venta1 -> venta1.getId() == idVenta).findFirst().get();
        return venta;
    }

}

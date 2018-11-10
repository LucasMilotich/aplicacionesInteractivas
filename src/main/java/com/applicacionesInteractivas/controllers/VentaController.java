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
    private List<Venta> ventas = new ArrayList<>();
    public static double precioUnitario = 10D;
    
    public static VentaController getInstance() {
        if (instance == null) {
            instance = new VentaController();
        }
        return instance;
    }

    public void setVentaBoleteria(VentaBoleteria ventaBoleteria) {
        this.ventaBoleteria = ventaBoleteria;
    }

    public VentaBoleteria getVentaBoleteria() {
        return ventaBoleteria;
    }

    /**
	 * getVentas
	 * 
	 * Retorna la lista de ventas que posee el Controller.
	 * De ser la cantidad igual a 0, se van a buscar a la BD.
	 * 
	 * @param -
	 * @return List<Venta>
	 */
    public List<Venta> getVentas() {
        if (ventas.size() == 0) {
            return ventas = VentaDAO.getInstance().findAll();
        } else {
            return ventas;
        }
    }

    /**
	 * setVentas
	 * 
	 * Setea en el atributo ventas, una lista de ventas pasada por parametro
	 * 
	 * @param ventas
	 * @return -
	 */
    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
	 * venderBoleteria
	 * 
	 * Realiza una venta por Boleteria, recibiendo el cuit del cine, el id de la funcion,
	 * el total a pagar, el medio de pago y la lista de asientos.
	 * 
	 * @param cineCuit, idFuncion, total, medioDePago, asientos
	 * @return Venta
	 */
    public Venta venderBoleteria(String cineCuit, int idFuncion, double total, MedioDePago medioDePago, List<AsientoFuncion> asientos) {

        Cine cine = CineController.getInstance().getCine(cineCuit);

        try {
            return Venta.venderEntrada(cine, asientos, total, medioDePago);
        } catch (AsientoFuncionNoDefinido asientoFuncionNoDefinido) {
            asientoFuncionNoDefinido.printStackTrace();
        }

        return null;
    }

    /**
	 * calcularPrecioFinal
	 * 
	 * Antes de realizar la venta, se le calcula el precio final a pagar,
	 * en caso de que haya descuentos vigentes.
	 * 
	 * @param cantidad, descuentos
	 * @return double
	 */
    public double calcularPrecioFinal(int cantidad, List<Descuento> descuentos) {
        double result = 0d;
        Descuento descuentoComposite = this.buildCompositeDescuento(descuentos);

        Venta ventaTemporal = new Venta();

        ventaTemporal.setTotal(precioUnitario * cantidad);
        result = precioUnitario * cantidad - descuentoComposite.aplicar(cantidad, ventaTemporal);

        return ventaTemporal.getTotal();
    }


    /**
	 * buildCompositeDescuento
	 * 
	 * Retorna un objeto del tipo Descuento, especificamente del tipo DescuentoComposite,
	 * con una lista de los descuentos a aplicar.
	 * 
	 * @param descuentos
	 * @return Descuento
	 */
    public Descuento buildCompositeDescuento(List<Descuento> descuentos) {
        DescuentoComposite d = new DescuentoComposite();
        for (Descuento desc : descuentos) {
            d.getDescuentos().add(desc);
        }

        return d;
    }

    /**
	 * retirarVentaPorTerminal
	 * 
	 * Busca la venta que coincide con el idVenta pasado por parametro y la retorna.
	 * 
	 * @param idVenta
	 * @return Venta
	 */
    public Venta retirarVentaPorTerminal(int idVenta) {
        Venta venta = null;
        venta = Terminal.getVentas().stream().filter(venta1 -> venta1.getId() == idVenta).findFirst().get();
        return venta;
    }

}

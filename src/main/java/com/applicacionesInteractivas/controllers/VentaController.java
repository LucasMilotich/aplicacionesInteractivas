package com.applicacionesInteractivas.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.bd.VentaDAO;
import com.applicacionesInteractivas.modelo.AsientoFuncion;
import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.modelo.Venta;
import com.applicacionesInteractivas.modelo.descuento.Descuento;
import com.applicacionesInteractivas.modelo.descuento.DescuentoComposite;
import com.applicacionesInteractivas.modelo.metodopago.IMetodoPago;
import com.applicacionesInteractivas.vista.formularios.ventas.VentaBoleteria;

public class VentaController {

    private static VentaController instance;
    private VentaBoleteria ventaBoleteria;
    private double precioUnitario = 10D;

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

    public void venderBoleteria(String cineCuit, int idFuncion, String formaPago, IMetodoPago metodoPago, List<AsientoFuncion> asientos) {

        List<Descuento> descuentos = DescuentoController.getInstance().getDescuentos();
        Descuento descuentoAAplicar = buildCompositeDescuento(descuentos);

        Cine cine = CineController.getInstance().getCine(cineCuit);
        //Pelicula pelicula = CineController.getInstance().getPelicula(nombrePelicula);
        //Sala sala = CineController.getInstance().getSala(cineCuil, salaNombre);
        //Funcion funcion = CineController.getInstance().getFuncion(pelicula, sala, Timestamp.valueOf(horario));

//        try {
//            Venta.venderEntrada(cine, pelicula, sala, funcion, asientos, formaPago, descuentoAAplicar);
//        } catch (AsientoFuncionNoDefinido asientoFuncionNoDefinido) {
//            asientoFuncionNoDefinido.printStackTrace();
//        }


    }
    
    public double calcularPrecioFinal(int cantidad, DescuentoComposite descuentos) {
    	double result = 0d;
    	
    	
    	return result;
    }


    private Descuento buildCompositeDescuento(List<Descuento> descuentos) {
        DescuentoComposite d = new DescuentoComposite();
        for (Descuento desc : descuentos) {
            d.getDescuentos().add(desc);
        }

        return d;
    }

    public Venta retirarVentaPorTerminal(int idVenta) {
        Venta venta = null;
        try {
            venta = VentaDAO.getInstance().findBy(idVenta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venta;
    }

}

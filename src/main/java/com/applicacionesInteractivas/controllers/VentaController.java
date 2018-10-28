package com.applicacionesInteractivas.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.bd.CineDAO;
import com.applicacionesInteractivas.bd.VentaDAO;
import com.applicacionesInteractivas.excepciones.AsientoFuncionNoDefinido;
import com.applicacionesInteractivas.modelo.AsientoFuncion;
import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.modelo.Funcion;
import com.applicacionesInteractivas.modelo.Pelicula;
import com.applicacionesInteractivas.modelo.Sala;
import com.applicacionesInteractivas.modelo.Venta;
import com.applicacionesInteractivas.modelo.descuento.Descuento;
import com.applicacionesInteractivas.modelo.descuento.DescuentoComposite;
import com.applicacionesInteractivas.vista.formularios.ventas.VentaBoleteria;

public class VentaController {

    private static VentaController instance;
    private VentaBoleteria ventaBoleteria;

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

    public void venderBoleteria(String cineCuil, String nombrePelicula, String salaNombre, String horario, String formaPago, List<String> descuentoNombre, List<AsientoFuncion> asientos) {
        // precio harcodeado

        List<Descuento> descuentos = DescuentoController.getInstance().getDescuentos();
        Descuento descuentoAAplicar = buildCompositeDescuento(descuentos);

        Cine cine = CineController.getInstance().getCine(cineCuil);
        Pelicula pelicula = CineController.getInstance().getPelicula(nombrePelicula);
        Sala sala = CineController.getInstance().getSala(cineCuil, salaNombre);
        //Funcion funcion = CineController.getInstance().getFuncion(pelicula, sala, Timestamp.valueOf(horario));

//        try {
//            Venta.venderEntrada(cine, pelicula, sala, funcion, asientos, formaPago, descuentoAAplicar);
//        } catch (AsientoFuncionNoDefinido asientoFuncionNoDefinido) {
//            asientoFuncionNoDefinido.printStackTrace();
//        }


    }



    private Descuento buildCompositeDescuento(List<Descuento> descuentos) {
        DescuentoComposite d = new DescuentoComposite();
        for (Descuento desc : descuentos) {
            d.getDescuentos().add(desc);
        }

        return d;
    }

    public Venta retirarVentaPorTerminal(int idVenta){

        return VentaDAO.getInstance().findBy(idVenta);
    }

}

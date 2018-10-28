package com.applicacionesInteractivas.modelo;

import com.applicacionesInteractivas.bd.EntradaDAO;
import com.applicacionesInteractivas.bd.VentaDAO;
import com.applicacionesInteractivas.excepciones.AsientoFuncionNoDefinido;
import com.applicacionesInteractivas.modelo.backend.IObserver;
import com.applicacionesInteractivas.modelo.backend.NovedadesObserver;
import com.applicacionesInteractivas.modelo.descuento.Descuento;
import com.applicacionesInteractivas.modelo.descuento.DescuentoComposite;
import com.applicacionesInteractivas.modelo.medioDePago.MedioDePago;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Venta {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private int cantidad;
    private double precioUnitario = 10;
    private double total;
    private List<Entrada> entradas;
    private String medioDePago;
    private Cine cine;

    private List<IObserver> observers = new ArrayList<>();

    public Venta(){
        observers.add(new NovedadesObserver());
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }




    private static Venta operar(Cine cine, Pelicula pelicula, Sala sala, Funcion funcion, Collection<AsientoFuncion> asientos, String medioDePago, Descuento descuento) throws AsientoFuncionNoDefinido {

        Venta venta = new Venta();

        venta.cantidad = asientos.size();
        venta.total = venta.cantidad * venta.precioUnitario;
        venta.medioDePago = medioDePago;
        venta.cine = cine;


        if (asientos == null || asientos.size() < 1) {
            throw new AsientoFuncionNoDefinido("Asiento funcion no definido");
        }

        VentaDAO.getInstance().insert(venta);

        Entrada entrada;

        for (AsientoFuncion asiento : asientos) {
            entrada = new Entrada(asiento, funcion);
            venta.entradas.add(entrada);
            EntradaDAO.getInstance().insert(entrada);
        }


        return venta;
    }


    public static Venta comprarEntrada(Funcion funcion, Collection<AsientoFuncion> asientos) throws AsientoFuncionNoDefinido {
        //return this.operar(funcion, asientos);
        return null;
    }

    public static Venta venderEntrada(Cine cine, Pelicula pelicula, Sala sala, Funcion funcion, Collection<AsientoFuncion> asientos, String medioDePago, Descuento descuento) throws AsientoFuncionNoDefinido {
        Venta venta =  operar(cine, pelicula, sala, funcion, asientos, medioDePago, descuento);
        venta.notificarObservers(venta);
        return venta ;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    private void notificarObservers(Venta venta){
        for (IObserver io : observers){
            io.notificarVenta(this);
        }
    }
}

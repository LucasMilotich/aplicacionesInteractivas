package com.applicacionesInteractivas.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.applicacionesInteractivas.bd.EntradaDAO;
import com.applicacionesInteractivas.bd.TarjetaDAO;
import com.applicacionesInteractivas.bd.VentaDAO;
import com.applicacionesInteractivas.excepciones.AsientoFuncionNoDefinido;
import com.applicacionesInteractivas.modelo.backend.IObserver;
import com.applicacionesInteractivas.modelo.backend.NovedadesObserver;
import com.applicacionesInteractivas.modelo.medioDePago.MedioDePago;
import com.applicacionesInteractivas.modelo.medioDePago.Tarjeta;

public class Venta {

    private int id;
    private int cantidad;
    private double precioUnitario = 10;
    private double total;

    private List<Entrada> entradas;
    private MedioDePago medioDePago;
    private Cine cine;
    private List<IObserver> observers = new ArrayList<>();
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venta(){
        observers.add(new NovedadesObserver());
        entradas = new ArrayList<Entrada>();
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

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    private static Venta operar(Cine cine, Collection<AsientoFuncion> asientos, double total, MedioDePago medioDePago) throws AsientoFuncionNoDefinido {

        Venta venta = new Venta();

        venta.cantidad = asientos.size();
        venta.total = total;
        venta.medioDePago = medioDePago;
        venta.cine = cine;


        if (asientos == null || asientos.size() < 1) {
            throw new AsientoFuncionNoDefinido("Asiento funcion no definido");
        }

        VentaDAO.getInstance().insert(venta);

        Entrada entrada;

        for (AsientoFuncion asiento : asientos) {
        	asiento.setOcupado(true);
            entrada = new Entrada(asiento, venta);
            venta.entradas.add(entrada);
            EntradaDAO.getInstance().insert(entrada);
        }
        
        if(medioDePago.toString() == "TARJETA CREDITO" || medioDePago.toString() == "TARJETA DEBITO") {
        	Tarjeta t = (Tarjeta) medioDePago;
        	t.setVenta(venta);
        	TarjetaDAO.getInstance().insert(t);
        }


        return venta;
    }


    public static Venta comprarEntrada(Funcion funcion, Collection<AsientoFuncion> asientos) throws AsientoFuncionNoDefinido {
        //return this.operar(funcion, asientos);
        return null;
    }

    public static Venta venderEntrada(Cine cine, Collection<AsientoFuncion> asientos, double total, MedioDePago medioDePago) throws AsientoFuncionNoDefinido {
        Venta venta =  operar(cine, asientos, total, medioDePago);
        venta.notificarObservers(venta);
        return venta;
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

    public void retirar(){
        VentaDAO.getInstance().retirar(this.id);
    }
}

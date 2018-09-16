package uade.api.modelo;

import uade.api.excepciones.AsientoFuncionNoDefinido;
import uade.api.modelo.medioDePago.MedioDePago;

import java.util.Collection;
import java.util.List;

public class Venta {

    private int cantidad;
    private double precioUnitario = 10;
    private double total;
    private List<Entrada> entradas;
    private MedioDePago medioDePago;

    private Venta operar(Funcion funcion, Collection<AsientoFuncion> asientos, MedioDePago medioDePago) throws AsientoFuncionNoDefinido {

        if(asientos == null || asientos.size() < 1){
            throw new AsientoFuncionNoDefinido("Asiento funcion no definido");
        }

        this.cantidad = asientos.size();
        this.total = asientos.size() * this.precioUnitario;
        this.medioDePago = medioDePago;

        Entrada entrada;

        for (AsientoFuncion asiento : asientos){
            entrada = new Entrada(asiento,funcion);
            entradas.add(entrada);
        }
        return this;
    }


    public Venta comprarEntrada(Funcion funcion, Collection<AsientoFuncion> asientos, MedioDePago medioDePago) throws AsientoFuncionNoDefinido {
        return this.operar(funcion, asientos, medioDePago);
    }
    public Venta venderEntrada(Funcion funcion, Collection<AsientoFuncion> asientos, MedioDePago medioDePago) throws AsientoFuncionNoDefinido {
        return this.operar(funcion, asientos, medioDePago);
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
}

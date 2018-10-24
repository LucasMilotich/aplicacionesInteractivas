package com.applicacionesInteractivas.controllers;

import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.modelo.Venta;
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

    private List<Venta> ventas = new ArrayList<>();

	public void setVentaBoleteria(VentaBoleteria ventaBoleteria) {
		this.ventaBoleteria = ventaBoleteria;
	}
	
    public void venderBoleteria(String cineCuil, String nombrePelicula, String sala, String horario, int cantidad, String formaPago, List<String> descuentoNombre){

    }

}

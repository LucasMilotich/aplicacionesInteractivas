package com.applicacionesInteractivas.controllers;

import com.applicacionesInteractivas.modelo.Venta;

import java.util.ArrayList;
import java.util.List;

public class VentaController {

    private static VentaController instance;

    public static VentaController getInstance() {
        if (instance == null) {
            instance = new VentaController();
        }
        return instance;
    }

    private List<Venta> ventas = new ArrayList<>();

    public void venderBoleteria(){

    }
}

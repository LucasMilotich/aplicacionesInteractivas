package com.applicacionesInteractivas.modelo;

import java.util.ArrayList;
import java.util.List;

public class Terminal {

    private static Terminal instance;

    public static Terminal getInstance() {
        if (instance == null) {
            instance = new Terminal();
        }
        return instance;
    }
    public static List<Venta> getVentas() {
        return ventas;
    }

    public static void setVentas(List<Venta> ventas) {
        Terminal.ventas = ventas;
    }

    static List<Venta> ventas = new ArrayList<>();

}

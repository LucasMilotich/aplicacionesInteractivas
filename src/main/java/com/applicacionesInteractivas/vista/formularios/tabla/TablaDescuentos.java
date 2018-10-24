package com.applicacionesInteractivas.vista.formularios.tabla;

import com.applicacionesInteractivas.modelo.Funcion;
import com.applicacionesInteractivas.modelo.descuento.Descuento;
import com.applicacionesInteractivas.modelo.descuento.DosPorUno;
import com.applicacionesInteractivas.modelo.descuento.PorcentajeSobreVenta;
import sun.security.krb5.internal.crypto.Des;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaDescuentos extends AbstractTableModel {

    private static final long serialVersionUID = -2458393323291422128L;
    private List<Descuento> descuentos;
    private String[] columnNames = {"Cine", "Nombre", "Vigencia desde", "Vigencia hasta", "Cantidad productos requeridos", "Cantidad productos a pagar", "Porcentaje venta"};

    public TablaDescuentos() {
        descuentos = new ArrayList<Descuento>();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public int getRowCount() {
        return this.descuentos.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Descuento func = descuentos.get(row);
        switch (col) {
            case 0:
                return func.getCine().getCuit();
            case 1:
                return func.getNombre();
            case 2:
                return func.getVigenciaDesde();
            case 3:
                return func.getVigenciaHasta();
            case 4:
                if (func.isDosPorUno()){
                    return ((DosPorUno) func).getCantidadProductosRequeridos();
                }
                return 0;
            case 5:
                if (func.isDosPorUno()){
                    return ((DosPorUno) func).getCantidadProductosAPagar();
                }
                return 0;
            case 6:
                if (func.isPorcentaje()){
                    return ((PorcentajeSobreVenta) func).getPorcentajeSobreVenta();
                }
                return 0;

            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setDescuentos(List<Descuento> descuentos) {
        this.descuentos = descuentos;
    }

    public List<Descuento> getDescuentos() {
        return descuentos;
    }
}

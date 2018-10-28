package com.applicacionesInteractivas.vista.formularios.tabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.applicacionesInteractivas.modelo.Funcion;

public class TablaFunciones extends AbstractTableModel {

    private static final long serialVersionUID = -2458393323291422128L;
    private List<Funcion> funciones;
    private String[] columnNames = {"Id", "Cine", "Sala", "Pelicula", "Fecha", "Hora"};

    public TablaFunciones() {
        funciones = new ArrayList<Funcion>();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return this.funciones.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Funcion func = funciones.get(row);
        switch (col) {
            case 0:
            	return func.getId();
            case 1:
                return func.getSala().getCine().getCuit();
            case 2:
                return func.getSala().getNombre();
            case 3:
                return func.getPelicula().getNombre();
            case 4:
                return func.getFecha();
            case 5:
            	return func.getHora();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setFunciones(List<Funcion> funciones) {
        this.funciones = funciones;
    }

    public List<Funcion> getFunciones() {
        return funciones;
    }
}

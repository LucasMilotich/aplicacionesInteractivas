package com.applicacionesInteractivas.vista.formularios.tabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.applicacionesInteractivas.modelo.Funcion;

public class TablaFunciones extends AbstractTableModel {

	private static final long serialVersionUID = -2458393323291422128L;
	private List<Funcion> funciones;
	private String[] columnNames = {"Horario"};
	
	public TablaFunciones() {
		funciones = new ArrayList<Funcion>();
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return this.funciones.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Funcion func = funciones.get(row);
	    switch(col) {
	      case 0: return func.getHorario();
	      default: return "";
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

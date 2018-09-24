package com.applicacionesInteractivas.vista.formularios.tabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.modelo.Sala;

public class TablaSalas extends AbstractTableModel{

	private static final long serialVersionUID = -1960243629148803488L;
	private List<Sala> salas;
	private String[] columnNames = {"Nombre", "Capacidad"};
	
	

	public TablaSalas() {
		super();
		salas = new ArrayList<Sala>();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return this.salas.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Sala sala = salas.get(row);
	    switch(col) {
	      case 0: return sala.getNombre();
	      case 1: return sala.getCapacidad();
	      default: return "";
	    }
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public List<Sala> getSalas() {
		return salas;
	}
}

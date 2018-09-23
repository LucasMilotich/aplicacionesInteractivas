package com.applicacionesInteractivas.vista.formularios.tabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.applicacionesInteractivas.modelo.Cine;

public class TablaCines extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8751294376447351895L;
	private List<Cine> cines;
	private String[] columnNames = {"CUIT",
            "Nombre",
            "Domicilio",
            "Cant. Salas",
            "Cap. Total"};
	
	public TablaCines() {
		cines = new ArrayList<Cine>();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return cines.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Cine cine = cines.get(row);
	    switch(col) {
	      case 0: return cine.getCuit();
	      case 1: return cine.getNombre();
	      case 2: return cine.getDomicilio();
	      case 3: return cine.getCantidadSalas();
	      case 4: return cine.getCapacidadTotal();
	      default: return "";
	    }
	}
	
	@Override
	public String getColumnName(int column) {
		
		return columnNames[column];
	}

	public void setCines(List<Cine> cines) {
		this.cines = cines;
	}

	public List<Cine> getCines() {
		return cines;
	}

}

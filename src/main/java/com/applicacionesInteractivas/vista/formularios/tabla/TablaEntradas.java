package com.applicacionesInteractivas.vista.formularios.tabla;

import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.modelo.Entrada;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaEntradas extends AbstractTableModel{

	/**
	 *
	 */
	private static final long serialVersionUID = -8751294376447351895L;
	private List<Entrada> entradas;
	private String[] columnNames = {"Asiento",
            "Código aunteticación",
            "Horario Función",
            "Sala",
            "Cine"};

	public TablaEntradas() {
		entradas = new ArrayList<Entrada>();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return entradas.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Entrada cine = entradas.get(row);
	    switch(col) {
	      case 0: return Integer.toString(cine.getAsiento().getAsiento().getPosx()) + " " + Integer.toString(cine.getAsiento().getAsiento().getPosY());
	      case 1: return cine.getCodAutenticacion();
	      case 2: return cine.getFuncion().getFecha().toString() + " " + cine.getFuncion().getHora().toString();
	      case 3: return cine.getFuncion().getSala().getNombre();
	      case 4: return cine.getFuncion().getSala().getCine().getNombre();
	      default: return "";
	    }
	}
	
	@Override
	public String getColumnName(int column) {
		
		return columnNames[column];
	}

	public void setCines(List<Entrada> cines) {
		this.entradas = cines;
	}

	public List<Entrada> getCines() {
		return entradas;
	}

}

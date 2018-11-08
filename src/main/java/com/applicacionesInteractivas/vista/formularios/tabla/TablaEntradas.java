package com.applicacionesInteractivas.vista.formularios.tabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.applicacionesInteractivas.modelo.Entrada;

public class TablaEntradas extends AbstractTableModel{

	/**
	 *
	 */
	private static final long serialVersionUID = -8751294376447351895L;
	private List<Entrada> entradas;
	private String[] columnNames = {"Asiento",
            "Horario Funcion",
            "Sala",
            "Cine"};

	public 	TablaEntradas() {
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
		Entrada entrada = entradas.get(row);
	    switch(col) {
	      case 0: return "Fila: "+ Integer.toString(entrada.getAsientoFuncion().getAsiento().getPosx()+1) + " Asiento: " + Integer.toString(entrada.getAsientoFuncion().getAsiento().getPosY()+1);
	      case 2: return entrada.getAsientoFuncion().getFuncion().getFecha().toString() + " " + entrada.getAsientoFuncion().getFuncion().getHora().toString();
	      case 3: return entrada.getAsientoFuncion().getFuncion().getSala().getNombre();
	      case 4: return entrada.getAsientoFuncion().getFuncion().getSala().getCine().getNombre();
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

package com.applicacionesInteractivas.vista.formularios.tabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.applicacionesInteractivas.modelo.Pelicula;

public class TablaPeliculas extends AbstractTableModel{

	private static final long serialVersionUID = -2458393323291422128L;
	private List<Pelicula> peliculas;
	private String[] columnNames = {"Nombre",
            "Director",
            "Genero",
            "Duracion",
            "Idioma",
            "Subtitulos",
            "Calificacion",
            "Observacion"};
	
	public TablaPeliculas() {
		peliculas = new ArrayList<Pelicula>();
	}
	
	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		return this.peliculas.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Pelicula peli = peliculas.get(row);
	    switch(col) {
	      case 0: return peli.getNombre();
	      case 1: return peli.getDirector();
	      case 2: return peli.getGenero();
	      case 3: return peli.getDuracion();
	      case 4: return peli.getIdioma();
	      case 5: return peli.getSubtitulos();
	      case 6: return peli.getCalificacion();
	      case 7: return peli.getObservacion();
	      default: return "";
	    }
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

}

package com.applicacionesInteractivas.vista.formularios.usuarios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.applicacionesInteractivas.modelo.Usuario;

public class ABMTableModel extends AbstractTableModel {
    /**
     *
     */
    private static final long serialVersionUID = -8751294376447351895L;
    private List<Usuario> usuarios;
    private String[] columnNames = {"DNI",
        "Nombre",
        "Domicilio",
        "Nombre usuario",
        "Email",
        "Fecha de nacimiento"};

    public ABMTableModel() {
        usuarios = new ArrayList<Usuario>();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Usuario usuario = usuarios.get(row);
        switch (col) {
            case Columns.DNI:
                return usuario.getDni();
            case Columns.NOMBRE:
                return usuario.getNombre();
            case Columns.DOMICILIO:
                return usuario.getDomicilio();
            case Columns.NOMBREUSUARIO:
                return usuario.getNombreUsuario();
            case Columns.EMAIL:
                return usuario.getEmail();
            case Columns.FECHANACIMIENTO:
                return usuario.getFechaNacimiento();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {

        return columnNames[column];
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

}

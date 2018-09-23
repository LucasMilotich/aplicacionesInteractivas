package com.applicacionesInteractivas.vista.formularios.usuarios;

import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.modelo.Usuario;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ABMTableModel extends AbstractTableModel
    {
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
            switch(col) {
                case 0: return usuario.getDni();
                case 1: return usuario.getNombre();
                case 2: return usuario.getDomicilio();
                case 3: return usuario.getNombreUsuario();
                case 4: return usuario.getEmail();
                case 5: return usuario.getFechaNacimiento();
                default: return "";
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

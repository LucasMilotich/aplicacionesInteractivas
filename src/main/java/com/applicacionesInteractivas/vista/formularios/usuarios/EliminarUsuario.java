package com.applicacionesInteractivas.vista.formularios.usuarios;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.applicacionesInteractivas.controllers.UsuarioController;

public class EliminarUsuario extends JFrame {
    private JButton btnEliminar;
    private JTable tablaPeliculas;
    private ABMTableModel tablaPeliculasModel;
    private JScrollPane miBarra;
    private JPanel mainPanel;
    private JPanel tableContainer;
    private JPanel btnContainer;

    public EliminarUsuario() {
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Eliminar usuario");
        mainPanel = new JPanel();


        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(e -> {
            UsuarioController usuario = UsuarioController.getInstance();
            usuario.eliminarUsuario((String) tablaPeliculas.getValueAt(tablaPeliculas.getSelectedRow(), Columns.NOMBREUSUARIO));
            JOptionPane.showMessageDialog(null, "Usuario eliminado!");
            this.setVisible(false);
        });
        btnEliminar.setEnabled(false);
        this.add(btnEliminar);

        tablaPeliculas = new JTable();
        tablaPeliculas.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tablaPeliculas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
                    try {
                        btnEliminar.setEnabled(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        miBarra = new JScrollPane();
        miBarra.setBounds(40, 300, 400, 130);

        tablaPeliculasModel = new ABMTableModel();
        tablaPeliculasModel.setUsuarios(UsuarioController.getInstance().getUsuarios());

        tablaPeliculas.setModel(tablaPeliculasModel);
        tablaPeliculas.setDragEnabled(false);
        miBarra.setViewportView(tablaPeliculas);

        btnContainer = new JPanel();
        btnContainer.add(btnEliminar);

        tableContainer = new JPanel();
        tableContainer.add(miBarra);

        mainPanel.add(btnContainer);
        mainPanel.add(tableContainer);

        getContentPane().add(mainPanel);
    }
}

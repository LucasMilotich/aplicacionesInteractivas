package com.applicacionesInteractivas.vista.formularios.descuentos;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.controllers.DescuentoController;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaCines;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaDescuentos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormElimDescuento extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -4718031332588416051L;
    private JPanel mainPanel;
    private JButton btnEliminar;
    private JTable tabDescuentos;
    private JScrollPane mibarra;
    private TablaDescuentos tablaDescuentos;

    public FormElimDescuento() {

        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Eliminar descuento");
        mainPanel = new JPanel();

        btnEliminar = new JButton("Eliminar descuento");
        btnEliminar.addActionListener(e -> {
            DescuentoController cine = DescuentoController.getInstance();
            cine.eliminarDescuento((String) tabDescuentos.getValueAt(tabDescuentos.getSelectedRow(), 0), (String) tabDescuentos.getValueAt(tabDescuentos.getSelectedRow(), 1));
            JOptionPane.showMessageDialog(null, "Cine eliminado!");
            this.setVisible(false);
        });
        btnEliminar.setEnabled(false);

        JPanel btnContainer = new JPanel();
        btnContainer.add(btnEliminar);

        tabDescuentos = new JTable();
        tabDescuentos.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tabDescuentos.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
                    try {
                        btnEliminar.setEnabled(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        mibarra = new JScrollPane();
        mibarra.setBounds(40, 300, 400, 130);

        tablaDescuentos = new TablaDescuentos();
        tablaDescuentos.setDescuentos(DescuentoController.getInstance().getDescuentos());

        tabDescuentos.setModel(tablaDescuentos);
        mibarra.setViewportView(tabDescuentos);

        JPanel tablaCinesContainer = new JPanel();
        tablaCinesContainer.add(mibarra);

        mainPanel.add(tablaCinesContainer);
        mainPanel.add(btnContainer);

        getContentPane().add(mainPanel);
    }
}

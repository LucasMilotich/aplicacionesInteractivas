package com.applicacionesInteractivas.vista.formularios.salas;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaSalas;

public class FormModifSala extends JFrame {

    private static final long serialVersionUID = -8185511184999906353L;
    private JLabel lblNombre;
    private JLabel lblColumnas;
    private JLabel lblFilas;
    private JLabel lblCine;
    private JTextField txtNombre;
    private JTextField txtFilas;
    private JTextField txtColumnas;
    private JTextField txtCine;
    private JButton btnModificar;
    private JTable tablaSalas;
    private TablaSalas tablaSalasModel;
    private JScrollPane mibarra;
    private int idSala;
    private JPanel mainPanel;
    private JPanel nombreContainer, columContainer,cineContainer, filaContainer, btnContainer, tableContainer;


    public FormModifSala() {

        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Modificar Sala");
        mainPanel = new JPanel();

        lblNombre = new JLabel("Nombre");

        txtNombre = new JTextField();
        txtNombre.setColumns(12);
        txtNombre.setEditable(false);

        lblFilas = new JLabel("Filas");
        txtFilas = new JTextField();
        txtFilas.setColumns(12);
        txtFilas.setEditable(false);

        lblColumnas = new JLabel("Columnas");
        txtColumnas = new JTextField();
        txtColumnas.setColumns(12);
        txtColumnas.setEditable(false);

        lblCine = new JLabel("Cine cuit");
        txtCine = new JTextField();
        txtCine.setColumns(12);
        txtCine.setEditable(false);

        btnModificar = new JButton("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(e -> {
            CineController cine = CineController.getInstance();
            cine.modificarSala( idSala,
            		txtNombre.getText(),
                    Integer.parseInt(txtFilas.getText()),
                    Integer.parseInt(txtColumnas.getText()));
            JOptionPane.showMessageDialog(null, "Sala modificada!");
            this.setVisible(false);
        });

        tablaSalas = new JTable();
        tablaSalas.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tablaSalas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    try {
                        txtCine.setText((String) table.getValueAt(row, 4));
                        txtNombre.setText((String) table.getValueAt(row, 1));
                        txtNombre.setEditable(true);
                        txtFilas.setText(Integer.toString((int) table.getValueAt(row, 2)));
                        txtFilas.setEditable(true);
                        txtColumnas.setText(Integer.toString((int) table.getValueAt(row, 3)));
                        txtColumnas.setEditable(true);
                        idSala = (int) table.getValueAt(row, 0);

                        btnModificar.setEnabled(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        mibarra = new JScrollPane();
        mibarra.setBounds(40, 300, 400, 130);

        tablaSalasModel = new TablaSalas();
        tablaSalasModel.setSalas(CineController.getInstance().getSalas());

        tablaSalas.setModel(tablaSalasModel);
        mibarra.setViewportView(tablaSalas);

        nombreContainer = new JPanel();
        nombreContainer.add(lblNombre);
        nombreContainer.add(txtNombre);

        cineContainer = new JPanel();
        cineContainer.add(lblCine);
        cineContainer.add(txtCine);

        filaContainer = new JPanel();
        filaContainer.add(lblFilas);
        filaContainer.add(txtFilas);

        columContainer = new JPanel();
        columContainer.add(lblColumnas);
        columContainer.add(txtColumnas);

        btnContainer = new JPanel();
        btnContainer.add(btnModificar);

        tableContainer = new JPanel();
        tableContainer.add(mibarra);

        mainPanel.add(cineContainer);
        mainPanel.add(filaContainer);
        mainPanel.add(columContainer);
        mainPanel.add(nombreContainer);
        mainPanel.add(btnContainer);
        mainPanel.add(tableContainer);

        getContentPane().add(mainPanel);
    }
}

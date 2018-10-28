package com.applicacionesInteractivas.vista.formularios.terminal;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.controllers.UsuarioController;
import com.applicacionesInteractivas.controllers.VentaController;
import com.applicacionesInteractivas.modelo.Venta;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaEntradas;
import com.applicacionesInteractivas.vista.formularios.usuarios.ABMTableModel;

import javax.swing.*;

public class TerminalForm extends JFrame {

    /**
     *
     */
    private JPanel mainPanel;

    private JLabel lblIdentificadorEntrada;
    private JTextField txtIdentificadorentrada;
    private JLabel lblCantEntradas;
    private JTextField txtCantEntradas;
    private JLabel lblTotal;
    private JTextField txtTotal;
    private JLabel lblMedioDePago;
    private JTextField txtMedioDePago;
    private JButton btnConfirm;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;

    private static final long serialVersionUID = -7869162737881219117L;

    public TerminalForm() {

        this.setSize(320, 360);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Terminal");

        lblIdentificadorEntrada = new JLabel();
        lblIdentificadorEntrada.setText("Id Venta");
        this.add(lblIdentificadorEntrada);

        txtIdentificadorentrada = new JTextField();
        txtIdentificadorentrada.setColumns(12);
        this.add(txtIdentificadorentrada);

        lblCantEntradas = new JLabel();
        lblCantEntradas.setText("Cantidad de entradas");
        this.add(lblCantEntradas);
        lblCantEntradas.setVisible(false);

        txtCantEntradas = new JTextField();
        txtCantEntradas.setColumns(12);
        this.add(txtCantEntradas);
        txtCantEntradas.setVisible(false);

        lblTotal = new JLabel();
        lblTotal.setText("Total pagado");
        this.add(lblTotal);
        lblTotal.setVisible(false);

        txtTotal = new JTextField();
        txtTotal.setColumns(12);
        this.add(txtTotal);
        txtTotal.setVisible(false);

        lblMedioDePago = new JLabel();
        lblMedioDePago.setText("Medio de pago ");
        this.add(lblTotal);
        lblMedioDePago.setVisible(false);

        txtMedioDePago = new JTextField();
        txtMedioDePago.setColumns(12);
        this.add(txtTotal);
        txtMedioDePago.setVisible(false);

        btnConfirm = new JButton("Confirmar");
        this.add(btnConfirm);

        panel1 = new JPanel();
        panel1.add(lblIdentificadorEntrada);
        panel1.add(txtIdentificadorentrada);

        panel2 = new JPanel();
        panel2.add(lblCantEntradas);
        panel2.add(txtCantEntradas);

        panel3 = new JPanel();
        panel3.add(lblTotal);
        panel3.add(txtTotal);

        panel4 = new JPanel();
        panel4.add(lblMedioDePago);
        panel4.add(txtMedioDePago);

        panel5 = new JPanel();
        panel5.add(btnConfirm);


        JTable entradas = new JTable();
        TablaEntradas tablaEntradas = new TablaEntradas();

        entradas.setModel(tablaEntradas);
        entradas.setAutoCreateColumnsFromModel(true);

        panel6 = new JPanel();
        panel6.add(entradas);

        this.add(entradas);
        btnConfirm.addActionListener(e -> {
            VentaController cine = VentaController.getInstance();
            Venta venta = cine.retirarVentaPorTerminal(Integer.parseInt(txtIdentificadorentrada.getText()));
            txtIdentificadorentrada.setText(Integer.toString(venta.getId()));
            txtCantEntradas.setText(Integer.toString(venta.getCantidad()));
            txtTotal.setText(Double.toString(venta.getTotal()));
            txtMedioDePago.setText(venta.getMedioDePago());
            tablaEntradas.setCines(venta.getEntradas());
            this.setVisible(false);
        });
        mainPanel = new JPanel();

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);
        mainPanel.add(panel5);
        mainPanel.add(panel6);


        getContentPane().add(mainPanel);
    }
}

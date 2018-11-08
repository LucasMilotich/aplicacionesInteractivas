package com.applicacionesInteractivas.vista.formularios.terminal;

import javax.swing.*;

import com.applicacionesInteractivas.controllers.VentaController;
import com.applicacionesInteractivas.modelo.Venta;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaEntradas;

import java.awt.*;

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

        this.setSize(520, 560);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Terminal");

        lblIdentificadorEntrada = new JLabel();
        lblIdentificadorEntrada.setText("Código autenticación");
        this.add(lblIdentificadorEntrada);

        txtIdentificadorentrada = new JTextField();
        txtIdentificadorentrada.setColumns(12);
        this.add(txtIdentificadorentrada);

        lblCantEntradas = new JLabel();
        lblCantEntradas.setText("Cantidad de entradas");
        this.add(lblCantEntradas);

        txtCantEntradas = new JTextField();
        txtCantEntradas.setColumns(12);
        this.add(txtCantEntradas);

        lblTotal = new JLabel();
        lblTotal.setText("Total pagado");
        this.add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setColumns(12);
        this.add(txtTotal);

        lblMedioDePago = new JLabel();
        lblMedioDePago.setText("Medio de pago ");
        this.add(lblTotal);

        txtMedioDePago = new JTextField();
        txtMedioDePago.setColumns(12);
        this.add(txtTotal);

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
        entradas.setPreferredScrollableViewportSize(new Dimension(500, 70));

        entradas.setAutoCreateColumnsFromModel(true);

        btnConfirm.addActionListener(e -> {
            VentaController cine = VentaController.getInstance();
            Venta venta = cine.retirarVentaPorTerminal(Integer.parseInt(txtIdentificadorentrada.getText()));
            txtIdentificadorentrada.setText(Integer.toString(venta.getId()));
            txtCantEntradas.setText(Integer.toString(venta.getCantidad()));
            txtTotal.setText(Double.toString(venta.getTotal()));
            txtMedioDePago.setText(venta.getMedioDePago().toString());


            TablaEntradas tablaEntradas = new TablaEntradas();

            tablaEntradas.setCines(venta.getEntradas());
            entradas.setModel(tablaEntradas);
            panel2.setVisible(true);
            panel3.setVisible(true);
            panel4.setVisible(true);
            panel6.setVisible(true);


        });

        JScrollPane mibarra = new JScrollPane();
        mibarra.setBounds(40, 300, 400, 130);


        mainPanel = new JPanel();

        mainPanel.add(panel1);
        mainPanel.add(panel5);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);

        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);


        panel6 = new JPanel();
        mibarra.setViewportView(entradas);
        panel6.add(mibarra);
        panel6.setVisible(false);

        mainPanel.add(panel6);


        getContentPane().add(mainPanel);
    }
}

package com.applicacionesInteractivas.vista.formularios.salas;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaSalas;
import com.applicacionesInteractivas.vista.formularios.utils.ValidadorCampo;

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

    public FormModifSala() {

        this.setSize(500, 460);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.setTitle("Modificar Sala");

        lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(20, 40, 120, 28);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(130, 40, 120, 28);
        this.txtNombre.addKeyListener(ValidadorCampo.lengthValidador(49, "NOMBRE"));
        txtNombre.setEditable(false);
        getContentPane().add(txtNombre);
        
        lblFilas = new JLabel("Filas");
        lblFilas.setBounds(20, 80, 120, 28);
        getContentPane().add(lblFilas);
        
        txtFilas = new JTextField();
        txtFilas.setBounds(130, 80, 120, 28);
        this.txtFilas.addKeyListener(ValidadorCampo.numberValidator(1, "FILAS"));
        txtFilas.setEditable(false);
        getContentPane().add(txtFilas);

        lblColumnas = new JLabel("Columnas");
        lblColumnas.setBounds(20, 120, 120, 28);
        getContentPane().add(lblColumnas);
        
        txtColumnas = new JTextField();
        txtColumnas.setBounds(130, 120, 120, 28);
        this.txtColumnas.addKeyListener(ValidadorCampo.numberValidator(1, "COLUMNAS"));
        txtColumnas.setEditable(false);
        getContentPane().add(txtColumnas);

        lblCine = new JLabel("Cine cuit");
        lblCine.setBounds(20, 160, 120, 28);
        getContentPane().add(lblCine);
        
        txtCine = new JTextField();
        txtCine.setBounds(130, 160, 120, 28);
        txtCine.setEditable(false);
        getContentPane().add(txtCine);

        btnModificar = new JButton("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(e -> {
            CineController cine = CineController.getInstance();
            String nombre = txtNombre.getText();
			String filas = txtFilas.getText();
			String columnas = txtColumnas.getText();
			if(nombre.equals("") || filas.equals("") || columnas.equals("")) {
				JOptionPane.showMessageDialog(null, "Hay campos sin completar!", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			cine.modificarSala( idSala,
            		nombre,
                    Integer.parseInt(filas),
                    Integer.parseInt(columnas));
            JOptionPane.showMessageDialog(null, "Sala modificada!");
            this.setVisible(false);
        });
        btnModificar.setBounds(165, 200, 120, 28);
        getContentPane().add(btnModificar);

        tablaSalas = new JTable();
        tablaSalas.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tablaSalas.addMouseListener(new MouseAdapter() {
            @Override
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
        getContentPane().add(mibarra);
        mibarra.setBounds(20, 240, 440, 150);

        tablaSalasModel = new TablaSalas();
        tablaSalasModel.setSalas(CineController.getInstance().getSalas());

        tablaSalas.setModel(tablaSalasModel);
        mibarra.setViewportView(tablaSalas);

    }
}

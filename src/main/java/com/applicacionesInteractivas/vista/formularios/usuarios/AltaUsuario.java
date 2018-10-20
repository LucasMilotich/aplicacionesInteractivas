package com.applicacionesInteractivas.vista.formularios.usuarios;

import com.applicacionesInteractivas.controllers.UsuarioController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class AltaUsuario extends JFrame {

    /**
     *
     */
    private JPanel mainPanel;
    private static final long serialVersionUID = -4928365317491320581L;

    public AltaUsuario() {

        this.setSize(320, 360);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Crear Usuario");

        JLabel lblNombreUser = new JLabel();
        lblNombreUser.setText("Nombre Usuario");
        this.add(lblNombreUser);

        JTextField txtNombreUser = new JTextField();
        txtNombreUser.setColumns(12);
        this.add(txtNombreUser);

        JLabel lblEmail = new JLabel();
        lblEmail.setText("Email");
        this.add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setColumns(12);
        this.add(txtEmail);

        JLabel lblContrasena = new JLabel();
        lblContrasena.setText("Contrasena Usuario");
        this.add(lblContrasena);

        JPasswordField txtContrasena = new JPasswordField();
        txtContrasena.setColumns(12);
        this.add(txtContrasena);

        JLabel lblNombre = new JLabel();
        lblNombre.setText("Nombre Completo");
        this.add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setColumns(12);
        this.add(txtNombre);

        JLabel lblDomicilio = new JLabel();
        lblDomicilio.setText("Domicilio");
        this.add(lblDomicilio);

        JTextField txtDomicilio = new JTextField();
        txtDomicilio.setColumns(12);
        this.add(txtDomicilio);

        JLabel lblDni = new JLabel();
        lblDni.setText("DNI");
        this.add(lblDni);

        JTextField txtDni = new JTextField();
        txtDni.setColumns(12);
        this.add(txtDni);

        JLabel lblFechaNac = new JLabel();
        lblFechaNac.setText("Fecha Nacimiento");
        this.add(lblFechaNac);

        JTextField txtFechaNac = new JTextField();
        txtFechaNac.setColumns(12);
        this.add(txtFechaNac);

        JButton btnConfirm = new JButton("Confirmar");
        this.add(btnConfirm);

        JPanel panel1 = new JPanel();
        panel1.add(lblNombreUser);
        panel1.add(txtNombreUser);

        JPanel panel2 = new JPanel();
        panel2.add(lblEmail);
        panel2.add(txtEmail);

        JPanel panel3 = new JPanel();
        panel3.add(lblContrasena);
        panel3.add(txtContrasena);

        JPanel panel4 = new JPanel();
        panel4.add(lblNombre);
        panel4.add(txtNombre);

        JPanel panel5 = new JPanel();
        panel5.add(lblDomicilio);
        panel5.add(txtDomicilio);

        JPanel panel6 = new JPanel();
        panel6.add(lblDni);
        panel6.add(txtDni);

        JPanel panel7 = new JPanel();
        panel7.add(lblFechaNac);
        panel7.add(txtFechaNac);

        JPanel panel8 = new JPanel();
        panel8.add(btnConfirm);

        btnConfirm.addActionListener(e -> {

            try {
                UsuarioController
                    .getInstance()
                    .crearUsuario(
                        txtNombreUser.getText(),
                        txtEmail.getText(),
                        txtContrasena.getText(),
                        txtNombre.getText(),
                        txtDomicilio.getText(),
                        txtDni.getText(),
                        new Date());

                JOptionPane.showMessageDialog(null, "Usuario creado!");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Error creando usuario " + exception.getMessage());
            }

            this.setVisible(false);


        });
        mainPanel = new JPanel();

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);
        mainPanel.add(panel5);
        mainPanel.add(panel6);
        mainPanel.add(panel7);
        mainPanel.add(panel8);

        getContentPane().add(mainPanel);
    }
}

package com.applicacionesInteractivas.vista.formularios.usuarios;

import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.UsuarioController;
import com.applicacionesInteractivas.vista.formularios.utils.ValidadorCampo;

public class AltaUsuario extends JFrame {

    private static final long serialVersionUID = -4928365317491320581L;

    public AltaUsuario() {

        this.setSize(320, 420);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.setTitle("Crear Usuario");

        JLabel lblNombreUser = new JLabel();
        lblNombreUser.setText("Nombre Usuario");
        lblNombreUser.setBounds(20, 40, 120, 28);
        getContentPane().add(lblNombreUser);

        JTextField txtNombreUser = new JTextField();
        txtNombreUser.setBounds(130, 40, 120, 28);
        getContentPane().add(txtNombreUser);

        JLabel lblEmail = new JLabel();
        lblEmail.setText("Email");
        lblEmail.setBounds(20, 80, 120, 28);
        getContentPane().add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(130, 80, 120, 28);
        getContentPane().add(txtEmail);

        JLabel lblContrasena = new JLabel();
        lblContrasena.setText("Contrasena");
        lblContrasena.setBounds(20, 120, 120, 28);
        getContentPane().add(lblContrasena);

        JPasswordField txtContrasena = new JPasswordField();
        txtContrasena.setBounds(130, 120, 120, 28);
        getContentPane().add(txtContrasena);

        JLabel lblNombre = new JLabel();
        lblNombre.setText("Nombre Completo");
        lblNombre.setBounds(20, 160, 120, 28);
        getContentPane().add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(130, 160, 120, 28);
        getContentPane().add(txtNombre);

        JLabel lblDomicilio = new JLabel();
        lblDomicilio.setText("Domicilio");
        lblDomicilio.setBounds(20, 200, 120, 28);
        getContentPane().add(lblDomicilio);

        JTextField txtDomicilio = new JTextField();
        txtDomicilio.setBounds(130, 200, 120, 28);
        getContentPane().add(txtDomicilio);

        JLabel lblDni = new JLabel();
        lblDni.setText("DNI");
        lblDni.setBounds(20, 240, 120, 28);
        getContentPane().add(lblDni);

        JTextField txtDni = new JTextField();
        txtDni.setBounds(130, 240, 120, 28);
        txtDni.addKeyListener(ValidadorCampo.numberValidator(8, "DNI"));
        getContentPane().add(txtDni);

        JLabel lblFechaNac = new JLabel();
        lblFechaNac.setText("Fecha Nacimiento");
        lblFechaNac.setBounds(20, 280, 120, 28);
        getContentPane().add(lblFechaNac);

        JTextField txtFechaNac = new JTextField();
        txtFechaNac.setBounds(130, 280, 120, 28);
        txtFechaNac.addKeyListener(ValidadorCampo.validadorFecha("FECHA"));
        getContentPane().add(txtFechaNac);

        JButton btnConfirm = new JButton("Confirmar");
        getContentPane().add(btnConfirm);
        btnConfirm.setBounds(100, 340, 120, 28);
        btnConfirm.addActionListener(e -> {
            try {
                UsuarioController
                    .getInstance()
                    .crearUsuario(
                        txtNombreUser.getText(),
                        txtEmail.getText(),
                        String.copyValueOf(txtContrasena.getPassword()),
                        txtNombre.getText(),
                        txtDomicilio.getText(),
                        txtDni.getText(),
                        LocalDate.now(),
                            false);

                JOptionPane.showMessageDialog(null, "Usuario creado!");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Error creando usuario " + exception.getMessage());
            }
            this.setVisible(false);
        });
    }
}

package com.applicacionesInteractivas.vista.formularios.usuarios;

import com.applicacionesInteractivas.controllers.UsuarioController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JFormABMUsuario extends JFrame {
    private JTable table1;

    private JPanel mainPanel;

    JTextField nombreUsuarioTxtField;
    JTextField emailTxtField;
    JTextField passwordTxtField;
    JTextField nombreTxtField;
    JTextField domicilioTxtField;
    JTextField dniTxtField;
    JTextField fechaNacimientoTxtField;

    JLabel nombreUsuarioLabel;
    JLabel emailLabel;
    JLabel passwordLabel;
    JLabel nombreLabel;
    JLabel domicilioLabel;
    JLabel dniLabel;
    JLabel fechaNacimientoLabel;

    private JScrollPane mibarra;

    public JFormABMUsuario() throws HeadlessException {
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("ABM Usuario");



         JTable usuarios = new JTable();
         ABMTableModel abmTableModel = new ABMTableModel();
         abmTableModel.setUsuarios(UsuarioController.getInstance().getUsuarios());
         usuarios.setModel(abmTableModel);


        nombreUsuarioTxtField = new JTextField();
        emailTxtField = new JTextField();
        passwordTxtField = new JTextField();
        nombreTxtField = new JTextField();
        domicilioTxtField = new JTextField();
        dniTxtField = new JTextField();
        fechaNacimientoTxtField = new JTextField();

        nombreUsuarioLabel = new JLabel() ;
        emailLabel = new JLabel() ;
        passwordLabel = new JLabel() ;
        nombreLabel = new JLabel() ;
        domicilioLabel = new JLabel() ;
        dniLabel = new JLabel() ;
        fechaNacimientoLabel = new JLabel() ;

        nombreUsuarioLabel.setText("nombreUsuarioLabel");
        emailLabel.setText("emailLabel");
        passwordLabel.setText("passwordLabel");
        nombreLabel.setText("nombreLabel");
        domicilioLabel.setText("domicilioLabel");
        dniLabel.setText("dniLabel");
        fechaNacimientoLabel.setText("fechaNacimientoLabel");

        nombreUsuarioTxtField.setColumns(12);
        emailTxtField.setColumns(12);
        passwordTxtField.setColumns(12);
        nombreTxtField.setColumns(12);
        domicilioTxtField.setColumns(12);
        dniTxtField.setColumns(12);
        fechaNacimientoTxtField.setColumns(12);

        usuarios.setAutoCreateColumnsFromModel(true);

        this.add(usuarios);
        this.add(nombreUsuarioLabel);
        this.add(nombreUsuarioTxtField);

        this.add(emailLabel);
        this.add(emailTxtField);
        this.add(passwordLabel);
        this.add(passwordTxtField);
        this.add(nombreLabel);
        this.add(nombreTxtField);
        this.add(domicilioLabel);
        this.add(domicilioTxtField);
        this.add(dniLabel);
        this.add(dniTxtField);
        this.add(fechaNacimientoLabel);
        this.add(fechaNacimientoTxtField);

        JPanel panel1 = new JPanel();
        panel1.add(usuarios);


        JPanel panel2 = new JPanel();
        panel2.add(nombreUsuarioLabel);
        panel2.add(nombreUsuarioTxtField);

        JPanel panel3 = new JPanel();
        panel3.add(emailLabel);
        panel3.add(emailTxtField);

        JPanel panel4 = new JPanel();
        panel4.add(passwordLabel);
        panel4.add(passwordTxtField);

        JPanel panel5 = new JPanel();
        panel5.add(nombreLabel);
        panel5.add(nombreTxtField);

        JPanel panel6 = new JPanel();
        panel6.add(domicilioLabel);
        panel6.add(domicilioTxtField);

        JPanel panel7 = new JPanel();
        panel7.add(dniLabel);
        panel7.add(dniTxtField);

        JPanel panel8 = new JPanel();
        panel8.add(domicilioLabel);
        panel8.add(domicilioTxtField);


        mibarra = new JScrollPane();
        mibarra.setBounds(40, 300, 400, 130);
        mibarra.setViewportView(usuarios);


        mainPanel = new JPanel();

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);
        mainPanel.add(panel5);
        mainPanel.add(panel6);
        mainPanel.add(panel7);
        mainPanel.add(panel8);
        mainPanel.add(mibarra);

        getContentPane().add(mainPanel);

    }
}

package com.applicacionesInteractivas.vista.formularios.usuarios;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.controllers.UsuarioController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JButton btnModificar;


    private JScrollPane mibarra;

    public JFormABMUsuario() throws HeadlessException {
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("ABM Usuario");

        btnModificar = new JButton("Modificar Usuario");
        btnModificar.addActionListener(e -> {

            JOptionPane.showMessageDialog(null,"Cine modificado!");
            this.setVisible(false);
        });
        

        JPanel btnContainer = new JPanel();
        btnContainer.add(btnModificar);

         JTable usuarios = new JTable();
         ABMTableModel abmTableModel = new ABMTableModel();
         abmTableModel.setUsuarios(UsuarioController.getInstance().getUsuarios());
         usuarios.setModel(abmTableModel);

            usuarios.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    try{
                        dniTxtField.setText((String) table.getValueAt(row, Columns.DNI));

                        nombreTxtField.setText((String) table.getValueAt(row, Columns.NOMBRE));
                        nombreTxtField.setEnabled(true);

                        nombreUsuarioTxtField.setText((String) table.getValueAt(row, Columns.NOMBREUSUARIO));
                        nombreUsuarioTxtField.setEnabled(true);

                        emailTxtField.setText((String) table.getValueAt(row, Columns.EMAIL));
                        emailTxtField.setEnabled(true);

                        domicilioTxtField.setText((String) table.getValueAt(row, Columns.DOMICILIO));
                        domicilioTxtField.setEnabled(true);

                        fechaNacimientoTxtField.setText((String) table.getValueAt(row, Columns.FECHANACIMIENTO));
                        fechaNacimientoTxtField.setEnabled(true);

                        btnModificar.setEnabled(true);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });


        nombreUsuarioTxtField = new JTextField();
        emailTxtField = new JTextField();
        passwordTxtField = new JTextField();
        nombreTxtField = new JTextField();
        domicilioTxtField = new JTextField();
        dniTxtField = new JTextField();
        fechaNacimientoTxtField = new JTextField();

        nombreUsuarioLabel = new JLabel("Nombre usuario") ;
        emailLabel = new JLabel("Email") ;
        passwordLabel = new JLabel("Password") ;
        nombreLabel = new JLabel("Nombre y apellido") ;
        domicilioLabel = new JLabel("Domicilio ") ;
        dniLabel = new JLabel("DNI") ;
        fechaNacimientoLabel = new JLabel("Fec. nacimiento ") ;



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
        mainPanel.add(btnContainer);
        mainPanel.add(mibarra);

        getContentPane().add(mainPanel);

    }
}

package com.applicacionesInteractivas.vista.formularios.usuarios;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.UsuarioController;
import com.applicacionesInteractivas.vista.formularios.utils.ValidadorCampo;

public class ABMUsuario extends JFrame {
  
	private static final long serialVersionUID = -8634477335406370134L;

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

    public ABMUsuario() throws HeadlessException {
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.setTitle("ABM Usuario");

        btnModificar = new JButton("Modificar Usuario");
        btnModificar.addActionListener(e -> {
            UsuarioController usuarioController = UsuarioController.getInstance();
            String nombreUsuario = nombreUsuarioTxtField.getText();
			String email = emailTxtField.getText();
			String password = passwordTxtField.getText();
			String nombre = nombreTxtField.getText();
			String domicilio = domicilioTxtField.getText();
			String dni = dniTxtField.getText();
			LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoTxtField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			if(nombreUsuario.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(null, "Los campos NOMBRE USUARIO y CONTRASENA no pueden estar vacios!",
											"Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			usuarioController.modificarUsuario(nombreUsuario,email,password,nombre,domicilio,dni,fechaNacimiento,false);

            JOptionPane.showMessageDialog(null, "Usuario modificado!");
            this.setVisible(false);
        });
        btnModificar.setBounds(180, 330, 140, 28);
        getContentPane().add(btnModificar);

        JTable usuarios = new JTable();
        usuarios.setPreferredScrollableViewportSize(new Dimension(500, 70));
        usuarios.addMouseListener(new MouseAdapter() {
            @Override
			public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    try {
                        dniTxtField.setText((String) table.getValueAt(row, Columns.DNI));

                        nombreTxtField.setText((String) table.getValueAt(row, Columns.NOMBRE));
                        nombreTxtField.setEnabled(true);

                        nombreUsuarioTxtField.setText((String) table.getValueAt(row, Columns.NOMBREUSUARIO));
                        nombreUsuarioTxtField.setEnabled(true);

                        emailTxtField.setText((String) table.getValueAt(row, Columns.EMAIL));
                        emailTxtField.setEnabled(true);

                        domicilioTxtField.setText((String) table.getValueAt(row, Columns.DOMICILIO));
                        domicilioTxtField.setEnabled(true);

                        fechaNacimientoTxtField.setText(((LocalDate) table.getValueAt(row, Columns.FECHANACIMIENTO)).toString());
                        fechaNacimientoTxtField.setEnabled(true);

                        btnModificar.setEnabled(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        
        mibarra = new JScrollPane();
        getContentPane().add(mibarra);
        mibarra.setBounds(20, 380, 560, 150);

        ABMTableModel abmTableModel = new ABMTableModel();
        abmTableModel.setUsuarios(UsuarioController.getInstance().getUsuarios());
        usuarios.setModel(abmTableModel);
        mibarra.setViewportView(usuarios);

        nombreUsuarioTxtField = new JTextField();
        this.nombreUsuarioTxtField.addKeyListener(ValidadorCampo.lengthValidador(49, "NOMBRE USUARIO"));
        nombreUsuarioTxtField.setBounds(130, 40, 120, 28);
        
        emailTxtField = new JTextField();
        this.emailTxtField.addKeyListener(ValidadorCampo.lengthValidador(49, "EMAIL"));
        emailTxtField.setBounds(130, 80, 120, 28);
        
        passwordTxtField = new JTextField();
        this.passwordTxtField.addKeyListener(ValidadorCampo.lengthValidador(49, "PASSWORD"));
        passwordTxtField.setBounds(130, 120, 120, 28);
        
        nombreTxtField = new JTextField();
        this.nombreTxtField.addKeyListener(ValidadorCampo.lengthValidador(49, "NOMBRE"));
        nombreTxtField.setBounds(130, 160, 120, 28);
        
        domicilioTxtField = new JTextField();
        this.domicilioTxtField.addKeyListener(ValidadorCampo.lengthValidador(49, "DOMICILIO"));
        domicilioTxtField.setBounds(130, 200, 120, 28);
        
        dniTxtField = new JTextField();
        this.dniTxtField.addKeyListener(ValidadorCampo.numberValidator(8, "DNI"));
        dniTxtField.setBounds(130, 240, 120, 28);
        
        fechaNacimientoTxtField = new JTextField();
        this.fechaNacimientoTxtField.addKeyListener(ValidadorCampo.validadorFecha("FECHA NACIMIENTO"));
        fechaNacimientoTxtField.setBounds(130, 280, 120, 28);
        
        nombreUsuarioLabel = new JLabel("Nombre usuario");
        nombreUsuarioLabel.setBounds(20, 40, 120, 28);
        
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(20, 80, 120, 28);
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20, 120, 120, 28);
        
        nombreLabel = new JLabel("Nombre y apellido");
        nombreLabel.setBounds(20, 160, 120, 28);
        
        domicilioLabel = new JLabel("Domicilio ");
        domicilioLabel.setBounds(20, 200, 120, 28);
        
        dniLabel = new JLabel("DNI");
        dniLabel.setBounds(20, 240, 120, 28);
        
        fechaNacimientoLabel = new JLabel("Fec. nacimiento ");
        fechaNacimientoLabel.setBounds(20, 280, 120, 28);

        fechaNacimientoTxtField.addKeyListener(ValidadorCampo.validadorFecha("FECHA"));

        usuarios.setAutoCreateColumnsFromModel(true);

        getContentPane().add(nombreUsuarioLabel);
        getContentPane().add(nombreUsuarioTxtField);
        getContentPane().add(emailLabel);
        getContentPane().add(emailTxtField);
        getContentPane().add(passwordLabel);
        getContentPane().add(passwordTxtField);
        getContentPane().add(nombreLabel);
        getContentPane().add(nombreTxtField);
        getContentPane().add(domicilioLabel);
        getContentPane().add(domicilioTxtField);
        getContentPane().add(dniLabel);
        getContentPane().add(dniTxtField);
        getContentPane().add(fechaNacimientoLabel);
        getContentPane().add(fechaNacimientoTxtField);


    }
}

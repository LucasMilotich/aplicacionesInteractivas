package com.applicacionesInteractivas.vista.formularios.usuarios.roles;

import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.applicacionesInteractivas.controllers.UsuarioController;
import com.applicacionesInteractivas.modelo.rol.IRol;
import com.applicacionesInteractivas.vista.formularios.usuarios.ABMTableModel;
import com.applicacionesInteractivas.vista.formularios.usuarios.Columns;

public class ABMRoles extends JFrame {
    
	private static final long serialVersionUID = -865814400459900570L;
	private JPanel mainPanel;
    private JButton btnModificar;
    private JScrollPane mibarra;
    private ArrayList<JCheckBox> boxList = new ArrayList<JCheckBox>();

    private String username;


    public ABMRoles() throws HeadlessException {

        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("ABM Roles");

        btnModificar = new JButton("Guardar roles");
        JPanel btnContainer = new JPanel();
        btnContainer.add(btnModificar);

        JTable usuarios = new JTable();
        ABMTableModel abmTableModel = new ABMTableModel();
        abmTableModel.setUsuarios(UsuarioController.getInstance().getUsuarios());
        usuarios.setModel(abmTableModel);

        usuarios.setAutoCreateColumnsFromModel(true);

        this.add(usuarios);

        JPanel panel1 = new JPanel();
        panel1.add(usuarios);

        mibarra = new JScrollPane();
        mibarra.setBounds(40, 300, 400, 110);
        mibarra.setViewportView(usuarios);


        mainPanel = new JPanel();

        buildRolCheckboxes();
        mainPanel.add(btnContainer);


        mainPanel.add(mibarra);

        usuarios.addMouseListener(new MouseAdapter() {
            @Override
			public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    try {
                        username = (String) table.getValueAt(row, Columns.NOMBREUSUARIO);

                        for (IRol u : UsuarioController.getInstance().getUsuario(username).getRoles()) {
                            for (JCheckBox checkBox : boxList) {
                                if (checkBox.getText().equals(u.nombre())) {
                                    checkBox.setSelected(true);
                                }
                            }
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        btnModificar.addActionListener(e -> {
            UsuarioController usuarioController = UsuarioController.getInstance();

            Stream<JCheckBox> rolesSeleccionados = boxList.stream().filter(AbstractButton::isSelected);

            usuarioController.modificarRoles(rolesSeleccionados.map(it -> it.getText()).collect(Collectors.toList()), username);
            JOptionPane.showMessageDialog(null, "Usuario modificado!");
            this.setVisible(false);
        });


        getContentPane().add(mainPanel);


    }

    private void buildRolCheckboxes() {
        UsuarioController usuarioController = UsuarioController.getInstance();


        for (int i = 0; i < usuarioController.getRoles().size(); i++) {
            JPanel boxesContainer = new JPanel();
            JCheckBox box = new JCheckBox(usuarioController.getRoles().get(i).nombre());
            boxesContainer.add(box);
            boxList.add(box);
            mainPanel.add(boxesContainer);
        }


    }

}

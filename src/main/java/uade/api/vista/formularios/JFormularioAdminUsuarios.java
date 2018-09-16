package uade.api.vista.formularios;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFormularioAdminUsuarios extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4029676028528519391L;
	
	public JFormularioAdminUsuarios() {
		
		this.setSize(320, 240);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new FlowLayout());
		this.setTitle("Administración Usuarios");
		
		JButton btnAddUser = new JButton("Dar de alta Usuario");
		btnAddUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame form2 = new JFormularioAltaUsuario();
				form2.setVisible(true);
			}
		});
		this.add(btnAddUser);
		
		JButton btnUpdUser = new JButton("Modificar Usuario");
		this.add(btnUpdUser);
		
		JButton btnDelUser = new JButton("Eliminar Usuario");
		this.add(btnDelUser);
	}

}

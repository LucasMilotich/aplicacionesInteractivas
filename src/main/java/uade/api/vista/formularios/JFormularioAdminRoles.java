package uade.api.vista.formularios;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFormularioAdminRoles extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6999935790207609694L;

	public JFormularioAdminRoles() {
		
		this.setSize(320, 240);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Administración Roles");
		
		JButton btnAddRol = new JButton("Dar de alta Rol");
		this.add(btnAddRol);
		
		JButton btnUpdRol = new JButton("Modificar Rol");
		this.add(btnUpdRol);
		
		JButton btnDelRol = new JButton("Eliminar Rol");
		this.add(btnDelRol);
	}
}

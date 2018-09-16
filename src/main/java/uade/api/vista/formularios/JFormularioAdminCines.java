package uade.api.vista.formularios;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFormularioAdminCines extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4859825063578897901L;

	public JFormularioAdminCines() {
		
		this.setSize(320, 240);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Administración Cines");
		
		JButton btnAddCine = new JButton("Dar de alta Cine");
		this.add(btnAddCine);
		
		JButton btnUpdCine = new JButton("Modificar Cine");
		this.add(btnUpdCine);
		
		JButton btnDelCine = new JButton("Eliminar Cine");
		this.add(btnDelCine);
	}
}

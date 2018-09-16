package uade.api.vista.formularios;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFormularioAdminDescuentos extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3333370012841122390L;

	public JFormularioAdminDescuentos() {
		
		this.setSize(320, 240);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Administraci�n Descuentos");
		
		JButton btnAddDescuento = new JButton("Dar de alta Descuento");
		this.add(btnAddDescuento);
		
		JButton btnUpdDescuento = new JButton("Modificar Descuento");
		this.add(btnUpdDescuento);
		
		JButton btnDelDescuento = new JButton("Eliminar Descuento");
		this.add(btnDelDescuento);
	}
}

package uade.api.vista.formularios;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFormularioAdminPeliculas extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3419041216351844575L;

	public JFormularioAdminPeliculas() {
		
		this.setSize(320, 240);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Administración Peliculas");
		
		JButton btnAddPelicula = new JButton("Dar de alta Pelicula");
		this.add(btnAddPelicula);
		
		JButton btnUpdPelicula = new JButton("Modificar Pelicula");
		this.add(btnUpdPelicula);
		
		JButton btnDelPelicula = new JButton("Eliminar Pelicula");
		this.add(btnDelPelicula);
	}
}

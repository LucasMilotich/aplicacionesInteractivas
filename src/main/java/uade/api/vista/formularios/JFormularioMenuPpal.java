package uade.api.vista.formularios;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFormularioMenuPpal extends JFrame{

	/**
	 * 
	 */
	private JPanel mainPanel;
	private static final long serialVersionUID = -704300453015702288L;
	
	public JFormularioMenuPpal() {
		
		this.setSize(640, 480);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("TPO API 2C2018");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnUsuarioController = new JButton("Usuario Controller");
		this.add(btnUsuarioController);
		
		JButton btnRolController = new JButton("Rol Controller");
		this.add(btnRolController);
		
		JButton btnCineController = new JButton("Cine Controller");
		this.add(btnCineController);
		
		JButton btnSalaController = new JButton("Sala Controller");
		this.add(btnSalaController);
		
		JButton btnPeliculaController = new JButton("Pelicula Controller");
		this.add(btnPeliculaController);
		
		JButton btnFuncionController = new JButton("Funcion Controller");
		this.add(btnFuncionController);
		
		JButton btnDescuentoController = new JButton("Descuento Controller");
		this.add(btnDescuentoController);

		this.mainPanel = new JPanel();
		JPanel panel1 = new JPanel();
		panel1.add(btnUsuarioController);
		
		JPanel panel2 = new JPanel();
		panel1.add(btnRolController);
		
		JPanel panel3 = new JPanel();
		panel1.add(btnCineController);
		
		JPanel panel4 = new JPanel();
		panel1.add(btnSalaController);
		
		JPanel panel5 = new JPanel();
		panel1.add(btnPeliculaController);
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		
		//this.mainPanel.add(btnFuncionController);
		//this.mainPanel.add(btnDescuentoController);
	}

}

package com.applicacionesInteractivas.vista.formularios.funciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.modelo.Pelicula;
import com.applicacionesInteractivas.modelo.Sala;
import com.applicacionesInteractivas.vista.formularios.utils.ValidadorCampo;

public class FormAltaFuncion extends JFrame{

	private static final long serialVersionUID = 362160396368097636L;
	private JLabel lblCine;
	private Vector<String> listadoCines;
	private JLabel lblPelicula;
	private Vector<String> listadoPeliculas;
	private JLabel lblSala;
	private Vector<String> listadoSalas;
	private JLabel lblDia;
	private String[] listaDias = {"01","02","03","04","05","06","07","08","09","10","11","12",
			"13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private JComboBox<String> comboDia;
	private JLabel lblMes;
	private String[] listaMeses = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	private JComboBox<String> comboMes;
	private JLabel lblAnio;
	private String[] listaAnio = {"2018"};
	private JComboBox<String> comboAnio;
	private JComboBox<String> comboCine;
	private JComboBox<String> comboPelicula;
	private JComboBox<String> comboSala;
	private JLabel lblHora;
	private JTextField txtHora;
	private JButton btnConfirmar;
	
	public FormAltaFuncion() {
		
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		this.setTitle("Crear Funcion");
		
		lblCine = new JLabel("Cine");
		lblCine.setBounds(20, 40, 120, 28);
		getContentPane().add(lblCine);
		
		lblPelicula = new JLabel("Pelicula");
		lblPelicula.setBounds(20, 80, 120, 28);
		getContentPane().add(lblPelicula);
		
		lblSala = new JLabel("Sala");
		lblSala.setBounds(20, 120, 120, 28);
		getContentPane().add(lblSala);
		
		listadoCines = CineController.getInstance().getListadoCines();
		ComboBoxModel<String> cineModel = new DefaultComboBoxModel<String>(listadoCines);
		comboCine = new JComboBox<String>(cineModel);
		comboCine.setSelectedItem(null);
		comboCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
		    {
		        String selectedItem = (String) comboCine.getSelectedItem();
		        String[] cine = selectedItem.split(" - ");
		        
		        listadoPeliculas = CineController.getInstance().getListadoPeliculas();
				ComboBoxModel<String> peliculaModel = new DefaultComboBoxModel<String>(listadoPeliculas);
				comboPelicula.setModel(peliculaModel);
				comboPelicula.setSelectedItem(null);
				
				listadoSalas = CineController.getInstance().getListadoSalas(cine[0]);
				ComboBoxModel<String> salaModel = new DefaultComboBoxModel<String>(listadoSalas);
				comboSala.setModel(salaModel);
				comboSala.setSelectedItem(null);
		    }
		});
		comboCine.setBounds(130, 40, 220, 28);
		getContentPane().add(comboCine);
		
		comboPelicula = new JComboBox<String>();
		comboPelicula.setBounds(130, 80, 220, 28);
		getContentPane().add(comboPelicula);
		
		comboSala = new JComboBox<String>();
		comboSala.setBounds(130, 120, 220, 28);
		getContentPane().add(comboSala);
		
		lblDia = new JLabel("Dia");
		lblDia.setBounds(20, 160, 30, 30);
		getContentPane().add(lblDia);
		
		comboDia = new JComboBox<String>(listaDias);
		comboDia.setBounds(50, 160, 40, 30);
		getContentPane().add(comboDia);
		
		lblMes = new JLabel("Mes");
		lblMes.setBounds(100, 160, 30, 30);
		getContentPane().add(lblMes);
		
		comboMes = new JComboBox<String>(listaMeses);
		comboMes.setBounds(130, 160, 40, 30);
		getContentPane().add(comboMes);
		
		lblAnio = new JLabel("Anio");
		lblAnio.setBounds(180, 160, 30, 30);
		getContentPane().add(lblAnio);
		
		comboAnio = new JComboBox<String>(listaAnio);
		comboAnio.setBounds(210, 160, 60, 30);
		getContentPane().add(comboAnio);
		
		lblHora = new JLabel("Hora");
		lblHora.setBounds(280, 160, 30, 30);
		getContentPane().add(lblHora);
		
		txtHora = new JTextField();
		txtHora.addKeyListener(ValidadorCampo.validadorHora());
		txtHora.setBounds(310, 160, 50, 30);
		getContentPane().add(txtHora);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(e -> {
			CineController cineController = CineController.getInstance();
			Sala s = cineController.getSala(Integer.parseInt(String.valueOf(comboSala.getSelectedItem()).split(" - ")[0]));
			Pelicula p = cineController.getPelicula(Integer.parseInt(String.valueOf(comboPelicula.getSelectedItem()).split(" - ")[0]));
			LocalDate fecha = LocalDate.of(Integer.valueOf((String)comboAnio.getSelectedItem()), 
											Integer.valueOf((String)comboMes.getSelectedItem()),
											Integer.valueOf((String)comboDia.getSelectedItem()));
			String[] horario = txtHora.getText().split(":");
			LocalTime hora = LocalTime.of(Integer.parseInt(horario[0]),Integer.parseInt(horario[1]));
			cineController.crearFuncion(p,
										s,
										fecha,
										hora);
			JOptionPane.showMessageDialog(null,"Funcion creada!");
			this.setVisible(false);
		});
		btnConfirmar.setBounds(120, 220, 120, 28);
		getContentPane().add(btnConfirmar);
		
	}
}

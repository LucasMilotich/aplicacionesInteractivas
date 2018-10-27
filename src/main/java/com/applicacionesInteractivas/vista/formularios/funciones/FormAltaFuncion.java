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
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.modelo.Pelicula;
import com.applicacionesInteractivas.modelo.Sala;

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
	private JPanel cineContainer, peliculaContainer, salaContainer, horarioContainer, btnContainer;
	private JPanel mainPanel;
	
	public FormAltaFuncion() {
		
		this.setSize(400, 450);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Crear Funcion");
		mainPanel = new JPanel();
		
		lblCine = new JLabel("Cine");
		lblPelicula = new JLabel("Pelicula");
		lblSala = new JLabel("Sala");
		
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
		this.add(comboCine);
		
		comboPelicula = new JComboBox<String>();
		comboPelicula.setSize(comboCine.getWidth(), comboCine.getHeight());
		this.add(comboPelicula);
		
		comboSala = new JComboBox<String>();
		comboSala.setSize(comboCine.getWidth(), comboCine.getHeight());
		this.add(comboSala);
		
		lblDia = new JLabel("Dia");
		this.add(lblDia);
		
		comboDia = new JComboBox<String>(listaDias);
		this.add(comboDia);
		
		lblMes = new JLabel("Mes");
		this.add(lblMes);
		
		comboMes = new JComboBox<String>(listaMeses);
		this.add(comboMes);
		
		lblAnio = new JLabel("Anio");
		this.add(lblAnio);
		
		comboAnio = new JComboBox<String>(listaAnio);
		this.add(comboAnio);
		
		lblHora = new JLabel("Hora");
		this.add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setColumns(12);
		this.add(txtHora);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(e -> {
			CineController cineController = CineController.getInstance();
			String values = String.valueOf(comboCine.getSelectedItem());
			String[] cine = values.split(" - ");
			//Cine c = cineController.getCine(cine[0]);
			Sala s = cineController.getSala(cine[0], String.valueOf(comboSala.getSelectedItem()));
			Pelicula p = cineController.getPelicula(String.valueOf(comboPelicula.getSelectedItem()));
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
		this.add(btnConfirmar);
		
		cineContainer = new JPanel();
		cineContainer.add(lblCine);
		cineContainer.add(comboCine);
		
		peliculaContainer = new JPanel();
		peliculaContainer.add(lblPelicula);
		peliculaContainer.add(comboPelicula);
		
		salaContainer = new JPanel();
		salaContainer.add(lblSala);
		salaContainer.add(comboSala);
		
		horarioContainer = new JPanel();
		horarioContainer.add(lblDia);
		horarioContainer.add(comboDia);
		horarioContainer.add(lblMes);
		horarioContainer.add(comboMes);
		horarioContainer.add(lblAnio);
		horarioContainer.add(comboAnio);
		horarioContainer.add(lblHora);
		horarioContainer.add(txtHora);
		
		btnContainer = new JPanel();
		btnContainer.add(btnConfirmar);
		
		mainPanel.add(cineContainer);
		mainPanel.add(peliculaContainer);
		mainPanel.add(salaContainer);
		mainPanel.add(horarioContainer);
		mainPanel.add(btnContainer);
		
		getContentPane().add(mainPanel);
		
	}
}

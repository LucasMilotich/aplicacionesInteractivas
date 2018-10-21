package com.applicacionesInteractivas.vista.formularios.funciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.applicacionesInteractivas.modelo.Cine;
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
	private JComboBox<String> comboCine;
	private JComboBox<String> comboPelicula;
	private JComboBox<String> comboSala;
	private JLabel lblHorario;
	private JTextField txtHorario;
	private JButton btnConfirmar;
	private JPanel cineContainer, peliculaContainer, salaContainer, horarioContainer, btnContainer;
	private JPanel mainPanel;
	
	public FormAltaFuncion() {
		
		this.setSize(320, 360);
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
		this.add(comboPelicula);
		
		comboSala = new JComboBox<String>();
		this.add(comboSala);
		
		lblHorario = new JLabel("Horario");
		this.add(lblHorario);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(12);
		this.add(txtHorario);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(e -> {
			CineController cineController = CineController.getInstance();
			//Obtengo parametros
			String values = String.valueOf(comboCine.getSelectedItem());
			String[] cine = values.split(" - ");
			Cine c = cineController.getCine(cine[0]);
			Sala s = cineController.getSala(cine[0], String.valueOf(comboSala.getSelectedItem()));
			Pelicula p = cineController.getPelicula(String.valueOf(comboPelicula.getSelectedItem()));
			cineController.crearFuncion(p,
										s,
					LocalDateTime.parse(txtHorario.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
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
		horarioContainer.add(lblHorario);
		horarioContainer.add(txtHorario);
		
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

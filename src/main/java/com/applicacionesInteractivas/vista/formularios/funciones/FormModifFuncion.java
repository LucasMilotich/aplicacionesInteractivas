package com.applicacionesInteractivas.vista.formularios.funciones;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaFunciones;
import com.applicacionesInteractivas.vista.formularios.utils.ValidadorCampo;

public class FormModifFuncion extends JFrame{

	private static final long serialVersionUID = 1785958213568294559L;
	private JLabel lblDia;
	private JLabel lblMes;
	private JLabel lblAnio;
	private JLabel lblHora;
	private JLabel lblSala;
	private JLabel lblCine;
	private JLabel lblPelicula;
	private String[] listaDias = {"1","2","3","4","5","6","7","8","9","10","11","12",
			"13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private JComboBox<String> comboDia;
	private String[] listaMeses = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	private JComboBox<String> comboMes;
	private String[] listaAnio = {"2018"};
	private JComboBox<String> comboAnio;
	private JTextField txtHora;
	private JTextField txtSala;
	private JTextField txtCine;
	private JTextField txtPelicula;
	private JButton btnModificar;
	private JTable tablaFunciones;
	private TablaFunciones tablaFuncionesModel;
	private JScrollPane miBarra;
	private JPanel horarioContainer, cineContainer,peliculaContainer,salaContainer, btnContainer, tableContainer;
	private JPanel mainPanel;
	private int idFuncion;
	
	public FormModifFuncion() {
		
		this.setSize(600, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Modificar Funcion");
		mainPanel = new JPanel();
		
		lblDia = new JLabel("Dia");
		this.add(lblDia);
		
		comboDia = new JComboBox<String>(listaDias);
		comboDia.setSelectedItem(null);
		comboDia.setEnabled(false);;
		this.add(comboDia);
		
		lblMes = new JLabel("Mes");
		this.add(lblMes);
		
		comboMes = new JComboBox<String>(listaMeses);
		comboMes.setSelectedItem(null);
		comboMes.setEnabled(false);;
		this.add(comboMes);
		
		lblAnio = new JLabel("Anio");
		this.add(lblAnio);
		
		comboAnio = new JComboBox<String>(listaAnio);
		comboAnio.setSelectedItem(null);
		comboAnio.setEnabled(false);;
		this.add(comboAnio);
		
		lblHora = new JLabel("Hora");
		this.add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setColumns(12);
		txtHora.setEnabled(false);
		txtHora.addKeyListener(ValidadorCampo.validadorHora("HORA"));
		this.add(txtHora);
		
		lblCine = new JLabel("Cine");
		this.add(lblCine);
		
		txtCine = new JTextField();
		txtCine.setColumns(12);
		txtCine.setEditable(false);
		this.add(txtCine);

		lblSala= new JLabel("Sala");
		this.add(lblSala);

		txtSala = new JTextField();
		txtSala.setColumns(12);
		txtSala.setEditable(false);
		this.add(txtSala);

		lblPelicula = new JLabel("Pelicula");
		this.add(lblPelicula);

		txtPelicula = new JTextField();
		txtPelicula.setColumns(12);
		txtPelicula.setEditable(false);
		this.add(txtPelicula);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(e -> {
			CineController cine = CineController.getInstance();
			LocalDate fecha = LocalDate.of(Integer.valueOf((String)comboAnio.getSelectedItem()), 
								Integer.valueOf((String)comboMes.getSelectedItem()),
								Integer.valueOf((String)comboDia.getSelectedItem()));
			String[] horario = txtHora.getText().split(":");
			LocalTime hora = LocalTime.of(Integer.parseInt(horario[0]),Integer.parseInt(horario[1]));
			cine.modificarFuncion(idFuncion, fecha, hora);;
			JOptionPane.showMessageDialog(null,"Funcion modificada!");
			this.setVisible(false);
		});
		btnModificar.setEnabled(false);
		this.add(btnModificar);
		
		tablaFunciones = new JTable();
		tablaFunciones.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tablaFunciones.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            try{
		            	txtCine.setText((String) table.getValueAt(row, 1));
						txtSala.setText((String) table.getValueAt(row, 2));
						txtPelicula.setText((String) table.getValueAt(row, 3));
						LocalDate fecha = (LocalDate)table.getValueAt(row, 4);
						comboDia.setSelectedItem(String.valueOf(fecha.getDayOfMonth()));
						comboDia.setEnabled(true);
						comboMes.setSelectedItem(String.valueOf(fecha.getMonthValue()));
						comboMes.setEnabled(true);
						comboAnio.setSelectedItem(String.valueOf(fecha.getYear()));
						comboAnio.setEnabled(true);
						txtHora.setText( table.getValueAt(row, 5).toString());
		            	txtHora.setEnabled(true);
		            	idFuncion = (int)table.getValueAt(row, 0);
			            btnModificar.setEnabled(true);
		            }
		            catch(Exception e){
		            	e.printStackTrace();
		            }
		        }
		    }
		});
		
		miBarra = new JScrollPane();
		miBarra.setBounds(40, 300, 400, 130);
		
		tablaFuncionesModel = new TablaFunciones();
		tablaFuncionesModel.setFunciones(CineController.getInstance().getFunciones());
		
		tablaFunciones.setModel(tablaFuncionesModel);
		miBarra.setViewportView(tablaFunciones);
		
		horarioContainer = new JPanel();
		horarioContainer.add(lblDia);
		horarioContainer.add(comboDia);
		horarioContainer.add(lblMes);
		horarioContainer.add(comboMes);
		horarioContainer.add(lblAnio);
		horarioContainer.add(comboAnio);
		horarioContainer.add(lblHora);
		horarioContainer.add(txtHora);
		
		cineContainer = new JPanel();
		cineContainer.add(lblCine);
		cineContainer.add(txtCine);

		peliculaContainer = new JPanel();
		peliculaContainer.add(lblPelicula);
		peliculaContainer.add(txtPelicula);

		salaContainer = new JPanel();
		salaContainer.add(lblSala);
		salaContainer.add(txtSala);
		
		btnContainer = new JPanel();
		btnContainer.add(btnModificar);
		
		tableContainer = new JPanel();
		tableContainer.add(miBarra);
		
		mainPanel.add(cineContainer);
		mainPanel.add(peliculaContainer);
		mainPanel.add(salaContainer);
		mainPanel.add(horarioContainer);
		mainPanel.add(btnContainer);
		mainPanel.add(tableContainer);
		
		getContentPane().add(mainPanel);
	}
}

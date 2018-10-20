package com.applicacionesInteractivas.vista.formularios.ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;

public class VentaBoleteria extends JFrame {

	private static final long serialVersionUID = -1333475726421442297L;
	private JLabel lblCine;
	private Vector<String> listadoCines;
	private JComboBox<String> comboCine;
	private JLabel lblPelicula;
	private Vector<String> listadoPeliculas;
	private JComboBox<String> comboPelicula;
	private JLabel lblDia;
	private String[] listaDias = {"01","02","03","04","05","06","07","08","09","10","11","12",
			"13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private JComboBox<String> comboDia;
	private JLabel lblMes;
	private String[] listaMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
									"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	private JComboBox<String> comboMes;
	private JLabel lblAnio;
	private String[] listaAnio = {"2018"};
	private JComboBox<String> comboAnio;
	private JLabel lblFuncion;
	private Vector<String> listadoFunciones;
	private JComboBox<String> comboFuncion;
	private JLabel lblCantidad;
	private String[] listaCantidad = {"1","2","3","4","5","6","7","8","9","10"};
	private JComboBox<String> comboCantidad;
	private JLabel lblFormaPago;
	private String[] listaFormasPago = {"Efectivo", "Tarjeta Debito", "Tarjeta Credito"};
	private JComboBox<String> comboFormaPago;
	private JLabel lblDescuento;
	private JTextField txtDescuento;
	private JButton btnConfirmar;
	private JPanel mainPanel;
	
	public VentaBoleteria() {

		this.setSize(320, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("TPO API 2C2018");
		
		lblCine = new JLabel("Cine");
		this.add(lblCine);
		
		listadoCines = CineController.getInstance().getListadoCines();
		ComboBoxModel<String> cineModel = new DefaultComboBoxModel<String>(listadoCines);
		comboCine = new JComboBox<String>();
		comboCine.setModel(cineModel);
		comboCine.setSelectedItem(null);
		comboCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
		    {
		        //String selectedItem = (String) comboCine.getSelectedItem();
		        
		        listadoPeliculas = CineController.getInstance().getListadoPeliculas();
				ComboBoxModel<String> peliculaModel = new DefaultComboBoxModel<String>(listadoPeliculas);
				comboPelicula.setModel(peliculaModel);
				
				listadoFunciones = CineController.getInstance().getListadoFunciones();
				ComboBoxModel<String> funcionModel = new DefaultComboBoxModel<String>(listadoFunciones);
				comboFuncion.setModel(funcionModel);
		    }
		});
		this.add(comboCine);
		
		lblPelicula = new JLabel("Pelicula");
		this.add(lblPelicula);
		
		comboPelicula = new JComboBox<String>();
		this.add(comboPelicula);
		
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
		
		lblFuncion = new JLabel("Funcion");
		this.add(lblFuncion);
		
		comboFuncion = new JComboBox<String>();
		this.add(comboFuncion);
		
		lblCantidad = new JLabel("Cantidad");
		this.add(lblCantidad);
		
		comboCantidad = new JComboBox<String>(listaCantidad);
		this.add(comboCantidad);
		
		lblFormaPago = new JLabel("Forma de Pago");
		this.add(lblFormaPago);
		
		comboFormaPago = new JComboBox<>(listaFormasPago);
		this.add(comboFormaPago);
		
		lblDescuento = new JLabel("Descuentos");
		this.add(lblDescuento);
		
		txtDescuento = new JTextField();
		txtDescuento.setColumns(12);
		this.add(txtDescuento);
		
		btnConfirmar = new JButton();
		btnConfirmar.setText("Confirmar");
		this.add(btnConfirmar);
		
		this.mainPanel = new JPanel();
		
		JPanel cineContainer = new JPanel();
		cineContainer.add(lblCine);
		cineContainer.add(comboCine);
		
		JPanel peliculaContainer = new JPanel();
		peliculaContainer.add(lblPelicula);
		peliculaContainer.add(comboPelicula);
		
		JPanel fechaContainer = new JPanel();
		fechaContainer.add(lblDia);
		fechaContainer.add(comboDia);
		fechaContainer.add(lblMes);
		fechaContainer.add(comboMes);
		fechaContainer.add(lblAnio);
		fechaContainer.add(comboAnio);
		
		JPanel funcionContainer = new JPanel();
		funcionContainer.add(lblFuncion);
		funcionContainer.add(comboFuncion);
		
		JPanel cantContainer = new JPanel();
		cantContainer.add(lblCantidad);
		cantContainer.add(comboCantidad);
		
		JPanel formaContainer = new JPanel();
		formaContainer.add(lblFormaPago);
		formaContainer.add(comboFormaPago);
		
		JPanel descuentoContainer = new JPanel();
		descuentoContainer.add(lblDescuento);
		descuentoContainer.add(txtDescuento);
		
		JPanel btnContainer = new JPanel();
		btnContainer.add(btnConfirmar);
		
		mainPanel.add(cineContainer);
		mainPanel.add(peliculaContainer);
		mainPanel.add(fechaContainer);
		mainPanel.add(funcionContainer);
		mainPanel.add(cantContainer);
		mainPanel.add(formaContainer);
		mainPanel.add(descuentoContainer);
		mainPanel.add(btnContainer);
		
		getContentPane().add(mainPanel);
		
	}
}

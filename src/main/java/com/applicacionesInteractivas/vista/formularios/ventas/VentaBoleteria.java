package com.applicacionesInteractivas.vista.formularios.ventas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.controllers.DescuentoController;
import com.applicacionesInteractivas.controllers.VentaController;
import com.applicacionesInteractivas.modelo.Funcion;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaDescuentos;;

public class VentaBoleteria extends JFrame {

	private static final long serialVersionUID = -1333475726421442297L;
	private JLabel lblCine;
	private Vector<String> listadoCines;
	private JComboBox<String> comboCine;
	private JLabel lblPelicula;
	private Vector<String> listadoPeliculas;
	private JComboBox<String> comboPelicula;
	private JLabel lblDia;
	private String[] listaDias = {"1","2","3","4","5","6", "7","8","9","10","11","12",
			"13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private JComboBox<String> comboDia;
	private JLabel lblMes;
	private String[] listaMeses = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	private JComboBox<String> comboMes;
	private JLabel lblAnio;
	private String[] listaAnio = {"2018"};
	private JButton btnBuscarFunciones;
	private JComboBox<String> comboAnio;
	private JLabel lblFuncion;
	private JComboBox<String> comboFuncion;
	private JLabel lblCantidad;
	private String[] listaCantidad = {"1","2","3","4","5","6","7","8","9","10"};
	private JComboBox<String> comboCantidad;
	private JButton btnAsientos;
	private JLabel lblFormaPago;
	private String[] listaFormasPago = {"Efectivo", "Tarjeta Debito", "Tarjeta Credito"};
	private JComboBox<String> comboFormaPago;
	private JButton btnFormaPago;
	private JLabel lblDescuento;
	private JTable tabDescuentos;
	private TablaDescuentos tablaDescuentos;
	private JScrollPane mibarra;
	private JButton btnConfirmar;
	private FormTarjeta datosTarjeta;
	private FormAsientos asientos;
	private JPanel mainPanel;
	
	public VentaBoleteria() {

		this.setSize(600, 600);
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
				String cuit = ((String)comboCine.getSelectedItem()).split(" - ")[0];
				tablaDescuentos.setDescuentos(DescuentoController.getInstance().getDescuentosPorCine(cuit));
		        tabDescuentos.setModel(tablaDescuentos);
		        tablaDescuentos.fireTableDataChanged();
		    }
		});
		this.add(comboCine);
		
		lblPelicula = new JLabel("Pelicula");
		this.add(lblPelicula);
		
		listadoPeliculas = CineController.getInstance().getListadoPeliculas();
		ComboBoxModel<String> peliculaModel = new DefaultComboBoxModel<String>(listadoPeliculas);
		comboPelicula = new JComboBox<String>();
		comboPelicula.setModel(peliculaModel);
		comboPelicula.setSelectedItem(null);
		this.add(comboPelicula);
		
		lblDia = new JLabel("Dia");
		this.add(lblDia);
		
		comboDia = new JComboBox<String>(listaDias);
		comboDia.setSelectedItem(null);
		this.add(comboDia);
		
		lblMes = new JLabel("Mes");
		this.add(lblMes);
		
		comboMes = new JComboBox<String>(listaMeses);
		comboMes.setSelectedItem(null);
		this.add(comboMes);
		
		lblAnio = new JLabel("Anio");
		this.add(lblAnio);
		
		comboAnio = new JComboBox<String>(listaAnio);
		comboAnio.setSelectedItem(null);
		this.add(comboAnio);
		
		btnBuscarFunciones = new JButton("Buscar funciones");
		btnBuscarFunciones.addActionListener(e -> {
			CineController cineController = CineController.getInstance();
			String cuitCine = ((String)comboCine.getSelectedItem()).split(" - ")[0];
			int idPeli = Integer.parseInt(((String)comboPelicula.getSelectedItem()).split(" - ")[0]);
			LocalDate fecha = LocalDate.of(Integer.valueOf((String)comboAnio.getSelectedItem()), 
					Integer.valueOf((String)comboMes.getSelectedItem()),
					Integer.valueOf((String)comboDia.getSelectedItem()));
			Vector<String> funciones = cineController.getListadoFunciones(cuitCine, idPeli, fecha);
			if(funciones.size() == 0) {
				JOptionPane.showMessageDialog(null,"No se han encontrado funciones para los datos ingresados!");
				comboFuncion.setSelectedItem(null);
				comboFuncion.setModel(null);
			}else {
				ComboBoxModel<String> funcionModel = new DefaultComboBoxModel<String>(funciones);
				comboFuncion.setModel(funcionModel);
			}
				
		});
		this.add(btnBuscarFunciones);
		
		lblFuncion = new JLabel("Funcion");
		this.add(lblFuncion);
		
		comboFuncion = new JComboBox<String>();
		this.add(comboFuncion);
		
		lblCantidad = new JLabel("Cantidad");
		this.add(lblCantidad);
		
		comboCantidad = new JComboBox<String>(listaCantidad);
		this.add(comboCantidad);
		
		btnAsientos = new JButton("Seleccionar asientos");
		btnAsientos.addActionListener(e -> {
			if(asientos == null) {
				int id = Integer.parseInt(((String)comboFuncion.getSelectedItem()).split(" - ")[0]);
				Funcion f = CineController.getInstance().getFuncion(id);
				asientos = new FormAsientos(f);
			}
			asientos.setAlwaysOnTop(true);
			asientos.setVisible(true);
		});
		this.add(btnAsientos);
		
		lblFormaPago = new JLabel("Forma de Pago");
		this.add(lblFormaPago);
		
		comboFormaPago = new JComboBox<>(listaFormasPago);
		comboFormaPago.setSelectedItem(null);
		comboFormaPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
		    {
		        String formaPago = (String)comboFormaPago.getSelectedItem();
		        if(!formaPago.equals("Efectivo")) {
		        	btnFormaPago.setVisible(true);
		        }else{
		        	btnFormaPago.setVisible(false);
		        }
		    }
		});
		this.add(comboFormaPago);
		
		btnFormaPago = new JButton("Datos Tarjeta");
		btnFormaPago.setVisible(false);
		btnFormaPago.addActionListener(e -> {
			if(datosTarjeta == null)
				datosTarjeta = new FormTarjeta();
			datosTarjeta.setAlwaysOnTop(true);
			datosTarjeta.setVisible(true);
		});
		this.add(btnFormaPago);
		
		lblDescuento = new JLabel("Descuentos");
		this.add(lblDescuento);
		
		tabDescuentos = new JTable();
		tabDescuentos.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		mibarra = new JScrollPane();
		mibarra.setBounds(40, 300, 400, 130);
		
		tablaDescuentos = new TablaDescuentos();
		
		mibarra.setViewportView(tabDescuentos);
		
		btnConfirmar = new JButton();
		btnConfirmar.setText("Confirmar");
		btnConfirmar.addActionListener(e -> {
			VentaController ventaController = VentaController.getInstance();
			String cuitCine = ((String)comboCine.getSelectedItem()).split(" - ")[0];
			String nombrePeli = (String)comboPelicula.getSelectedItem();
			//A la venta no deberia pasarsele una Funcion en vez de salaNombre y el horario? La funcion tiene ambas.
			/*ventaController.venderBoleteria(cuitCine, nombrePeli, salaNombre, horario, 
											formaPago, descuentoNombre, asientos);*/
			JOptionPane.showMessageDialog(null,"Venta realizada!");
			this.setVisible(false);
		});
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
		fechaContainer.add(btnBuscarFunciones);
		
		JPanel funcionContainer = new JPanel();
		funcionContainer.add(lblFuncion);
		funcionContainer.add(comboFuncion);
		
		JPanel cantContainer = new JPanel();
		cantContainer.add(lblCantidad);
		cantContainer.add(comboCantidad);
		cantContainer.add(btnAsientos);
		
		JPanel formaContainer = new JPanel();
		formaContainer.add(lblFormaPago);
		formaContainer.add(comboFormaPago);
		formaContainer.add(btnFormaPago);
		
		JPanel descuentoContainer = new JPanel();
		descuentoContainer.add(lblDescuento);
		descuentoContainer.add(mibarra);
		
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

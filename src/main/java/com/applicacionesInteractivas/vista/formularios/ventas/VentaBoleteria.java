package com.applicacionesInteractivas.vista.formularios.ventas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.controllers.DescuentoController;
import com.applicacionesInteractivas.controllers.VentaController;
import com.applicacionesInteractivas.modelo.AsientoFuncion;
import com.applicacionesInteractivas.modelo.Funcion;
import com.applicacionesInteractivas.modelo.Venta;
import com.applicacionesInteractivas.modelo.descuento.Descuento;
import com.applicacionesInteractivas.modelo.medioDePago.Contado;
import com.applicacionesInteractivas.modelo.medioDePago.MedioDePago;
import com.applicacionesInteractivas.modelo.medioDePago.Tarjeta;
import com.applicacionesInteractivas.modelo.medioDePago.TarjetaCredito;
import com.applicacionesInteractivas.modelo.medioDePago.TarjetaDebito;
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
	private String[] listaFormasPago = {"EFECTIVO", "TARJETA DEBITO", "TARJETA CREDITO"};
	private JComboBox<String> comboFormaPago;
	private JButton btnFormaPago;
	private JLabel lblDescuento;
	private JTable tabDescuentos;
	private TablaDescuentos tablaDescuentos;
	private JScrollPane mibarra;
	private JButton btnConfirmar;
	private FormTarjeta datosTarjeta;
	private FormAsientos asientos;
	
	public VentaBoleteria() {

		this.setSize(550, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		this.setTitle("Venta Boleteria");
		
		lblCine = new JLabel("Cine");
		lblCine.setBounds(20, 30, 120, 28);
		getContentPane().add(lblCine);
		
		listadoCines = CineController.getInstance().getListadoCines();
		ComboBoxModel<String> cineModel = new DefaultComboBoxModel<String>(listadoCines);
		comboCine = new JComboBox<String>();
		comboCine.setModel(cineModel);
		comboCine.setSelectedItem(null);
		comboCine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
		    {
				String cuit = ((String)comboCine.getSelectedItem()).split(" - ")[0];
				tablaDescuentos.setDescuentos(DescuentoController.getInstance().getDescuentosPorCineVigentes(cuit));
		        tabDescuentos.setModel(tablaDescuentos);
		        tablaDescuentos.fireTableDataChanged();
		    }
		});
		comboCine.setBounds(130, 30, 200, 28);
		getContentPane().add(comboCine);
		
		lblPelicula = new JLabel("Pelicula");
		lblPelicula.setBounds(20, 70, 120, 28);
		getContentPane().add(lblPelicula);
		
		listadoPeliculas = CineController.getInstance().getListadoPeliculas();
		ComboBoxModel<String> peliculaModel = new DefaultComboBoxModel<String>(listadoPeliculas);
		comboPelicula = new JComboBox<String>();
		comboPelicula.setModel(peliculaModel);
		comboPelicula.setSelectedItem(null);
		comboPelicula.setBounds(130, 70, 200, 28);
		getContentPane().add(comboPelicula);
		
		lblDia = new JLabel("Dia");
		lblDia.setBounds(20, 110, 30, 28);
		getContentPane().add(lblDia);
		
		comboDia = new JComboBox<String>(listaDias);
		comboDia.setSelectedItem(null);
		comboDia.setBounds(50, 110, 40, 28);
		getContentPane().add(comboDia);
		
		lblMes = new JLabel("Mes");
		lblMes.setBounds(100, 110, 30, 28);
		getContentPane().add(lblMes);
		
		comboMes = new JComboBox<String>(listaMeses);
		comboMes.setSelectedItem(null);
		comboMes.setBounds(130, 110, 40, 28);
		getContentPane().add(comboMes);
		
		lblAnio = new JLabel("Anio");
		lblAnio.setBounds(180, 110, 30, 28);
		getContentPane().add(lblAnio);
		
		comboAnio = new JComboBox<String>(listaAnio);
		comboAnio.setSelectedItem(null);
		comboAnio.setBounds(210, 110, 60, 28);
		getContentPane().add(comboAnio);
		
		btnBuscarFunciones = new JButton("Buscar funciones");
		btnBuscarFunciones.addActionListener(e -> {
			CineController cineController = CineController.getInstance();
			String cuitCine = (String)comboCine.getSelectedItem();//((String)comboCine.getSelectedItem()).split(" - ")[0];
			String pelicula = (String)comboPelicula.getSelectedItem();//((String)comboPelicula.getSelectedItem()).split(" - ")[0];
			
			String anio = (String)comboAnio.getSelectedItem();
			String mes = (String)comboMes.getSelectedItem();
			String dia = (String)comboDia.getSelectedItem();
			if(cuitCine == null || pelicula == null || anio == null || mes == null || dia == null) {
				JOptionPane.showMessageDialog(null, "Debe completar los campos Cine, Pelicula y Fecha para buscar funciones!", 
											"Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			cuitCine = cuitCine.split(" - ")[0];
			pelicula = pelicula.split(" - ")[0];
			int idPeli = Integer.parseInt(pelicula);
			LocalDate fecha = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
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
		btnBuscarFunciones.setBounds(280, 110, 140, 28);
		getContentPane().add(btnBuscarFunciones);
		
		lblFuncion = new JLabel("Funcion");
		lblFuncion.setBounds(20, 150, 120, 28);
		getContentPane().add(lblFuncion);
		
		comboFuncion = new JComboBox<String>();
		comboFuncion.setBounds(130, 150, 110, 28);
		getContentPane().add(comboFuncion);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(20, 190, 120, 28);
		getContentPane().add(lblCantidad);
		
		comboCantidad = new JComboBox<String>(listaCantidad);
		comboCantidad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
		    {
				int cantidad = Integer.parseInt((String)comboCantidad.getSelectedItem());
				String funcion = (String)comboFuncion.getSelectedItem();
				if(funcion == null ) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una funcion.", "Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				funcion = funcion.split(" - ")[0];
				int id = Integer.parseInt(funcion);
				Funcion f = CineController.getInstance().getFuncion(id);
				if(asientos != null && asientos.isVisible())
					asientos.setVisible(false);
				try {
					asientos = new FormAsientos(f, cantidad);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }
		});
		comboCantidad.setBounds(130, 190, 110, 28);
		getContentPane().add(comboCantidad);
		
		btnAsientos = new JButton("Seleccionar asientos");
		btnAsientos.addActionListener(e -> {
			if(asientos == null) {
				String funcion = (String)comboFuncion.getSelectedItem();
				if(funcion == null ) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una funcion.", "Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				funcion = funcion.split(" - ")[0];
				int id = Integer.parseInt(funcion);
				Funcion f = CineController.getInstance().getFuncion(id);
				try {
					asientos = new FormAsientos(f, Integer.parseInt((String)comboCantidad.getSelectedItem()));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			asientos.setVisible(true);
		});
		btnAsientos.setBounds(250, 190, 160, 28);
		getContentPane().add(btnAsientos);
		
		lblFormaPago = new JLabel("Forma de Pago");
		lblFormaPago.setBounds(20, 230, 120, 28);
		getContentPane().add(lblFormaPago);
		
		comboFormaPago = new JComboBox<>(listaFormasPago);
		comboFormaPago.setSelectedItem(null);
		comboFormaPago.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
		    {
		        String formaPago = (String)comboFormaPago.getSelectedItem();
		        if(!formaPago.equals("EFECTIVO")) {
		        	btnFormaPago.setVisible(true);
		        }else{
		        	btnFormaPago.setVisible(false);
		        	if(datosTarjeta != null)
		        		datosTarjeta.setVisible(false);
		        }
		    }
		});
		comboFormaPago.setBounds(130, 230, 110, 28);
		getContentPane().add(comboFormaPago);
		
		btnFormaPago = new JButton("Datos Tarjeta");
		btnFormaPago.setVisible(false);
		btnFormaPago.addActionListener(e -> {
			if(datosTarjeta == null)
				datosTarjeta = new FormTarjeta();
			datosTarjeta.setVisible(true);
		});
		btnFormaPago.setBounds(250, 230, 160, 28);
		getContentPane().add(btnFormaPago);
		
		lblDescuento = new JLabel("Descuentos");
		lblDescuento.setBounds(20, 270, 120, 28);
		getContentPane().add(lblDescuento);
		
		tabDescuentos = new JTable();
		tabDescuentos.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		mibarra = new JScrollPane();
		mibarra.setBounds(20, 300, 500, 130);
		getContentPane().add(mibarra);
		
		tablaDescuentos = new TablaDescuentos();
		
		mibarra.setViewportView(tabDescuentos);
		
		btnConfirmar = new JButton();
		btnConfirmar.setText("Confirmar");
		btnConfirmar.addActionListener(e -> {
			Venta venta = null ;
			int cantidad = Integer.parseInt((String)comboCantidad.getSelectedItem());
			VentaController ventaController = VentaController.getInstance();
			String cuitCine = ((String)comboCine.getSelectedItem()).split(" - ")[0];
			List<Descuento> descuentos = DescuentoController.getInstance().getDescuentosPorCineVigentes(cuitCine);
			int idFuncion = Integer.parseInt(((String)comboFuncion.getSelectedItem()).split(" - ")[0]);
			String formaPago = (String)comboFormaPago.getSelectedItem();
			List<AsientoFuncion> asientosVenta = new ArrayList<AsientoFuncion>();
			asientosVenta = this.asientos.obtenerAsientosSeleccionados();
			MedioDePago medioDePago;
			if(formaPago.equals("EFECTIVO"))
				medioDePago = new Contado();
			else {
				if(datosTarjeta == null)
					datosTarjeta = new FormTarjeta();
				Tarjeta tarjeta = datosTarjeta.getDatosTarjeta(formaPago);
				
				if(formaPago.equals("TARJETA CREDITO"))
					medioDePago = tarjeta;
				else
					medioDePago = tarjeta;
			}

			switch(this.validaDatosVenta(asientosVenta, cantidad, medioDePago)) {
				case -1:
					JOptionPane.showMessageDialog(null, "La cantidad de asientos reservados no coincide con la cantidad pedida.", "Error", JOptionPane.WARNING_MESSAGE);
					asientos.setVisible(true);
					return;
				case -2:
					JOptionPane.showMessageDialog(null, "Hay campos sin rellenar en los datos de la tarjeta.", "Error", JOptionPane.WARNING_MESSAGE);
					datosTarjeta.setVisible(true);
					return;
				case -3:
					JOptionPane.showMessageDialog(null, "Los datos de la tarjeta ingresados no cumplen con las longitudes requeridas.\n"
														+"Numero: 16 digitos. Vencimiento: 4 digitos. Codigo: 4 digitos(AMEX), 3 digitos(Visa, Master)", "Error", JOptionPane.WARNING_MESSAGE);
					datosTarjeta.setVisible(true);
					return;
					
			}
			
			double totalVenta = ventaController.calcularPrecioFinal(cantidad, descuentos);
			
			int respuesta = JOptionPane.showConfirmDialog(null, "El total a pagar es de $"+totalVenta+". Desea continuar?",
														"Question",JOptionPane.YES_NO_OPTION);
			
			if(respuesta == JOptionPane.YES_OPTION) {
				venta = ventaController.venderBoleteria(cuitCine, idFuncion, totalVenta, medioDePago, asientosVenta);
			}else {
				return;
			}

			JOptionPane.showMessageDialog(null,"Venta realizada! Su codigo de autorizacion es " + Integer.toString(venta.getId()) );
			this.setVisible(false);
		});
		btnConfirmar.setBounds(230, 440, 120, 28);
		getContentPane().add(btnConfirmar);
	}
	
	private int validaDatosVenta(List<AsientoFuncion> asientos, int cant, MedioDePago medioPago) {
		
		if(asientos.size() != cant)
			return -1;
		
		if(medioPago.toString().equals("TARJETA CREDITO") || medioPago.toString().equals("TARJETA DEBITO"))
			return this.datosTarjeta.validarDatosTarjeta();
		
		return 0;
	}
}

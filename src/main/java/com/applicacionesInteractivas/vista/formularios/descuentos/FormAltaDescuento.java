package com.applicacionesInteractivas.vista.formularios.descuentos;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.controllers.DescuentoController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class FormAltaDescuento extends JFrame{
	
	/**
	 * 
	 */
	private JPanel mainPanel;
	
	private JLabel lblNombreDescuento;
	private JTextField txtNombreDescuento;
	private JLabel lblVigenciaDesde;
	private JTextField txtVigenciaDesde;
	private JLabel lblVigenciaHasta;
	private JTextField txtVigenciaHasta;

	private JLabel lblTipoDescuento;
	private JTextField txtTipoDescuento;

	private Vector<String> listadoCines;
	private JLabel lblCine;
	private JComboBox<String> comboCine;
	private JPanel cineContainer;

	private JButton btnConfirm;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;

	private String cineCuil;
	
	private static final long serialVersionUID = -7869162737881214117L;
	public FormAltaDescuento() {
		
		this.setSize(320, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Crear Descuento");

		lblCine = new JLabel("Cine");
		listadoCines = CineController.getInstance().getListadoCines();
		ComboBoxModel<String> cineModel = new DefaultComboBoxModel<String>(listadoCines);
		comboCine = new JComboBox<String>(cineModel);
		comboCine.setSelectedItem(null);
		comboCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String selectedItem = (String) comboCine.getSelectedItem();
				String[] cine = selectedItem.split(" - ");
				cineCuil = cine[0];
			}});
		this.add(comboCine);

		
		lblNombreDescuento = new JLabel();
		lblNombreDescuento.setText("Nombre descuento");
		this.add(lblNombreDescuento);
		
		txtNombreDescuento = new JTextField();
		txtNombreDescuento.setColumns(12);
		this.add(txtNombreDescuento);
		
		lblVigenciaDesde = new JLabel();
		lblVigenciaDesde.setText("Vigencia desde");
		lblVigenciaDesde.setToolTipText("La fecha es de formato dd/mm/aaaa");
		this.add(lblVigenciaDesde);
		
		txtVigenciaDesde = new JTextField();
		txtVigenciaDesde.setColumns(12);
		txtVigenciaDesde.setToolTipText("La fecha es de formato dd/mm/aaaa");
		this.add(txtVigenciaDesde);

		lblVigenciaHasta = new JLabel();
		lblVigenciaHasta.setText("Vigencia hasta");
		lblVigenciaHasta.setToolTipText("La fecha es de formato dd/mm/aaaa");
		this.add(lblVigenciaHasta);
		
		txtVigenciaHasta = new JTextField();
		txtVigenciaHasta.setColumns(12);
		txtVigenciaHasta.setToolTipText("La fecha es de formato dd/mm/aaaa");
		this.add(txtVigenciaHasta);

		lblTipoDescuento = new JLabel();
		lblTipoDescuento.setText("Tipo descuento");
		this.add(lblTipoDescuento);

		txtTipoDescuento = new JTextField();
		txtTipoDescuento.setColumns(12);
		this.add(txtTipoDescuento);

		lblTipoDescuento.setToolTipText("Para descuentos tipo 2x1, tipear 2x1. Para descuentos porcentuales, tipear el numero con el signo porcentaje al lado");
		txtTipoDescuento.setToolTipText("Para descuentos tipo 2x1, tipear 2x1. Para descuentos porcentuales, tipear el numero con el signo porcentaje al lado");


		btnConfirm = new JButton("Confirmar");
		this.add(btnConfirm);
		
		panel1 = new JPanel();
		panel1.add(lblNombreDescuento);
		panel1.add(txtNombreDescuento);
		
		panel2 = new JPanel();
		panel2.add(lblVigenciaDesde);
		panel2.add(txtVigenciaDesde);
		
		panel3 = new JPanel();
		panel3.add(lblVigenciaHasta);
		panel3.add(txtVigenciaHasta);

		panel4 = new JPanel();
		panel4.add(lblTipoDescuento);
		panel4.add(txtTipoDescuento);
		
		panel5 = new JPanel();
		panel5.add(btnConfirm);
		cineContainer = new JPanel();
		cineContainer.add(lblCine);
		cineContainer.add(comboCine);

		btnConfirm.addActionListener(e -> {
			DescuentoController descuento = DescuentoController.getInstance();
			descuento.crearDescuento(cineCuil, txtNombreDescuento.getText(),
					txtVigenciaDesde.getText(),
					txtVigenciaHasta.getText(),
					txtTipoDescuento.getText());
			JOptionPane.showMessageDialog(null,"Descuento creado!");
			this.setVisible(false);
		});
		mainPanel = new JPanel();

		mainPanel.add(cineContainer);
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		
		getContentPane().add(mainPanel);
	}
}

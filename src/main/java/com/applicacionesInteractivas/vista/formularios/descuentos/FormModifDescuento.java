package com.applicacionesInteractivas.vista.formularios.descuentos;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.DescuentoController;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaDescuentos;

public class FormModifDescuento extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7611922162786588565L;
	private JLabel lblCuit;
	private JTextField txtCuit;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblVigenciaDesde;
	private JTextField txtVigenciaDesde;
	private JLabel lblVigenciaHasta;
	private JTextField txtVigenciaHasta;
	private JLabel lblprodAComprar;
	private JTextField txtProdAComprar;
	private JLabel lblprodAPagar;
	private JTextField txtProdAPagar;
	private JLabel lblporcentaje;
	private JTextField txtPorcentaje;
	private JButton btnModificar;
	private JTable tabCines;
	private TablaDescuentos tablaDescuentos;
	private JPanel mainPanel;
	private JScrollPane mibarra;
	
	public FormModifDescuento() {
		
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Modificar Descuento");
		mainPanel = new JPanel();
		
		lblCuit = new JLabel("CUIT");
		lblNombre = new JLabel("Nombre");
		lblVigenciaDesde = new JLabel("Vigencia desde");
		lblVigenciaHasta = new JLabel("Vigencia Hasta");
		lblprodAComprar = new JLabel("Cantidad de productos a comprar");
		lblprodAPagar= new JLabel("Cantidad de productos a pagar");
		lblporcentaje= new JLabel("Porcentaje sobre la venta");
		
		txtCuit = new JTextField();
		txtCuit.setColumns(12);
		txtCuit.setEnabled(false);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(12);
		txtNombre.setEnabled(false);
		
		txtVigenciaDesde = new JTextField();
		txtVigenciaDesde.setColumns(12);
		txtVigenciaDesde.setEnabled(false);
		
		txtVigenciaHasta = new JTextField();
		txtVigenciaHasta.setColumns(12);
		txtVigenciaHasta.setEnabled(false);
		
		txtProdAComprar = new JTextField();
		txtProdAComprar.setColumns(12);
		txtProdAComprar.setEnabled(false);

		txtProdAPagar = new JTextField();
		txtProdAPagar.setColumns(12);
		txtProdAPagar.setEnabled(false);

		txtPorcentaje = new JTextField();
		txtPorcentaje.setColumns(12);
		txtPorcentaje.setEnabled(false);
		
		btnModificar = new JButton("Modificar Descuento");
		btnModificar.addActionListener(e -> {
			DescuentoController descuentoController= DescuentoController.getInstance();
			descuentoController.modificarDescuento(txtCuit.getText(), txtNombre.getText(),
				txtVigenciaDesde.getText(),
				txtVigenciaHasta.getText(),
				Integer.parseInt(txtProdAComprar.getText()),
				Integer.parseInt(txtProdAPagar.getText()),
				Integer.parseInt(txtPorcentaje.getText()));
			JOptionPane.showMessageDialog(null,"Descuento modificado!");
			this.setVisible(false);
		});
		btnModificar.setEnabled(false);
		
		JPanel cuitContainer = new JPanel();
		cuitContainer.add(lblCuit);
		cuitContainer.add(txtCuit);
		
		JPanel nombreContainer = new JPanel();
		nombreContainer.add(lblNombre);
		nombreContainer.add(txtNombre);
		
		JPanel domContainer = new JPanel();
		domContainer.add(lblVigenciaDesde);
		domContainer.add(txtVigenciaDesde);
		
		JPanel cantContainer = new JPanel();
		cantContainer.add(lblVigenciaHasta);
		cantContainer.add(txtVigenciaHasta);
		
		JPanel capContainer = new JPanel();
		capContainer.add(lblprodAComprar);
		capContainer.add(txtProdAComprar);

		JPanel aPagarContainer = new JPanel();
		aPagarContainer.add(lblprodAPagar);
		aPagarContainer.add(txtProdAPagar);

		JPanel porcentajeContainer = new JPanel();
		porcentajeContainer.add(lblporcentaje);
		porcentajeContainer.add(txtPorcentaje);
		
		JPanel btnContainer = new JPanel();
		btnContainer.add(btnModificar);
		
		tabCines = new JTable();
		tabCines.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tabCines.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            try{
		            	txtCuit.setText((String) table.getValueAt(row, 0));
			            txtNombre.setText((String) table.getValueAt(row, 1));

			            txtVigenciaDesde.setText(((LocalDate) table.getValueAt(row, 2)).toString());
			            txtVigenciaDesde.setEnabled(true);
			            txtVigenciaHasta.setText(((LocalDate)table.getValueAt(row, 3)).toString());
			            txtVigenciaHasta.setEnabled(true);
						txtProdAComprar.setText(((Integer)table.getValueAt(row, 4)).toString());
			            txtProdAComprar.setEnabled(true);

						txtProdAPagar.setText(((Integer)table.getValueAt(row, 5)).toString());
						txtProdAPagar.setEnabled(true);
						txtPorcentaje.setText(((Integer)table.getValueAt(row, 6)).toString());
						txtPorcentaje.setEnabled(true);
			            btnModificar.setEnabled(true);
		            }
		            catch(Exception e){
		            	e.printStackTrace();
		            }
		        }
		    }
		});

		JPanel tablaCinesContainer = new JPanel();
		
		mibarra = new JScrollPane();
		mibarra.setBounds(40, 300, 400, 130);
		
		tablaDescuentos = new TablaDescuentos();
		tablaDescuentos.setDescuentos(DescuentoController.getInstance().getDescuentos());
		
		tabCines.setModel(tablaDescuentos);
		mibarra.setViewportView(tabCines);
		
		tablaCinesContainer.add(mibarra);
		
		mainPanel.add(cuitContainer);
		mainPanel.add(nombreContainer);
		mainPanel.add(domContainer);
		mainPanel.add(cantContainer);
		mainPanel.add(capContainer);
		mainPanel.add(aPagarContainer);
		mainPanel.add(porcentajeContainer);
		mainPanel.add(btnContainer);
		mainPanel.add(tablaCinesContainer);

		getContentPane().add(mainPanel);
		
	}
}

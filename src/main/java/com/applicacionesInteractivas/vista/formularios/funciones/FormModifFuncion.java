package com.applicacionesInteractivas.vista.formularios.funciones;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.applicacionesInteractivas.controllers.CineController;
import com.applicacionesInteractivas.vista.formularios.tabla.TablaFunciones;

public class FormModifFuncion extends JFrame{

	private static final long serialVersionUID = 1785958213568294559L;
	private JLabel lblHorario;
	private JLabel lblSala;
	private JLabel lblCine;
	private JLabel lblPelicula;
	private JTextField txtHorario;
	private JTextField txtSala;
	private JTextField txtCine;
	private JTextField txtPelicula;
	private JButton btnModificar;
	private JTable tablaFunciones;
	private TablaFunciones tablaFuncionesModel;
	private JScrollPane miBarra;
	private JPanel horarioContainer, cineContainer,peliculaContainer,salaContainer, btnContainer, tableContainer;
	private JPanel mainPanel;
	
	public FormModifFuncion() {
		
		this.setSize(600, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Modificar Funcion");
		mainPanel = new JPanel();
		
		lblHorario = new JLabel("Horario");
		this.add(lblHorario);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(12);
		txtHorario.setEditable(false);
		this.add(txtHorario);
		
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
//			cine.modificarFuncion(LocalDateTime.parse(txtHorario.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
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
		            	txtCine.setText((String) table.getValueAt(row, 0));
						txtSala.setText((String) table.getValueAt(row, 1));
						txtPelicula.setText((String) table.getValueAt(row, 2));
						txtHorario.setText((String) table.getValueAt(row, 3)
								);
		            	txtSala.setEditable(true);
						txtCine.setEditable(true);
						txtPelicula.setEditable(true);
						txtHorario.setEditable(true);
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
		horarioContainer.add(lblHorario);
		horarioContainer.add(txtHorario);
		
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

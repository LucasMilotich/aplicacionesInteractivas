package com.applicacionesInteractivas.vista.formularios.ventas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.applicacionesInteractivas.bd.AsientoFuncionDAO;
import com.applicacionesInteractivas.modelo.AsientoFuncion;
import com.applicacionesInteractivas.modelo.Funcion;

public class FormAsientos extends JFrame{

	private static final long serialVersionUID = 2438572568138476459L;
	private JButton btnGuardar;
	private JPanel panel, mainPanel;
	private JToggleButton[][] botones;
	private AsientoFuncion[][] asientos;
	private int cant;
	
	public FormAsientos(Funcion f, int cantidad) throws SQLException {
		//this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Seleccion asientos");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        cant = cantidad;
        int filas = f.getSala().getFilas();
        int columnas = f.getSala().getColumnas();
        this.setSize((columnas * 70) + 150, (filas* 50));
        botones = new JToggleButton[filas][columnas];
        asientos = new AsientoFuncion[filas][columnas];
        panel = new JPanel(new GridLayout(filas, columnas));
        for (int row = 0; row < filas; row++) {
        	JLabel lblFila = new JLabel("Fila "+ Integer.toString(row+1));
        	panel.add(lblFila);
            for (int column = 0; column < columnas; column++) {
                final JToggleButton button = new JToggleButton(String.valueOf(column + 1));
                AsientoFuncion af = AsientoFuncionDAO.getInstance().findBy(f.getId(), row, column);
                if(af.isOcupado()) {
                	button.setSelected(true);
                	button.setEnabled(false);
                	button.setOpaque(true);
                	button.setBackground(Color.red);
                	button.setText("Ocup.");
                }
                button.setSize(5, 5);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
                        boolean selected = abstractButton.getModel().isSelected();
                        
                        if (selected) {
                        	if (cant == 0) {
                            	abstractButton.getModel().setSelected(false);
                            	return;
                            }
                        	cant--;
                        } else {
                        	cant++;
                        }
                    }
                });
                botones[row][column] = button;
                asientos[row][column] = af;
                panel.add(button);
            }
        }
        
        btnGuardar = new JButton("Guardar y volver");
        btnGuardar.addActionListener(e -> {
        	this.setVisible(false);
        });
        this.add(btnGuardar);
		
		mainPanel = new JPanel();
		mainPanel.add(panel);
		mainPanel.add(btnGuardar);
		
		getContentPane().add(mainPanel);
	}

	public List<AsientoFuncion> obtenerAsientosSeleccionados() {
		List<AsientoFuncion> asientos = new ArrayList<AsientoFuncion>();
		//Recorrer la lista de ToggleButton y fijarse cuales estan selected, si es que estan enabled primero.
		for(int i = 0; i< this.botones.length;i++) {
			for(int j = 0; j < this.botones[i].length;j++) {
				if(botones[i][j].isEnabled() && botones[i][j].isSelected()) {
					asientos.add(this.asientos[i][j]);
				}
			}
		}
		return asientos;
	}
}

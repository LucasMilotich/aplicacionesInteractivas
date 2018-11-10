package com.applicacionesInteractivas.vista.formularios.utils;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ValidadorCampo {

    /**
     * Solo valida para los JTextField
     *
     * @param length of field
     * @return keyadapter
     */
    public static KeyAdapter numberValidator(int length, String nombreCampo) {
        return new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((JTextField) e.getComponent()).getText().length() > length){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "El campo " + nombreCampo+"solo permite " + Integer.toString(length) + " digitos");
                }

                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)
                    || (c == KeyEvent.VK_SLASH || c == KeyEvent.VK_COMMA || c == KeyEvent.VK_PERIOD))) {
                    JOptionPane.showMessageDialog(null, "El campo solo permite numeros");
                    e.consume();
                }
            }
        };
    }

    public static KeyAdapter lengthValidador(int length, String nombreCampo) {
        return new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((JTextField) e.getComponent()).getText().length() > 10)
                    e.consume();

            }
        };
    }

    public static KeyAdapter validadorHora(String nombreCampo) {
        return new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((JTextField) e.getComponent()).getText().length() + 1 > 4 ){
                    try {
                        LocalTime.parse(((JTextField) e.getComponent()).getText().concat(String.valueOf(c)), DateTimeFormatter.ofPattern("HH:mm"));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "El campo " + nombreCampo+ " solo permite el formato HH:mm");
                        e.consume();
                    }

                }



            }
        };
    }

    public static KeyAdapter validadorFecha(String nombreCampo) {
        return new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((JTextField) e.getComponent()).getText().length() + 1 >= 10 ){
                    try {
                        LocalDate.parse(((JTextField) e.getComponent()).getText().concat(String.valueOf(c)), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "El campo " + nombreCampo+ " solo permite el formato dd/MM/yyyy");
                        e.consume();
                    }

                }



            }
        };
    }
}

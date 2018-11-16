package com.applicacionesInteractivas;


import com.applicacionesInteractivas.vista.formularios.JFormularioLogin;

public class Main {
    public static void main(String args[]){
        /*JFormularioMenuPpal jFormularioMenuPpal = new JFormularioMenuPpal(new ArrayList<IRol>());
        jFormularioMenuPpal.setVisible(true);*/
    	JFormularioLogin login = new JFormularioLogin();
    	login.setVisible(true);
    }
}

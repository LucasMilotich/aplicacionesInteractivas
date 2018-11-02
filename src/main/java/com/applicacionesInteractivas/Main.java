package com.applicacionesInteractivas;


import java.util.ArrayList;

import com.applicacionesInteractivas.modelo.rol.IRol;
import com.applicacionesInteractivas.vista.formularios.JFormularioMenuPpal;

public class Main {
    public static void main(String args[]){

        JFormularioMenuPpal jFormularioMenuPpal = new JFormularioMenuPpal(new ArrayList<IRol>());
        jFormularioMenuPpal.setVisible(true);
    	/*JFormularioLogin login = new JFormularioLogin();
    	login.setVisible(true);*/

    }


}

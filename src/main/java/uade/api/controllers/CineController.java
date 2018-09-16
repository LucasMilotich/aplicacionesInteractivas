package uade.api.controllers;

import uade.api.bd.CineDAO;
import uade.api.bd.FuncionDAO;
import uade.api.bd.PeliculaDAO;
import uade.api.bd.SalaDAO;
import uade.api.modelo.*;
import uade.api.modelo.medioDePago.MedioDePago;
import uade.api.vista.formularios.JFormularioAdminCines;
import uade.api.vista.formularios.JFormularioAdminPeliculas;
import uade.api.vista.formularios.JFormularioAdminSalas;

import java.util.Collection;
import java.util.List;

public class CineController {

    public CineController() {

        buildView();
        buildModel();
    }

    //    Modelo
    private List<Cine> cines;
    private List<Pelicula> peliculas;
    private List<Sala> salas;
    private List<Funcion> funciones;

    //    Vista
    private JFormularioAdminCines formularioAdminCines;
    private JFormularioAdminPeliculas formularioAdminPeliculas;
    private JFormularioAdminSalas formularioAdminSalas;


    private void buildView(){

        this.formularioAdminCines = new JFormularioAdminCines();
        this.formularioAdminPeliculas = new JFormularioAdminPeliculas();
        this.formularioAdminSalas = new JFormularioAdminSalas();

    }
    private void buildModel(){

        this.cines = CineDAO.getInstance().findAll();
        this.salas = SalaDAO.getInstance().findAll();
        this.peliculas = PeliculaDAO.getInstance().findAll();
        this.funciones = FuncionDAO.getInstance().findAll();

    }

    private Venta venderEntrada(Funcion funcion, Collection<AsientoFuncion> asientos, MedioDePago medioDePago){

        Venta venta;

        try {
           venta = new Venta().venderEntrada(funcion,asientos,medioDePago);
        } catch (Exception e){

        }

        return null;
    }
}

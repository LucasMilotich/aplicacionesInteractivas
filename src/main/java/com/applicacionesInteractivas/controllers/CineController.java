package com.applicacionesInteractivas.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.applicacionesInteractivas.bd.CineDAO;
import com.applicacionesInteractivas.bd.FuncionDAO;
import com.applicacionesInteractivas.bd.PeliculaDAO;
import com.applicacionesInteractivas.bd.SalaDAO;
import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.modelo.Funcion;
import com.applicacionesInteractivas.modelo.Pelicula;
import com.applicacionesInteractivas.modelo.Sala;
import com.applicacionesInteractivas.vista.formularios.cines.FormAltaCine;
import com.applicacionesInteractivas.vista.formularios.cines.FormElimCine;
import com.applicacionesInteractivas.vista.formularios.cines.FormModifCine;
import com.applicacionesInteractivas.vista.formularios.funciones.FormAltaFuncion;
import com.applicacionesInteractivas.vista.formularios.funciones.FormElimFuncion;
import com.applicacionesInteractivas.vista.formularios.funciones.FormModifFuncion;
import com.applicacionesInteractivas.vista.formularios.peliculas.FormAltaPelicula;
import com.applicacionesInteractivas.vista.formularios.peliculas.FormElimPelicula;
import com.applicacionesInteractivas.vista.formularios.peliculas.FormModifPelicula;
import com.applicacionesInteractivas.vista.formularios.salas.FormAltaSala;
import com.applicacionesInteractivas.vista.formularios.salas.FormElimSala;
import com.applicacionesInteractivas.vista.formularios.salas.FormModifSala;

public class CineController {

    private static CineController instance;

    public static CineController getInstance() {
        if (instance == null) {
            instance = new CineController();
            instance.buildModel();
        }
        return instance;
    }

    //    Modelo
    private List<Cine> cines = new ArrayList<Cine>();
    private List<Pelicula> peliculas = new ArrayList<Pelicula>();
    private List<Sala> salas = new ArrayList<Sala>();
    private List<Funcion> funciones = new ArrayList<Funcion>();

    //    Vista
    // Cine
    private FormAltaCine formularioAltaCine;
    private FormModifCine formularioModifCine;
    private FormElimCine formularioElimCine;

    // Sala
    private FormAltaSala formularioAltaSala;
    private FormModifSala formularioModifSala;
    private FormElimSala formularioElimSala;

    // Pelicula
    private FormAltaPelicula formularioAltaPelicula;
    private FormModifPelicula formularioModifPelicula;
    private FormElimPelicula formularioElimPelicula;

    // Funciones
    private FormAltaFuncion formularioAltaFuncion;
    private FormModifFuncion formularioModifFuncion;
    private FormElimFuncion formularioElimFuncion;

    /**
	 * getCines
	 * 
	 * Retorna la lista de cines que posee el Cine Controller.
	 * De ser la cantidad igual a 0, se van a buscar a la BD.
	 * 
	 * @param -
	 * @return List<Cine>
	 */
    public List<Cine> getCines() {
        if (cines.size() == 0) {
            return cines = CineDAO.getInstance().findAll();
        } else {
            return cines;
        }

    }
    
    /**
	 * getListadoCines
	 * 
	 * Retorna un arreglo con String's formados por el CUIT del cine y su nombre.
	 * 
	 * @param -
	 * @return Vector<String>
	 */
    public Vector<String> getListadoCines() {
        Vector<String> listado = new Vector<String>();
        for (Cine c : getCines()) {
            listado.add(c.getCuit() + " - " + c.getNombre());
        }

        return listado;
    }

    /**
	 * setCines
	 * 
	 * Setea en el atributo cines, una lista de cines pasada por parametro
	 * 
	 * @param cines
	 * @return -
	 */
    public void setCines(List<Cine> cines) {
        this.cines = cines;
    }
    
    /**
	 * getPeliculas
	 * 
	 * Retorna la lista de peliculas que posee el Cine Controller.
	 * De ser la cantidad igual a 0, se van a buscar a la BD.
	 * 
	 * @param -
	 * @return List<Pelicula>
	 */
    public List<Pelicula> getPeliculas() {
    	if (peliculas.size() == 0) {
            return peliculas = PeliculaDAO.getInstance().findAll();
        } else {
            return peliculas;
        }
    }

    /**
	 * getListadoPeliculas
	 * 
	 * Retorna un arreglo con String's formados por el id de la pelicula y su nombre.
	 * 
	 * @param -
	 * @return Vector<String>
	 */
    public Vector<String> getListadoPeliculas() {
    	
        Vector<String> listado = new Vector<String>();
        for (Pelicula p : this.getPeliculas()) {
            listado.add(p.getId() + " - " + p.getNombre());
        }

        return listado;
    }

    /**
	 * setPeliculas
	 * 
	 * Setea en el atributo peliculas, una lista de peliculas pasada por parametro
	 * 
	 * @param peliculas
	 * @return -
	 */
    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    /**
	 * getSalas
	 * 
	 * Retorna la lista de salas que posee el Cine Controller.
	 * De ser la cantidad igual a 0, se van a buscar a la BD.
	 * 
	 * @param -
	 * @return List<Sala>
	 */
    public List<Sala> getSalas() {
        if (salas.size() == 0) {
            return salas = SalaDAO.getInstance().findAll();
        } else {
            return salas;
        }
    }

    /**
	 * getListadoSalas
	 * 
	 * Retorna un arreglo con String's formados por el id de la sala(correspondiente a un cuit) y su nombre.
	 * 
	 * @param cuit
	 * @return Vector<String>
	 */
    public Vector<String> getListadoSalas(String cuit) {
        Vector<String> listado = new Vector<String>();
        for (Sala s : this.getSalas()) {
        	if(s.getCine().getCuit().equals(cuit))
        		listado.add(String.valueOf(s.getId()) + " - " + s.getNombre());
        }
        return listado;
    }

    /**
	 * setSalas
	 * 
	 * Setea en el atributo salas, una lista de salas pasada por parametro
	 * 
	 * @param salas
	 * @return -
	 */
    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    /**
	 * getFunciones
	 * 
	 * Retorna la lista de funciones que posee el Cine Controller.
	 * De ser la cantidad igual a 0, se van a buscar a la BD.
	 * 
	 * @param -
	 * @return List<Funcion>
	 */
    public List<Funcion> getFunciones() {
        if (funciones.size() == 0) {
            return funciones = FuncionDAO.getInstance().findAll();
        } else {
            return funciones;
        }
    }

    /**
	 * getListadoFunciones
	 * 
	 * Retorna un arreglo con String's formados por el id de la funcion
	 * (correspondiente a un cuit, pelicula y fecha) y la hora.
	 * 
	 * @param cuitCine, idPeli, fecha
	 * @return Vector<String>
	 */
    public Vector<String> getListadoFunciones(String cuitCine, int idPeli, LocalDate fecha) {
        Vector<String> listado = new Vector<String>();
        for (Funcion f : getFunciones()) {
        	if(f.getSala().getCine().getCuit().equals(cuitCine) && f.getPelicula().getId() == idPeli &&
        			f.getFecha().equals(fecha))
        		listado.add(f.getId() + " - " + f.getHora().toString());
        }
        return listado;
    }

    /**
	 * setFunciones
	 * 
	 * Setea en el atributo funciones, una lista de funciones pasada por parametro
	 * 
	 * @param funciones
	 * @return -
	 */
    public void setFunciones(List<Funcion> funciones) {
        this.funciones = funciones;
    }

    public FormAltaCine getFormularioAltaCine() {
        return formularioAltaCine;
    }

    public void setFormularioAltaCine(FormAltaCine formularioAltaCine) {
        this.formularioAltaCine = formularioAltaCine;
    }

    public FormModifCine getFormularioModifCine() {
        return formularioModifCine;
    }

    public void setFormularioModifCine(FormModifCine formularioModifCine) {
        this.formularioModifCine = formularioModifCine;
    }

    public FormElimCine getFormularioElimCine() {
        return formularioElimCine;
    }

    public void setFormularioElimCine(FormElimCine formularioElimCine) {
        this.formularioElimCine = formularioElimCine;
    }

    public FormAltaSala getFormularioAltaSala() {
        return formularioAltaSala;
    }

    public void setFormularioAltaSala(FormAltaSala formularioAltaSala) {
        this.formularioAltaSala = formularioAltaSala;
    }

    public FormModifSala getFormularioModifSala() {
        return formularioModifSala;
    }

    public void setFormularioModifSala(FormModifSala formularioModifSala) {
        this.formularioModifSala = formularioModifSala;
    }

    public FormElimSala getFormularioElimSala() {
        return formularioElimSala;
    }

    public void setFormularioElimSala(FormElimSala formularioElimSala) {
        this.formularioElimSala = formularioElimSala;
    }

    public FormAltaPelicula getFormularioAltaPelicula() {
        return formularioAltaPelicula;
    }

    public void setFormularioAltaPelicula(FormAltaPelicula formularioAltaPelicula) {
        this.formularioAltaPelicula = formularioAltaPelicula;
    }

    public FormModifPelicula getFormularioModifPelicula() {
        return formularioModifPelicula;
    }

    public void setFormularioModifPelicula(FormModifPelicula formularioModifPelicula) {
        this.formularioModifPelicula = formularioModifPelicula;
    }

    public FormElimPelicula getFormularioElimPelicula() {
        return formularioElimPelicula;
    }

    public void setFormularioElimPelicula(FormElimPelicula formularioElimPelicula) {
        this.formularioElimPelicula = formularioElimPelicula;
    }

    public FormAltaFuncion getFormularioAltaFuncion() {
        return formularioAltaFuncion;
    }

    public void setFormularioAltaFuncion(FormAltaFuncion formularioAltaFuncion) {
        this.formularioAltaFuncion = formularioAltaFuncion;
    }

    public FormModifFuncion getFormularioModifFuncion() {
        return formularioModifFuncion;
    }

    public void setFormularioModifFuncion(FormModifFuncion formularioModifFuncion) {
        this.formularioModifFuncion = formularioModifFuncion;
    }

    public FormElimFuncion getFormularioElimFuncion() {
        return formularioElimFuncion;
    }

    public void setFormularioElimFuncion(FormElimFuncion formularioElimFuncion) {
        this.formularioElimFuncion = formularioElimFuncion;
    }

    /**
	 * buildModel
	 * 
	 * Inicializa todas las listas que posee el Controller.
	 * 
	 * @param -
	 * @return -
	 */
    private void buildModel() {

        this.cines = CineDAO.getInstance().findAll();
        this.salas = SalaDAO.getInstance().findAll();
        this.peliculas = PeliculaDAO.getInstance().findAll();
        this.funciones = FuncionDAO.getInstance().findAll();

    }

    /**
	 * crearCine
	 * 
	 * Da de alta un Cine y lo agrega en la coleccion cines.
	 * 
	 * @param cuit, nombre, domicilio
	 * @return -
	 */
    public void crearCine(String cuit, String nombre, String domicilio) {

        this.cines.add(Cine.crearCine(cuit, nombre, domicilio));
    
    }

    /**
	 * modificarCine
	 * 
	 * Modifica un Cine.
	 * 
	 * @param cuit, nombre, domicilio
	 * @return -
	 */
    public void modificarCine(String cuit, String nombre, String domicilio) {
        
    	Cine c = this.getCine(cuit);
        Cine.modificarCine(c, cuit, nombre, domicilio, false);
    
    }

    /**
	 * eliminarCine
	 * 
	 * Elimina un Cine y lo remueve de la coleccion cines.
	 * 
	 * @param cuit
	 * @return -
	 */
    public void eliminarCine(String cuit) {

        Cine c = this.getCine(cuit);
        cines.remove(c);
        Cine.modificarCine(c, c.getCuit(), c.getNombre(), c.getDomicilio(), true);

    }

    /**
	 * getCine
	 * 
	 * Retorna un objeto Cine, si es que el mismo se encuentra en la coleccion de cines.
	 * De lo contrario retorna null.
	 * 
	 * @param cuit
	 * @return Cine
	 */
    public Cine getCine(String cuit) {

        for (Cine c : getCines()) {
            if (c.esCine(cuit))
                return c;
        }

        return null;
    }

    /**
	 * crearSala
	 * 
	 * Da de alta una Sala y la agrega en la coleccion salas.
	 * 
	 * @param nombre, files, columnas, cine
	 * @return -
	 */
    public void crearSala(String nombre, int filas, int columnas, Cine cine) {
    	Sala s = Sala.crearSala(nombre, filas, columnas, cine);
        this.salas.add(s);
        cine.agregarSala(s);
    }

    /**
	 * modificarSala
	 * 
	 * Modifica una Sala.
	 * 
	 * @param id, nombre, filas, columnas
	 * @return -
	 */
    public void modificarSala(int id, String nombre, int filas, int columnas) {

        Sala s = this.getSala(id);
        Sala.modificarSala(s, nombre, filas, columnas,s.isDeleted());

    }

    /**
	 * eliminarSala
	 * 
	 * Elimina una Sala y lo remueve de la coleccion salas.
	 * 
	 * @param id
	 * @return -
	 */
    public void eliminarSala(int id) {

        Sala s = this.getSala(id);
        salas.remove(s);
        Sala.eliminarSala(s);
        s.getCine().eliminarSala(s);

    }

    /**
	 * getSala
	 * 
	 * Retorna un objeto Sala, si es que el mismo se encuentra en la coleccion de salas.
	 * De lo contrario retorna null.
	 * 
	 * @param id
	 * @return Sala
	 */
    public Sala getSala(int id) {
        for (Sala s : getSalas()) {
            if (s.getId() == id)
                return s;
        }
        return null;
    }

    /**
	 * crearPelicula
	 * 
	 * Da de alta una Pelicula y la agrega en la coleccion peliculas.
	 * 
	 * @param nombre, director, genero, duracion, idioma, subtitulos, calificacion, observacion
	 * @return -
	 */
    public void crearPelicula(String nombre, String director, String genero, 
                              String duracion, String idioma, String subtitulos,double calificacion, String observacion) {
    	
    	this.peliculas.add(Pelicula.crearPelicula(nombre, director, genero, duracion, idioma, subtitulos, calificacion, observacion));
    
    }

    /**
	 * modificarPelicula
	 * 
	 * Modifica una Pelicula.
	 * 
	 * @param id, nombre, director, genero, duracion, idioma, subtitulos, calificacion, observacion
	 * @return -
	 */
    public void modificarPelicula(int id, String nombre, String director, String genero,
                                  String duracion, String idioma, String subtitulos, double calificacion, String observacion) {
        
    	Pelicula p = this.getPelicula(id);
        Pelicula.modificarPelicula(p, nombre, director, genero, duracion, idioma, subtitulos, calificacion, observacion, p.isDeleted());
    
    }

    /**
	 * eliminarPelicula
	 * 
	 * Elimina una Pelicula, a traves de su id, y luego lo remueve de la coleccion peliculas.
	 * 
	 * @param id
	 * @return -
	 */
    public void eliminarPelicula(int id) {
        
    	Pelicula p = this.getPelicula(id);
        peliculas.remove(p);
        Pelicula.eliminarPelicula(p);
    
    }

    /**
	 * getPelicula
	 * 
	 * Retorna un objeto Pelicula, si es que el mismo se encuentra en la coleccion de peliculas.
	 * De lo contrario retorna null.
	 * 
	 * @param id
	 * @return Pelicula
	 */
    public Pelicula getPelicula(int id) {
        for (Pelicula p : getPeliculas()) {
            if (p.esPelicula(id))
                return p;
        }
        return null;
    }
    
    /**
	 * esPeliculaEliminable
	 * 
	 * A traves del id de una pelicula, verificamos si la misma tiene funciones activas.
	 * De tener, retorna false.
	 * 
	 * @param id
	 * @return boolean
	 */
    public boolean esPeliculaEliminable(int id) {
    	return Pelicula.esPeliculaEliminable(id);
    }

    /**
	 * crearFuncion
	 * 
	 * Da de alta una Funcion y la agrega en la coleccion funciones.
	 * 
	 * @param pelicula, sala, fecha, hora
	 * @return -
	 */
    public void crearFuncion(Pelicula pelicula, Sala sala, LocalDate fecha, LocalTime hora) {
        Funcion f = Funcion.crearFuncion(pelicula,sala,fecha,hora);
        this.funciones.add(f);
    }

    /**
	 * modificarFuncion
	 * 
	 * Modifica una Funcion, obteniendola primero a traves del id.
	 * 
	 * @param idFuncion, fecha, hora
	 * @return -
	 */
    public void modificarFuncion(int idFuncion,LocalDate fecha, LocalTime hora) {
    	Funcion f = this.getFuncion(idFuncion);
    	Funcion.modificarFuncion(f, fecha, hora);
    }

    /**
	 * eliminarFuncion
	 * 
	 * Elimina una Funcion a traves de su id, y luego la remueve de la coleccion funciones.
	 * 
	 * @param idFuncion
	 * @return -
	 */
    public void eliminarFuncion(int idFuncion) {
    	Funcion f = this.getFuncion(idFuncion);
    	funciones.remove(f);
    	Funcion.eliminarFuncion(f);
    }

    /**
	 * getFuncion
	 * 
	 * Retorna un objeto Funcion, si es que el mismo se encuentra en la coleccion de funciones.
	 * De lo contrario retorna null.
	 *  
	 * @param id
	 * @return Funcion
	 */
    public Funcion getFuncion(int id) {
        for (Funcion f : funciones) {
            if (f.getId() == id)
                return f;
        }
        return null;
    }
    
    /**
	 * esFuncionEliminable
	 * 
	 * A traves del id de una funcion, verificamos si la misma tiene entradas vendidas.
	 * De tener, retorna false.
	 * 
	 * @param id
	 * @return boolean
	 */
    public boolean esFuncionEliminable(int id) {
    	return Funcion.esFuncionEliminable(id);
    }
    
}

package uade.api.modelo;

import java.util.List;

public class Cine {

    public Cine(String cuit, String nombre, String domicilio, int cantidadSalas, int capacidadTotal, List<Pelicula> peliculas, List<Funcion> funciones, List<Sala> salas) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cantidadSalas = cantidadSalas;
        this.capacidadTotal = capacidadTotal;
        this.peliculas = peliculas;
        this.funciones = funciones;
        this.salas = salas;
    }

    public Cine(String cuit, String nombre, String domicilio, int cantidadSalas, int capacidadTotal) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cantidadSalas = cantidadSalas;
        this.capacidadTotal = capacidadTotal;
    }

    private String cuit;
    private String nombre;
    private String domicilio;
    private int cantidadSalas;
    private int capacidadTotal;
    private List<Pelicula> peliculas;
    private List<Funcion> funciones;
    private List<Sala> salas;



    public  Entrada  retirarEntrada(String codAutenticacion) {
        return null;
    }
    public List<Funcion> consultarFunciones(Pelicula pelicula, String hora) {
        return null;
    }
    public  Pelicula  altaPelicula(String nombre, String director, int duracion, String idioma, String[] subtitulos, int calificacion, String obs) {
        return null;
    }
    public  Pelicula  modificarPelicula(String nombre, String director, int duracion, String idioma, String[] subtitulos, int calificacion, String obs) {
        return null;
    }
    public  boolean  eliminarPelicula(int idPelicula) {
        return false;
    }
    public  Sala  altaSala(String nombre, int capacidad) {
        return null;
    }
    public  Sala  modificarSala(String nombre, int capacidad) {
        return null;
    }
    public  boolean  eliminarSala(int idSala) {
        return false;
    }
    public  Venta  consultarVenta(String id) {
        return null;
    }



    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getCantidadSalas() {
        return cantidadSalas;
    }

    public void setCantidadSalas(int cantidadSalas) {
        this.cantidadSalas = cantidadSalas;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }
}

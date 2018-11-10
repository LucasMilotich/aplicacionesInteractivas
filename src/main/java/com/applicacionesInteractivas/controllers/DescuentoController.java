package com.applicacionesInteractivas.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.applicacionesInteractivas.bd.DescuentoDAO;
import com.applicacionesInteractivas.modelo.Cine;
import com.applicacionesInteractivas.modelo.descuento.Descuento;
import com.applicacionesInteractivas.modelo.descuento.DosPorUno;
import com.applicacionesInteractivas.modelo.descuento.PorcentajeSobreVenta;

public class DescuentoController {

    private static DescuentoController instance;
    private List<Descuento> descuentos = new ArrayList<>();

    public static DescuentoController getInstance() {
        if (instance == null) {
            instance = new DescuentoController();
        }
        return instance;
    }
    
    /**
	 * getDescuentos
	 * 
	 * Retorna la lista de descuentos que posee el Descuento Controller.
	 * De ser la cantidad igual a 0, se van a buscar a la BD.
	 * 
	 * @param -
	 * @return List<Descuento>
	 */
    public List<Descuento> getDescuentos() {
        if (descuentos.size() == 0) {
            return descuentos = DescuentoDAO.getInstance().findAll();
        } else {
            return descuentos;
        }
    }
    
    /**
	 * getDescuentosPorCineVigentes
	 * 
	 * Retorna una lista de descuentos correspondientes a un cine especifico.
	 * 
	 * @param cuit
	 * @return List<Descuento>
	 */
    public List<Descuento> getDescuentosPorCineVigentes(String cuit) {
    	
        return DescuentoDAO.getInstance().findAllByCuitAndDate(cuit);
    
    }

    /**
	 * getDescuento
	 * 
	 * Retorna un objeto Descuento correspondiente a un cine y nombre especifico.
	 * 
	 * @param cuil, nombre
	 * @return Descuento
	 */
    public Descuento getDescuento(String cuil, String nombre) {
        for (Descuento c : getDescuentos()) {
            if (c.getCine().getCuit().equals(cuil) && c.getNombre().equals(nombre))
                return c;
        }

        return null;
    }

    /**
	 * eliminarDescuento
	 * 
	 * Elimina un descuento, obteniendolo primero a traves del cuit del cine y nombre del descuento.
	 * Luego lo remueve de la coleccion de descuentos.
	 * 
	 * @param cineCuil, nombre
	 * @return -
	 */
    public void eliminarDescuento(String cineCuil, String nombre) {
        Descuento d = getDescuento(cineCuil, nombre);
        if (d.isPorcentaje()) {
            Descuento.modificarDescuento(d, d.getVigenciaDesde(), d.getVigenciaHasta(), 0, 0, ((PorcentajeSobreVenta) d).getPorcentajeSobreVenta(), true);
        } else if (d.isDosPorUno()) {
            Descuento.modificarDescuento(d, d.getVigenciaDesde(), d.getVigenciaHasta(), ((DosPorUno) d).getCantidadProductosRequeridos(), ((DosPorUno) d).getCantidadProductosAPagar(), 0, true);
        }
        descuentos.remove(d);
    }

    /**
	 * modificarDescuento
	 * 
	 * Modifica un Descuento, obteniendolo primero a traves del cuit del cine y el nombre del descuento.
	 * 
	 * @param cineCuil, nombre, vigenciaDesde, vigenciaHasta, cantProdAComprar, cantProdAPagar, porcentaje
	 * @return -
	 */
    public void modificarDescuento(String cineCuil, String nombre, String vigenciaDesde, String vigenciaHasta, int cantProdAComprar, int cantProdAPagar, int porcentaje) {
        Descuento d = getDescuento(cineCuil, nombre);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Descuento.modificarDescuento(d, LocalDate.parse(vigenciaDesde, dtf), LocalDate.parse(vigenciaHasta, dtf), cantProdAComprar, cantProdAPagar, porcentaje, false);
    }

    /**
	 * crearDescuento
	 * 
	 * Verifica si el tipoDescuento pasado por parametro contiene un %.
	 * De ser asi, da de alta un Descuento por porcentaje.
	 * De lo contrario, crea un Descuento DosPorUno.
	 * Luego lo agrega en la coleccion de descuentos.
	 * 
	 * @param cineCuil, nombre, vigenciaDesde, vigenciaHasta, tipoDescuento
	 * @return -
	 */
    public void crearDescuento(String cineCuil, String nombre, String vigenciaDesde, String vigenciaHasta, String tipoDescuento) {

        if (tipoDescuento.contains("%")) {
            crearPorcentaje(cineCuil, nombre, vigenciaDesde, vigenciaHasta, Integer.parseInt(tipoDescuento.substring(0, tipoDescuento.length() - 1)));
        } else if (tipoDescuento.contains("x")) {
            int cantProdReq;
            int cantACobrar;
            String[] values = tipoDescuento.split("x");
            cantProdReq = Integer.parseInt(values[0]);
            cantACobrar = Integer.parseInt(values[1]);
            crearDosPorUno(cineCuil, nombre, vigenciaDesde, vigenciaHasta, cantProdReq, cantACobrar);
        }


    }

    /**
	 * crearDosPorUno
	 * 
	 * Da de alta un Descuento del tipo 2x1, y lo agrega en la coleccion de descuentos.
	 * 
	 * @param cineCuil, nombre, vigenciaDesde, vigenciaHasta, cantidadRequeridosDeProductos, cantidadACobrar
	 * @return -
	 */
    private void crearDosPorUno(String cineCuil, String nombre, String vigenciaDesde, String vigenciaHasta, int cantidadRequeridosDeProductos, int cantidadACobrar) {
        Cine cine = CineController.getInstance().getCine(cineCuil);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DosPorUno dosPorUno = DosPorUno.crearDosPorUno(cine, nombre, LocalDate.parse(vigenciaDesde, dtf), LocalDate.parse(vigenciaHasta, dtf), cantidadRequeridosDeProductos, cantidadACobrar);
        descuentos.add(dosPorUno);
    }

    /**
	 * crearPorcentaje
	 * 
	 * Da de alta un Descuento del tipo porcentaje de venta, y lo agrega en la coleccion de descuentos.
	 * 
	 * @param cineCuil, nombre, vigenciaDesde, vigenciaHasta, porcentaje
	 * @return -
	 */
    private void crearPorcentaje(String cineCuil, String nombre, String vigenciaDesde, String vigenciaHasta, int porcentaje) {
        Cine cine = CineController.getInstance().getCine(cineCuil);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        PorcentajeSobreVenta porcentajeSobreVenta = PorcentajeSobreVenta.crearPorcentajeSobreVenta(cine, nombre, LocalDate.parse(vigenciaDesde, dtf), LocalDate.parse(vigenciaHasta, dtf), porcentaje);
        descuentos.add(porcentajeSobreVenta);
    }
}

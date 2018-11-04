package com.applicacionesInteractivas.modelo.medioDePago;

import com.applicacionesInteractivas.modelo.Venta;

public class Tarjeta extends MedioDePago {
    
	private String tipo;
    private String numero;
    private String vencimiento;
    private String codigo;
    private Venta venta;

    public Tarjeta(String tipo, String numero, String vencimiento, String codigo) {
		super();
		this.tipo = tipo;
		this.numero = numero;
		this.vencimiento = vencimiento;
		this.codigo = codigo;
	}

	public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
}

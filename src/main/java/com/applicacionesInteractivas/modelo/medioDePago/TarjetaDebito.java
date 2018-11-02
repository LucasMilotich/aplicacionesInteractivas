package com.applicacionesInteractivas.modelo.medioDePago;

public class TarjetaDebito extends Tarjeta {

	public TarjetaDebito(String tipo, String numero, String vencimiento, String codigo) {
		super(tipo, numero, vencimiento, codigo);
	}

	@Override
	public String toString() {
		return "TARJETA DEBITO";
	}
}

package com.applicacionesInteractivas.modelo.medioDePago;

public class TarjetaCredito extends Tarjeta {

	public TarjetaCredito(String tipo, String numero, String vencimiento, String codigo) {
		super(tipo, numero, vencimiento, codigo);
	}

	@Override
	public String toString() {
		return "TARJETA CREDITO";
	}
}

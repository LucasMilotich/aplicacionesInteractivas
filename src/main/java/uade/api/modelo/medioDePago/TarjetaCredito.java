package uade.api.modelo.medioDePago;

public class TarjetaCredito extends MedioDePago {
    private String tipo;
    private String banco;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}

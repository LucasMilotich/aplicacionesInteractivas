package uade.api.modelo;

public class Entrada {

    public Entrada(){}
    public Entrada(AsientoFuncion asiento, Funcion funcion){
        this.asiento = asiento;
        this.funcion = funcion;
        this.estado = "VENDIDO";
        this.codAutenticacion = Double.toString(Math.random());

    }
    private  AsientoFuncion  asiento;
    private  String  estado;
    private  String  codAutenticacion;
    private Funcion funcion;

    public AsientoFuncion getAsiento() {
        return asiento;
    }

    public void setAsiento(AsientoFuncion asiento) {
        this.asiento = asiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodAutenticacion() {
        return codAutenticacion;
    }

    public void setCodAutenticacion(String codAutenticacion) {
        this.codAutenticacion = codAutenticacion;
    }
}

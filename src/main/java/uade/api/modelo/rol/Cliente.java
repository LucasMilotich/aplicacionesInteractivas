package uade.api.modelo.rol;

public class Cliente implements IRol {
    @Override
    public boolean puedeOperar(String accion) {
        return false;
    }
}

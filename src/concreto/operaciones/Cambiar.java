package concreto.operaciones;

import abstracto.interfaces.Operacion;
import abstracto.interfaces.Cambio;

public final class Cambiar implements Operacion {

    private final Cambio[] cambios;
    
    public Cambiar(Cambio[] cambios){
        this.cambios = cambios;
    }
    
    @Override
    public void realizar() {
        for (Cambio cambio : cambios) {
            cambio.ejecutar();
        }
    }
    
}

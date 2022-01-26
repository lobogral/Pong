package concreto.operaciones;

import abstracto.interfaces.Interaccion;
import abstracto.interfaces.Operacion;

public final class Interactuar implements Operacion {

    private final Interaccion[] interacciones;
    
    public Interactuar(Interaccion[] interacciones){
        this.interacciones = interacciones;
    }
    
    @Override
    public void realizar() {
        for (Interaccion interaccion : interacciones) {
            interaccion.ejecutar();
        }
    }
    
}

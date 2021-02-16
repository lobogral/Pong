package Operaciones;

import Interfaces.Interaccion;
import Interfaces.Operacion;

public class Interactuar implements Operacion {

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

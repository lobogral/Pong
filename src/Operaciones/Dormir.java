package Operaciones;

import Interfaces.Operacion;

public class Dormir implements Operacion {

    @Override
    public void realizar() {
        long tiempoRetrazo = System.currentTimeMillis() + 15;
        long tiempoActual = 0;
        while (tiempoActual < tiempoRetrazo) {
            tiempoActual = System.currentTimeMillis();
        }
    }
    
}

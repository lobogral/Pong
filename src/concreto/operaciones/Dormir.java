package concreto.operaciones;

import abstracto.interfaces.Operacion;

public class Dormir implements Operacion {

    @Override
    public void realizar() {
        long tiempoRetrazo = System.currentTimeMillis() + 10;
        long tiempoActual = 0;
        while (tiempoActual < tiempoRetrazo) {
            tiempoActual = System.currentTimeMillis();
        }
    }
    
}

package concreto.operaciones;

import abstracto.interfaces.Operacion;

public final class Dormir implements Operacion {

    @Override
    public void realizar() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {}
    }
    
}

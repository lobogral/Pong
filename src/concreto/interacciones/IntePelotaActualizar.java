package concreto.interacciones;
import abstracto.interfaces.Interaccion;
import abstracto.maniqui.ManiquiMov;

public final class IntePelotaActualizar implements Interaccion{
    
    private final ManiquiMov pelota;
    
    public IntePelotaActualizar(ManiquiMov pelota){
        this.pelota = pelota;
    }
    
    @Override
    public void ejecutar(){
        pelota.actualizar();
    }
    
}

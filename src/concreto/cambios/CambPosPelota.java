package concreto.cambios;
import abstracto.maniqui.ManiquiMov;
import abstracto.interfaces.Cambio;

public final class CambPosPelota implements Cambio{
    
    private final ManiquiMov pelota;
    
    public CambPosPelota(ManiquiMov pelota){
        this.pelota = pelota;
    }
    
    @Override
    public void ejecutar(){
        pelota.actualizar();
    }
    
}

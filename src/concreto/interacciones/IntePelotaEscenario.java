package concreto.interacciones;
import abstracto.interfaces.Interaccion;
import abstracto.maniqui.ManiquiEst;
import abstracto.maniqui.ManiquiMov;

public final class IntePelotaEscenario implements Interaccion{
    
    private final ManiquiMov pelota;
    private final ManiquiEst escenario;
    
    public IntePelotaEscenario(ManiquiMov pelota, ManiquiEst escenario){
        this.pelota = pelota;
        this.escenario = escenario;
    }
    
    @Override
    public void ejecutar(){
        
        boolean valor3 = pelota.getPosY() <= escenario.getPosY();
        boolean valor4 = pelota.getPosY() >= escenario.getAlto() - pelota.getAlto();
        if (valor3 || valor4) {
            pelota.setVel(pelota.getVelX(), -pelota.getVelY());
        }
        
        pelota.actualizar();
    }
    
}
package concreto.interacciones;
import abstracto.interfaces.Interaccion;
import abstracto.clases.Maniqui;

public final class IntePelotaEscenario implements Interaccion{
    
    private final Maniqui pelota;
    private final Maniqui escenario;
    
    public IntePelotaEscenario(Maniqui pelota, Maniqui escenario){
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
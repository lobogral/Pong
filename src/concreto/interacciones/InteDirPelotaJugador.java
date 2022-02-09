package concreto.interacciones;
import abstracto.interfaces.Interaccion;
import abstracto.maniqui.ManiquiMov;

public final class InteDirPelotaJugador implements Interaccion{
    
    private final ManiquiMov pelota;
    private final ManiquiMov jugador;
    
    public InteDirPelotaJugador(ManiquiMov pelota, ManiquiMov jugador){
        this.pelota = pelota;
        this.jugador = jugador;
    }
    
    @Override
    public void ejecutar(){
        
        // Revisa si el jugador no se intersecta con la pelota
        boolean interP = true;
        interP &= pelota.getPosX() + pelota.getAncho() > jugador.getPosX();
        interP &= pelota.getPosX() < jugador.getPosX() + jugador.getAncho();
        interP &= pelota.getPosY() + pelota.getAlto() > jugador.getPosY();
        interP &= pelota.getPosY() < jugador.getPosY() + jugador.getAlto();
        
        // Si se intersecta, cambia de dirección
        if (interP) {
            pelota.setVel(-pelota.getVelX(), -pelota.getVelY());
        }
        
    }
    
}
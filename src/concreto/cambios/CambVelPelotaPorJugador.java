package concreto.cambios;
import abstracto.maniqui.ManiquiMov;
import abstracto.interfaces.Cambio;

public final class CambVelPelotaPorJugador implements Cambio{
    
    private final ManiquiMov pelota;
    private final ManiquiMov jugador;
    
    public CambVelPelotaPorJugador(ManiquiMov pelota, ManiquiMov jugador){
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
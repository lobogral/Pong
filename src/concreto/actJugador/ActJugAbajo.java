package concreto.actJugador;

import abstracto.interfaces.ActJugador;
import abstracto.maniqui.ManiquiOpcionMov;

public final class ActJugAbajo implements ActJugador{
    
    private final ManiquiOpcionMov jugador;
    
    public ActJugAbajo(ManiquiOpcionMov jugador){
        this.jugador = jugador;
    }
    
    @Override
    public void presionar(){
        jugador.setIsMoviendo(true);
        jugador.setVel(0, Math.abs(jugador.getVelY()));
    }
    
    @Override
    public void soltar(){
        jugador.setIsMoviendo(false);
    }
    
}

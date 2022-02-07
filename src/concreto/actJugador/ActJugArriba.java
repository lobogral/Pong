package concreto.actJugador;

import abstracto.interfaces.ActJugador;
import abstracto.maniqui.ManiquiOpcionMov;
import concreto.actores.Jugador;

public final class ActJugArriba implements ActJugador{
    
    private final ManiquiOpcionMov jugador;
    
    public ActJugArriba(ManiquiOpcionMov jugador){
        this.jugador = jugador;
    }
    
    @Override
    public void presionar(){
        jugador.setIsMoviendo(true);
        jugador.setVel(0, -Math.abs(jugador.getVelY()));
    }
    
    @Override
    public void soltar(){
        jugador.setIsMoviendo(false);
    }
    
}

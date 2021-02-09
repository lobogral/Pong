package Interacciones;
import Actores.ActEscenario;
import Principal.Interaccion;
import Actores.ActJugador;

public class InteJugadorEscenario implements Interaccion{
    
    private final ActJugador jugador;
    private final ActEscenario escenario;
    
    public InteJugadorEscenario(ActJugador jugador, ActEscenario escenario){
        this.jugador = jugador;
        this.escenario = escenario;
    }
    
    @Override
    public void ejecutar(){
        if (jugador.getPosY() > 100 && jugador.getVelPositiva()) {
            jugador.actualizar();
        }
        
        if (jugador.getPosY() < escenario.getALTO() - 100 && !jugador.getVelPositiva()) {
            jugador.actualizar();
        }
    }
    
}

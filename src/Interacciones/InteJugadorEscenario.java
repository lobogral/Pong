package Interacciones;
import Actores.Escenario;
import Principal.Interaccion;
import Actores.Jugador;

public class InteJugadorEscenario implements Interaccion{
    
    private final Jugador jugador;
    private final Escenario escenario;
    
    public InteJugadorEscenario(Jugador jugador, Escenario escenario){
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

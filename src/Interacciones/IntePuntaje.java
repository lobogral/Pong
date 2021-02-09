package Interacciones;
import Actores.ActEscenario;
import Principal.Interaccion;
import Actores.ActJugador;
import Actores.ActPelota;

public class IntePuntaje implements Interaccion{
    
    private final ActPelota pelota;
    private final ActEscenario escenario;
    private final ActJugador jugador1;
    private final ActJugador jugador2;
    
    public IntePuntaje(ActPelota pelota, ActEscenario escenario, ActJugador jugador1, ActJugador jugador2){
        this.pelota = pelota;
        this.escenario = escenario;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }
    
    @Override
    public void ejecutar(){
        if (pelota.getPosX() <= 0) {
            jugador2.aumentarPuntaje();
        }
      
        if (pelota.getPosX() >= escenario.getANCHO() - 40) {
            jugador1.aumentarPuntaje();
        }
        
    }
    
}

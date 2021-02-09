package Interacciones;
import Actores.Escenario;
import Principal.Interaccion;
import Actores.Jugador;
import Actores.Pelota;

public class IntePuntaje implements Interaccion{
    
    private final Pelota pelota;
    private final Escenario escenario;
    private final Jugador jugador1;
    private final Jugador jugador2;
    
    public IntePuntaje(Pelota pelota, Escenario escenario, Jugador jugador1, Jugador jugador2){
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

package Interacciones;
import Interfaces.Interaccion;
import Interfaces.Maniqui;
import Interfaces.Puntaje;

public class IntePuntaje implements Interaccion{
    
    private final Maniqui pelota;
    private final Maniqui escenario;
    private final Puntaje jugador1;
    private final Puntaje jugador2;
    
    public IntePuntaje(Maniqui pelota, Maniqui escenario, Puntaje jugador1, Puntaje jugador2){
        this.pelota = pelota;
        this.escenario = escenario;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }
    
    @Override
    public void ejecutar(){
        if (pelota.getPosX() <= 0) {
            jugador2.aumentar();
        }
      
        if (pelota.getPosX() >= escenario.getAncho() - pelota.getAncho()) {
            jugador1.aumentar();
        }
        
    }
    
}

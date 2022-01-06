package concreto.interacciones;
import abstracto.interfaces.Interaccion;
import abstracto.clases.Maniqui;
import abstracto.interfaces.Puntaje;

public class IntePuntaje implements Interaccion{
    
    private final Maniqui pelota;
    private final Maniqui escenario;
    private final Puntaje puntajeJugador1;
    private final Puntaje puntajeJugador2;
    
    public IntePuntaje(Maniqui pelota, Maniqui escenario, Puntaje jugador1, Puntaje jugador2){
        this.pelota = pelota;
        this.escenario = escenario;
        this.puntajeJugador1 = jugador1;
        this.puntajeJugador2 = jugador2;
    }
    
    @Override
    public void ejecutar(){
        if (pelota.getPosX() <= 0) {
            puntajeJugador2.aumentar();
        }
      
        if (pelota.getPosX() >= escenario.getAncho() - pelota.getAncho()) {
            puntajeJugador1.aumentar();
        }
        
    }
    
}

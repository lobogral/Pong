package concreto.cambios;
import abstracto.interfaces.Puntaje;
import abstracto.maniqui.ManiquiEst;
import abstracto.interfaces.Cambio;

public final class CambReiniciar implements Cambio{
    
    private final ManiquiEst pelota;
    private final ManiquiEst escenario;
    private final Puntaje puntajeJugador1;
    private final Puntaje puntajeJugador2;
    
    public CambReiniciar(ManiquiEst pelota, ManiquiEst escenario, Puntaje jugador1, Puntaje jugador2){
        this.pelota = pelota;
        this.escenario = escenario;
        this.puntajeJugador1 = jugador1;
        this.puntajeJugador2 = jugador2;
    }
    
    @Override
    public void ejecutar(){
        
        boolean valor1 = pelota.getPosX() < 0;
        boolean valor2 = pelota.getPosX() > escenario.getAncho() - pelota.getAncho();
        
        if (valor1) {
            puntajeJugador2.aumentar();
        }
      
        if (valor2) {
            puntajeJugador1.aumentar();
        }
        
        if (valor1 || valor2) {
            pelota.setPos(escenario.getAncho()/2, escenario.getAlto()/2);
        }
        
    }
    
}

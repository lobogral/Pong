package concreto.interacciones;
import abstracto.interfaces.Interaccion;
import abstracto.maniqui.ManiquiEst;
import abstracto.maniqui.ManiquiMov;
import abstracto.maniqui.ManiquiOpcionMov;

public final class InteJugador implements Interaccion{
    
    private final ManiquiMov pelota;
    private final ManiquiEst escenario;
    private final ManiquiOpcionMov jugador;
    private final ManiquiMov jugadorFut;
    
    public InteJugador(ManiquiMov pelota, ManiquiEst escenario, ManiquiOpcionMov jugador){
        this.pelota = pelota;
        this.escenario = escenario;
        this.jugador = jugador;
        this.jugadorFut = new ManiquiMov();
    }
    
    @Override
    public void ejecutar(){

        if(jugador.getIsMoviendo()){
            
            //Establezco un clon del jugador
            jugadorFut.setPos(jugador.getPosX(), jugador.getPosY());
            jugadorFut.setVel(jugador.getVelX(), jugador.getVelY());
            jugadorFut.setDimensiones(jugador.getAncho(), jugador.getAlto());

            //Actualizo el clon del jugador
            jugadorFut.actualizar();

            /*
             * Analizo que pasaría con todas las interacciones después de actualizar
             */        

            // Revisa si el jugador no se intersecta con la pelota
            boolean interP = false;
            interP |= pelota.getPosX() + pelota.getAncho() < jugadorFut.getPosX();
            interP |= pelota.getPosX() > jugadorFut.getPosX() + jugadorFut.getAncho();
            interP |= pelota.getPosY() + pelota.getAlto() < jugadorFut.getPosY();
            interP |= pelota.getPosY() > jugadorFut.getPosY() + jugadorFut.getAlto();

            // Revisa si el jugador está dentro del escenario (coordenadas verticales)
            boolean interE = true;
            interE &= jugadorFut.getPosY() + jugadorFut.getAlto() < escenario.getAlto();
            interE &= jugadorFut.getPosY() > escenario.getPosY();
            
            // Si el clon no choca con nada tiene permiso de actualizar
            if(interP && interE){
                jugador.actualizar();
            }    
        }
    }
}
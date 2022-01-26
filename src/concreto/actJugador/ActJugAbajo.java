package concreto.actJugador;

import abstracto.clases.Maniqui;
import abstracto.interfaces.ActJugador;

public final class ActJugAbajo implements ActJugador{
    
    private final Maniqui jugador;
    private final Maniqui escenario;
    private final Maniqui pelota;
    
    public ActJugAbajo(Maniqui pelota, Maniqui jugador, Maniqui escenario){
        this.pelota = pelota;
        this.jugador = jugador;
        this.escenario = escenario;
    }
    
    @Override
    public void ejecutar(){
        
        boolean valorFinal = true;
        
        // Interacción jugador con bordes del escenario
        boolean valor1 = jugador.getPosY() + jugador.getAlto() + Math.abs(jugador.getVelY()) < escenario.getAlto();
        valorFinal = valorFinal && (valor1);

        // Interacción jugador con pelota
        boolean valor2 = false;
        valor2 |= pelota.getPosY() + pelota.getAlto() < jugador.getPosY();
        valor2 |= pelota.getPosY() > jugador.getPosY() + jugador.getAlto() + Math.abs(jugador.getVelY());
        valor2 |= pelota.getPosX() + pelota.getAncho() < jugador.getPosX();
        valor2 |= pelota.getPosX() > jugador.getPosX() + jugador.getAncho();
        valorFinal = valorFinal && (valor2);

        if(valorFinal){
            jugador.setVel(0, Math.abs(jugador.getVelY()));
            jugador.actualizar();
        }
        
    }
    
}

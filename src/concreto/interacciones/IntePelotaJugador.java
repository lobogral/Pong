package concreto.interacciones;
import abstracto.interfaces.Interaccion;
import abstracto.clases.Maniqui;

public final class IntePelotaJugador implements Interaccion{

    private final Maniqui pelota;
    private final Maniqui jugador;

    public IntePelotaJugador(Maniqui pelota, Maniqui jugador){
        this.pelota = pelota;
        this.jugador = jugador;
    }

    @Override
    public void ejecutar(){

        boolean valor = true;
        valor &= pelota.getPosX() + pelota.getAncho() > jugador.getPosX();
        valor &= pelota.getPosX() < jugador.getPosX() + jugador.getAncho();
        valor &= pelota.getPosY() + pelota.getAlto() > jugador.getPosY();
        valor &= pelota.getPosY() < jugador.getPosY() + jugador.getAlto();
        
        if (valor) {
            pelota.setVel(-pelota.getVelX(), -pelota.getVelY());
            pelota.actualizar();
        }
    }

}

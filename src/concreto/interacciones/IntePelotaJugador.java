package concreto.interacciones;
import abstracto.interfaces.Interaccion;
import abstracto.maniqui.ManiquiMov;

public final class IntePelotaJugador implements Interaccion{

    private final ManiquiMov pelota;
    private final ManiquiMov jugador;

    public IntePelotaJugador(ManiquiMov pelota, ManiquiMov jugador){
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

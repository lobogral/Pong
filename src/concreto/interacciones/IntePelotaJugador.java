package concreto.interacciones;
import abstracto.interfaces.Interaccion;
import abstracto.clases.Maniqui;

public class IntePelotaJugador implements Interaccion{

    private final Maniqui pelota;
    private final Maniqui jugador;

    public IntePelotaJugador(Maniqui pelota, Maniqui jugador){
        this.pelota = pelota;
        this.jugador = jugador;
    }

    @Override
    public void ejecutar(){
        boolean valor1, valor2, valor3, valor4;
        valor1 = pelota.getPosX() + pelota.getAncho()> jugador.getPosX();
        valor2 = pelota.getPosX() < jugador.getPosX() + jugador.getAncho();
        valor3 = pelota.getPosY() + pelota.getAlto()> jugador.getPosY();
        valor4 = pelota.getPosY() < jugador.getPosY() + jugador.getAlto();
        
        if (valor1 && valor2 && valor3 && valor4) {
            pelota.setVel(-pelota.getVelX(), -pelota.getVelY());
            /*
             * Doble actualizar permite que la pelota
             * No se pegue a la paleta del jugador
            */
            pelota.actualizar();
            pelota.actualizar();
        }
    }

}

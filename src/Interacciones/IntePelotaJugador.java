package Interacciones;
import Interfaces.Interaccion;
import Actores.Jugador;
import Actores.Pelota;

public class IntePelotaJugador implements Interaccion{
    
    private final Pelota pelota;
    private final Jugador jugador;
    
    public IntePelotaJugador(Pelota pelota, Jugador jugador){
        this.pelota = pelota;
        this.jugador = jugador;
    }
    
    @Override
    public void ejecutar(){
        boolean valor1, valor2, valor3, valor4;
        valor1 = pelota.getPosX() + pelota.getDiametro() > jugador.getPosX();
        valor2 = pelota.getPosX() < jugador.getPosX() + jugador.getAncho();
        valor3 = pelota.getPosY() + pelota.getDiametro() > jugador.getPosY();
        valor4 = pelota.getPosY() < jugador.getPosY() + jugador.getAlto();
        
        if (valor1 && valor2 && valor3 && valor4) {
            pelota.invertirVelX();
            pelota.invertirVelY();
            /*
             * Doble actualizar permite que la pelota
             * No se pegue a la paleta del jugador
            */
            pelota.actualizar();
            pelota.actualizar();
        }
    }
    
}

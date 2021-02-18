package Operaciones;

import Actores.Escenario;
import Actores.Jugador;
import Actores.Pelota;
import Interacciones.InteJugadorEscenario;
import Interacciones.IntePelotaEscenario;
import Interacciones.IntePelotaJugador;
import Interacciones.IntePuntaje;
import Interfaces.Interaccion;
import Interfaces.Maniqui;
import Interfaces.Operacion;
import Interfaces.Puntaje;

public class Interactuar implements Operacion {

    private final Interaccion[] interacciones;
    
    public Interactuar(Escenario escenario, Pelota pelota, Jugador jugador1, Jugador jugador2){
        
        Maniqui mPelota = pelota;
        Maniqui mJugador1 = jugador1;
        Maniqui mJugador2 = jugador2;
        Maniqui mEscenario = escenario;
        Puntaje pJugador1 = jugador1;
        Puntaje pJugador2 = jugador2;
        
        interacciones = new Interaccion[6];
        interacciones[0] = new InteJugadorEscenario(mJugador1, mEscenario);
        interacciones[1] = new InteJugadorEscenario(mJugador2, mEscenario);
        interacciones[2] = new IntePuntaje(mPelota, mEscenario, pJugador1, pJugador2);
        interacciones[3] = new IntePelotaJugador(mPelota, mJugador1);
        interacciones[4] = new IntePelotaJugador(mPelota, mJugador2);
        interacciones[5] = new IntePelotaEscenario(mPelota, mEscenario);

    }
    
    @Override
    public void realizar() {
        for (Interaccion interaccion : interacciones) {
            interaccion.ejecutar();
        }
    }
    
}

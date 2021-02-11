import Actores.Escenario;
import Actores.Jugador;
import Actores.Pelota;
import Interacciones.InteJugadorEscenario;
import Interacciones.IntePelotaEscenario;
import Interacciones.IntePelotaJugador;
import Interacciones.IntePuntaje;
import Principal.Actor;
import Principal.Interaccion;
import Principal.Pong;
import Principal.Ventana;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Launcher {

    public static void main(String[] args) {
        
        int ANCHO = 800;
        int ALTO = 600;
        
        Pelota pelota = new Pelota(ANCHO/2, ALTO/2);
        Jugador jugador1 = new Jugador(70, ALTO/2);
        Jugador jugador2 = new Jugador(720, ALTO/2);
        Escenario escenario = new Escenario(ANCHO, ALTO);
        
        KeyListener[] keyListeners = new KeyListener[2];
        keyListeners[0] = jugador1;
        keyListeners[1] = jugador2;
        
        Actor[] actores = new Actor[4];
        actores[0] = escenario;
        actores[1] = pelota;
        actores[2] = jugador1;
        actores[3] = jugador2;

        Interaccion[] interacciones = new Interaccion[6];
        interacciones[0] = new InteJugadorEscenario(jugador1, escenario);
        interacciones[1] = new InteJugadorEscenario(jugador2, escenario);
        interacciones[2] = new IntePuntaje(pelota, escenario, jugador1, jugador2);
        interacciones[3] = new IntePelotaJugador(pelota, jugador1);
        interacciones[4] = new IntePelotaJugador(pelota, jugador2);
        interacciones[5] = new IntePelotaEscenario(pelota, escenario);
        
        JFrame ventana = new Ventana(ANCHO, ALTO, keyListeners);
        Pong pong = new Pong(ventana, actores, interacciones);
    }
}

import Actores.Escenario;
import Actores.Jugador;
import Actores.Pelota;
import Actores.Relleno;
import Interacciones.InteJugadorEscenario;
import Interacciones.IntePelotaEscenario;
import Interacciones.IntePelotaJugador;
import Interacciones.IntePuntaje;
import Principal.Actor;
import Principal.Interaccion;
import Principal.Pong;
import Principal.Ventana;
import java.awt.event.KeyEvent;

public class Launcher {

    public static void main(String[] args) {

        Ventana ventana = new Ventana();
        int ANCHO = ventana.getAncho();
        int ALTO = ventana.getAlto();
        
        Pelota pelota = new Pelota(ANCHO/2, ALTO/2);
        Jugador jugador1 = new Jugador(70, ALTO/2, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        Jugador jugador2 = new Jugador(720, ALTO/2, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        Escenario escenario = new Escenario(0, 57, ANCHO, ALTO);
        Relleno relleno = new Relleno(ANCHO, 57);
        
        Actor[] actores = new Actor[5];
        actores[0] = relleno;
        actores[1] = escenario;
        actores[2] = pelota;
        actores[3] = jugador1;
        actores[4] = jugador2;

        Interaccion[] interacciones = new Interaccion[6];
        interacciones[0] = new InteJugadorEscenario(jugador1, escenario);
        interacciones[1] = new InteJugadorEscenario(jugador2, escenario);
        interacciones[2] = new IntePuntaje(pelota, escenario, jugador1, jugador2);
        interacciones[3] = new IntePelotaJugador(pelota, jugador1);
        interacciones[4] = new IntePelotaJugador(pelota, jugador2);
        interacciones[5] = new IntePelotaEscenario(pelota, escenario);
        
        ventana.addKeyListener(jugador1);
        ventana.addKeyListener(jugador2);
        
        Pong pong = new Pong(ventana, actores, interacciones);
    }
}

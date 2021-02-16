import Actores.Escenario;
import Actores.Jugador;
import Actores.Pelota;
import Interacciones.InteJugadorEscenario;
import Interacciones.IntePelotaEscenario;
import Interacciones.IntePelotaJugador;
import Interacciones.IntePuntaje;
import Interfaces.Actor;
import Interfaces.Interaccion;
import Interfaces.Operacion;
import Operaciones.Dibujar;
import Operaciones.Dormir;
import Operaciones.Interactuar;
import java.awt.event.KeyEvent;

public class Launcher {
    
    public static void main(String[] args) {

        Ventana ventana = new Ventana(800, 600);
        int anchoJuego = ventana.getAnchoJuego();
        int altoJuego = ventana.getAltoJuego();
        
        Pelota pelota = new Pelota(anchoJuego/2, altoJuego/2);
        Jugador jugador1 = new Jugador(70, altoJuego/2, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        Jugador jugador2 = new Jugador(720, altoJuego/2, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        Escenario escenario = new Escenario(0, 57, anchoJuego, altoJuego);
        
        ventana.addKeyListener(jugador1);
        ventana.addKeyListener(jugador2);
        
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
        
        Operacion[] operaciones = new Operacion[3];
        operaciones[0] = new Dibujar(ventana.getLapiz(), actores);
        operaciones[1] = new Interactuar(interacciones);
        operaciones[2] = new Dormir();
        
        while (true) {
            for (Operacion operacion : operaciones) {
                operacion.realizar();
            }
        }
    }
}

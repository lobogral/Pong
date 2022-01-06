import abstracto.clases.Listener;
import abstracto.clases.Ventana;
import abstracto.clases.Pong;
import abstracto.interfaces.Interaccion;
import abstracto.interfaces.Lienzo;
import abstracto.interfaces.Operacion;
import concreto.actores.Complemento;
import concreto.actores.Escenario;
import concreto.actores.Jugador;
import concreto.actores.Pelota;
import concreto.interacciones.InteJugadorEscenario;
import concreto.interacciones.IntePelotaEscenario;
import concreto.interacciones.IntePelotaJugador;
import concreto.interacciones.IntePuntaje;
import concreto.operaciones.Dibujar;
import concreto.operaciones.Dormir;
import concreto.operaciones.Interactuar;
import java.awt.event.KeyEvent;

public class Launcher {

    public static void main(String[] args) {
        
        Ventana ventana = new Ventana(800, 600);
        int anchoJuego = ventana.getAnchoJuego();
        int altoJuego = ventana.getAltoJuego();

        Pelota pelota = new Pelota(anchoJuego/2, altoJuego/2);
        Jugador jugador1 = new Jugador(70, altoJuego/2);
        Jugador jugador2 = new Jugador(720, altoJuego/2);
        Escenario escenario = new Escenario(0, 57, anchoJuego, altoJuego);
        Complemento complemento = new Complemento(0, 0, anchoJuego, 57);

        ventana.addKeyListener(new Listener(jugador1, KeyEvent.VK_W, KeyEvent.VK_S));
        ventana.addKeyListener(new Listener(jugador2, KeyEvent.VK_I, KeyEvent.VK_K));

        Lienzo[] lienzos = {complemento, escenario, pelota, jugador1, jugador2};

        Interaccion[] interacciones = new Interaccion[6];
        interacciones[0] = new InteJugadorEscenario(jugador1, escenario);
        interacciones[1] = new InteJugadorEscenario(jugador2, escenario);
        interacciones[2] = new IntePuntaje(pelota, escenario, jugador1, jugador2);
        interacciones[3] = new IntePelotaJugador(pelota, jugador1);
        interacciones[4] = new IntePelotaJugador(pelota, jugador2);
        interacciones[5] = new IntePelotaEscenario(pelota, escenario);
        
        Operacion[] operaciones = new Operacion[3];
        operaciones[0] = new Dibujar(anchoJuego, altoJuego, ventana.getLapiz(), lienzos);
        operaciones[1] = new Interactuar(interacciones);
        operaciones[2] = new Dormir();
        
        Pong pong = new Pong(operaciones);
        pong.iniciarJuego();
    }

}

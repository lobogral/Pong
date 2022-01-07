import abstracto.clases.Listener;
import abstracto.clases.Ventana;
import abstracto.clases.Pong;
import abstracto.interfaces.Interaccion;
import abstracto.interfaces.Lienzo;
import abstracto.interfaces.ListenerEsp;
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
        Jugador jugador1 = new Jugador(70, altoJuego/2, KeyEvent.VK_W, KeyEvent.VK_S);
        Jugador jugador2 = new Jugador(720, altoJuego/2, KeyEvent.VK_I, KeyEvent.VK_K);
        Escenario escenario = new Escenario(0, 57, anchoJuego, altoJuego);
        Complemento complemento = new Complemento(0, 0, anchoJuego, 57);

        ListenerEsp[] listenersEsp = {jugador1, jugador2};
        ventana.addKeyListener(new Listener(listenersEsp));

        Lienzo[] lienzos = {complemento, escenario, pelota, jugador1, jugador2};
        int cont;
        
        cont = 0;
        Interaccion[] interacciones = new Interaccion[6];
        interacciones[cont++] = new InteJugadorEscenario(jugador1, escenario);
        interacciones[cont++] = new InteJugadorEscenario(jugador2, escenario);
        interacciones[cont++] = new IntePuntaje(pelota, escenario, jugador1, jugador2);
        interacciones[cont++] = new IntePelotaJugador(pelota, jugador1);
        interacciones[cont++] = new IntePelotaJugador(pelota, jugador2);
        interacciones[cont++] = new IntePelotaEscenario(pelota, escenario);
        
        cont = 0;
        Operacion[] operaciones = new Operacion[3];
        operaciones[cont++] = new Dibujar(anchoJuego, altoJuego, ventana.getLapiz(), lienzos);
        operaciones[cont++] = new Interactuar(interacciones);
        operaciones[cont++] = new Dormir();
        
        Pong pong = new Pong(operaciones);
        pong.iniciarJuego();
    }

}

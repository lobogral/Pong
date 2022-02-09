import abstracto.clases.Listener;
import abstracto.clases.Ventana;
import abstracto.clases.Pong;
import abstracto.interfaces.ActJugador;
import abstracto.interfaces.Interaccion;
import abstracto.interfaces.Lienzo;
import abstracto.interfaces.Operacion;
import concreto.actJugador.ActJugArriba;
import concreto.actJugador.ActJugAbajo;
import concreto.actores.Complemento;
import concreto.actores.Escenario;
import concreto.actores.Jugador;
import concreto.actores.Pelota;
import concreto.interacciones.InteDirPelotaEscenario;
import concreto.interacciones.InteJugadorActualizar;
import concreto.interacciones.InteDirPelotaJugador;
import concreto.interacciones.IntePelotaActualizar;
import concreto.interacciones.InteReiniciar;
import concreto.operaciones.Dibujar;
import concreto.operaciones.Dormir;
import concreto.operaciones.Interactuar;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Launcher {

    public static void main(String[] args) {
        
        Ventana ventana = new Ventana(800, 600);
        int anchoJuego = ventana.getAnchoJuego();
        int altoJuego = ventana.getAltoJuego();

        Pelota pelota = new Pelota(anchoJuego/2, altoJuego/2);
        Jugador jugador1 = new Jugador(70, altoJuego/2);
        Jugador jugador2 = new Jugador(720, altoJuego/2);
        Escenario escenario = new Escenario(0, 60, anchoJuego, altoJuego);
        Complemento complemento = new Complemento(0, 0, anchoJuego, 60);

        HashMap<Integer, ActJugador> actsJugador = new HashMap<>();
        actsJugador.put(KeyEvent.VK_W, new ActJugArriba(jugador1));
        actsJugador.put(KeyEvent.VK_S, new ActJugAbajo(jugador1));
        actsJugador.put(KeyEvent.VK_I, new ActJugArriba(jugador2));
        actsJugador.put(KeyEvent.VK_K, new ActJugAbajo(jugador2));
                
        ventana.addKeyListener(new Listener(actsJugador));

        Lienzo[] lienzos = {complemento, escenario, pelota, jugador1, jugador2};
        int cont;
        
        cont = 0;
        Interaccion[] interacciones = new Interaccion[7];
        interacciones[cont++] = new InteJugadorActualizar(pelota, escenario, jugador1);
        interacciones[cont++] = new InteJugadorActualizar(pelota, escenario, jugador2);
        interacciones[cont++] = new InteReiniciar(pelota, escenario, jugador1, jugador2);
        interacciones[cont++] = new InteDirPelotaJugador(pelota, jugador1);
        interacciones[cont++] = new InteDirPelotaJugador(pelota, jugador2);
        interacciones[cont++] = new InteDirPelotaEscenario(pelota, escenario);
        interacciones[cont++] = new IntePelotaActualizar(pelota);
        
        cont = 0;
        Operacion[] operaciones = new Operacion[3];
        operaciones[cont++] = new Dibujar(anchoJuego, altoJuego, ventana.getLapiz(), lienzos);
        operaciones[cont++] = new Interactuar(interacciones);
        operaciones[cont++] = new Dormir();
        
        Pong pong = new Pong(operaciones);
        pong.iniciarJuego();
    }

}

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
import concreto.interacciones.IntePelotaEscenario;
import concreto.interacciones.IntePelotaJugador;
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
        actsJugador.put(KeyEvent.VK_W, new ActJugArriba(pelota, jugador1, escenario));
        actsJugador.put(KeyEvent.VK_S, new ActJugAbajo(pelota, jugador1, escenario));
        actsJugador.put(KeyEvent.VK_I, new ActJugArriba(pelota, jugador2, escenario));
        actsJugador.put(KeyEvent.VK_K, new ActJugAbajo(pelota, jugador2, escenario));
                
        ventana.addKeyListener(new Listener(actsJugador));

        Lienzo[] lienzos = {complemento, escenario, pelota, jugador1, jugador2};
        int cont;
        
        cont = 0;
        Interaccion[] interacciones = new Interaccion[4];        
        interacciones[cont++] = new InteReiniciar(pelota, escenario, jugador1, jugador2);
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

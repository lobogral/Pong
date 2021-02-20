
import Actores.Complemento;
import Actores.Escenario;
import Actores.Jugador;
import Actores.Pelota;
import Interfaces.Lienzo;
import Interfaces.Operacion;
import Operaciones.Dibujar;
import Operaciones.Dormir;
import Operaciones.Interactuar;
import java.awt.event.KeyEvent;

public class Pong {
    
    private final Operacion[] operaciones;
    
    public Pong(){
        Ventana ventana = new Ventana(800, 600);
        int anchoJuego = ventana.getAnchoJuego();
        int altoJuego = ventana.getAltoJuego();

        Pelota pelota = new Pelota(anchoJuego/2, altoJuego/2);
        Jugador jugador1 = new Jugador(70, altoJuego/2, KeyEvent.VK_W, KeyEvent.VK_S);
        Jugador jugador2 = new Jugador(720, altoJuego/2, KeyEvent.VK_I, KeyEvent.VK_K);
        Escenario escenario = new Escenario(0, 57, anchoJuego, altoJuego);
        Complemento complemento = new Complemento(0, 0, anchoJuego, 57);

        ventana.addKeyListener(jugador1);
        ventana.addKeyListener(jugador2);

        Lienzo[] lienzos = {complemento, escenario, pelota, jugador1, jugador2};

        operaciones = new Operacion[3];
        operaciones[0] = new Dibujar(anchoJuego, altoJuego, ventana.getLapiz(), lienzos);
        operaciones[1] = new Interactuar(escenario, pelota, jugador1, jugador2);
        operaciones[2] = new Dormir();

        
    }
    
    public void iniciarJuego(){
        while (true) {
            for (Operacion operacion : operaciones) {
                operacion.realizar();
            }
        }
    }
    
}

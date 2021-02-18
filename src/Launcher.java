import Actores.Escenario;
import Actores.Jugador;
import Actores.Pelota;
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
        
        Jugador[] jugadores = {jugador1, jugador2};

        Operacion[] operaciones = new Operacion[3];
        operaciones[0] = new Dibujar(ventana.getLapiz(), escenario, pelota, jugadores);
        operaciones[1] = new Interactuar(escenario, pelota, jugador1, jugador2);
        operaciones[2] = new Dormir();

        while (true) {
            for (Operacion operacion : operaciones) {
                operacion.realizar();
            }
        }
    }
}

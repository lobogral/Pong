package Principal;

import Actores.ActEscenario;
import Actores.ActPelota;
import Actores.ActJugador;
import Interacciones.InteJugadorEscenario;
import Interacciones.IntePelotaEscenario;
import Interacciones.IntePuntaje;
import Interacciones.IntePelotaJugador;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Pong extends JFrame {

    private final Interaccion[] interacciones;
    private final Actor[] actores;

    public static void main(String[] args) {
        Pong pong = new Pong();
    }

    public Pong() {
        
        int ANCHO = 800;
        int ALTO = 600;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(ANCHO, ALTO);
        this.setResizable(false);
        this.setLocation(100, 100);
        this.setVisible(true);
        this.setTitle("Pong");
        this.createBufferStrategy(2);

        ActPelota pelota = new ActPelota(ANCHO/2, ALTO/2);
        ActJugador jugador1 = new ActJugador(70, ALTO/2);
        ActJugador jugador2 = new ActJugador(720, ALTO/2);
        ActEscenario escenario = new ActEscenario(ANCHO, ALTO);
        this.addKeyListener(jugador1);
        this.addKeyListener(jugador2);
        
        actores = new Actor[4];
        actores[0] = escenario;
        actores[1] = pelota;
        actores[2] = jugador1;
        actores[3] = jugador2;

        interacciones = new Interaccion[6];
        interacciones[0] = new InteJugadorEscenario(jugador1, escenario);
        interacciones[1] = new InteJugadorEscenario(jugador2, escenario);
        interacciones[2] = new IntePuntaje(pelota, escenario, jugador1, jugador2);
        interacciones[3] = new IntePelotaJugador(pelota, jugador1);
        interacciones[4] = new IntePelotaJugador(pelota, jugador2);
        interacciones[5] = new IntePelotaEscenario(pelota, escenario);
        
        while (true) {
            this.interactuar();
            this.dibujar();
            this.dormir();
        }

    }

    private void interactuar() {
        for (Interaccion interaccion : interacciones) {
            interaccion.ejecutar();
        }
    }
    
    private void dibujar() {
        
        BufferStrategy buffer = this.getBufferStrategy();
        Graphics lapiz = buffer.getDrawGraphics();
        
        for (Actor actor : actores) {
            actor.dibujar(lapiz);
        }

        lapiz.dispose();
        buffer.show();

        Toolkit.getDefaultToolkit().sync();
    }

    private void dormir() {
        long tiempoRetrazo = System.currentTimeMillis() + 15;
        long tiempoActual = 0;
        while (tiempoActual < tiempoRetrazo) {
            tiempoActual = System.currentTimeMillis();
        }
    }

}

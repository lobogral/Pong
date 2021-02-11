package Principal;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Pong {

    private final JFrame ventana;
    private final Interaccion[] interacciones;
    private final Actor[] actores;

    public Pong(JFrame ventana, Actor[] actores, Interaccion[] interacciones) {

        this.ventana = ventana;
        this.actores = actores;
        this.interacciones = interacciones;
        
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
        
        BufferStrategy buffer = ventana.getBufferStrategy();
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

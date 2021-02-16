package Principal;

import java.awt.Graphics;

public class Pong {

    private final Ventana ventana;
    private final Interaccion[] interacciones;
    private final Actor[] actores;

    public Pong(Ventana ventana, Actor[] actores, Interaccion[] interacciones) {

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

        Graphics lapiz = ventana.getLapiz();
        
        for (Actor actor : actores) {
            actor.dibujar(lapiz);
        }

        ventana.dibujar();
    }

    private void dormir() {
        long tiempoRetrazo = System.currentTimeMillis() + 15;
        long tiempoActual = 0;
        while (tiempoActual < tiempoRetrazo) {
            tiempoActual = System.currentTimeMillis();
        }
    }

}

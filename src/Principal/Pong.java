package Principal;

import java.awt.Graphics;

public class Pong {

    private final Interaccion[] interacciones;
    private final Actor[] actores;

    public Pong(Graphics lapiz, Actor[] actores, Interaccion[] interacciones) {

        this.actores = actores;
        this.interacciones = interacciones;
        
        while (true) {
            this.interactuar();
            this.dibujar(lapiz);
            this.dormir();
        }

    }

    private void interactuar() {
        for (Interaccion interaccion : interacciones) {
            interaccion.ejecutar();
        }
    }

    private void dibujar(Graphics lapiz) {
        for (Actor actor : actores) {
            actor.dibujar(lapiz);
        }
    }

    private void dormir() {
        long tiempoRetrazo = System.currentTimeMillis() + 15;
        long tiempoActual = 0;
        while (tiempoActual < tiempoRetrazo) {
            tiempoActual = System.currentTimeMillis();
        }
    }

}

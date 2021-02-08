import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Pong extends KeyAdapter {

    private static final int ANCHO = 800;
    private static final int ALTO = 600;
    private final Pelota pelota;
    private final Jugador jugadorIzquierdo;
    private final Jugador jugadorDerecho;
    private final JFrame escenario;


    public static void main(String[] args) {
        Pong pong = new Pong();
    }

    public Pong() {
        escenario = new JFrame();
        escenario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        escenario.setSize(ANCHO, ALTO);
        escenario.setResizable(false);
        escenario.setLocation(100, 100);
        escenario.setVisible(true);
        escenario.setTitle("Pong");
        escenario.createBufferStrategy(2);
        escenario.addKeyListener(this);

        pelota = new Pelota(ANCHO/2, ALTO/2);
        jugadorIzquierdo = new Jugador(70, ALTO/2);
        jugadorDerecho = new Jugador(720, ALTO/2);

        while (true) {
            this.colisiones();
            this.dibujar();
            this.dormir();
        }

    }

    private void colisiones() {
        colisionPelotaJugador(jugadorIzquierdo);
        colisionPelotaJugador(jugadorDerecho);
        colisionPelotaEscenario();
        colisionJugadorEscenario(jugadorIzquierdo);
        colisionJugadorEscenario(jugadorDerecho);
    }

    private void colisionPelotaEscenario(){
        if (pelota.getPosX() <= 0) {
            jugadorDerecho.aumentarPuntaje();
            pelota.setPosXY(ANCHO/2, ALTO/2);
        }
      
        if (pelota.getPosX() >= ANCHO - 40) {
            jugadorIzquierdo.aumentarPuntaje();
            pelota.setPosXY(ANCHO/2, ALTO/2);
        }
        
        if (pelota.getPosY() <= 100 || pelota.getPosY() >= Pong.ALTO - 40) {
            pelota.invertirVelY();
        }
        
        pelota.actualizar();
        
    }
    
    private void colisionPelotaJugador(Jugador jugador){
        
        boolean valor1, valor2, valor3, valor4;
        valor1 = pelota.getPosX() + pelota.getDiametro() > jugador.getPosX();
        valor2 = pelota.getPosX() < jugador.getPosX() + jugador.getAncho();
        valor3 = pelota.getPosY() + pelota.getDiametro() > jugador.getPosY();
        valor4 = pelota.getPosY() < jugador.getPosY() + jugador.getAlto();
        
        if (valor1 && valor2 && valor3 && valor4) {
            pelota.invertirVelX();
            pelota.invertirVelY();
            /*
             * Doble actualizar permite que la pelota
             * No se pegue a la paleta del jugador
            */
            pelota.actualizar();
            pelota.actualizar();
        }

    }

    private void colisionJugadorEscenario(Jugador jugador){

        if (jugador.getPosY() > 100 && jugador.getVelPositiva()) {
            jugador.actualizar();
        }
        
        if (jugador.getPosY() < ALTO - 100 && !jugador.getVelPositiva()) {
            jugador.actualizar();
        }

    }
    
    private void dibujar() {
        
        BufferStrategy buffer = escenario.getBufferStrategy();
        Graphics lapiz = buffer.getDrawGraphics();

        lapiz.setColor(Color.BLACK);
        lapiz.fillRect(0, 0, ANCHO, ALTO);
        lapiz.setColor(Color.WHITE);
        lapiz.drawLine(0, 80, Pong.ANCHO, 80);
        
        pelota.dibujar(lapiz);
        jugadorIzquierdo.dibujar(lapiz);
        jugadorDerecho.dibujar(lapiz);

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

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP -> {
                jugadorIzquierdo.subir();
                jugadorDerecho.subir();
            }
            case KeyEvent.VK_DOWN -> {
                jugadorIzquierdo.bajar();
                jugadorDerecho.bajar();
            }
        }
    }

}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Pong extends JFrame implements KeyListener {

    public static final int ANCHO = 800;
    public static final int ALTO = 600;
    private final Pelota pelota;
    private final Paleta paletaIzquierda;
    private final Paleta paletaDerecha;
    private final Puntuacion puntuacion;


    public static void main(String[] args) {
        Pong pong = new Pong();
    }

    public Pong() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(ANCHO, ALTO);
        this.setResizable(false);
        this.setLocation(100, 100);
        this.setVisible(true);
        this.createBufferStrategy(2);
        this.addKeyListener(this);

        pelota = new Pelota();
        paletaIzquierda = new Paleta(70);
        paletaDerecha = new Paleta(700);
        puntuacion = new Puntuacion();

        while (true) {
            this.compararPelotaPaletas();
            this.actualizar();
            this.dibujar();
            this.dormir();
        }

    }

    private void actualizar() {
        pelota.actualizar();
    }

    private void compararPelotaPaletas() {

        //Colision pelota-paletaIzquierda
        boolean valor1 = pelota.getPosX() + pelota.getDiametro() > paletaIzquierda.getPosX();
        boolean valor2 = pelota.getPosX() < paletaIzquierda.getPosX() + paletaIzquierda.getAncho();
        boolean valor3 = pelota.getPosY() + pelota.getDiametro() > paletaIzquierda.getPosY();
        boolean valor4 = pelota.getPosY() < paletaIzquierda.getPosY() + paletaIzquierda.getAlto();

        if (valor1 && valor2 && valor3 && valor4) {
            pelota.invertirVelX();
        }         
        
        if (pelota.getPosX() <= 0) {
            puntuacion.aumentarBuenas();
            pelota.setInicial();
        }

        //Colisión pelota-paletaDerecha
        valor1 = pelota.getPosX() + pelota.getDiametro() > paletaDerecha.getPosX();
        valor2 = pelota.getPosX() < paletaDerecha.getPosX() + paletaDerecha.getAncho();
        valor3 = pelota.getPosY() + pelota.getDiametro() > paletaDerecha.getPosY();
        valor4 = pelota.getPosY() < paletaDerecha.getPosY() + paletaDerecha.getAlto();
        
        if (valor1 && valor2 && valor3 && valor4) {
            pelota.invertirVelX();
        }
      
        if (pelota.getPosX() >= ANCHO - 40) {
            puntuacion.aumentarMalas();
            pelota.setInicial();
        }
        
    }

    private void dibujar() {
        
        BufferStrategy buffer = this.getBufferStrategy();
        Graphics lapiz = buffer.getDrawGraphics();

        lapiz.setColor(Color.GRAY);
        lapiz.fillRect(0, 0, ANCHO, ALTO);

        pelota.dibujar(lapiz);
        paletaIzquierda.dibujar(lapiz);
        paletaDerecha.dibujar(lapiz);
        puntuacion.dibujar(lapiz);

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
                paletaIzquierda.subir();
                paletaDerecha.subir();
            }
            case KeyEvent.VK_DOWN -> {
                paletaIzquierda.bajar();
                paletaDerecha.bajar();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}

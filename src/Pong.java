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
    private final Paletas paletas;
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
        paletas = new Paletas();
        puntuacion = new Puntuacion();

        while (true) {
            this.comparar();
            this.actualizar();
            this.dibujar();
            this.dormir();
        }

    }

    private void actualizar() {
        paletas.actualizar();
        pelota.actualizar();
    }

    private void comparar() {
        boolean valor1 = pelota.getX() < 75 && pelota.getX() > 60;
        boolean valor2 = pelota.getY() > paletas.getY();
        boolean valor3 = pelota.getY() < paletas.getY() + paletas.getAlto();
        if (valor1 && valor2 && valor3) {
            if (pelota.getVeloX() < 0) {
                puntuacion.aumentarBuenas();
            }
            pelota.cambiarDireccion();
        }

        boolean valor4 = pelota.getX() > 695 && pelota.getX() < 710;
        boolean valor5 = pelota.getY() > paletas.getY();
        boolean valor6 = pelota.getY() < paletas.getY() + paletas.getAlto();
        if (valor4 && valor5 && valor6) {
            if (pelota.getVeloX() > 0) {
                puntuacion.aumentarBuenas();
            }
            pelota.cambiarDireccion();
        }
        
        if (pelota.getX() <= 0 || pelota.getX() >= ANCHO - 40) {
            puntuacion.aumentarMalas();
        }
    }

    private void dibujar() {

        BufferStrategy buffer = this.getBufferStrategy();
        Graphics lapiz = buffer.getDrawGraphics();

        lapiz.setColor(Color.GRAY);
        lapiz.fillRect(0, 0, ANCHO, ALTO);

        pelota.dibujar(lapiz);
        paletas.dibujar(lapiz);
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
            case KeyEvent.VK_UP:
                paletas.cambiarDireccion();
                break;
            case KeyEvent.VK_DOWN:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}

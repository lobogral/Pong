package Principal;

import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Ventana extends JFrame {

    public Ventana(int ANCHO, int ALTO, KeyListener[] keyListeners) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(ANCHO, ALTO);
        this.setResizable(false);
        this.setLocation(100, 100);
        this.setVisible(true);
        this.setTitle("Pong");
        this.createBufferStrategy(2);
        
        for (KeyListener keyListener : keyListeners) {
            this.addKeyListener(keyListener);
        }

    }

}

package abstracto.clases;

import java.awt.Graphics;
import javax.swing.JFrame;

public class Ventana extends JFrame {
    
    public Ventana(int ancho, int alto) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(ancho, alto);
        this.setResizable(false);
        this.setLocation(100, 100);
        this.setVisible(true);
        this.setTitle("Pong");
    }

    public int getAnchoJuego(){
        return getContentPane().getWidth();
    }

    public int getAltoJuego(){
        return getContentPane().getHeight();
    }
    
    public Graphics getLapiz(){
        return getContentPane().getGraphics();
    }

}
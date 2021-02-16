package Principal;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Ventana extends JFrame {

    private final Image buffer; 
    private final Graphics virtual;
    private final Graphics real;

    public Ventana() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setResizable(false);
        this.setLocation(100, 100);
        this.setVisible(true);
        this.setTitle("Pong");
        
        buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        virtual = buffer.getGraphics();
        real = getContentPane().getGraphics();

    }
    
    public Graphics getLapiz(){
        return virtual;
    }
    
    public void dibujar(){
        real.drawImage(buffer, 0, 0, null);
    }
    
    public int getAncho(){
        return getContentPane().getWidth();
    }
    
    public int getAlto(){
        return getContentPane().getHeight();
    }

}

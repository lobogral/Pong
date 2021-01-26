import java.awt.Color;
import java.awt.Graphics;

public class Paletas {
    
    private int y;
    private int veloY;
    private final int alto;

    public Paletas() {
        y = Pong.ALTO / 2;
        veloY = 4;
        alto = 80;
    }
    
    public void dibujar(Graphics lapiz){
        lapiz.setColor(Color.ORANGE);
        lapiz.fillRect(68, y, 20, alto);
        lapiz.fillRect(702, y, 20, alto);
    }
    
    public void actualizar(){
        if (y > 100 && veloY<0) {
            y += veloY;
        }
        if (y < Pong.ALTO - 100 && veloY>0) {
            y += veloY;
        }
    }
    
    public void cambiarDireccion(){
        veloY = -veloY;
    }
    
    public int getY(){
        return y;
    }
    
    public int getAlto(){
        return alto;
    }
}

import java.awt.Color;
import java.awt.Graphics;

public class Pelota {
    private int x;
    private int y;
    private int veloX;
    private int veloY;

    public Pelota() {
        x = Pong.ANCHO /2;
        y = Pong.ALTO /2;
        veloX = 5;
        veloY = -5;
    }
    
    public void dibujar(Graphics lapiz){
        lapiz.setColor(Color.CYAN);
        lapiz.fillOval(x, y, 20, 20);
    }
    
    public void actualizar(){
        x = x + veloX;
        y = y + veloY;

        if (x <= 0 || x >= Pong.ANCHO - 40) {
            veloX = -veloX;
        }

        if (y <= 100 || y >= Pong.ALTO - 40) {
            veloY = -veloY;
        }
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getVeloX(){
        return veloX;
    }
    public void cambiarDireccion(){
        veloX = -veloX;
    }
}

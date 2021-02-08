import java.awt.Color;
import java.awt.Graphics;

public class Pelota {
    private int posX;
    private int posY;
    private int velX;
    private int velY;
    private final int diametro;

    public Pelota() {
        posX = Pong.ANCHO /2;
        posY = Pong.ALTO /2;
        velX = 2;
        velY = -2;
        diametro = 20;
    }
    
    public void dibujar(Graphics lapiz){
        lapiz.setColor(Color.CYAN);
        lapiz.fillOval(posX, posY, diametro, diametro);
    }
    
    public void actualizar(){
        posX = posX + velX;
        posY = posY + velY;

        if (posX <= 0 || posX >= Pong.ANCHO - 40) {
            velX = -velX;
        }

        if (posY <= 100 || posY >= Pong.ALTO - 40) {
            velY = -velY;
        }
    }
    
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public void invertirVelX(){
        velX = -velX;
    }
    public void setInicial(){
        posX = Pong.ANCHO/2;
        posY = Pong.ALTO/2;
    }
    public int getDiametro(){
        return diametro;
    }

}

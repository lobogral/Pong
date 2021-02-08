import java.awt.Color;
import java.awt.Graphics;

public class Pelota {
    private int posX;
    private int posY;
    private int velX;
    private int velY;
    private final int diametro;

    public Pelota(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.velX = 2;
        this.velY = -2;
        this.diametro = 20;
    }
    
    public void dibujar(Graphics lapiz){
        lapiz.setColor(Color.WHITE);
        lapiz.fillOval(posX, posY, diametro, diametro);
    }
    
    public void actualizar(){
        posX += velX;
        posY += velY;
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
    public void invertirVelY(){
        velY = -velY;
    }
    public void setPosXY(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
    public int getDiametro(){
        return diametro;
    }

}

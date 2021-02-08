import java.awt.Color;
import java.awt.Graphics;

public class Paleta {
    
    private final int posX;
    private int posY;
    private final int alto;
    private final int ancho;

    public Paleta(int posX) {
        this.posX = posX;
        this.posY = Pong.ALTO/2;
        this.alto = 80;
        this.ancho = 20;
    }
    
    public void dibujar(Graphics lapiz){
        lapiz.setColor(Color.ORANGE);
        lapiz.fillRect(posX, posY, ancho, alto);
    }
    
    public void bajar(){
        posY += alto;
    }
    
    public void subir(){
        posY += -alto;
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
    
    public int getAlto(){
        return alto;
    }
    
    public int getAncho(){
        return ancho;
    }
}

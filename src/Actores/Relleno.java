package Actores;

import Principal.Actor;
import java.awt.Color;
import java.awt.Graphics;

public class Relleno implements Actor {

    private final int posX;
    private final int posY;
    private final int alto;
    private final int ancho;
    
    public Relleno(int ancho, int alto){
        this.posX = 0;
        this.posY = 0;
        this.ancho = ancho;
        this.alto = alto;
    }
    
    public int getAncho(){
        return ancho;
    }
        
    public int getAlto(){
        return alto;
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }

    @Override
    public void dibujar(Graphics lapiz) {
        lapiz.setColor(Color.BLACK);
        lapiz.fillRect(posX, posY, ancho, alto);
        lapiz.setColor(Color.WHITE);
        lapiz.drawLine(0, alto-1, ancho, alto-1);
    }

}

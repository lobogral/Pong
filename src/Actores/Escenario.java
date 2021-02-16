package Actores;

import Principal.Actor;
import java.awt.Color;
import java.awt.Graphics;

public class Escenario implements Actor {

    private final int posX;
    private final int posY;
    private final int alto;
    private final int ancho;
    
    public Escenario(int posX, int posY, int ancho, int alto){
        this.posX = posX;
        this.posY = posY;
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
        lapiz.fillRect(0, 0, ancho, alto);
        lapiz.setColor(Color.WHITE);
        lapiz.drawLine(0, posY-1, ancho, posY-1);
    }

}

package Actores;

import Principal.Actor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Jugador extends KeyAdapter implements Actor{
    
    private int velY;
    private final int posX;
    private int posY;
    private final int alto;
    private final int ancho;
    private int puntaje;
    
    public Jugador(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.alto = 80;
        this.ancho = 3;
        this.puntaje = 0;
        this.velY = 2;
    }
    
    @Override
    public void dibujar(Graphics lapiz){
        //Puntaje
        lapiz.setColor(Color.WHITE);
        lapiz.setFont(new Font("Courier New", Font.PLAIN, 40));
        lapiz.drawString("" + puntaje, posX - 10, 68);
        //Paleta
        lapiz.setColor(Color.WHITE);
        lapiz.fillRect(posX, posY, ancho, alto);
    }
    
    public void actualizar(){
        posY += -velY;
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
    
    public boolean getVelPositiva(){
        return velY > 0;
    }
    
    public void aumentarPuntaje(){
        puntaje++;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP -> {
                velY = 2;
            }
            case KeyEvent.VK_DOWN -> {
                velY = -2;
            }
        }
    }
}

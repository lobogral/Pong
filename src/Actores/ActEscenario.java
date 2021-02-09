package Actores;

import Principal.Actor;
import java.awt.Color;
import java.awt.Graphics;

public class ActEscenario implements Actor {

    private final int ALTO;
    private final int ANCHO;
    
    public ActEscenario(int ANCHO, int ALTO){
        this.ANCHO = ANCHO;
        this.ALTO = ALTO;
    }
    
    public int getANCHO(){
        return ANCHO;
    }
        
    public int getALTO(){
        return ALTO;
    }

    @Override
    public void dibujar(Graphics lapiz) {
        lapiz.setColor(Color.BLACK);
        lapiz.fillRect(0, 0, ANCHO, ALTO);
        lapiz.setColor(Color.WHITE);
        lapiz.drawLine(0, 80, ANCHO, 80);
    }

}

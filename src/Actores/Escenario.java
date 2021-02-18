package Actores;

import java.awt.Color;
import java.awt.Graphics;
import Interfaces.Lienzo;
import Interfaces.Maniqui;

public class Escenario extends Maniqui implements Lienzo {

    public Escenario(int posX, int posY, int ancho, int alto){
        this.setPos(posX, posY);
        this.setDimensiones(ancho, alto);
    }

    @Override
    public void dibujar(Graphics lapiz) {
        lapiz.setColor(Color.BLACK);
        lapiz.fillRect(0, 0, getAncho(), getAlto());
        lapiz.setColor(Color.WHITE);
        lapiz.drawLine(0, getPosY()-1, getAncho(), getPosY()-1);
    }

}

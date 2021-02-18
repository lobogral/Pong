package Actores;

import java.awt.Color;
import java.awt.Graphics;
import Interfaces.Lienzo;
import Interfaces.Maniqui;

public class Pelota extends Maniqui implements Lienzo {

    public Pelota(int posX, int posY) {
        this.setPos(posX, posY);
        this.setVel(2, -2);
        this.setDimensiones(14, 14);
    }

    @Override
    public void dibujar(Graphics lapiz){
        lapiz.setColor(Color.WHITE);
        lapiz.fillOval(getPosX(), getPosY(), getAncho(), getAlto());
    }

}

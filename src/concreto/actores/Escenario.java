package concreto.actores;

import java.awt.Color;
import java.awt.Graphics;
import abstracto.interfaces.Lienzo;
import abstracto.clases.Maniqui;

public final class Escenario extends Maniqui implements Lienzo {

    public Escenario(int posX, int posY, int ancho, int alto){
        this.setPos(posX, posY);
        this.setDimensiones(ancho, alto);
    }

    @Override
    public void dibujar(Graphics lapiz) {
        lapiz.setColor(Color.BLACK);
        lapiz.fillRect(getPosX(), getPosY(), getAncho(), getAlto());
    }

}

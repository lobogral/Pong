package concreto.actores;

import abstracto.interfaces.Lienzo;
import abstracto.maniqui.ManiquiEst;
import java.awt.Color;
import java.awt.Graphics;

public final class Complemento extends ManiquiEst implements Lienzo {

    public Complemento(int posX, int posY, int ancho, int alto){
        this.setPos(posX, posY);
        this.setDimensiones(ancho, alto);
    }

    @Override
    public void dibujar(Graphics lapiz) {
        lapiz.setColor(Color.BLACK);
        lapiz.fillRect(getPosX(), getPosY(), getAncho(), getAlto());
        lapiz.setColor(Color.WHITE);
        lapiz.drawLine(getPosX(), getAlto()-1, getAncho(), getAlto()-1);
    }

}
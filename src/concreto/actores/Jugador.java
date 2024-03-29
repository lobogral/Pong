package concreto.actores;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import abstracto.interfaces.Lienzo;
import abstracto.interfaces.Puntaje;
import abstracto.maniqui.ManiquiOpcionMov;

public final class Jugador extends ManiquiOpcionMov implements Lienzo, Puntaje {

    private int puntaje;

    public Jugador(int posX, int posY) {
        this.setPos(posX, posY);
        this.setVel(0, 20);
        this.setDimensiones(3, 80);
        this.puntaje = 0;
    }

    @Override
    public void dibujar(Graphics lapiz){
        //Puntaje
        lapiz.setColor(Color.WHITE);
        lapiz.setFont(new Font("Courier New", Font.PLAIN, 40));
        lapiz.drawString("" + puntaje, getPosX() - 10, 40);
        //Paleta
        lapiz.setColor(Color.WHITE);
        lapiz.fillRect(getPosX(), getPosY(), getAncho(), getAlto());
    }

    @Override
    public void aumentar(){
        puntaje++;
    }

}

package concreto.actores;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import abstracto.interfaces.Lienzo;
import abstracto.clases.Maniqui;
import abstracto.interfaces.Puntaje;

public class Jugador extends Maniqui implements Lienzo, Puntaje {

    private int puntaje;

    public Jugador(int posX, int posY) {
        this.setPos(posX, posY);
        this.setVel(0, 2);
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

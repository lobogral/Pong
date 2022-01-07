package concreto.actores;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import abstracto.interfaces.Lienzo;
import abstracto.clases.Maniqui;
import abstracto.interfaces.ListenerEsp;
import abstracto.interfaces.Puntaje;

public class Jugador extends Maniqui implements Lienzo, Puntaje, ListenerEsp {

    private int puntaje;
    private final int keyEventUp;
    private final int keyEventDown;

    public Jugador(int posX, int posY, int keyEventUp, int keyEventDown) {
        this.setPos(posX, posY);
        this.setVel(0, 2);
        this.setDimensiones(3, 80);
        this.puntaje = 0;
        this.keyEventUp = keyEventUp;
        this.keyEventDown = keyEventDown;
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

    @Override
    public void ejecutar(int key) {
        if(key == keyEventUp){
            setVel(0, -2);
        } else if(key == keyEventDown){
            setVel(0, 2);
        }
    }

}

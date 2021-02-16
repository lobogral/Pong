package Operaciones;

import Interfaces.Actor;
import Interfaces.Operacion;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Dibujar implements Operacion {

    private final Image buffer; 
    private final Graphics lapizVirtual;
    private final Graphics lapizReal;
    private final Actor[] actores;
    
    public Dibujar(Graphics lapiz, Actor[] actores) {
        
        this.actores = actores;
        
        buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        lapizVirtual = buffer.getGraphics();
        lapizReal = lapiz;

    }

    @Override
    public void realizar() {
        for (Actor actor : actores) {
            actor.dibujar(lapizVirtual);
        }
        lapizReal.drawImage(buffer, 0, 0, null);
    }

}

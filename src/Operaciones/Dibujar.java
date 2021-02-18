package Operaciones;

import Interfaces.Operacion;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import Interfaces.Lienzo;

public class Dibujar implements Operacion {

    private final Image buffer; 
    private final Graphics lapizVirtual;
    private final Graphics lapizReal;
    private final Lienzo[] actores;
    
    public Dibujar(Graphics lapiz, Lienzo[] actores) {
        
        this.actores = actores;
        
        buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        lapizVirtual = buffer.getGraphics();
        lapizReal = lapiz;

    }

    @Override
    public void realizar() {
        for (Lienzo actor : actores) {
            actor.dibujar(lapizVirtual);
        }
        lapizReal.drawImage(buffer, 0, 0, null);
    }

}

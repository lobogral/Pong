package concreto.operaciones;

import abstracto.interfaces.Operacion;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import abstracto.interfaces.Lienzo;

public final class Dibujar implements Operacion {

    private final Image buffer; 
    private final Graphics lapizVirtual;
    private final Graphics lapizReal;
    private final Lienzo[] lienzos;
    
    public Dibujar(int ancho, int alto, Graphics lapiz, Lienzo[] lienzos) {
        
        this.lienzos = lienzos;
        
        buffer = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        lapizVirtual = buffer.getGraphics();
        lapizReal = lapiz;

    }

    @Override
    public void realizar() {
        for (Lienzo lienzo : lienzos) {
            lienzo.dibujar(lapizVirtual);
        }
        lapizReal.drawImage(buffer, 0, 0, null);
    }

}

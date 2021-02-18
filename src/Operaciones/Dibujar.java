package Operaciones;

import Actores.Escenario;
import Actores.Jugador;
import Actores.Pelota;
import Interfaces.Operacion;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import Interfaces.Lienzo;

public class Dibujar implements Operacion {

    private final Image buffer; 
    private final Graphics lapizVirtual;
    private final Graphics lapizReal;
    private final Lienzo[] lienzos;
    
    public Dibujar(Graphics lapiz, Escenario escenario, Pelota pelota, Jugador[] jugadores) {
        
        this.lienzos = new Lienzo[]{escenario, pelota, jugadores[0], jugadores[1]};
        
        buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
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

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Puntuacion {
    private int puntuacionPaletaDerecha;
    private int puntuacionPaletaIzquierda;
    
    public void dibujar(Graphics lapiz){
        lapiz.setColor(Color.BLUE);
        lapiz.fillRect(0, 0, Pong.ANCHO, 80);
        lapiz.setColor(Color.WHITE);
        lapiz.drawLine(0, 80, Pong.ANCHO, 80);
        
        lapiz.setColor(Color.WHITE);
        lapiz.setFont(new Font("Arial", Font.BOLD, 16));
        lapiz.drawString("Paleta derecha: " + puntuacionPaletaDerecha, 20, 50);

        lapiz.setColor(Color.WHITE);
        lapiz.setFont(new Font("Arial", Font.BOLD, 16));
        lapiz.drawString("Paleta izquierda: " + puntuacionPaletaIzquierda, 20, 70);
    }
    
    public void aumentarBuenas(){
        puntuacionPaletaDerecha++;
    }
    public void aumentarMalas(){
        puntuacionPaletaIzquierda++;
    }
}

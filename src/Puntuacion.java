import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Puntuacion {
    private int Buenas;
    private int Malas;
    
    public void dibujar(Graphics lapiz){
        lapiz.setColor(Color.BLUE);
        lapiz.fillRect(0, 0, Pong.ANCHO, 80);
        lapiz.setColor(Color.WHITE);
        lapiz.drawLine(0, 80, Pong.ANCHO, 80);
        
        lapiz.setColor(Color.WHITE);
        lapiz.setFont(new Font("Arial", Font.BOLD, 16));
        lapiz.drawString("Buenas: " + Buenas, 20, 50);

        lapiz.setColor(Color.WHITE);
        lapiz.setFont(new Font("Arial", Font.BOLD, 16));
        lapiz.drawString("Malas: " + Malas, 20, 70);
    }
    
    public void aumentarBuenas(){
        Buenas++;
    }
    public void aumentarMalas(){
        Malas++;
    }
}

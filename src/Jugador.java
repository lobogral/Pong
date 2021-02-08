import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Jugador {
    
    private int velY;
    private final int posX;
    private int posY;
    private final int alto;
    private final int ancho;
    private int puntaje;
    
    public Jugador(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.alto = 80;
        this.ancho = 5;
        this.puntaje = 0;
        this.velY = 2;
    }
    
    public void dibujar(Graphics lapiz){
        //Puntaje
        lapiz.setColor(Color.WHITE);
        lapiz.setFont(new Font("Consolas", Font.PLAIN, 30));
        lapiz.drawString("" + puntaje, posX - 5, 65);
        //Paleta
        lapiz.setColor(Color.WHITE);
        lapiz.fillRect(posX, posY, ancho, alto);
    }
    
    public void actualizar(){
        posY += -velY;
    }
    
    public void bajar(){
        velY = -2;
    }
    
    public void subir(){
        velY = 2;
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
    
    public int getAlto(){
        return alto;
    }
    
    public int getAncho(){
        return ancho;
    }
    
    public boolean getVelPositiva(){
        return velY > 0;
    }
    
    public void aumentarPuntaje(){
        puntaje++;
    }
}

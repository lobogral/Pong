package abstracto.maniqui;

/**
 * Maniquí estático
 */
public class ManiquiEst {
    private int posX;
    private int posY;
    private int ancho;
    private int alto;
    
    public void setPos(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public void setDimensiones(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
    
    public int getAncho(){
        return ancho;
    }
    
    public int getAlto(){
        return alto;
    }
    
}

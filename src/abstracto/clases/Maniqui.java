package abstracto.clases;

public class Maniqui {
    
    private int posX;
    private int posY;
    private int velX;
    private int velY;
    private int ancho;
    private int alto;
    
    public void setPos(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
    
    public void setVel(int velX, int velY){
        this.velX = velX;
        this.velY = velY;
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
    
    public int getVelX(){
        return velX;
    }
    
    public int getVelY(){
        return velY;
    }
    
    public int getAncho(){
        return ancho;
    }
    
    public int getAlto(){
        return alto;
    }
    
    public void actualizar(){
        posX += velX;
        posY += velY;
    }
}

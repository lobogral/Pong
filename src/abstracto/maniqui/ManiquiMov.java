package abstracto.maniqui;

/**
 * Maniquí movible o actualizable
 */
public class ManiquiMov extends ManiquiEst{
    
    private int velX;
    private int velY;
    
    public void setVel(int velX, int velY){
        this.velX = velX;
        this.velY = velY;
    }
    
    public int getVelX(){
        return velX;
    }
    
    public int getVelY(){
        return velY;
    }
    
    public void actualizar(){
        this.setPos(getPosX() + velX, getPosY() + velY);
    }
}

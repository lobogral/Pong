package abstracto.maniqui;

/**
 * Maniquí con opción de moverse o no
 */
public class ManiquiOpcionMov extends ManiquiMov{
    
    private boolean isMoviendo;
    
    public boolean getIsMoviendo(){
        return isMoviendo;
    }
    
    public void setIsMoviendo(boolean isMoviendo){
        this.isMoviendo = isMoviendo;
    }
    
}

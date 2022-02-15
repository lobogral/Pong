package concreto.cambios;
import abstracto.maniqui.ManiquiEst;
import abstracto.maniqui.ManiquiMov;
import abstracto.interfaces.Cambio;

public final class CambVelPelotaPorEscenario implements Cambio{
    
    private final ManiquiMov pelota;
    private final ManiquiEst escenario;
    
    public CambVelPelotaPorEscenario(ManiquiMov pelota, ManiquiEst escenario){
        this.pelota = pelota;
        this.escenario = escenario;
    }
    
    @Override
    public void ejecutar(){
        
        // Revisa si el jugador está fuera del escenario (coordenadas verticales)
        boolean interE = false;
        interE |= pelota.getPosY() <= escenario.getPosY();
        interE |= pelota.getPosY() >= escenario.getAlto() - pelota.getAlto();
        
        // En caso de que esté fuera, cambia de dirección
        if (interE) {
            pelota.setVel(pelota.getVelX(), -pelota.getVelY());
        }
        
    }
    
}
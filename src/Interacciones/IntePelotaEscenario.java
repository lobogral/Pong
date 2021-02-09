package Interacciones;
import Actores.ActEscenario;
import Principal.Interaccion;
import Actores.ActPelota;

public class IntePelotaEscenario implements Interaccion{
    
    private final ActPelota pelota;
    private final ActEscenario escenario;
    
    public IntePelotaEscenario(ActPelota pelota, ActEscenario escenario){
        this.pelota = pelota;
        this.escenario = escenario;
    }
    
    @Override
    public void ejecutar(){
        if (pelota.getPosX() <= 0) {
            pelota.setPosXY(escenario.getANCHO()/2, escenario.getALTO()/2);
        }
      
        if (pelota.getPosX() >= escenario.getANCHO() - 40) {
            pelota.setPosXY(escenario.getANCHO()/2, escenario.getALTO()/2);
        }
        
        if (pelota.getPosY() <= 100 || pelota.getPosY() >= escenario.getALTO() - 40) {
            pelota.invertirVelY();
        }
        
        pelota.actualizar();
    }
    
}
package Interacciones;
import Actores.Escenario;
import Principal.Interaccion;
import Actores.Pelota;

public class IntePelotaEscenario implements Interaccion{
    
    private final Pelota pelota;
    private final Escenario escenario;
    
    public IntePelotaEscenario(Pelota pelota, Escenario escenario){
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
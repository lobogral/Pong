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
        
        boolean valor1 = pelota.getPosX() <= 0;
        boolean valor2 = pelota.getPosX() >= escenario.getAncho() - pelota.getDiametro();
        if (valor1 || valor2) {
            pelota.setPosXY(escenario.getAncho()/2, escenario.getAlto()/2);
        }

        boolean valor3 = pelota.getPosY() <= escenario.getPosY();
        boolean valor4 = pelota.getPosY() >= escenario.getAlto() - pelota.getDiametro();
        if (valor3 || valor4) {
            pelota.invertirVelY();
        }
        
        pelota.actualizar();
    }
    
}
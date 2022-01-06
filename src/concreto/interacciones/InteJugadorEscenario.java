package concreto.interacciones;
import abstracto.interfaces.Interaccion;
import abstracto.clases.Maniqui;

public class InteJugadorEscenario implements Interaccion{
    
    private final Maniqui jugador;
    private final Maniqui escenario;
    
    public InteJugadorEscenario(Maniqui jugador, Maniqui escenario){
        this.jugador = jugador;
        this.escenario = escenario;
    }

    @Override
    public void ejecutar(){
        if (jugador.getPosY() > escenario.getPosY() && jugador.getVelY()<=0) {
            jugador.actualizar();
        }
        
        boolean valor1 = jugador.getPosY() + jugador.getAlto() < escenario.getAlto();
        boolean valor2 = jugador.getVelY()>0;
        if (valor1 && valor2) {
            jugador.actualizar();
        }
    }

}

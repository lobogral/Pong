package Interacciones;
import Actores.Escenario;
import Interfaces.Interaccion;
import Actores.Jugador;

public class InteJugadorEscenario implements Interaccion{
    
    private final Jugador jugador;
    private final Escenario escenario;
    
    public InteJugadorEscenario(Jugador jugador, Escenario escenario){
        this.jugador = jugador;
        this.escenario = escenario;
    }
    
    @Override
    public void ejecutar(){
        if (jugador.getPosY() > escenario.getPosY() && jugador.getVelPositiva()) {
            jugador.actualizar();
        }
        
        boolean valor1 = jugador.getPosY() + jugador.getAlto() < escenario.getAlto();
        boolean valor2 = !jugador.getVelPositiva();
        if (valor1 && valor2) {
            jugador.actualizar();
        }
    }
    
}

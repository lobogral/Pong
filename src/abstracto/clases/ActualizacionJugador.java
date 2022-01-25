package abstracto.clases;

public class ActualizacionJugador {
    
    private final Maniqui jugador;
    private final Maniqui escenario;
    private final Maniqui pelota;
    private final int velYJugador;
    
    public ActualizacionJugador(Maniqui pelota, Maniqui jugador, Maniqui escenario, int velYJugador){
        this.pelota = pelota;
        this.jugador = jugador;
        this.escenario = escenario;
        this.velYJugador = velYJugador;
    }
    
    public void ejecutar(){
        
        boolean valorFinal = true;
        
        // Interacción jugador con bordes del escenario
        boolean valor1 = jugador.getPosY() > escenario.getPosY();
        boolean valor2 = jugador.getPosY() + jugador.getAlto() < escenario.getAlto();
        valorFinal = valorFinal && valor1 && valor2;

        // Interacción jugador con pelota
        boolean valor3 = pelota.getPosY() + pelota.getAlto() < jugador.getPosY();
        boolean valor4 = pelota.getPosY() > jugador.getPosY() + jugador.getAlto();
        boolean valor5 = pelota.getPosX() + pelota.getAncho() < jugador.getPosX();
        boolean valor6 = pelota.getPosX() > jugador.getPosX() + jugador.getAncho();
        valorFinal = valorFinal && (valor3 || valor4 || valor5 || valor6);

        if(valorFinal){
            jugador.setVel(0, velYJugador);
            jugador.actualizar();
        }
        
    }
    
}

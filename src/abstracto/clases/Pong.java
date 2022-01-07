package abstracto.clases;

import abstracto.interfaces.Operacion;

public class Pong {
    
    private final Operacion[] operaciones;
    
    public Pong(Operacion[] operaciones){
        this.operaciones = operaciones;
    }
    
    public void iniciarJuego(){
        while (true) {
            for (Operacion operacion : operaciones) {
                operacion.realizar();
            }
        }
        
    }
    
}

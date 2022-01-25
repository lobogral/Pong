package abstracto.clases;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Listener extends KeyAdapter {
    
    private final HashMap<Integer, ActualizacionJugador> actualizacionesJugador;
    
    public Listener(HashMap<Integer, ActualizacionJugador> actualizacionesJugador){
        this.actualizacionesJugador = actualizacionesJugador;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        ActualizacionJugador actualizacionJugador = actualizacionesJugador.get(e.getKeyCode());
        if (actualizacionJugador != null) actualizacionJugador.ejecutar();
    }
    
}

package abstracto.clases;

import abstracto.interfaces.ActJugador;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Listener extends KeyAdapter {
    
    private final HashMap<Integer, ActJugador> actsJugador;
    
    public Listener(HashMap<Integer, ActJugador> actsJugador){
        this.actsJugador = actsJugador;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        ActJugador actJugador = actsJugador.get(e.getKeyCode());
        if (actJugador != null) actJugador.ejecutar();
    }
    
}

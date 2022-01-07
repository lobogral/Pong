package abstracto.clases;

import abstracto.interfaces.ListenerEsp;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Listener extends KeyAdapter {
    
    private final ListenerEsp[] listenersEsp;

    public Listener(ListenerEsp[] listenersEsp){
        this.listenersEsp = listenersEsp;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (ListenerEsp listenerEsp : listenersEsp) {
            listenerEsp.ejecutar(key);
        }
    }
    
}

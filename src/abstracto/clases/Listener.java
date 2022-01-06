package abstracto.clases;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Listener extends KeyAdapter {
    
    private final int keyEventUp;
    private final int keyEventDown;
    private final Maniqui maniqui;

    public Listener(Maniqui maniqui, int keyEventUp, int keyEventDown){
        this.maniqui = maniqui;
        this.keyEventUp = keyEventUp;
        this.keyEventDown = keyEventDown;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == keyEventUp){
            maniqui.setVel(0, -2);
        } else if(key == keyEventDown){
            maniqui.setVel(0, 2);
        }
    }
    
}

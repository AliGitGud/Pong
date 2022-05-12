package package1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private Control control;

    public KeyHandler(Control control) {
        this.control = control;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            control.setMoveUpSpieler(true);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            control.setMoveDownSpieler(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            control.setMoveUpSpieler(false);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            control.setMoveDownSpieler(false);
        }
    }
}

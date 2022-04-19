package package1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {
            Var.moveup = true;
        }else if (e.getKeyCode() == KeyEvent.VK_S){
            Var.movedown = true;
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            Var.moveup2 = true;
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            Var.movedown2 = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {
            Var.moveup = false;
        }else if (e.getKeyCode() == KeyEvent.VK_S){
            Var.movedown = false;
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            Var.moveup2 = false;
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            Var.movedown2 = false;
        }
    }
}

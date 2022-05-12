package package1;

import java.util.Timer;
import java.util.TimerTask;

public class GegnerMovement {
    private int gegnerX = 570, gegnerY = 175;
    private boolean moveUpGegner = false, moveDownGegner = false;
    Timer move;

    public GegnerMovement(Control control) {
        move = new Timer();
        move.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (moveUpGegner == true) {
                    if (gegnerY >= 5) {
                        gegnerY -= 2;
                    }
                } else if (moveDownGegner == true) {
                    if (gegnerY <= control.getWindowHeight() - 90) {
                        gegnerY += 2;
                    }
                }
            }
        }, 0, 8);
    }

    public int getGegnerX() {
        return gegnerX;
    }

    public int getGegnerY() {
        return gegnerY;
    }

    public boolean isMoveUpGegner() {
        return moveUpGegner;
    }

    public boolean isMoveDownGegner() {
        return moveDownGegner;
    }

    public void setMoveUpGegner(boolean moveUpGegner) {
        this.moveUpGegner = moveUpGegner;
    }

    public void setMoveDownGegner(boolean moveDownGegner) {
        this.moveDownGegner = moveDownGegner;
    }
}

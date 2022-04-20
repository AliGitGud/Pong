package package1;

import java.util.Timer;
import java.util.TimerTask;

public class GegnerMovement {
    private int gegnerX = 570, gegnerY = 175;
    Timer move;

    public GegnerMovement() {
        move = new Timer();
        move.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (Var.moveup2 == true) {
                    if (gegnerY >= 5) {
                        gegnerY -= 2;
                    }
                } else if (Var.movedown2 == true) {
                    if (gegnerY <= Var.windowHeight - 90) {
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
}

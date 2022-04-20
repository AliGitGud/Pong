package package1;

import java.util.Timer;
import java.util.TimerTask;

public class Movement {
    private int spielerX = 5, spielerY = 175;
    private boolean moveUpSpieler = false, moveDownSpieler = false;
    Timer move;
    public Movement(){
        move = new Timer();
        move.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (Var.moveup == true){
                    if (spielerY >= 5){
                        spielerY -= 2;
                    }
                }else if (Var.movedown == true){
                    if (spielerY <= Var.windowHeight - 90){
                        spielerY  += 2;
                    }
                }
            }
        }, 0, 8);
    }

    public int getSpielerX() {
        return spielerX;
    }

    public int getSpielerY() {
        return spielerY;
    }

    public boolean isMoveUpSpieler() {
        return moveUpSpieler;
    }

    public boolean isMoveDownSpieler() {
        return moveDownSpieler;
    }
}

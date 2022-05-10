package package1;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class Movement {
    private Control control;
    private int spielerX = 5, spielerY = 175;
    private boolean moveUpSpieler = false, moveDownSpieler = false;
    Timer move;
    public Movement(Control control){
        this.control = control;
        move = new Timer();
        move.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (moveUpSpieler){
                    if (spielerY >= 5){
                        spielerY -= 2;
                    }
                }else if (moveDownSpieler){
                    if (spielerY <= control.getWindowHeight() - 90){
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

    public void setMoveUpSpieler(boolean moveUpSpieler) {
        this.moveUpSpieler = moveUpSpieler;
    }
    public void setMoveDownSpieler(boolean moveDownSpieler) {
        this.moveDownSpieler = moveDownSpieler;
    }
}

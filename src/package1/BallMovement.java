package package1;

import java.util.Timer;
import java.util.TimerTask;

public class BallMovement {
    Timer move;
    TimerTask timerTask;
    public BallMovement(){
        move = new Timer();
        move.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Var.ballX += Var.ballDirecX;
                Var.ballY += Var.ballDirecY;
            }
        }, 0, 4);
    }
}

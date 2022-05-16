package package1;

import java.util.Timer;
import java.util.TimerTask;

public class BallMovement {
    private int ballx = 290, bally = 190, ballDirecX = 1, ballDirecY = -1;
    Timer move;
    TimerTask timerTask;
    public BallMovement(){
        move = new Timer();
        move.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                ballx += ballDirecX;
                bally += ballDirecY;
            }
        }, 0, 4);
    }

    public void flipBallDirection() {
        ballx *= -1;
        bally *= -1;
    }

    public int getBallx() {
        return ballx;
    }

    public int getBally() {
        return bally;
    }

    public int getBallDirecX() {
        return ballDirecX;
    }

    public int getBallDirecY() {
        return ballDirecY;
    }

    public void setBallx(int ballx) {
        this.ballx = ballx;
    }

    public void setBally(int bally) {
        this.bally = bally;
    }

    public void setBallDirecX(int ballDirecX) {
        this.ballDirecX = ballDirecX;
    }

    public void setBallDirecY(int ballDirecY) {
        this.ballDirecY = ballDirecY;
    }
}

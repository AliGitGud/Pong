package package1;

import java.util.Timer;
import java.util.TimerTask;

public class BallCollision {

    Timer kollision;

    public BallCollision(Control control) {
        kollision = new Timer();
        kollision.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (control.getBallPosY() + 50 >= control.getWindowHeight()) {
                    control.setBallDirecY(-1);
                }
                if (control.getBallPosY() <= 0) {
                    control.setBallDirecY(1);
                }
                if (control.getBallPosX() + 20 >= control.getWindowWidth()) {
                    control.setBallPosX(290);
                    control.setBallPosY(190);

                    control.setBallDirecX(-1);
                    control.setSpielerPunkte(control.getSpielerPunkte() + 1);
                }
                if (control.getBallPosX() <= 0) {
                    control.setBallPosX(290);
                    control.setBallPosY(190);

                    control.setBallDirecX(+1);
                    control.setGegnerPunkte(control.getGegnerPunkte() + 1);
                }
                if (control.getBallPosX() < control.getSpielerPosX() + 15
                        && control.getBallPosX() > control.getSpielerPosX()
                        && control.getBallPosY() < control.getSpielerPosY() + 50
                        && control.getBallPosY() > control.getSpielerPosY()) {
                    control.setBallDirecX(1);
                }
                if (control.getBallPosX() > control.getGegnerPosX() - 15
                        && control.getBallPosX() < control.getGegnerPosX()
                        && control.getBallPosY() < control.getGegnerPosY() + 50
                        && control.getBallPosY() > control.getGegnerPosY()) {
                    control.setBallDirecX(-1);
                }
            }
        }, 0, 4);
    }
}

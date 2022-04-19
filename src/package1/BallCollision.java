package package1;

import java.util.Timer;
import java.util.TimerTask;

public class BallCollision {
    private Control control;
    Timer kollision;

    public BallCollision(Control control) {
        kollision = new Timer();
        this.control = control;
        kollision.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (control.getBallPosY() + 50 >= Var.windowHeight) {
                    control.setBallDirecY(-1);
                }
                if (control.getBallPosY() <= 0) {
                    control.setBallDirecY(1);
                }
                if (control.getBallPosX() + 20 >= Var.windowWidth) {
                    control.setBallPosX(290);
                    control.setBallPosY(190);

                    control.setBallDirecX(-1);
                    Var.playerpoints1 += 1;
                }
                if (control.getBallPosX() <= 0) {
                    control.setBallPosX(290);
                    control.setBallPosY(190);

                    control.setBallDirecX(-1);
                    Var.playerpoints2 += 1;
                }
                if (control.getBallPosX() < Var.x + 15 && control.getBallPosX() > Var.x && control.getBallPosY() < Var.y + 50 && control.getBallPosY() > Var.y) {
                    control.setBallDirecX(1);
                }
                if (control.getBallPosX() > Var.x2 - 15 && control.getBallPosX() < Var.x2 && control.getBallPosY() < Var.y2 + 50 && control.getBallPosY() > Var.y2) {
                    control.setBallDirecX(-1);
                }
            }
        }, 0, 4);
    }
}

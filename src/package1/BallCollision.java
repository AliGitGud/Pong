package package1;

import java.util.Timer;
import java.util.TimerTask;

public class BallCollision {
    Timer kollision;
    public BallCollision(){
        kollision = new Timer();
        kollision.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (Var.ballY + 50>= Var.windowHeight){
                    Var.ballDirecY = -1;
                }
                if (Var.ballY <= 0){
                    Var.ballDirecY = 1;
                }
                if (Var.ballX+20>= Var.windowWidth){
                    Var.ballX = 290;
                    Var.ballY = 190;

                    Var.ballDirecX = -1;
                    Var.playerpoints1 += 1;
                }
                if (Var.ballX <= 0) {
                    Var.ballX = 290;
                    Var.ballY = 190;

                    Var.ballDirecX = -1;
                    Var.playerpoints2 += 1;
                }
                if (Var.ballX < Var.x + 15 && Var.ballX > Var.x && Var.ballY < Var.y + 50 && Var.ballY > Var.y){
                    Var.ballDirecX = 1;
                }
                if (Var.ballX > Var.x2 - 15 && Var.ballX < Var.x2  && Var.ballY < Var.y2 + 50 && Var.ballY > Var.y2){
                    Var.ballDirecX = -1;
                }
            }
        },0,4);
    }
}

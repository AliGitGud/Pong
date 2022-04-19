package package1;

import java.util.Timer;
import java.util.TimerTask;

public class GegnerMovement {
    Timer move;
    public GegnerMovement(){
        move = new Timer();
        move.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (Var.moveup2 == true){
                    if (Var.y2 >= 5){
                        Var.y2 -= 2;
                    }
                }else if (Var.movedown2 == true){
                    if (Var.y2 <= Var.windowHeight - 90) {
                        Var.y2 += 2;
                    }
                }
            }
         }, 0, 8);
    }
}

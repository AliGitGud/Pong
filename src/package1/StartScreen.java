package package1;

import javax.swing.*;

public class StartScreen {
    public StartScreen(){
        Var.startWind = new JFrame();
        Var.startWind.setSize(Var.windowWidth, Var.windowHeight);
        Var.startWind.setTitle("Pong");
    }
}

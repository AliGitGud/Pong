package package1;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI {
    private Draw lblDraw;

    public GUI(Draw draw) {
        lblDraw = draw;
        Var.mainWind = new JFrame();
        Var.mainWind.setSize(Var.windowWidth, Var.windowHeight);
        Var.mainWind.setTitle("Pong");
        Var.mainWind.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Var.mainWind.setLayout(null);
        Var.mainWind.setResizable(false);
        Var.mainWind.setVisible(true);
        Var.mainWind.setLocationRelativeTo(null);
        Var.mainWind.addKeyListener(new KeyHandler());
        Var.mainWind.requestFocus();
        lblDraw.setBounds(0, 0, Var.windowWidth, Var.windowHeight);
        lblDraw.setVisible(true);
        Var.mainWind.add(lblDraw);
    }

   }

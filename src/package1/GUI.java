package package1;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GUI {
    private Draw lblDraw;
    private JFrame mainWindow;
    private int windowWidth = 600, windowHeight = 400;

    public GUI(Draw draw, KeyHandler keyHandler) {
        lblDraw = draw;
        mainWindow = new JFrame();
        mainWindow.setSize(windowWidth, windowHeight);
        mainWindow.setTitle("Pong");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setLayout(null);
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.addKeyListener(keyHandler);
        mainWindow.requestFocus();
        lblDraw.setBounds(0, 0, windowWidth, windowHeight);
        lblDraw.setVisible(true);
        mainWindow.add(lblDraw);
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }
}

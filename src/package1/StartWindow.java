package package1;

import javax.swing.*;
import java.awt.*;

public class StartWindow {
    private JFrame startWindow;
    private JButton hostgamebtn, joingamebtn, spielregelnbtn;
    private JPanel startpnl;
    private JLabel titlelb;
    Font titleFont = new Font("Algerian", Font.PLAIN, 60);
    Font buttonFont = new Font("Algerian", Font.PLAIN, 20);
    public StartWindow() {
        startWindow = new JFrame();
        startWindow.setSize(600, 400);
        startWindow.setVisible(true);
        startWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        startWindow.setLocationRelativeTo(null);
        startWindow.setTitle("Pong");

        startpnl = new JPanel();
        startpnl.setBounds(0, 0, 600,400);
        startpnl.setBackground(Color.white);
        startWindow.add(startpnl);

        titlelb = new JLabel("Pong");
        startpnl.add(titlelb);
        titlelb.setFont(titleFont);

        hostgamebtn = new JButton("Hostgame");
        hostgamebtn.setBackground(Color.black);
        hostgamebtn.setForeground(Color.white);
        hostgamebtn.setFont(buttonFont);
        startpnl.add(hostgamebtn);
    }
}

package package1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class StartWindow {
    private JFrame startWindow;
    private JButton hostgamebtn;
    private JButton joingamebtn;
    private JButton infobtn;
    private JButton ueberpruefenbtn;
    private JPanel infopnl;
    private JLabel titlelb;
    private JTextField joinTextField;
    private JTextArea infoTextArea, hostTextArea;
    private Container con;
    private JButton zurueckbtn;

    public JButton getZurueckbtn() {
        return zurueckbtn;
    }

    private JPanel hostpnl;

    public JPanel getHostpnl() {
        return this.hostpnl;
    }

    public JPanel getStartpnl() {
        return startpnl;
    }

    private JPanel startpnl;

    public JPanel getJoinpnl() {
        return joinpnl;
    }

    private JPanel joinpnl;

    public JPanel getInfopnl() {
        return infopnl;
    }

    Font titleFont = new Font("Algerian", Font.PLAIN, 60);
    Font buttonFont = new Font("Algerian", Font.PLAIN, 20);
    Font infoFont = new Font("", Font.PLAIN, 20);

    public StartWindow(Control control) {
        int hoehe = 400, breite = 600;

        startWindow = new JFrame();
        startWindow.setSize(breite, hoehe);
        startWindow.setVisible(true);
        startWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        startWindow.setLocationRelativeTo(null);
        startWindow.setTitle("Pong");
        startWindow.setLayout(null);
        startWindow.setResizable(false);
        con = startWindow.getContentPane();

        startpnl = new JPanel();
        startpnl.setBounds(0, 0, breite, hoehe);
        startpnl.setLayout(null);
        startpnl.setBackground(Color.white);
        con.add(startpnl);

        titlelb = new JLabel("Pong");
        startpnl.setForeground(Color.white);
        titlelb.setFont(titleFont);
        startpnl.add(titlelb);
        titlelb.setBounds(breite / 2 - 100, 50, 200, 50);
        titlelb.setHorizontalAlignment(SwingConstants.CENTER);
        titlelb.setVerticalAlignment(SwingConstants.CENTER);

        infopnl = new JPanel();
        infopnl.setBounds(0, 0, breite, hoehe);
        infopnl.setLayout(null);
        infopnl.setBackground(Color.white);
        con.add(infopnl);
        infopnl.setVisible(false);

        hostpnl = new JPanel();
        hostpnl.setBounds(0, 0, breite, hoehe);
        hostpnl.setBackground(Color.white);
        con.add(hostpnl);
        hostpnl.setVisible(false);

        hostTextArea = new JTextArea();
        hostTextArea.setBounds(50, 10, 400, 325);
        hostTextArea.setLineWrap(true);
        hostTextArea.setWrapStyleWord(true);
        hostTextArea.setFont(infoFont);
        hostTextArea.setText("In der Konsole findest du deine Ip-Adresse. Um diesem Spiel beizutreten," +
                " muss dein Gegner die Ip-Adresse in die Suchleiste im Join-Fenster eingeben.\n \n" +
                "Warte auf Spieler...");
        hostTextArea.setEditable(false);
        hostpnl.add(hostTextArea);


        infoTextArea = new JTextArea();
        infoTextArea.setBounds(50, 10, 400, 325);
        infoTextArea.setLineWrap(true);
        infoTextArea.setWrapStyleWord(true);
        infoTextArea.setFont(infoFont);
        infoTextArea.setText("Das 1972 von Atari veröffentlichte Pong wurde " +
                "zum ersten weltweit beliebten Videospiel und in den 1970er-Jahren zunächst auf Geräten in Spielhallen"
                +
                " bekannt. Es gilt als Urvater der Videospiele, obgleich schon zuvor Videospiele entwickelt worden waren."
                +
                "Die Spielregeln sind einfach, ein Ball bewegt sich über das Spielfeld und muss, mithilfe der Balken rechts"
                +
                "und links, von den Spielern abgewehrt werden. Verfehlt man den Ball, kriegt der Gegner einen Punkt.");
        infoTextArea.setEditable(false);
        infopnl.add(infoTextArea);

        joinpnl = new JPanel();
        joinpnl.setBounds(0, 0, breite, hoehe);
        joinpnl.setLayout(null);
        joinpnl.setBackground(Color.white);
        con.add(joinpnl);
        joinpnl.setVisible(false);

        joinTextField = new JTextField();
        joinTextField.setText("IP-Adresse des Hosts...");
        joinTextField.setBounds(breite / 2 - 450 / 2, 100, 300, 30);
        joinpnl.add(joinTextField);
        
        ueberpruefenbtn = new JButton("Suchen");
        ueberpruefenbtn.setBackground(Color.white);
        ueberpruefenbtn.setBounds(375, 100, 120, 30);
        ueberpruefenbtn.setFont(buttonFont);
        ueberpruefenbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    control.connect(joinTextField.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        joinpnl.add(ueberpruefenbtn);

        zurueckbtn = new JButton("Zurück");
        zurueckbtn.setBounds(450, 300, 125, 50);
        zurueckbtn.setBackground(Color.white);
        zurueckbtn.setFont(buttonFont);
        zurueckbtn.setVisible(false);
        zurueckbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.goBackToStartScreen();
            }
        });
        con.add(zurueckbtn);

        hostgamebtn = new JButton("Host Game");
        hostgamebtn.setBackground(Color.WHITE);
        hostgamebtn.setSize(300, 75);
        hostgamebtn.setLocation(breite / 2 - hostgamebtn.getWidth() / 2, 100);
        hostgamebtn.setFont(buttonFont);
        hostgamebtn.setVisible(true);
        hostgamebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    control.host();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                control.goToHostScreen();
                // TODO Hostscreen designen
            }
        });
        startpnl.add(hostgamebtn);

        joingamebtn = new JButton("Join Game");
        joingamebtn.setBackground(Color.WHITE);
        joingamebtn.setSize(300, 75);
        joingamebtn.setLocation(breite / 2 - joingamebtn.getWidth() / 2, 200);
        joingamebtn.setFont(buttonFont);
        joingamebtn.setVisible(true);
        joingamebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.goToJoinScreen();
            }
        });
        startpnl.add(joingamebtn);

        infobtn = new JButton("Info");
        infobtn.setBackground(Color.WHITE);
        infobtn.setBounds(10, 300, 100, 50);
        infobtn.setFont(buttonFont);
        infobtn.setVisible(true);
        infobtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.goToInfoScreen();
            }
        });
        startpnl.add(infobtn);
    }
}

package package1;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {
    private Control control;
    private int spielerPunkte = 0, gegnerPunkte = 0;
    public Draw(Control control) {
        this.control = control;
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, control.getWindowWidth(), control.getWindowHeight());

        g.setColor(Color.WHITE);

        for (int i = 0; i <= 30; i++) {
            g.fillRect(control.getWindowWidth() / 2 - 5, i * 20, 5, 10);

        }
        g.fillRect(control.getSpielerPosX(), control.getSpielerPosY(), 10, 50);
        g.fillRect(control.getGegnerPosX(), control.getGegnerPosY(), 10, 50);

        g.drawString("" + spielerPunkte, control.getWindowWidth() / 2 - 50, 50);
        g.drawString("" + gegnerPunkte, control.getWindowWidth() / 2 + 50, 50);

        g.fillRect(control.getBallPosX(), control.getBallPosY(), 15, 15);
        repaint();
    }

    public int getSpielerPunkte() {
        return spielerPunkte;
    }

    public int getGegnerPunkte() {
        return gegnerPunkte;
    }

    public void setSpielerPunkte(int spielerPunkte) {
        this.spielerPunkte = spielerPunkte;
    }

    public void setGegnerPunkte(int gegnerPunkte) {
        this.gegnerPunkte = gegnerPunkte;
    }
}

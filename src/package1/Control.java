package package1;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import net.Client;
import net.Server;

import static java.net.InetAddress.getLocalHost;

public class Control {
    private BallMovement ballMovement;
    private Draw draw;
    private GUI gui;
    private GegnerMovement gegnerMovement;
    private Movement movement;
    private KeyHandler keyHandler;
    private StartWindow startWindow;
    private Server server;
    private Client client;
    private IpAdress ipAdress;

    public Control() {
        movement = new Movement(this);
        gegnerMovement = new GegnerMovement(this);
        startWindow = new StartWindow(this);
        ipAdress = new IpAdress();
    }

    public void startGame() {
        keyHandler = new KeyHandler(this);
        draw = new Draw(this);
        gui = new GUI(draw, keyHandler);
        ballMovement = new BallMovement();
        new BallCollision(this);
        this.startWindow.hide();
    }

    public void setBallDirecX(int direcX) {
        ballMovement.setBallDirecX(direcX);
    }

    public int getDirecX() {
        return ballMovement.getBallDirecX();
    }

    public void setBallDirecY(int direcY) {
        ballMovement.setBallDirecY(direcY);
    }

    public int getBallDirecY() {
        return ballMovement.getBallDirecY();
    }

    public void setBallDirecXY(int direcX, int direcY) {
        ballMovement.setBallDirecX(direcX);
        ballMovement.setBallDirecY(direcY);
    }

    public int getBallPosX() {
        return ballMovement.getBallx();
    }

    public void setBallPosX(int ballX) {
        ballMovement.setBallx(ballX);
    }

    public int getBallPosY() {
        return ballMovement.getBally();
    }

    public void setBallPosY(int ballY) {
        ballMovement.setBally(ballY);
    }

    public Draw getDraw() {
        return draw;
    }

    public int getGegnerPosX() {
        return gegnerMovement.getGegnerX();
    }

    public int getGegnerPosY() {
        return gegnerMovement.getGegnerY();
    }

    public int getSpielerPosX() {
        return movement.getSpielerX();
    }

    public int getSpielerPosY() {
        return movement.getSpielerY();
    }

    public boolean isSpielerMoveUp() {
        return movement.isMoveUpSpieler();
    }

    public boolean isSpielerMoveDown() {
        return movement.isMoveDownSpieler();
    }

    public void setMoveUpSpieler(boolean moveUpSpieler) {
        movement.setMoveUpSpieler(moveUpSpieler);
    }

    public void setMoveDownSpieler(boolean moveDownSpieler) {
        movement.setMoveDownSpieler(moveDownSpieler);
    }

    public boolean isGegnerMoveUp() {
        return gegnerMovement.isMoveUpGegner();
    }

    public boolean isGegnerMoveDown() {
        return gegnerMovement.isMoveDownGegner();
    }

    public void setMoveUpGegner(boolean moveUpGegner) {
        gegnerMovement.setMoveUpGegner(moveUpGegner);
    }

    public void setMoveDownGegner(boolean moveDownGegner) {
        gegnerMovement.setMoveDownGegner(moveDownGegner);
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public int getSpielerPunkte() {
        return draw.getSpielerPunkte();
    }

    public int getGegnerPunkte() {
        return draw.getGegnerPunkte();
    }

    public void setSpielerPunkte(int spielerPunkte) {
        draw.setSpielerPunkte(spielerPunkte);
    }

    public void setGegnerPunkte(int gegnerPunkte) {
        draw.setGegnerPunkte(gegnerPunkte);
    }

    public int getWindowWidth() {
        return gui.getWindowWidth();
    }

    public int getWindowHeight() {
        return gui.getWindowHeight();
    }

    public void connect(String ipAddress) throws IOException {
        this.client = new Client(this, ipAddress);
        this.startGame();
        ballMovement.flipBallDirection();
    }

    public void host() throws IOException {
        this.server = new Server(this);
        this.client = new Client(this, InetAddress.getLocalHost().getHostAddress());
        startWindow.setHostAreaText(getIpAdress() + "\n Warte auf Spieler...");
    }

    public Client getClient() {
        return this.client;
    }

    public Server getServer() {
        return this.server;
    }

    public void goToHostScreen() {
        startWindow.getStartpnl().setVisible(false);
        startWindow.getHostpnl().setVisible(true);
        startWindow.getZurueckbtn().setVisible(false);
        ipAdress.ipAdresseAusgeben();
    }

    public void goToJoinScreen() {
        startWindow.getStartpnl().setVisible(false);
        startWindow.getJoinpnl().setVisible(true);
        startWindow.getZurueckbtn().setVisible(true);
    }

    public void goBackToStartScreen() {
        startWindow.getStartpnl().setVisible(true);
        startWindow.getJoinpnl().setVisible(false);
        startWindow.getInfopnl().setVisible(false);
        startWindow.getZurueckbtn().setVisible(false);
    }

    public void goToInfoScreen() {
        startWindow.getStartpnl().setVisible(false);
        startWindow.getInfopnl().setVisible(true);
        startWindow.getZurueckbtn().setVisible(true);
    }

    public String getIpAdress(){
        String[] holdIP = server.getIp().split("/");
        return holdIP[1];
    }
}

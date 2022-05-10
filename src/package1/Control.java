package package1;

public class Control {
    private BallMovement ballMovement;
    private BallCollision ballCollision;
    private Draw draw;
    private GUI gui;
    private GegnerMovement gegnerMovement;
    private Movement movement;

    private KeyHandler keyHandler;
    public Control() {
        keyHandler = new KeyHandler(this);
        ballMovement = new BallMovement();
        draw = new Draw(this);
        gui = new GUI(draw, keyHandler);
        movement = new Movement(this);
        gegnerMovement = new GegnerMovement(this);
        ballCollision = new BallCollision(this);
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

    public int getGegnerPosX(){
        return gegnerMovement.getGegnerX();
    }
    public int getGegnerPosY(){
        return gegnerMovement.getGegnerY();
    }

    public int getSpielerPosX(){
        return movement.getSpielerX();
    }
    public int getSpielerPosY(){
        return movement.getSpielerY();
    }
    public boolean isSpielerMoveUp(){
        return movement.isMoveUpSpieler();
    }
    public boolean isSpielerMoveDown(){
        return movement.isMoveDownSpieler();
    }
    public void setMoveUpSpieler( boolean moveUpSpieler){
        movement.setMoveUpSpieler(moveUpSpieler);
    }
    public void setMoveDownSpieler( boolean moveDownSpieler){
        movement.setMoveDownSpieler(moveDownSpieler);
    }
    public boolean isGegnerMoveUp(){
        return gegnerMovement.isMoveUpGegner();
    }
    public boolean isGegnerMoveDown(){
        return gegnerMovement.isMoveDownGegner();
    }
    public void setMoveUpGegner( boolean moveUpGegner){
        gegnerMovement.setMoveUpGegner(moveUpGegner);
    }
    public void setMoveDownGegner( boolean moveDownGegner){
        gegnerMovement.setMoveDownGegner(moveDownGegner);
    }
    public KeyHandler getKeyHandler(){
        return keyHandler;
    }
    public int getSpielerPunkte(){
        return draw.getSpielerPunkte();
    }
    public int getGegnerPunkte(){
        return draw.getGegnerPunkte();
    }
    public void setSpielerPunkte(int spielerPunkte){
        draw.setSpielerPunkte(spielerPunkte);
    }
    public void setGegnerPunkte(int gegnerPunkte){
        draw.setGegnerPunkte(gegnerPunkte);
    }
    public int getWindowWidth(){
        return gui.getWindowWidth();
    }
    public int getWindowHeight(){
        return gui.getWindowHeight();
    }
}


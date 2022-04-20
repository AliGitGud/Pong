package package1;

public class Control {
    private BallMovement ballMovement;
    private BallCollision ballCollision;
    private Draw draw;
    private GUI gui;
    private GegnerMovement gegnerMovement;
    private Movement movement;
    public Control() {
        ballMovement = new BallMovement();
        ballCollision = new BallCollision(this);
        draw = new Draw(this);
        gui = new GUI(draw);
        gegnerMovement = new GegnerMovement();
        movement = new Movement();
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
}


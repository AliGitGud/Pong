package package1;

public class Control {
    private BallMovement ballMovement;
    private BallCollision ballCollision;
    private Draw draw;
    private GUI gui;
    public Control() {
        ballMovement = new BallMovement();
        ballCollision = new BallCollision(this);
        draw = new Draw(this);
        gui = new GUI(draw);
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
}


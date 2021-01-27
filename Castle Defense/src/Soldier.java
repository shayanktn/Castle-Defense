import javafx.scene.shape.Circle;

public abstract class Soldier extends Card {
    public abstract Circle build();

    private int player,speed;
    private boolean moveGrant, xGrant = getX() < 1000 - 50 && getX() > 50, YGrant = getY() < 1000 - 50 && getY() > 50;

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public boolean isMoveGrant() {
        return moveGrant;
    }

    public void setMoveGrant(boolean moveGrant) {
        this.moveGrant = moveGrant;
    }

    public boolean isXGrant() {
        return xGrant;
    }

    public void setXGrant(boolean xGrant) {
        this.xGrant = xGrant;
    }

    public boolean isYGrant() {
        return YGrant;
    }

    public void setYGrant(boolean YGrant) {
        this.YGrant = YGrant;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

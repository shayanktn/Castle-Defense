import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Goblin extends Soldier {
    public Goblin(int player,int x,int y) {
        setPlayer(player);
        setX(x);
        setY(y);
    }

    @Override
    public Circle build() {
        Circle circle = new Circle();
        if (getPlayer() == 1) {
            circle = new Circle(getX(), getY(), 15, Color.GREEN);
        } else if (getPlayer() == 2) {
            circle = new Circle(getX(), getY(), 15, Color.GREEN);
        }
        return circle;
    }
}

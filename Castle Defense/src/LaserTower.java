import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LaserTower extends Tower{

    public LaserTower(){}

    public LaserTower(int x,int y){
        setX(x);
        setY(y);
    }
    @Override
    public Rectangle build() {
        Rectangle rectangle = new Rectangle(getX(),getY(),80,80);
        rectangle.setFill(Color.RED);
        return rectangle;
    }
}

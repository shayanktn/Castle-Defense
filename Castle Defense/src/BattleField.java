import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class BattleField extends Application {

    SaveAndLoad saveAndLoad = new SaveAndLoad();

    int mapMode = saveAndLoad.load("C:\\Stellar\\Subjects\\Advanced Programming\\Java\\Projects\\Castle Defense\\src\\Map.txt");

    Card[] player1Soldiers = new Soldier[12];
    Card[] player2Soldiers = new Soldier[12];
    Card[] player1towers = new Tower[4];
    Card[] player2towers = new Tower[4];

    String key = "";
    String cycle = "";

    Soldier goblinCard1 = new Goblin(1, 50, 300 + 50);
    Soldier goblinCard2 = new Goblin(2, 100 + 800 + 50, 300 + 100 + 200 + 50);

    Circle goblin1 = goblinCard1.build();
    Circle goblin2 = goblinCard2.build();


    public BattleField() throws FileNotFoundException {
    }

    void sceneBuild(Group root) {
        Rectangle trail1 = new Rectangle(100, 300 - ((mapMode - 1) * 50), 1000 - 2 * (100), 100);
        trail1.setFill(Color.YELLOW);
        trail1.setArcWidth(15);
        trail1.setArcHeight(15);
        root.getChildren().add(trail1);

        Rectangle trail2 = new Rectangle(100, 400 + 100 + 100 + ((mapMode - 1) * 50), 1000 - 2 * (100), 100);
        trail2.setFill(Color.YELLOW);
        trail2.setArcWidth(15);
        trail2.setArcHeight(15);
        root.getChildren().add(trail2);

        Circle circle1 = new Circle(50, 300 + 50 - ((mapMode - 1) * 50), 50, Color.RED);
        root.getChildren().add(circle1);

        Circle circle2 = new Circle(50 + 100 + 1000 - 2 * (100), 400 + 100 + 100 + 50 + ((mapMode - 1) * 50), 50, Color.RED);
        root.getChildren().add(circle2);

        Polygon polygon1 = new Polygon();
        polygon1.getPoints().addAll(0.0, 400.0 + 100.0 + 100.0 + 100.0 + ((mapMode - 1) * 50), 100.0, 400.0 + 100.0 + 100.0 + 100.0 + ((mapMode - 1) * 50), 50.0, 400.0 + 100.0 + 100.0 + ((mapMode - 1) * 50));
        polygon1.setFill(Color.BLUE);
        root.getChildren().add(polygon1);

        Polygon polygon2 = new Polygon();
        polygon2.getPoints().addAll(100.0 + 800.0, 300.0 + 100.0 - ((mapMode - 1) * 50), 100.0 + 800.0 + 100.0, 300.0 + 100.0 - ((mapMode - 1) * 50), 100.0 + 800.0 + 50.0, 300.0 - ((mapMode - 1) * 50));
        polygon2.setFill(Color.BLUE);
        root.getChildren().add(polygon2);

        Card[] towerCards = new Tower[8];

        towerCards[0] = new LaserTower(100 + 1000 - 2 * (100) - 100, 200+20- ((mapMode - 1) * 50));
        towerCards[1] = new LaserTower(100 + 1000 - 2 * (100) - 100 - 100, 200 + 100 +100- ((mapMode - 1) * 50));
        towerCards[2] = new ElectricTower(100 + 1000 - 2 * (100) - 100 - 200, 200+20- ((mapMode - 1) * 50));
        towerCards[3] = new ElectricTower(100 + 1000 - 2 * (100) - 100 - 300, 200 + 100 +100- ((mapMode - 1) * 50));

        towerCards[4] = new LaserTower(100, 300 + 100 + 200 + 100+ ((mapMode - 1) * 50));
        towerCards[5] = new LaserTower(100 + 100, 300 + 100 + 200 + 100 - 100 -100+20+ ((mapMode - 1) * 50));
        towerCards[6] = new ElectricTower(100 + 200, 300 + 100 + 200 + 100+ ((mapMode - 1) * 50));
        towerCards[7] = new ElectricTower(100 + 300, 300 + 100 + 200 + 100 - 100-100+20+ ((mapMode - 1) * 50));

        Rectangle[] laserTowers1 = new Rectangle[2];
        Rectangle[] electricTowers1 = new Rectangle[2];

        Rectangle[] laserTowers2 = new Rectangle[2];
        Rectangle[] electricTowers2 = new Rectangle[2];

        laserTowers1[0] = ((LaserTower) towerCards[0]).build();
        laserTowers1[1] = ((LaserTower) towerCards[1]).build();
        electricTowers1[0] = ((ElectricTower) towerCards[2]).build();
        electricTowers1[1] = ((ElectricTower) towerCards[3]).build();

        laserTowers2[0] = ((LaserTower) towerCards[4]).build();
        laserTowers2[1] = ((LaserTower) towerCards[5]).build();
        electricTowers2[0] = ((ElectricTower) towerCards[6]).build();
        electricTowers2[1] = ((ElectricTower) towerCards[7]).build();

        root.getChildren().add(laserTowers1[0]);
        root.getChildren().add(laserTowers1[1]);
        root.getChildren().add(electricTowers1[0]);
        root.getChildren().add(electricTowers1[1]);

        root.getChildren().add(laserTowers2[0]);
        root.getChildren().add(laserTowers2[1]);
        root.getChildren().add(electricTowers2[0]);
        root.getChildren().add(electricTowers2[1]);
    }

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        primaryStage.setTitle("Castle Defense");
        Scene scene = new Scene(root, 1000, 1000, Color.BLACK);
        primaryStage.setScene(scene);

        sceneBuild(root);
        root.getChildren().add(goblin1);
        root.getChildren().add(goblin2);
        primaryStage.show();

        Thread player1 = new Thread("1") {
            @Override
            public void run() {
                super.run();
                if (key.equals("D")) {

                }
            }
        };
        Thread player2 = new Thread("2") {
            @Override
            public void run() {
                super.run();
                if (key.equals("LEFT")) {

                }
            }
        };

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                root.getChildren().clear();
                sceneBuild(root);
                goblin1.setCenterX(goblin1.getCenterX());
                goblin1.setCenterY(goblin1.getCenterY()-25);
                root.getChildren().add(goblin1);
                root.getChildren().add(goblin2);
            }
            if (event.getCode() == KeyCode.S) {
                root.getChildren().clear();
                sceneBuild(root);
                goblin1.setCenterX(goblin1.getCenterX());
                goblin1.setCenterY(goblin1.getCenterY()+25);
                root.getChildren().add(goblin1);
                root.getChildren().add(goblin2);
            }
            if (event.getCode() == KeyCode.A) {
                root.getChildren().clear();
                sceneBuild(root);
                goblin1.setCenterX(goblin1.getCenterX() - 25);
                root.getChildren().add(goblin1);
                root.getChildren().add(goblin2);
            }
            if (event.getCode() == KeyCode.D) {
                root.getChildren().clear();
                sceneBuild(root);
                goblin1.setCenterX(goblin1.getCenterX() + 25);
                root.getChildren().add(goblin1);
                root.getChildren().add(goblin2);
            }
        });

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            switch (cycle) {
                case "Castle" -> {

                }
                case "SoldierRemove" -> {

                }
                case "SoldierFire" -> {

                }
                case "TowerRemove" -> {

                }
                case "SoldierMove" -> {

                }
            }

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

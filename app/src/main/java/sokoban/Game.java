package sokoban;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;
import sokoban.UI.Map;

import static javafx.geometry.Pos.CENTER;

public class Game extends Application {
    Stage window;
    Scene scene;
    VBox vbox = new VBox();

    public static void main(String[] args) throws Exception {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //window
        window = primaryStage;
        window.setTitle("Sokoban");

        //map
        String map = MapLoader.load("build/resources/main/levels/map1.xsb");
        int[] size = MapLoader.getSize("build/resources/main/levels/map1.xsb");
        int[] pos = {0, 0};
        Player player = new Player(pos, "/Cells/player.png");
        World world = new World(size[0], size[1], player);
        Builder.init(map, player, world, size[0], size[1]);

        //GridPane
        Map grid = new Map(world);
        grid.showMap();
        grid.setAlignment(CENTER);

        //Vbox
        vbox.getChildren().addAll(grid);
        vbox.setAlignment(CENTER);
        vbox.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0), CornerRadii.EMPTY, Insets.EMPTY)));

        //scene
        scene = new Scene(vbox, 640, 640);
        scene.setOnKeyPressed(e -> addKeyHandler(scene, player, world, grid, e));
        window.setScene(scene);

        // Window
        window.setFullScreen(true);
        window.show();
    }

    public void addKeyHandler(Scene scene, Player player, World world, Map grid, KeyEvent ke) {

        KeyCode keyCode = ke.getCode();
        if (keyCode.equals(KeyCode.Z)) {
            player.move("up", world);

        } else if (keyCode.equals(KeyCode.Q)) {
            player.move("left", world);

        } else if (keyCode.equals(KeyCode.S)) {
            player.move("down", world);

        } else if (keyCode.equals(KeyCode.D)) {
            player.move("right", world);
        }
        try {
            grid.showMap();
        } catch (Exception yes) {
            System.out.println(yes);
        }
    }
}

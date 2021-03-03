package sokoban;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;
import sokoban.UI.Map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends Application {
    Stage window;
    Scene scene;

    //*****

    //*****
    public static void main(String[] args) throws Exception {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Sokoban");
        String map = MapLoader.load("build/resources/main/levels/map1.xsb");
        int[] size = MapLoader.getSize("build/resources/main/levels/map1.xsb");
        int[] pos = {0, 0};
        Player player = new Player(pos, "/Cells/player.png");
        World world = new World(size[0], size[1], player);
        world.setList(Builder.init(map, player, world, size[0], size[1]));
        world.setMap(Builder.build(world.getList(), size[0], size[1]));
        Map grid = new Map(world);
        grid.showMap();
        scene = new Scene(grid, 640, 640);
        scene.setOnKeyPressed(e -> addKeyHandler(scene, player, world, grid,e));
        window.setScene(scene);
        window.show();


    }

    public void addKeyHandler(Scene scene, Player player, World world, Map grid, KeyEvent ke) {

            KeyCode keyCode = ke.getCode();
            if (keyCode.equals(KeyCode.Z)) {
                player.move('z', world);

            } else if (keyCode.equals(KeyCode.Q)) {
                player.move('q', world);

            } else if (keyCode.equals(KeyCode.S)) {
                player.move('s', world);

            } else if (keyCode.equals(KeyCode.D)) {
                player.move('d', world);

            }
            world.update();
            try {
                grid.showMap();
            } catch (Exception yes) {
                System.out.println(yes);
            }
        }
    }
}
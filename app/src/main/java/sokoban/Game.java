package sokoban;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;
import sokoban.UI.Map;

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
        //Button button = new Button("QMFOQJSDQSLD");

       /* scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.Q) {
                System.out.println("A key was pressed");
            }
        });*/
        /*grid.addEventFilter(KeyEvent.ANY, keyEvent -> {
            System.out.println(keyEvent);
        });*/
        /*scene.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.A) {
                    System.out.println("A key was pressed");
                }
        });*/

        //  scene.setOnKeyPressed(e -> pressedKeys.add(e.getCode()));

        /*button.setOnAction (event -> {
            try {
                world.mapChanger("build/resources/main/levels/map2.xsb");
                grid.showMap();
            }catch (Exception e){
                System.out.println(e);}
        });*/
        grid.showMap();
        //grid.getChildren().addAll(button);
        scene = new Scene(grid, 640, 640);
        scene.setOnKeyPressed(e -> addKeyHandler(scene, player, world, grid));
        window.setScene(scene);
        window.show();


    }

    public void addKeyHandler(Scene scene, Player player, World world, Map grid) {
        scene.setOnKeyPressed(ke -> {
            KeyCode keyCode = ke.getCode();
            if (keyCode.equals(KeyCode.Z)) {
                player.move('z', world);

            }
            else if (keyCode.equals(KeyCode.Q)) {
                player.move('q', world);

            }
            else if (keyCode.equals(KeyCode.S)) {
                player.move('s', world);

            }
            else if (keyCode.equals(KeyCode.D)) {
                player.move('d', world);

            }
            world.update();
            try {
                grid.showMap();
            } catch (Exception yes) {
                System.out.println(yes);
            }
        });

  /*  public void showMap(GridPane grid, World world ) throws Exception {

        Cell[][] cell = world.getMap();

        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                Image image = new Image(new FileInputStream(cell[i][j].getCellTexture()));
                grid.add(new ImageView(image), j, i, 1, 1);
            }

        }
        scene = new Scene(grid, 640, 640);


    }*/
    }
}


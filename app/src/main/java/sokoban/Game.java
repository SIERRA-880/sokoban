package sokoban;
 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileInputStream;
import sokoban.Engine.Objects.*;
import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;

public class Game extends Application {
    Stage window;
    Scene scene1, scene2;
 
    public static void main(String[] args) {
 
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Sokoban");
        //button 1
 
        Label label1 = new Label("Click on the button to go to scen 2 ");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));
        //premier layout
 
        VBox layout1 = new VBox(90);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200, 300);
 
        //button 2
 
        Label label2 = new Label("Click on the button to go to scene 1 ");
        Button button2 = new Button("Go to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));
 
        //layout 2
 
        GridPane grid = new GridPane();
        String map;
        int[] size;
        map = MapLoader.load("build/resources/main/Maps/map1.txt");
        size = MapLoader.getSize("build/resources/main/Maps/map1.txt");
     
        int[] pos = {0, 0};
        Player player = new Player(pos, "/Cells/player.png");
 
        World world = new World(size[0], size[1], player);
        world.setList(Builder.init(map, player, world, size[0], size[1]));
        world.setMap(Builder.build(world.getList(), size[0], size[1]));
        Cell[][] cell = world.getMap();
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                Image image = new Image(new FileInputStream(cell[i][j].getCellTexture()));
                grid.add(new ImageView(image), j, i, 1, 1);
            }
 
        }
 
        scene2 = new Scene(grid, 640, 640);
 
        window.setScene(scene1);
        window.show();
 
    }
 
 
}

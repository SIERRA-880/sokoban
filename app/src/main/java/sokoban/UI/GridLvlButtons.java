package sokoban.UI;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;
import sokoban.Game;

import java.io.FileInputStream;

import static javafx.geometry.Pos.CENTER;

public class GridLvlButtons extends GridPane {
    //Grid that contains the different lvl buttons

    public GridLvlButtons() {
        String nom_button_selected = "build/resources/main/textures/Default/Buttons/levelMenu/levelButton_";
        String nom_button_unselected = "build/resources/main/textures/Default/Buttons/levelMenu/levelButtonOver_";
        int a = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                try {
                    String map = MapLoader.load("build/resources/main/levels/map" + (a) + ".xsb");
                    int[] size = MapLoader.getSize("build/resources/main/levels/map" + (a) + ".xsb");
                    int[] pos = {0, 0};
                    Player player = new Player(pos, "/Cells/player.png");
                    World world = new World(size[0], size[1], player);
                    Builder.init(map, player, world, size[0], size[1]);
                    Image image_selected = new Image(new FileInputStream(nom_button_selected + (a) + ".png"));
                    Image image_unselected = new Image(new FileInputStream(nom_button_unselected + (a++) + ".png"));
                    LevelButton button = new LevelButton(image_selected, image_unselected);
                    button.setOnAction(e -> {
                        try {
                            Game.switchScene(new LevelScene(new Map(world)));
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    });
                    button.setStyle("-fx-background-color: transparent;");
                    add(button, j, i);
                } catch (Exception ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }

                //setPadding(new Insets(0, 0, 0, 0));

            }
        }

        setHgap(30);
        setVgap(60);
        setAlignment(CENTER);

        //choisisez celui que vous voulez !
        setStyle("-fx-background-color: #000000;");
        //setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));

    }
}

package sokoban.UI.Scenes;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.UI.Widgets.*;

public class LevelScene extends Scene {
    //Scene that will containe a Map type object and display a level
    GridPane gridPane;
    Map map;
    public LevelScene(GridPane gridPane) throws Exception {
        super(gridPane);
        this.gridPane=gridPane;
        // map.showMap();
    }

    public void setMap(Map map) {
        gridPane.getChildren().setAll(map);
        this.map=map;
        map.showMap();
    }
    public void addKeyHandler(Scene scene, Player player, World world,KeyEvent ke) {
        //methode to move the player on th map

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
        map.showMap();
    }
}




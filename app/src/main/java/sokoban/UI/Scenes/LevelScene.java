package sokoban.UI.Scenes;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.UI.Widgets.Map;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


public class LevelScene extends Scene {
    //Scene that will containe a Map type object and display a level
    GridPane gridPane;
    Map map;
    public LevelScene(GridPane gridPane)  {
        super(gridPane);
        this.gridPane=gridPane;
        // map.showMap();
        setCursor(Cursor.NONE);
    }
    //truc chnagé

    public void setMap(Map map) {
        gridPane.getChildren().setAll(map);
        this.map=map;
        map.showMap();
    }
    public void addKeyHandler(Scene scene, Player player, World world,KeyEvent ke) {
        //methode to move the player on th map

        KeyCode keyCode = ke.getCode();
        if (keyCode.equals(KeyCode.Z)) {
            if (player.move("up", world)) {
                Media sound = new Media(new File("build/resources/main/textures/Default/Sounds/level/moveBox.wav").toURI().toString());
                MediaPlayer mplayer = new MediaPlayer(sound);
                mplayer.play();
            }

        } else if (keyCode.equals(KeyCode.Q)) {
            if (player.move("left", world)) {
                Media sound = new Media(new File("build/resources/main/textures/Default/Sounds/level/moveBox.wav").toURI().toString());
                MediaPlayer mplayer = new MediaPlayer(sound);
                mplayer.play();
            }

        } else if (keyCode.equals(KeyCode.S)) {
            if (player.move("down", world)) {
                Media sound = new Media(new File("build/resources/main/textures/Default/Sounds/level/moveBox.wav").toURI().toString());
                MediaPlayer mplayer = new MediaPlayer(sound);
                mplayer.play();
            }


        } else if (keyCode.equals(KeyCode.D)) {
            if (player.move("right", world)) {
                Media sound = new Media(new File("build/resources/main/textures/Default/Sounds/level/moveBox.wav").toURI().toString());
                MediaPlayer mplayer = new MediaPlayer(sound);
                mplayer.play();
            }
        }
        map.showMap();
        if (world.winCondition()) {
            Media sound = new Media(new File("build/resources/main/textures/Default/Sounds/level/allBoxesOnTarget.wav").toURI().toString());
            MediaPlayer  mplayer = new MediaPlayer(sound);
            mplayer.play();
            System.out.println("You win!");
        }
    }
}

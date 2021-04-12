package sokoban.UI.Scenes;

import javafx.scene.Scene;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;

import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Map;
import sokoban.UI.Widgets.BackButton;

import java.io.File;
import java.io.FileNotFoundException;


public class LevelScene extends Scene {
    //Scene that will contain a Map type object and display a level

    Map map;
    Boolean a = true;

    public LevelScene(Map map, StackPane stackPane)  {
        super(stackPane);
        // map
        this.map = map;
        stackPane.setStyle("-fx-background-color: #000000;");
        stackPane.getChildren().add(map);
        stackPane.setAlignment(map, Pos.CENTER);
        map.showMap();
        // backButton
        BackButton bbutton = new BackButton(new MenuLvlScene());
        stackPane.getChildren().add(bbutton);
        stackPane.setAlignment(bbutton, Pos.TOP_LEFT);
        stackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));
    }

    public void addKeyHandler( Player player, World world,KeyEvent ke) {
        //method to move the player on the map

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
        if (world.winCondition() && a) {
            a=false;
            Media sound = new Media(new File("build/resources/main/textures/Default/Sounds/level/allBoxesOnTarget.wav").toURI().toString());
            MediaPlayer  mplayer = new MediaPlayer(sound);
            mplayer.play();
            System.out.println("You win!");
        }
    }
}

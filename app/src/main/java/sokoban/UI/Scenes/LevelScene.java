package sokoban.UI.Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;

import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Map;

import java.io.File;
import java.io.FileNotFoundException;


public class LevelScene extends Scene {
    //Scene that will contain a Map type object and display a level

    BorderPane borderPane= new BorderPane();
    Map map;
    Boolean a=true;

    public LevelScene(Map gridPane)  {
        super(gridPane, Color.BLACK);
        //borderPane.getChildren().add(gridPane);
        setMap(gridPane);

        // map.showMap();
        //setCursor(Cursor.NONE);
    }

    public void setMap(Map map) {
        borderPane.setCenter(map);
        BorderPane.setAlignment(map,Pos.CENTER);
        BackButton backButton = new BackButton(new MenuLvlScene());
        borderPane.setRight(backButton);
        BorderPane.setAlignment(backButton, Pos.TOP_LEFT);
        borderPane.setStyle("-fx-background-color: #000000");
        this.map=map;
        map.showMap();
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

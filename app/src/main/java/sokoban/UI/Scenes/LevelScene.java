package sokoban.UI.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Map;
import sokoban.UI.Widgets.Controller;

import sokoban.Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class LevelScene extends Scene {
    //Scene that will contain a Map type object and display a level

    public Map map;
    StackPane stackPane;

    // sounds 
    String moveBoxSounds = new File("build/resources/main/textures/Default/Sounds/level/moveBox.wav").toURI().toString();
    String allBoxesOnTargetSounds = new File("build/resources/main/textures/Default/Sounds/level/allBoxesOnTarget.wav").toURI().toString();
    AudioClip moveBox = new AudioClip(moveBoxSounds);

    public LevelScene(StackPane stackPane)  {
        super(stackPane);
        this.stackPane= stackPane;

        // cursor
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/cursor_pointerFlat.png"));
            setCursor(new ImageCursor(image));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("cursor problem");
        }

        // map
        this.map = new Map();
        stackPane.setStyle("-fx-background-color: #000000;");
        stackPane.getChildren().add(map);
        StackPane.setAlignment(map, Pos.CENTER);
        map.showMap();

        // backButton
        BackButton bbutton = new BackButton();
        bbutton.setOnAction(e->Controller.switchToMenuLvlScene());
        stackPane.getChildren().add(bbutton);
        StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
        StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));
    }

    public void addKeyHandler(KeyEvent ke) {
        //method to move the player on the map
        Player player = Game.level.player;
        World world = Game.level.world;

        KeyCode keyCode = ke.getCode();
        if (keyCode.equals(KeyCode.Z)) {
            player.setTexture("up");
            if (player.move("up", world)) {
                moveBox.play();
            }

        } else if (keyCode.equals(KeyCode.Q)) {
            player.setTexture("left");
            if (player.move("left", world)) {
                moveBox.play();
            }

        } else if (keyCode.equals(KeyCode.S)) {
            player.setTexture("down");
            if (player.move("down", world)) {
                moveBox.play();
            }


        } else if (keyCode.equals(KeyCode.D)) {
            player.setTexture("right");
            if (player.move("right", world)) {
                moveBox.play();
            }
        }

        map.showMap();
        if (world.winCondition()) {
            AudioClip mplayer = new AudioClip(allBoxesOnTargetSounds);
            mplayer.play();
        }
    }
}

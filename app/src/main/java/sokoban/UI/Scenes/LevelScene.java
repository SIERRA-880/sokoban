package sokoban.UI.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import java.util.Scanner;

import sokoban.Game;
import sokoban.ScenesEnum;
import sokoban.Engine.Tools.MoveLogger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LevelScene extends BasicScene {
    //Scene that will contain a Map type object and display a level

    public Map map;
    StackPane stackPane;
    ScenesEnum previousScene;
    boolean move = true;

    // sounds 
    String moveBoxSounds = new File("build/resources/main/textures/Default/Sounds/level/moveBox.wav").toURI().toString();
    String allBoxesOnTargetSounds = new File("build/resources/main/textures/Default/Sounds/level/allBoxesOnTarget.wav").toURI().toString();
    AudioClip moveBox = new AudioClip(moveBoxSounds);

    public LevelScene(StackPane stackPane, ScenesEnum previousScene)  {
        super(stackPane);
        this.stackPane= stackPane;
        this.previousScene = previousScene;

        // map
        this.map = new Map();
        stackPane.setStyle("-fx-background-color: #000000;");
        stackPane.getChildren().add(map);
        StackPane.setAlignment(map, Pos.CENTER);
        map.showMap();

        // backButton
        BackButton bbutton = new BackButton();
        bbutton.setOnAction(e->Controller.switchScene(previousScene));
        stackPane.getChildren().add(bbutton);
        StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
        StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));
    }

    public void reset() {
        move = true;
    }

    public void addKeyHandler(KeyEvent ke) {
        //method to move the player on the map
        Player player = Game.level.player;
        World world = Game.level.world;

        if (!move) {
            return;
        }
        KeyCode keyCode = ke.getCode();
        if (keyCode.equals(Game.up)) {
            player.setTexture("up");
            if (player.move("up", world)) {
                moveBox.play();
            }

        } else if (keyCode.equals(Game.left)) {
            player.setTexture("left");
            if (player.move("left", world)) {
                moveBox.play();
            }

        } else if (keyCode.equals(Game.down)) {
            player.setTexture("down");
            if (player.move("down", world)) {
                moveBox.play();
            }

        } else if (keyCode.equals(Game.right)) {
            player.setTexture("right");
            if (player.move("right", world)) {
                moveBox.play();
            }
        }
        map.showMap();

        // win conditions 
        if (world.winCondition()) {
            AudioClip mplayer = new AudioClip(allBoxesOnTargetSounds);
            mplayer.play();
            move = false;
            MoveLogger.writeToNewestFile();

            // store the save file in an array
            if (Game.level.nlevel > 0) {
                try {
                    int currentLevel = Game.level.nlevel;
                    int[] levels = new int[15];
                    String workingDirectory = System.getProperty("user.dir");
                    String absoluteFilePath = "";
                    absoluteFilePath = workingDirectory + File.separator + "build" + File.separator + "resources" + File.separator + "main" + File.separator + "appdata" + File.separator + "saves";
                    Path dir = Paths.get(absoluteFilePath);
                    File saves = new File(absoluteFilePath);
                    Scanner myReader = new Scanner(saves);
                    int i = 0;
                    while (myReader.hasNextLine()) {
                        String currentLine = myReader.nextLine();
                        levels[i] = Integer.parseInt(currentLine);
                        i++;
                    }
                    myReader.close();
                    boolean write = true;
                    for (int n : levels) {
                        if (currentLevel+1 == n) {
                            write = false;
                        }
                    }
                    if (currentLevel==levels[currentLevel-1] && currentLevel!=15 && write) { 
                        currentLevel++;
                        Files.writeString(dir, "\n"+currentLevel+"", StandardOpenOption.APPEND);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package sokoban.UI.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.robot.Robot;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.UI.Widgets.*;

import java.util.Scanner;

import sokoban.Game;
import sokoban.ScenesEnum;
import sokoban.Engine.Tools.MoveLogger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LevelScene extends BasicScene {
    //Scene that will contain a Map type object and display a level

    public Map map;
    public Label label1 = new Label("YOU WIN !!!!");
    StackPane stackPane;
    ScenesEnum previousScene;
    boolean move = true;
    // sounds
    String moveBoxSounds = new File("build/resources/main/textures/" + Game.resourcePack + "/Sounds/level/moveBox.wav").toURI().toString();
    String allBoxesOnTargetSounds = new File("build/resources/main/textures/" + Game.resourcePack + "/Sounds/level/allBoxesOnTarget.wav").toURI().toString();
    AudioClip moveBox = new AudioClip(moveBoxSounds);
    Robot robot;

    public LevelScene(StackPane stackPane, ScenesEnum previousScene) {
        super(stackPane);

        this.stackPane = stackPane;
        this.previousScene = previousScene;
        robot = new Robot();

        //victory message
        label1.setFont(OptionPane.font());
        label1.setTextFill(Color.web("#A7F5F4"));
        label1.setStyle("-fx-font-size: 60");
        Bloom bloom = new Bloom();
        bloom.setThreshold(0.7);
        label1.setEffect(bloom);
        label1.setVisible(false);

        stackPane.getChildren().add(label1);
        StackPane.setAlignment(label1, Pos.TOP_CENTER);


        // map
        this.map = new Map();
        stackPane.setStyle("-fx-background-color: #000000;");
        stackPane.getChildren().add(map);
        StackPane.setAlignment(map, Pos.CENTER);
        map.showMap();

        //restart button
        try {
            ImageButton resetButton = new ImageButton("build/resources/main/textures/" + Game.resourcePack + "/Buttons/levelMenu/levelButton_reset.png"
            ,"build/resources/main/textures/" + Game.resourcePack + "/Buttons/levelMenu/levelButtonOver_reset.png");
            resetButton.setOnAction(e -> {
                Game.level.setLevel("map" + Game.level.nlevel);
                Game.levelScene.setOnKeyPressed(event -> Game.levelScene.addKeyHandler(event));
                Game.levelScene.map.showMap();
                label1.setVisible(false);
                Controller.switchScene(ScenesEnum.LEVELSCENE);
            });
            stackPane.getChildren().add(resetButton);
            stackPane.setAlignment(Pos.TOP_LEFT);
            StackPane.setMargin(resetButton, new Insets(20.0, 0.0, 0.0, 140.0));


        } catch (FileNotFoundException exception) {
            Controller.alert("The image of the reset button could not be loaded please check the file path in the LevelScene");

        }


        // backButton
        try {
            BackButton bbutton = new BackButton();
            bbutton.setOnAction(e -> {
                Controller.switchScene(previousScene);
                label1.setVisible(false);
            });
            stackPane.getChildren().add(bbutton);
            StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
            StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the back button could not be loaded please check the file path in the LevelScene");
        }
        // up button
        try {
            ImageButton upButton = new ImageButton("build/resources/main/textures/" + Game.resourcePack + "/Buttons/levelMenu/levelButton_empty.png",
                    "build/resources/main/textures/" + Game.resourcePack + "/Buttons/levelMenu/levelButtonOver_empty.png");
            upButton.setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");
            upButton.setText("UP");
            upButton.setOnAction(e -> {
                robot.keyPress(Game.up);
                robot.keyRelease(Game.up);
            });
            stackPane.getChildren().add(upButton);
            StackPane.setAlignment(upButton, Pos.CENTER_LEFT);
            StackPane.setMargin(upButton, new Insets(-160.0, 0.0, 0.0, 135.0));
        } catch (FileNotFoundException e) {

            Controller.alert("Image of the up button in LevelScene could not be" +
                    " loaded please check the path file");
        }

        // left button
        try {
            ImageButton leftButton = new ImageButton("build/resources/main/textures/" + Game.resourcePack + "/Buttons/levelMenu/levelButton_empty.png",
                    "build/resources/main/textures/" + Game.resourcePack + "/Buttons/levelMenu/levelButtonOver_empty.png");
            leftButton.setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");
            leftButton.setText("LEFT");
            leftButton.setOnAction(e -> {
                robot.keyPress(Game.left);
                robot.keyRelease(Game.left);
            });
            stackPane.getChildren().add(leftButton);
            StackPane.setAlignment(leftButton, Pos.CENTER_LEFT);
            StackPane.setMargin(leftButton, new Insets(0.0, 0.0, 0.0, 0.0));
        } catch (FileNotFoundException e) {
            Controller.alert("Image of the left button in LevelScene could not be" +
                    " loaded please check the path file");
        }

        // down button
        try {
            ImageButton downButton = new ImageButton("build/resources/main/textures/" + Game.resourcePack + "/Buttons/levelMenu/levelButton_empty.png",
                    "build/resources/main/textures/" + Game.resourcePack + "/Buttons/levelMenu/levelButtonOver_empty.png");
            downButton.setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");
            downButton.setText("DOWN");
            downButton.setOnAction(e -> {
                robot.keyPress(Game.down);
                robot.keyRelease(Game.down);
            });
            stackPane.getChildren().add(downButton);
            StackPane.setAlignment(downButton, Pos.CENTER_LEFT);
            StackPane.setMargin(downButton, new Insets(0.0, 0.0, 0.0, 120.0));
        } catch (FileNotFoundException e) {
            Controller.alert("Image of the down button in LevelScene could not be" +
                    " loaded please check the path file");
        }

        // right button
        try {
            ImageButton rightButton = new ImageButton("build/resources/main/textures/" + Game.resourcePack + "/Buttons/levelMenu/levelButton_empty.png",
                    "build/resources/main/textures/" + Game.resourcePack + "/Buttons/levelMenu/levelButtonOver_empty.png");
            rightButton.setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");
            rightButton.setText("RIGHT");
            rightButton.setOnAction(e -> {
                robot.keyPress(Game.right);
                robot.keyRelease(Game.right);
            });
            stackPane.getChildren().add(rightButton);
            StackPane.setAlignment(rightButton, Pos.CENTER_LEFT);
            StackPane.setMargin(rightButton, new Insets(0.0, 0.0, 0.0, 240.0));
        } catch (FileNotFoundException e) {
            Controller.alert("Image of the right button in LevelScene could not be" +
                    " loaded please check the path file");
        }
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
            if (player.move("up", world) && OptionPane.soundCheckBox.isSelected()) {
                moveBox.play();
            }

        } else if (keyCode.equals(Game.left)) {
            player.setTexture("left");
            if (player.move("left", world) && OptionPane.soundCheckBox.isSelected()) {
                moveBox.play();
            }

        } else if (keyCode.equals(Game.down)) {
            player.setTexture("down");
            if (player.move("down", world) && OptionPane.soundCheckBox.isSelected()) {
                moveBox.play();
            }

        } else if (keyCode.equals(Game.right)) {
            player.setTexture("right");
            if (player.move("right", world) && OptionPane.soundCheckBox.isSelected()) {
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
            label1.setVisible(true);

            // store the save file in an array
            if (Game.level.nlevel > 0) {
                try {
                    int currentLevel = Game.level.nlevel;
                    int[] levels = new int[15];
                    String workingDirectory = System.getProperty("user.dir");
                    String absoluteFilePath;
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
                        if (currentLevel + 1 == n) {
                            write = false;
                        }
                    }
                    if (currentLevel == levels[currentLevel - 1] && currentLevel != 15 && write) {
                        currentLevel++;
                        Files.writeString(dir, "\n" + currentLevel + "", StandardOpenOption.APPEND);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

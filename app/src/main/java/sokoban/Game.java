package sokoban;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sokoban.Engine.Objects.Level;
import sokoban.UI.Scenes.*;

import java.io.FileNotFoundException;

public class Game extends Application {
    //Main class that launches the game

    public static Stage window;
    public static Level level;
    public static VideoScene videoScene;
    public static MenuLvlScene menuLvlScene;
    public static LevelScene levelScene;
    public static CreditsScene creditsScene;
    public static OptionScene optionScene;
    public static ArcadeScene arcadeScene;
    public static RandomLevelScene randomLevelScene;
    public static BuilderScene builderScene;
    public static StackPane pane = new StackPane();
    public static KeyCode up;
    public static KeyCode left;
    public static KeyCode down;
    public static KeyCode right;
    public static String resourcePack;
    public static int genWidth;
    public static int genHeight;
    public static int genBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Sokoban");
        window.setMaximized(true);
        window.setFullScreenExitKeyCombination(KeyCombination.keyCombination(String.valueOf(KeyCode.F11)));

        // resource pack
        resourcePack = "Default"; 
        
        // generation parameters
        genWidth = 10;
        genHeight = 10;
        genBox = 4;

        // binds
        up = KeyCode.Z;
        left = KeyCode.Q;
        down = KeyCode.S;
        right = KeyCode.D;

        // Level
        level = new Level();
        level.setLevel("map1");

        // scenes
        videoScene = new VideoScene(pane);
        VideoScene.Mplayer.play();
        menuLvlScene = new MenuLvlScene(new StackPane());
        levelScene = new LevelScene(new StackPane(), ScenesEnum.MENULVLSCENE);
        creditsScene = new CreditsScene(new StackPane());
        optionScene = new OptionScene(new StackPane());
        arcadeScene = new ArcadeScene(new StackPane());
        randomLevelScene = new RandomLevelScene(new StackPane(), ScenesEnum.ARCADESCENE);
        builderScene = new BuilderScene(new StackPane());
        window.setScene(videoScene);
        window.show();
    }
}

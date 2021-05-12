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
    public static LoadScene loadScene;
    public static KeyCode up;
    public static KeyCode left;
    public static KeyCode down;
    public static KeyCode right;
    public static String resourcePack;
    public static int genWidth;
    public static int genHeight;
    public static int genBox;
    public static StackPane videoScenePane = new StackPane();
    public static StackPane menuLvlScenePane = new StackPane();
    public static StackPane levelScenePane = new StackPane();
    public static StackPane creditsScenePane = new StackPane();
    public static StackPane optionScenePane = new StackPane();
    public static StackPane arcadeScenePane = new StackPane();
    public static StackPane randomLevelScenePane = new StackPane();
    public static StackPane builderScenePane = new StackPane();
    public static StackPane loadScenePane = new StackPane();




    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Sokoban");
        window.setMaximized(true);

        // resource pack
        resourcePack = "Default"; 
        
        // generation parameters
        genWidth = 10;
        genHeight = 10;
        genBox = 1;

        // binds
        up = KeyCode.Z;
        left = KeyCode.Q;
        down = KeyCode.S;
        right = KeyCode.D;

        // Level
        level = new Level();
        level.setLevel("map1");

        // scenes
        videoScene = new VideoScene(videoScenePane);
        VideoScene.playMplayer();
        menuLvlScene = new MenuLvlScene(menuLvlScenePane);
        levelScene = new LevelScene(levelScenePane, ScenesEnum.MENULVLSCENE);
        creditsScene = new CreditsScene(creditsScenePane);
        optionScene = new OptionScene(optionScenePane);
        arcadeScene = new ArcadeScene(arcadeScenePane);
        randomLevelScene = new RandomLevelScene(randomLevelScenePane, ScenesEnum.ARCADESCENE);
        builderScene = new BuilderScene(builderScenePane);
        loadScene = new LoadScene(loadScenePane, ScenesEnum.ARCADESCENE);
        window.setScene(videoScene);
        window.show();
    }
}

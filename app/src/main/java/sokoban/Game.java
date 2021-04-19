package sokoban;

import javafx.scene.text.Font;
import sokoban.Engine.Objects.Level;

import sokoban.UI.Scenes.CreditsScene;
import sokoban.UI.Scenes.LevelScene;
import sokoban.UI.Scenes.MenuLvlScene;
import sokoban.UI.Scenes.VideoScene;
import sokoban.UI.Scenes.OptionScene;

import javafx.application.Application;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;

public class Game extends Application {
    //Main class that launches the game

    public static Stage window;
    public static Level level;
    public static VideoScene videoScene;
    public static MenuLvlScene menuLvlScene;
    public static LevelScene levelScene;
    public static CreditsScene creditsScene;
    public static OptionScene optionScene;
    public static StackPane pane = new StackPane();
    public static KeyCode up;
    public static KeyCode left;
    public static KeyCode down;
    public static KeyCode right;

    public static void main(String[] args)  {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        window = primaryStage;
        window.setTitle("Sokoban");
        window.setFullScreen(true);
        window.setFullScreenExitKeyCombination(KeyCombination.keyCombination(String.valueOf(KeyCode.F11)));

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
        levelScene = new LevelScene(new StackPane());
        creditsScene = new CreditsScene(new StackPane());
        optionScene = new OptionScene(new StackPane());
        window.setScene(videoScene);

        // window
        window.show();
    }
}

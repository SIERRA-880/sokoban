package sokoban;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaException;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Shape;

import sokoban.UI.Scenes.BgScene;
import sokoban.UI.Scenes.MenuLvlScene;
import sokoban.UI.Scenes.LevelScene;
import sokoban.UI.Scenes.VideoScene;
import sokoban.UI.Widgets.MovingBg;
import sokoban.UI.Widgets.VideoBg;

import sokoban.Engine.Objects.Level;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Game extends Application {
    //Main class that launches the game

    public static Stage window;
    public static Level level;
    public static VideoScene videoScene;
    public static MenuLvlScene menuLvlScene;
    public static LevelScene levelScene;
    public static StackPane pane= new StackPane();

    public static void main(String[] args)  {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        window = primaryStage;
        window.setTitle("Sokoban");
        window.setFullScreen(true);
        window.setFullScreenExitKeyCombination(KeyCombination.keyCombination(String.valueOf(KeyCode.F11)));

        // Level
        level = new Level();
        level.setLevel("map1");

        // scenes
        videoScene = new VideoScene(new StackPane());
        VideoScene.Mplayer.play();
        menuLvlScene = new MenuLvlScene(new StackPane());
        levelScene = new LevelScene(new StackPane());
        window.setScene(videoScene);



        // window
        window.show();

    }
}

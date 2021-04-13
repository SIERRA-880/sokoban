package sokoban;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaException;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import sokoban.UI.Scenes.BgScene;
import sokoban.UI.Scenes.MenuLvlScene;
import sokoban.UI.Scenes.VideoScene;
import sokoban.UI.Widgets.MovingBg;
import sokoban.UI.Widgets.VideoBg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Game extends Application {
    //Main class that launches the game

    public static Stage window;

    public static void main(String[] args)  {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        window = primaryStage;
        window.setTitle("Sokoban");
        window.setFullScreen(true);
        window.setFullScreenExitKeyCombination(KeyCombination.keyCombination(String.valueOf(KeyCode.F11)));

        VideoScene videoScene = new VideoScene(new StackPane());
        VideoScene.Mplayer.play();
        window.setScene(videoScene);

        window.show();

    }
}

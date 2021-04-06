package sokoban.UI.Widgets;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sokoban.Game;

import java.awt.*;

public class Controller {
    public static void switchScene(Scene scene) {
        Game.window.setScene(scene);
        Game.window.setFullScreen(true);

    }
//truc changé
}

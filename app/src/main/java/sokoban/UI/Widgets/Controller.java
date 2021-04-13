package sokoban.UI.Widgets;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import sokoban.Game;
import sokoban.UI.Scenes.VideoScene;

import java.io.FileNotFoundException;

public class Controller {

    public static void switchToVideoScene() {
        Game.window.setScene(Game.videoScene);
        Game.window.setFullScreen(true);
        Game.window.setFullScreenExitHint("");
    }

    public static void switchToMenuLvlScene() {
        Game.window.setScene(Game.menuLvlScene);
        Game.window.setFullScreen(true);
        Game.window.setFullScreenExitHint("");
    }

    public static void switchToLevelScene() {
        Game.window.setScene(Game.levelScene);
        Game.window.setFullScreen(true);
        Game.window.setFullScreenExitHint("");
    }

}

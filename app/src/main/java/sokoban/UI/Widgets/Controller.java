package sokoban.UI.Widgets;

import javafx.scene.Scene;
import sokoban.Game;

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
    }
    public static void switchScene(Scene scene) {

        Game.window.setScene(scene);
        Game.window.setFullScreen(true);
        Game.window.setFullScreenExitHint("");
    }

}

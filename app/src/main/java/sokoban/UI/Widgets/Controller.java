package sokoban.UI.Widgets;

import sokoban.Game;
import sokoban.UI.Scenes.OptionScene;
import javafx.scene.layout.StackPane;

public class Controller {

    public static void switchToVideoScene() {
        Game.pane = new StackPane();
        Game.window.setScene(Game.videoScene);
        Game.window.setFullScreen(true);
        Game.window.setFullScreenExitHint("");
    }

    public static void switchToMenuLvlScene() {
        Game.pane = new StackPane();
        Game.window.setScene(Game.menuLvlScene);
        Game.window.setFullScreen(true);
        Game.window.setFullScreenExitHint("");
    }

    public static void switchToLevelScene() {
        Game.pane = new StackPane();
        Game.window.setScene(Game.levelScene);
        Game.window.setFullScreen(true);
        Game.window.setFullScreenExitHint("");
    }

    public static void switchToOptionScene(){
        Game.pane = new StackPane();
        Game.window.setScene(new OptionScene());
        Game.window.setFullScreen(true);
        Game.window.setFullScreenExitHint("");
    }

    public static void switchToCreditsScene(){
        Game.pane = new StackPane();
        Game.window.setScene(Game.creditsScene);
        Game.window.setFullScreen(true);
        Game.window.setFullScreenExitHint("");
    }
}

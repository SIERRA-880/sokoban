package sokoban.UI.Widgets;

import javafx.scene.layout.StackPane;
import sokoban.Game;
import sokoban.UI.Scenes.OptionScene;

public class Controller {

    public static void switchScene(String scene) {
        Game.pane = new StackPane();
        switch (scene) {
            case "VideoScene" -> Game.window.setScene(Game.videoScene);
            case "MenuLvlScene" -> Game.window.setScene(Game.menuLvlScene);
            case "OptionScene" -> Game.window.setScene(new OptionScene());
            case "CreditsScene" -> Game.window.setScene(Game.creditsScene);
            case "LevelScene" -> Game.window.setScene(Game.levelScene);
            default -> System.out.println("I told you we would make a mistake !");
        }
        Game.window.setFullScreen(true);
        Game.window.setFullScreenExitHint("");
    }
}

package sokoban.UI.Widgets;

import javafx.scene.layout.StackPane;
import sokoban.Game;
import sokoban.UI.Scenes.OptionScene;

public class Controller {

    public static void switchScene(String scene) {
        Game.pane = new StackPane();
        switch (scene) {
            case "VideoScene":
                Game.window.setScene(Game.videoScene);
                break;
            case "MenuLvlScene":
                Game.window.setScene(Game.menuLvlScene);
                break;
            case "OptionScene":
                Game.window.setScene(new OptionScene());
                break;
            case "CreditsScene":
                Game.window.setScene(Game.creditsScene);
                break;
            case "LevelScene":
                Game.window.setScene(Game.levelScene);
                break;
            default:
                System.out.println("I told you we would make a mistake !");
                break;
        }
        Game.window.setFullScreen(true);
        Game.window.setFullScreenExitHint("");
    }
}

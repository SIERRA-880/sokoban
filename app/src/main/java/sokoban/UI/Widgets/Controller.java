package sokoban.UI.Widgets;

import javafx.scene.layout.StackPane;
import sokoban.Game;
import sokoban.ScenesEnum;
import sokoban.UI.Scenes.OptionScene;

public class Controller {

    public static void switchScene(ScenesEnum scene) {
        Game.pane = new StackPane();
        switch (scene) {
            case VIDEOSCENE:
                Game.window.setScene(Game.videoScene);
                break;
            case MENULVLSCENE:
                Game.menuLvlScene.refresh();
                Game.window.setScene(Game.menuLvlScene);
                break;
            case OPTIONSCENE:
                Game.window.setScene(Game.optionScene);
                break;
            case CREDITSSCENE:
                Game.window.setScene(Game.creditsScene);
                break;
            case LEVELSCENE:
                Game.levelScene.reset();
                Game.window.setScene(Game.levelScene);
                break;
            case ARCADESCENE:
                Game.window.setScene(Game.arcadeScene);
                break;
            case RANDOMLEVELSCENE:
                Game.window.setScene(Game.randomLevelScene);
                break;
            case BUILDERSCENE:
                Game.window.setScene(Game.builderScene);
                break;
            default:
                System.out.println("I told you we would make a mistake !");
                break;
        }
        Game.window.setMaximized(true);
        Game.window.setFullScreenExitHint("");
    }
}

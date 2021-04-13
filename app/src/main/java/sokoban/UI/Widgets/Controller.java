package sokoban.UI.Widgets;

import sokoban.Game;
import sokoban.UI.Scenes.OptionScene;

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
    public static void switchToOptionScene(){
        Game.window.setScene(new OptionScene());
        Game.window.setFullScreen(true);
        Game.window.setFullScreenExitHint("");
    }

}

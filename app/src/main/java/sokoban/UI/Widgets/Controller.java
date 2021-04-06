package sokoban.UI.Widgets;

import javafx.scene.Scene;
import sokoban.Game;


public class Controller {
    public static void switchScene(Scene scene) {
        Game.window.setScene(scene);
        Game.window.setFullScreen(true);

    }
//truc changé
}

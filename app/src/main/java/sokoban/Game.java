

package sokoban;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;
import sokoban.UI.GridLvlButtons;
import sokoban.UI.LevelScene;
import sokoban.UI.Map;
import sokoban.UI.MenuLvlScene;

public class Game extends Application {
    //Main class that launches the game
    public static Stage window;

    public static void main(String[] args) throws Exception {

        launch(args);
    }

    public static void switchScene(Scene scene) {
        window.setScene(scene);
        window.setFullScreen(true);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //window
        window = primaryStage;
        window.setTitle("Sokoban");

        MenuLvlScene menuLvlScene = new MenuLvlScene();

        window.setScene(menuLvlScene);

        // Window

        window.setFullScreen(true);
        window.setFullScreenExitKeyCombination(KeyCombination.keyCombination(String.valueOf(KeyCode.F11)));
        window.show();
    }


}


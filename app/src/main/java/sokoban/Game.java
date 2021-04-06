
package sokoban;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import sokoban.UI.Scenes.MenuLvlScene;

public class Game extends Application {
    //Main class that launches the game
    public static Stage window;

    public static void main(String[] args)  {

        launch(args);
    }
    //truc changé

    @Override
    public void start(Stage primaryStage) {
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




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
import sokoban.UI.LevelScene;
import sokoban.UI.Map;
import sokoban.UI.MenuLvlScene;

public class Game extends Application {
    //Main class that launches the game
    public static Stage window;


    public Game() throws Exception {
    }

    public static void main(String[] args) throws Exception {

        launch(args);
    }

    public static void switchScene(Scene scene) {
        window.setScene(scene);
        window.setFullScreen(true);
       // window.setFullScreenExitKeyCombination(KeyCombination.keyCombination(String.valueOf(KeyCode.F11)));
       // window.setFullScreenExitHint("Appuie sur f11 fdp");
       // window.getFullScreenExitHint();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //window
        window = primaryStage;
        window.setTitle("Sokoban");

        //map
        String map = MapLoader.load("build/resources/main/levels/map1.xsb");
        int[] size = MapLoader.getSize("build/resources/main/levels/map1.xsb");
        int[] pos = {0, 0};
        Player player = new Player(pos, "/Cells/player.png");
        World world = new World(size[0], size[1], player);
        Builder.init(map, player, world, size[0], size[1]);
        Map lvlMap = new Map(world);
        LevelScene lvlscene = new LevelScene(lvlMap);

        MenuLvlScene menuLvlScene = new MenuLvlScene();
        lvlscene.setOnKeyPressed(e-> lvlscene.addKeyHandler(lvlscene,player,world,lvlMap,e));
        window.setScene(menuLvlScene);

        // Window

        window.setFullScreen(true);
        window.setFullScreenExitHint("Appuie sur f11 pour quitter le fullscreen \n avant que je monte ta grand-mere en l'air connard");
        window.setFullScreenExitKeyCombination(KeyCombination.keyCombination(String.valueOf(KeyCode.F11)));
        window.show();
    }


}


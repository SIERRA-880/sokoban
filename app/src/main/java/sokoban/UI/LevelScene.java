package sokoban.UI;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.Game;

public class LevelScene extends Scene {

    public Map map;

    public LevelScene(Map map) throws Exception {
        super(map);
        this.map = map;
        Game.window.setFullScreen(true);
        map.showMap();

    }

    public void addKeyHandler(Scene scene, Player player, World world, Map grid, KeyEvent ke) {

        KeyCode keyCode = ke.getCode();
        if (keyCode.equals(KeyCode.Z)) {
            player.move("up", world);

        } else if (keyCode.equals(KeyCode.Q)) {
            player.move("left", world);

        } else if (keyCode.equals(KeyCode.S)) {
            player.move("down", world);

        } else if (keyCode.equals(KeyCode.D)) {
            player.move("right", world);
        }
        try {
            map.showMap();
        } catch (Exception yes) {
            System.out.println(yes);
        }
    }

}



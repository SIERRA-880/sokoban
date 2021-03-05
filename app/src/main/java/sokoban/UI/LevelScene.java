package sokoban.UI;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.Game;

public class LevelScene extends Scene {
    //Scene that will containe a Map type object and display a level

    public static Map map;

    public LevelScene(Map map) throws Exception {
        super(map);
        LevelScene.map = map;
        Game.window.setFullScreen(true);
        map.showMap();




    }
    public void addKeyHandler(Scene scene, Player player, World world, Map grid, KeyEvent ke) {
        //methode to move the player on th map
        System.out.println("yes");

        KeyCode keyCode = ke.getCode();
        if (keyCode.equals(KeyCode.Z)) {
            player.move("up", world);
            System.out.println("yes");

        } else if (keyCode.equals(KeyCode.Q)) {
            player.move("left", world);
            System.out.println("yes");

        } else if (keyCode.equals(KeyCode.S)) {
            player.move("down", world);
            System.out.println("yes");

        } else if (keyCode.equals(KeyCode.D)) {
            player.move("right", world);
        }
        grid.showMap();
    }


}




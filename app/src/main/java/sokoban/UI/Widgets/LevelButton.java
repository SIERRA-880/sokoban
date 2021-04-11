package sokoban.UI.Widgets;

import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.Engine.Objects.Level;

import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LevelButton extends ImageButton {

    int level;
    Player player;
    World world;
    Image locked;

    /**
     * This widget is a button that will start a game's level.
     * 
     * @param selected is the image when de mouse is over the button.
     * @param unselected is the image when de mouse is not over the button.
     * @param levek is the number of the level.
     */
    public LevelButton(Image selected, Image unselected, int level)throws FileNotFoundException {
        super(selected, unselected);
        this.level = level;
    }

    public Map getMap() {
        try {
            Level map = new Level("map" + level);
            world = map.getWorld();
            player = map.getPlayer();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return new Map(world);
    }
}

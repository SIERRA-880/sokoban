package sokoban.UI.Widgets;

import javafx.scene.image.Image;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;
import sokoban.Engine.Objects.Level;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LevelButton extends ImageButton {
    //type of button that is used to designate a level
    int level;
    Player player;
    World world;
    Image locked;

    public LevelButton(Image selected, Image unselected, int level) {
        super(selected, unselected);
        this.level = level;

    }
    public Map getMap() {
        try {
            Level map = new Level("map" + level);

            world = map.getWorld();
            player = map.getPlayer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Map(world);


    }
}



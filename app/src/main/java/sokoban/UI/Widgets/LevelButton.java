package sokoban.UI.Widgets;

import javafx.scene.image.Image;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;
import sokoban.UI.Widgets.ImageButton;

public class LevelButton extends ImageButton {
    //type of button that is used to designate a level
    int level;
    Player player;
    World world;

    public LevelButton(Image selected, Image unselected, int level) throws Exception {
        super(selected, unselected);
        this.level = level;

    }

    public Map getMap() {


        String map = MapLoader.load("build/resources/main/levels/map" + (level) + ".xsb");
        int[] size = MapLoader.getSize("build/resources/main/levels/map" + (level) + ".xsb");
        int[] pos = {0, 0};
        player = new Player(pos, "/Cells/player.png");
        world = new World(size[0], size[1], player);
        Builder.init(map, player, world, size[0], size[1]);
        Map gridMap = new Map(world);
        return gridMap;



    }


}

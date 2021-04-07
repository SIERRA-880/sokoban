package sokoban.Engine.Objects;

import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;

public class Level {

    private boolean locked = true;
    private String map;
    private World world;
    private Player player;
    private int[] size;
    
    public Level(String map) {
        int[] pos = {0, 0};
        this.map = MapLoader.load("build/resources/main/levels/"+map+".xsb"); 
        size = MapLoader.getSize("build/resources/main/levels/"+map+".xsb"); 
        player = new Player(pos, "/Cells/player.png");
        world = new World(size[0], size[1], player);
        Builder.init(this.map, player, world, size[0], size[1]);

    }

    public void unlock() {
        locked = false;
    }

    public World getWorld() {
        return world;
    }

    public Player getPlayer() {
        return player;
        }
}


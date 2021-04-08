package sokoban.Engine.Objects;

import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;

public class Level {

    private boolean locked = true;
    private String map;
    private World world;
    private Player player;
    private int[] size;
  
    /**
     * This create an instance of a level.
     * @param map is a string containing a map name. ex: map1 
     */
    public Level(String map) {
        int[] pos = {0, 0};
        this.map = MapLoader.load("build/resources/main/levels/"+map+".xsb"); 
        size = MapLoader.getSize("build/resources/main/levels/"+map+".xsb"); 
        player = new Player(pos, "/Cells/player.png");
        world = new World(size[0], size[1], player);
        Builder.init(this.map, player, world, size[0], size[1]);
    }

    /**
     * By default, a level is locked but it can be 
     * unlock by using this method.
     */
    public void unlock() {
        locked = false;
    }

    /**
     * This return the world of the current instance of a level.
     * 
     * @return world
     */
    public World getWorld() {
        return world;
    }

    /** 
     * This return the player of the current isntance of a level.
     * 
     * @return player
     */
    public Player getPlayer() {
        return player;
    }
}

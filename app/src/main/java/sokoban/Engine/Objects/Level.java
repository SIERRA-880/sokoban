package sokoban.Engine.Objects;

import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;

public class Level {

    private String map;
    public World world;
    public Player player;
    private int[] size;
  
    /**
     * This create an instance of a level.
     *
     * @param map is a string containing a map name. ex: map1 
     */
    public Level() {
    }

    public void setLevel(String map) {
        int[] pos = {0, 0};
        this.map = MapLoader.load("build/resources/main/levels/"+map+".xsb"); 
        size = MapLoader.getSize("build/resources/main/levels/"+map+".xsb"); 
        player = new Player(pos, "/Cells/player.png");
        world = new World(size[0], size[1], player);
        Builder.init(this.map, player, world, size[0], size[1]);
    }

    /**
     * This return the world of the current instance of a level.
     */
    public World getWorld() {
        return world;
    }

    /** 
     * This return the player of the current isntance of a level.
     */
    public Player getPlayer() {
        return player;
    }
}

package sokoban.Engine.Objects;

import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;

public class Level {

    public String map;
    public World world;
    public Player player;
    private int[] size;
    public int nlevel;
  
    public Level() {
    }

    /**
     * This method set the options for  an instance of a level.
     *
     * @param map is a string containing a map name. ex: map1 
     */
    public void setLevel(String map) {
        //nlevel = Integer.parseInt(map.charAt(map.length()-1)+"");
        nlevel = Integer.parseInt(map.replaceAll("[^0-9]", ""));
        int[] pos = {0, 0};
        this.map = MapLoader.load("build/resources/main/levels/"+map+".xsb"); 
        size = MapLoader.getSize("build/resources/main/levels/"+map+".xsb"); 
        player = new Player(pos, "/Cells/player_down.png");
        world = new World(size[0], size[1], player);
        Builder.init(this.map, player, world, size[0], size[1]);
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

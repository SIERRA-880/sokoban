package sokoban.Engine.Objects;

import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;

public class Level {

    public String map;
    public World world;
    public Player player;
    private int[] size;
    public int nlevel;
  
    /**
     * This method set the options for  an instance of a level.
     *
     * @param map is a string containing a map name. ex: map1 
     */
    public void setLevel(String map) {
        // regex to get the level number
        nlevel = Integer.parseInt(map.replaceAll("[^0-9]", ""));
        int[] pos = {0, 0};
        this.map = MapLoader.load("build/resources/main/levels/"+map+".xsb"); 
        size = MapLoader.getSize("build/resources/main/levels/"+map+".xsb"); 
        player = new Player(pos, "/Cells/player_down.png");
        world = new World(size[0], size[1], player);
        Builder.init(this.map, player, world, size[0], size[1]);
    }

    public void loadLevel(String map) {
        // regex to get the level number
        nlevel = 0;
        int[] pos = {0, 0};
        this.map = MapLoader.load("build/resources/main/levels/save/"+map+".xsb"); 
        size = MapLoader.getSize("build/resources/main/levels/save/"+map+".xsb"); 
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

    public void setNLevel(int n) {
        nlevel = n;
    }

    @Override
    public String toString() {
        // Initializing the String that will contains the output
        String output = "";

        // Double for loop to iterate trough the entire world
        for (int i = 0; i < world.height; i++) {
            for (int j = 0; j < world.width; j++) {
                // Creating an array of int to pass as a parameter for searchCell(pos)
                int[] pos = {j,i};
                Cell cell = world.searchCell(pos);
                output += cell.getTermTexture();
            }
        }
        return output;
    }
}

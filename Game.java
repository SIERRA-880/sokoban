import Objects.*;
import Tools.*;

import java.util.Scanner;

public class Game {
    
    public static void main(String[] args) {
        //String map = "########### .   .  ## # ## # ## $  #   ## $ $    ## #   # ### @#     ## . $ #.### #     ############";
        String map;
        int[] size;
        if (args.length > 0) {
            map = MapLoader.load(args[0]);
            size = MapLoader.getSize(args[0]);
        }
        else {
            map = MapLoader.load("Maps/map1.txt");
            size = MapLoader.getSize("Maps/map1.txt");
        }
        
        int[] pos = {0, 0};
        Player player = new Player(pos, '@');
        
        World world = new World(size[0], size[1], player);
        world.setList(Builder.innit(map, player, size[0], size[1]));
        world.setMap(Builder.build(world.getList(), size[0], size[1]));
        
        Scanner input = new Scanner(System.in);
        boolean replay = true;
        while (replay) {
            world.upDate();
            world.printMap();
            char direction = input.next().charAt(0);
            switch (direction) {
                case 'z' : player.move(direction, world); 
                break;
                case 'q' : player.move(direction, world);
                break;
                case 's' : player.move(direction, world);
                break;
                case 'd' : player.move(direction, world);
                break;
                case '1' : world.mapChanger("map1.txt");
                break;
                case '2' : world.mapChanger("map2.txt");
                break;
                case '!' : replay=false;
                break;
                
                default : System.out.println("Give a correct direction please.");
                break;
            }
        }
        
    }
}
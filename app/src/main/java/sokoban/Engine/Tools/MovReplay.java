package sokoban.Engine.Tools;

import sokoban.Engine.Objects.Level;
import sokoban.Engine.Objects.World;
import sokoban.Engine.Tools.WriteToXsb;
import sokoban.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovReplay {
    
    public static Level replay(Level level, String moves) {
        
//        String moves = "";
        try {
            File myObj = new File("build/resources/main/appdata/movements/"+ moves + ".mov");
            Scanner myReader = new Scanner(myObj);
            moves = myReader.nextLine();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found (MovReplay:12)");
        }

        for (int n=0; n<moves.length(); n++) {
            switch (moves.toLowerCase().charAt(n)) {
                case 'u':
                    level.player.move("up", level.world);
                    break;
                case 'r':
                    level.player.move("right", level.world);
                    break;
                case 'd':
                    level.player.move("down", level.world);
                    break;
                case 'l':
                    level.player.move("left", level.world);
                    break;
            }
            level.world.printMap();
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Problem with Thread.sleep() (MovReplay:28)");
            }
        }
        WriteToXsb.write("out1", level.toString(), level.world.width);
        return level;
    }

    public static void main(String[] args) {
        Level level = new Level();
        level.setLevel(args[0]);
        System.out.println(replay(level, args[1]));
    }
}

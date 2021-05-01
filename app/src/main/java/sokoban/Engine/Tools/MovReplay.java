package sokoban.Engine.Tools;

import sokoban.Engine.Objects.Level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovReplay {
   
    public static void main(String[] args) {

        Level level = new Level();
        level.setLevel(args[0]);
        String moves = "";
        try {
            File myObj = new File("build/resources/main/appdata/movements/"+args[1]);
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
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Problem with Thread.sleep() (MovReplay:28)");
            }
        }
    }
}

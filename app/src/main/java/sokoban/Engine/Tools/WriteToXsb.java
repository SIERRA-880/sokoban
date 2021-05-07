package sokoban.Engine.Tools;

import sokoban.Engine.Objects.*;

public class WriteToXsb {

    /**
     * @param level take a Level as parameter
     * @return A String containing the entire level on one line
     */
    public static String levelToString(Level level) {
        // Takes the attribute world fron the class Level
        World world = level.world;

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

    /**
     * @param map The level stored on one String from {@link #levelToString(Level level)}
     * @param width An int, the width of the level
     */
    public static void writeToXsb(String map, int width) {
        
    }
}

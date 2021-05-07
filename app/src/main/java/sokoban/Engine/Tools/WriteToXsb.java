package sokoban.Engine.Tools;

import sokoban.Engine.Objects.*;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;

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
     * Output a Level to .xsb format in build/resources/main/levels/
     * @param fileName A String containing the name of the output file
     */
    public static void write(String fileName, Level level) {
        try {
            // Use of System.getProperty("user.dir") to get the actual directory (eg. /home/ugo/games/sokoban)
            String workingDirectory = System.getProperty("user.dir");
            String absoluteFilePath = "";
            // Use of File.separator so it's working regardless the operating system
            absoluteFilePath = workingDirectory + File.separator + "build" + File.separator + "resources" + File.separator + "main" + File.separator + "levels" + File.separator + fileName + ".xsb";
        
            File file = new File(absoluteFilePath);
            file.createNewFile();
            
            FileOutputStream writer = new FileOutputStream(file);
            byte[] strToByte = levelToString(level).getBytes();
            writer.write(strToByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //createFile(fileName);
    }
}

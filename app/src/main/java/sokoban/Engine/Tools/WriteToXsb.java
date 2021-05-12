package sokoban.Engine.Tools;

import sokoban.Engine.Objects.*;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;

/**
 * Store a {@link sokoban.Engine.Objects.Level} in .xsb format. Useful if you want to save a game.
 * @author Ugo Proietti
 */
public class WriteToXsb {
    /**
     * Output a Level to .xsb format in build/resources/main/levels/
     * @param fileName A String containing the name of the output file
     * @param mapString The String returned by {@link sokoban.Engine.Tools.MapLoader#load}
     * @param mapWidth An int, the width of the map returned by {@link sokoban.Engine.Tools.MapLoader#getSize}
     */
    public static void write(String fileName, String mapString, int mapWidth) {
        try {
            // Use of System.getProperty("user.dir") to get the actual directory (eg. /home/ugo/games/sokoban)
            String workingDirectory = System.getProperty("user.dir");
            String absoluteFilePath = "";
            // Use of File.separator so it's working regardless the operating system
            absoluteFilePath = workingDirectory + File.separator + "build" + File.separator + "resources" + File.separator + "main" + File.separator + "levels" + File.separator + "save" + File.separator + fileName + ".xsb";
        
            File file = new File(absoluteFilePath);
            file.createNewFile();
            FileWriter writer = new FileWriter(file);

            int n = 0;
            while (n < mapString.length()) {
                for (int i=0; i<mapWidth; i++) {
                    char mapChar = mapString.charAt(n++);
                    writer.write(mapChar+"");
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //createFile(fileName);
    }
}

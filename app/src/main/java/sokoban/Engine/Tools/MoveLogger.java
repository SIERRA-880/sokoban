package sokoban.Engine.Tools;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MoveLogger {
    public static void main(String[] args) throws IOException {
        logMovement('u');
    }

    /**Create a file "dd/mm/yy_hh:mm:ss_level.mov" in the directory to store movements
     * 
     * @param level The level name, this will be appended at the end of the file
     * @throws IOException
     */
    public static void createFile(String level) throws IOException {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String formattedDate = date.format(format);

        // Create file named "dd/mm/yy_hh:mm:ss_level.mov"
        String fileName = formattedDate + "_" + level + ".mov";
        File myObj = new File(fileName);
        myObj.createNewFile();
    }

    /**
     * Append a char to the last modified file in the directory containing .mov files.
     * 
     * If the player is just moving, the method should be call with 'u','l','d','r'.
     * If the player is moving a box, the method should be called with 'U','L','D','R'.
     * Caps letter indicates that the player is moving a box.
     * 
     * @param direction A char 'u','l''d','r','U','L','D','R'.
     */
    public static void logMovement(char direction) {

    }

    /**
     * This method looks for the most recent file in the directory containing .mov files.
     * 
     * @return A string containing the name of the most recent file.
     */
    public static String getNewestFile() {

    }

    /**
     * Find the newest file with the method {@link sokoban.Engine.Tools.MoveLogger.getnewestFile} and write to it.
     */
    public static void writeToNewestFile() {

    }
}

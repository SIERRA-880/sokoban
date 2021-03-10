package sokoban.Engine.Tools;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MoveLogger {
    public static void main(String[] args) throws IOException {
        createFile("lvl1");
    }

    /**Create a file "dd/mm/yy_hh:mm:ss_level.mov" in the directory to store movements
     * 
     * @param level The level name, this will be appended at the end of the file
     * @throws IOException
     */
    public static void createFile(String level) throws IOException {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        // Format the original date pattern from "yyyy-MM-ddTHH:mm:ss.ms " to "10-03-2021_20-20-48 "
        String formattedDate = date.format(format);

        // Create file named "dd/mm/yy_hh:mm:ss_level.mov"
        String fileName = formattedDate + "_" + level + ".mov";
        File myObj = new File(fileName);
        myObj.createNewFile();
    }

    public static void name() {
        
    }
}

package sokoban.Engine.Tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

public class MoveLogger {

    static ArrayList<Character> movements = new ArrayList<Character>();

    /**
     * Create a file "dd/mm/yy_hh:mm:ss_level.mov" in the directory app/build/resources/main/movements/ to store movements
     * 
     * @param level The level name, this will be appended at the end of the file
     */
    public static void createFile(String level) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String formattedDate = date.format(format);

        // Create file named "dd/mm/yy_hh:mm:ss_level.mov"
        try {
            String fileName = formattedDate + "_" + level + ".mov";
            String workingDirectory = System.getProperty("user.dir");
            String absoluteFilePath = "";
            
            absoluteFilePath = workingDirectory + File.separator + "build" + File.separator + "resources" + File.separator + "main" + File.separator + "appdata" + File.separator + "movements" + File.separator + fileName;
        
            File file = new File(absoluteFilePath);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        movements.clear();
    }

    /**
     * Append a char to the last modified file in the directory containing .mov files.
     * 
     * If the player is just moving, the method should be call with 'u','l','d','r'.
     * If the player is moving a box, the method should be called with
     * 'U','L','D','R'. Caps letter indicates that the player is moving a box.
     * 
     * @param direction A char 'u','l','d','r','U','L','D','R'.
     */
    public static void logMovement(char direction) {
        movements.add(direction);
    }

    /**
     * This method looks for the most recent file in the directory containing .mov files.
     * 
     * Credit to : https://www.baeldung.com/java-last-modified-file
     * 
     * @return A string containing the name of the most recent file.
     */
     public static Path getNewestFile() {
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = "";
            
        absoluteFilePath = workingDirectory + File.separator + "build" + File.separator + "resources" + File.separator + "main" + File.separator + "appdata" + File.separator + "movements";
        
        Path dir = Paths.get(absoluteFilePath);

        if (Files.isDirectory(dir)) {
            try {
                Optional<Path> opPath = Files.list(dir)
                .filter(p -> !Files.isDirectory(p))
                .sorted((p1, p2)-> Long.valueOf(p2.toFile().lastModified())
                .compareTo(p1.toFile().lastModified()))
                .findFirst();

                if (opPath.isPresent()){
                    return opPath.get();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Find the newest file with the method {@link sokoban.Engine.Tools.MoveLogger#getNewestFile()} and write to it.
     */
    public static void writeToNewestFile() {
        try {
            StringBuilder sb = new StringBuilder();
            for (char s : movements) {
                sb.append(s);
            }
            Files.writeString(getNewestFile(), sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        movements.clear();
    }
}
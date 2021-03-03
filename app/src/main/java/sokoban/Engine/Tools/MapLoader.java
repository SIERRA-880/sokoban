package sokoban.Engine.Tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapLoader {
    /**
    * Measure the height of the map and the max width (if the map is not a rectangle)
    * 
    * Usage exemple : MapLoader.load("app/build/resources/main/levels/map1.xsb");
    * 
    * @param file the path to the map. Maps should be .xsb files
    * @return an array containing [height, width] of the map
    */
    public static int[] getSize(String file) {
        int[] res = {0, 0};
        
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            // Measure the height of the map based on the line count
            while (myReader.hasNextLine()) {
                // Storing current line since there is no method to call it
                String currentLine = myReader.nextLine();
                
                res[0]++;
                
                // Changing the longest line value (res[1]) if the condition is true
                if (currentLine.length() > res[1]) {
                    res[1] = currentLine.length();
                }
            }
            myReader.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }

        return res;
    }

    /**
    * The code used here comes from https://www.w3schools.com/java/java_files_read.asp
    * 
    * @param file the path to the map. Maps should be .xsb files
    * @return a string containing all the lines of the map.
    */
    public static String load(String file) {
        String res = "";
        int width = getSize("app/build/resources/main/levels/map1.xsb")[1];

        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String currentLine = myReader.nextLine();
                System.out.println(currentLine.length());
                String padded = "";
                if (currentLine.length() < width) {
                    padded = String.format("%-" + width + "s", currentLine);
                } else {
                    padded = currentLine;
                }
                res = res + padded;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }

        return res;
    }
}
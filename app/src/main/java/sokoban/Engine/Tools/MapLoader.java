package sokoban.Engine.Tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The game engine needs to get map data in a certain format, MapLoader repond to it's need by formatting a map in .xsb format to an understandable String for the engine.
 * @author Ugo Proietti
 */
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
                
                res[1]++;
                
                // Changing the longest line value (res[1]) if the condition is true
                if (currentLine.length() > res[1]) {
                    res[0] = currentLine.length();
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
     * Exemple:
     *      input = "  #  ##   "
     *      output = "__#  ##___"
     * 
     * @param input String provided by mapLoader.load method
     * @return the String with external whitespaces replaced by _ to see the difference between outside and inside
     */
    public static String mapTrimmer(String input) {
        int i = input.indexOf('#');
        int j = input.lastIndexOf('#');
        input = input.substring(0, i).replaceAll(" ", "_") + input.substring(i, j) + input.substring(j).replaceAll(" ", "_");
        return input;
    }

    /**
    * The code used here comes from https://www.w3schools.com/java/java_files_read.asp
    * 
    * @param file the path to the map. Maps should be .xsb files
    * @return a string containing all the lines of the map.
    */
    public static String load(String file) {
        String res = "";
        int width = getSize(file)[1];

        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String currentLine = myReader.nextLine();
                String padded ;
                if (currentLine.length() < width) {
                    padded = String.format("%-" + width + "s", currentLine);
                    padded = mapTrimmer(padded);
                } else {
                    padded = currentLine;
                    padded = mapTrimmer(padded);
                }
                res += padded;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }

        return res;
    }
}

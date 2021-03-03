package sokoban.Engine.Tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapLoader {

    public static void main(String[] args) {
        String file = "app/build/resources/main/levels/map1.xsb";

        System.out.println(load(file).substring(0, getSize(file)[1]));
        System.out.println(load(file).substring(getSize(file)[1], getSize(file)[1]*2));
        System.out.println(load(file).substring(getSize(file)[1]*2, getSize(file)[1]*3));
        System.out.println(load(file).substring(getSize(file)[1]*3, getSize(file)[1]*4));
        System.out.println(load(file).substring(getSize(file)[1]*4, getSize(file)[1]*5));
        System.out.println(load(file).substring(getSize(file)[1]*5, getSize(file)[1]*6));
        System.out.println(load(file).substring(getSize(file)[1]*6, getSize(file)[1]*7));
        System.out.println(load(file).substring(getSize(file)[1]*7, getSize(file)[1]*8));
        System.out.println(load(file).substring(getSize(file)[1]*8, getSize(file)[1]*9));
        System.out.println(load(file).substring(getSize(file)[1]*9, getSize(file)[1]*10));

    }

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
        // System.out.println("i = " + i + ", j = " + j);
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
        int width = getSize("app/build/resources/main/levels/map1.xsb")[1];

        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String currentLine = myReader.nextLine();
                String padded = "";
                if (currentLine.length() < width) {
                    padded = String.format("%-" + width + "s", currentLine);
                    padded = mapTrimmer(padded);
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
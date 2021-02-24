package Tools;

import Objects.*;

import java.io.File; // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class MapLoader {
    public static String load(String file) {    
        /** 
        * The code used here comes from https://www.w3schools.com/java/java_files_read.asp
        * This methods returns a string containing the entire map line by line.
        * Usage exemple : MapLoader.load("map_path.txt");
        */
        String res = "";
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                res = res + data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        return res;
    }
    
    public static int[] getSize(String file) {
        /**
        * This method returns an array [height, width]
        * Usage exemple : MapLoader.getSize("map_path.txt");
        */
        int[] res = new int[2];
        res[0] = 1;
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            res[1] = myReader.nextLine().length();     // The first line is used to measure de width of the map. If the map is not a rectangle, empty spaces should be filled with spaces !
            while (myReader.hasNextLine()) {
                myReader.nextLine();
                res[0]++;
            }
            myReader.close();            
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        return res;
    }
    
}

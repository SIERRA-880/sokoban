
import java.io.File; // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class MapLoader {
    /** exemple :
     * MapLoader.Load("MapLoader/Map2.txt"));
     */
    public static String load(String file) {
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
}

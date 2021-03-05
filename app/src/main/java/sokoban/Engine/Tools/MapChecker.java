package sokoban.Engine.Tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MapChecker {
    public static void main(String[] args) {
        if (args[0].equals("f")) {
            checkFile(args[1]);
        } else if (args[0].equals("d")) {
            checkDirectory(args[1]);
            // System.out.println(checkDirectory(args[1]));
        } else {
            System.out.println("Bad argument ! You should use 'f' for file or 'd' for directory.");
        }
    }

    private static void checkFile(String file) {
        File myObj = new File(file);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String currentLine = myReader.nextLine();

        }
        myReader.close();
    }

    private static void checkDirectory(String path) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".xsb")) {
                checkFile(listOfFiles[i].getAbsolutePath());
            }
        }
    }
}
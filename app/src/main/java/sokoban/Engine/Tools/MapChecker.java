package sokoban.Engine.Tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MapChecker {

    public static final String ANSI_RED = "\u001B[31m";
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
    
    private static String checkFile(String file) {
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            
            // Checks if the first line is the border of the map and not whitespaces line
            // If theres no # in the first line, it returns the appropriate error
            String firstLine = myReader.nextLine();
            boolean check = false;
            for (char c : firstLine.toCharArray()) {
                if (c == '#') {
                    check = true;
                }
            }
            if (!check) {
                myReader.close();
                return ANSI_RED + "First line should not be a line of spaces ! Please trim the excess lines.";
            }
            
            // Checks if the file only contains appropriate characters
            while (myReader.hasNextLine()) {
                // Store current line at each iteration of while
                String currentLine = myReader.nextLine();
                for (char c : currentLine.toCharArray()) {
                    switch (c) {
                        case ' ':
                            break;
                        case '.':
                            break;
                        case '$':
                             break;
                        case '@':
                            break;
                        case '#':
                            break;
                        case '_':
                            break;
                        case '*':
                            break;
                        case '+':
                            break;
                        default:
                            return ANSI_RED + "Contain inapropriate character";
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        return "No error found";
    }

    private static void checkDirectory(String path) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Checking " + path);
        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".xsb")) {
                System.out.println("========================================");
                System.out.println("Checking " + listOfFiles[i]);
                System.out.println("========================================");
                System.out.println(checkFile(listOfFiles[i].getAbsolutePath()));
            }
        }
    }
}
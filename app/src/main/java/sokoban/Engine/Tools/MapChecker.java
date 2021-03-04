package sokoban.Engine.Tools;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MapChecker {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        if (args[0] == "f") {
            System.out.println(checkFile(args[1]));
        } else if (args[0] == "d") {
            System.out.println(checkDirectory(args[1]));
        } else {
            System.out.println("Bad argument ! You should use 'f' for file or 'd' for directory.");
        }
    }

    private static char[] checkDirectory(String string) {
        return null;
    }

    private static String checkFile(String string) {
        return null;
    }
}

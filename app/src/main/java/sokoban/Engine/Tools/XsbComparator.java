package sokoban.Engine.Tools;

import sokoban.Engine.Tools.MapLoader;

public class XsbComparator {
    public static boolean compare(String xsb1, String xsb2) {
        String str1 = MapLoader.load(xsb1);
        String str2 = MapLoader.load(xsb2);

        if (str1.equals(str2)) {
            return true;
        } else {
            return false;
        }
    }
}

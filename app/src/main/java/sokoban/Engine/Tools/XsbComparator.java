package sokoban.Engine.Tools;

import sokoban.Engine.Tools.MapLoader;

/**
 * Compare if two .xsb are equals
 * @author Ugo Proietti
 */
public class XsbComparator {
    /**
     * @param xsb1 A String, the name of a level
     * @param xsb2 A String, the name of another level
     * @return True if both levels are equals
     */
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

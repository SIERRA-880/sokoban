package sokoban.Engine.Tools;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/** 
 * Use this class to load, set and store settings from/to build/resources/main/appdata/settings.properties to/from local variable
 * @author Ugo Proietti
 */
public class Settings {
    
    private static String absolutePath = System.getProperty("user.dir") + File.separator + "build" + File.separator + "resources" + File.separator + "main" + File.separator + "appdata" + File.separator + "settings.properties";
    public static Properties settings = new Properties();
    public static String up = null;
    public static String left = null;
    public static String down = null;
    public static String right = null;

    /**
     * Load stored settings from settings.properties file in local variables
     */
    public static void load() {
        try {
            settings.load(new FileInputStream(absolutePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        up = settings.getProperty("up");
        left = settings.getProperty("left");
        down = settings.getProperty("down");
        right = settings.getProperty("right");
    }

    /**
     * Change a settings, don't forget to store it using {@link #store()} !
     * @param name A String, the name of the settings
     * @param value A String, the value of the settings
     */
    public static void set(String name, String value) {
        settings.setProperty(name, value);
    }

    /**
     * Store settings in the settings.properties file
     */
    public static void store() {
        try{
            settings.store(new FileWriter(absolutePath), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

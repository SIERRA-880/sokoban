package sokoban.Engine.Tools;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Settings {
    
    private static String absolutePath = System.getProperty("user.dir") + File.separator + "build" + File.separator + "resources" + File.separator + "main" + File.separator + "appdata" + File.separator + "settings.properties";
    public static Properties settings = new Properties();
    public static String up = null;
    public static String left = null;
    public static String down = null;
    public static String right = null;

    public static void load() {
        try {
            settings.load(new FileInputStream(absolutePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        set1 = settings.getProperty("set1");
        set3 = settings.getProperty("set3");
        set3 = settings.getProperty("set3");
    }

    public static void set(String name, String value) {
        settings.setProperty(name, value);
    }

    public static void store() {
        try{
            settings.store(new FileWriter(absolutePath),"Writing");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

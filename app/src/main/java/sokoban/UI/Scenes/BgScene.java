package sokoban.UI.Scenes;


import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import sokoban.UI.Widgets.MovingBg;
import javafx.scene.media.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BgScene extends Scene {
    public static MediaPlayer player;

    public BgScene(MovingBg bg) {
        super(bg);
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus" +
                    "/cursor_pointerFlat.png"));  //pass in the image path
            setCursor(new ImageCursor(image));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("cursor problem");
        }
        Media sound = new Media(new File("build/resources/main/textures/Default/Sounds/menus/basshunter-dota-hq.wav").toURI().toString());
        player = new MediaPlayer(sound);
        player.setVolume(0.1);
        player.play();

    }

    public BgScene(MovingBg bg, int X, int Y) {
        super(bg, X, Y);
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/cursor_pointerFlat.png"));  //pass in the image path
            setCursor(new ImageCursor(image));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("cursor problem");
        }
    }
}

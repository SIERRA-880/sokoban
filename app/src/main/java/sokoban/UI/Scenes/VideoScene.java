package sokoban.UI.Scenes;

import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.Scene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import sokoban.UI.Widgets.VideoBg;

public class VideoScene extends Scene {

    public VideoScene(VideoBg vb){
        super(vb);
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/cursor_pointerFlat.png"));
            setCursor(new ImageCursor(image));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("cursor problem");
        }
    }
}

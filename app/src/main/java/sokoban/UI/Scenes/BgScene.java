package sokoban.UI.Scenes;

import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import sokoban.UI.Widgets.MovingBg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BgScene extends Scene {

    public BgScene(MovingBg bg){
        super(bg);
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/cursor_pointerFlat.png"));  //pass in the image path
            setCursor(new ImageCursor(image));
        }catch(FileNotFoundException e){e.printStackTrace();System.out.println("cursor problem");}
    }
    public BgScene(MovingBg bg , int X, int Y){
        super(bg,X,Y);
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/cursor_pointerFlat.png"));  //pass in the image path
            setCursor(new ImageCursor(image));
        }catch(FileNotFoundException e){e.printStackTrace();System.out.println("cursor problem");}
    }
}

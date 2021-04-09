package sokoban.UI.Scenes;

import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import sokoban.UI.Widgets.*;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MenuLvlScene extends Scene {
    //Scene that contains a grid of the different level buttons
    //truc chnagé
    public MenuLvlScene()  {

        super(new GridLvlButtons(), 640, 640, Color.BLACK);
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/cursor_pointerFlat.png"));  //pass in the image path
            setCursor(new ImageCursor(image));
        }catch(FileNotFoundException e){e.printStackTrace();System.out.println("cursor problem");}


    }



}

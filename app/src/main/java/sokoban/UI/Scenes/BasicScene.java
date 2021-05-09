package sokoban.UI.Scenes;

import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import sokoban.Game;

public class BasicScene extends Scene {
    
    public BasicScene(StackPane stackPane) {
        super(stackPane);
        stackPane.setStyle("-fx-background-color: #000000;");

        // cursor
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/"+Game.resourcePack+"/Menus/cursor_pointerFlat.png"));
            setCursor(new ImageCursor(image));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("cursor problem");
        }
    }
}

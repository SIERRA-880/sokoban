package sokoban.UI.Scenes;

import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import sokoban.Game;
import sokoban.UI.Widgets.Controller;

/**
 * Object used as mother of all other scenes
 */
public class BasicScene extends Scene {

    /**
     * Contructor of BasicScene
     * @param stackPane Pane type object where other layouts will be placed on
     */
    public BasicScene(StackPane stackPane) {
        super(stackPane);
        stackPane.setStyle("-fx-background-color: #000000;");

        // cursor
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/"+Game.resourcePack+"/Menus/cursor_pointerFlat.png"));
            setCursor(new ImageCursor(image));
        }
        catch (FileNotFoundException e) {
            Controller.alert("The image on the cursor could not be loaded please check the file path in BasicScene.");
        }
    }
}

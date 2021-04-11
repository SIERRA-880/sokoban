package sokoban.UI.Widgets;

import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BackButton extends ImageButton {

    /**
     * An instance of this button will switch between the current scene and 
     * the previous one (given in the parameters).
     *
     * @param scene is the previous scene.
     */
    public BackButton(Scene scene)throws FileNotFoundException{
        super(new Image(new FileInputStream("build/resources/main/textures/Default/Buttons/levelMenu/levelButton_back.png")),
                        new Image(new FileInputStream("build/resources/main/textures/Default/Buttons/levelMenu/levelButtonOver_back.png")));
        setOnAction(event -> Controller.switchScene(scene));
    }
}

package sokoban.UI.Widgets;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BackButton extends ImageButton {

    /**
     * An instance of this button will switch between the current scene and 
     * the previous one (given in the parameters).
     *
     * @param scene is the previous scene.
     */
    public Scene scene;
    public BackButton(Scene _scene, StackPane currentPane){
        super("build/resources/main/textures/Default/Buttons/levelMenu/levelButton_back.png",
              "build/resources/main/textures/Default/Buttons/levelMenu/levelButtonOver_back.png");
        scene= _scene;
        setOnAction(event -> {
            Controller.switchScene(scene);
            currentPane.getChildren().clear();});
    }
}

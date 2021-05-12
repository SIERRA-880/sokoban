package sokoban.UI.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import sokoban.Engine.Tools.WriteToXsb;
import sokoban.Game;
import sokoban.ScenesEnum;
import sokoban.UI.Widgets.Controller;
import sokoban.UI.Widgets.ImageButton;

import java.io.FileNotFoundException;

/**
 * Scene displaying a randomly generated level
 */
public class RandomLevelScene extends LevelScene {

    private final TextField saveText;

    /**
     * @param stackPane Pane type object where other layouts will be placed on
     * @param previousScene Pane type object that refers to the previous scene
     */
    public RandomLevelScene(StackPane stackPane, ScenesEnum previousScene) {
        super(stackPane, previousScene);

        // text input 
        saveText = new TextField();
        saveText.setPromptText("map name");
        stackPane.getChildren().add(saveText);

        StackPane.setAlignment(saveText, Pos.CENTER_RIGHT);
        StackPane.setMargin(saveText, new Insets(0.0, 200.0, -250.0, 1525.0));

        // save button
        try {
            ImageButton saveButton = new ImageButton("build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButton.png",
                    "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButtonOver.png");
            saveButton.setText("save");
            saveButton.setOnAction(e -> save());
            stackPane.getChildren().add(saveButton);
            StackPane.setAlignment(saveButton, Pos.CENTER_RIGHT);
            StackPane.setMargin(saveButton, new Insets(400.0, 200.0, 0.0, 0.0));
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the save button could not be loaded please check the file path in RandomLevelScene");
        }
    }

    /**
     * Mehtode usded to save a randomly generated level in a file
     */
    public void save() {
        String mapString = Game.level.toString();
        WriteToXsb.write(saveText.getText(), mapString, Game.level.world.width);
    }
}

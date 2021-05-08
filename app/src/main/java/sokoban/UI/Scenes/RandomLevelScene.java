package sokoban.UI.Scenes;

import javafx.scene.layout.StackPane;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;

import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Controller;
import sokoban.UI.Widgets.ImageButton;
import sokoban.Game;
import sokoban.ScenesEnum;
import sokoban.Engine.Tools.WriteToXsb;

import sokoban.Engine.Tools.Generation.*;
import sokoban.Engine.Objects.*;

public class RandomLevelScene extends LevelScene {

    private TextField saveText;

    public RandomLevelScene(StackPane stackPane, ScenesEnum previousScene) {
        super(stackPane, previousScene);

        // text input 
        saveText = new TextField();
        saveText.setPromptText("map name");
        stackPane.getChildren().add(saveText);

        StackPane.setAlignment(saveText, Pos.CENTER_RIGHT);
        StackPane.setMargin(saveText, new Insets(0.0, 200.0, -250.0, 1525.0));

        // save button
        ImageButton saveButton = new ImageButton("build/resources/main/textures/Default/Buttons/mainMenu/mainButton.png",
                                              "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver.png");
        saveButton.setText("save");
        saveButton.setOnAction(e->save());
        stackPane.getChildren().add(saveButton);
        StackPane.setAlignment(saveButton, Pos.CENTER_RIGHT);
        StackPane.setMargin(saveButton, new Insets(400.0, 200.0, 0.0, 0.0));
    }

    public void save() {
        String mapString = Game.level.toString();
        WriteToXsb.write(saveText.getText(), mapString, Game.level.world.width);
    }
}

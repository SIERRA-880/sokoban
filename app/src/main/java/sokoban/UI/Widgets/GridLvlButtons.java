package sokoban.UI.Widgets;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import sokoban.UI.Scenes.LevelScene;

import sokoban.Game;
import sokoban.UI.Widgets.Controller;

import static javafx.geometry.Pos.CENTER;

public class GridLvlButtons extends GridPane {

    private final String buttonSelected = "build/resources/main/textures/Default/Buttons/levelMenu/levelButton_";
    private final String buttonUnselected = "build/resources/main/textures/Default/Buttons/levelMenu/levelButtonOver_";
    private final String imageLocked = "build/resources/main/textures/Default/Buttons/levelMenu/levelButton_locker.png";

    /**
     * This widget is a grid of 15 LevelButtons.
     */
    public GridLvlButtons() {
        int[] lock = {1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // this has to be replace with a save file.
        int a = 1;

        // for each button on the grid we assign a level number
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                LevelButton button;
                String imageButtonSelected = buttonSelected + a + ".png";
                String imageButtonUnselected = buttonUnselected + a + ".png";

                // here we check if the level has been completed or not 
                if (lock[a - 1] == a) {
                    button = new LevelButton(imageButtonSelected, imageButtonUnselected, (a++));
                    button.setOnAction(e -> {
                        button.getMap();
                        Game.levelScene.setOnKeyPressed(event -> Game.levelScene.addKeyHandler(event));
                        Game.levelScene.map.showMap();
                        Controller.switchToLevelScene();
                    });
                }
                else {
                    button = new LevelButton(imageLocked, imageLocked, (a++));
                }
                add(button, j, i);
            }
        }

        // grid options
        setHgap(69);
        setVgap(69);
        setAlignment(CENTER);
        setStyle("-fx-background-color: #000000;");
    }
}

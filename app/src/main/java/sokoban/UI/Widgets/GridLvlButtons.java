package sokoban.UI.Widgets;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import sokoban.UI.Scenes.LevelScene;

import static javafx.geometry.Pos.CENTER;

public class GridLvlButtons extends GridPane {

    private final String nom_button_selected = "build/resources/main/textures/Default/Buttons/levelMenu/levelButton_";
    private final String nom_button_unselected = "build/resources/main/textures/Default/Buttons/levelMenu/levelButtonOver_";

    /**
     * This widget is a grid of 15 LevelButtons.
     */
    public GridLvlButtons() {
        Assign(nom_button_selected, nom_button_unselected);
        setHgap(69);
        setVgap(69);
        setAlignment(CENTER);
        setStyle("-fx-background-color: #000000;");
    }

    public void Assign(String nom_button_selected, String nom_button_unselected) {
        int[] lock = {1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // this has to be replace with a save file.
        int a = 1;
        String image_locked = "build/resources/main/textures/Default/Buttons/levelMenu/levelButton_locker.png";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                LevelButton button;
                String nom_button_selected_b = nom_button_selected + a + ".png";
                String nom_button_unselected_b = nom_button_unselected + a + ".png";
                if (lock[a - 1] == a) {
                    button = new LevelButton(nom_button_selected_b, nom_button_unselected_b, (a++));
                    LevelButton finalButton = button;
                    finalButton.setOnAction(e -> {
                        LevelScene lvlscene = new LevelScene(finalButton.getMap(), new StackPane());
                        lvlscene.setOnKeyPressed(event -> lvlscene.addKeyHandler(finalButton.player, finalButton.world, event));
                        Controller.switchScene(lvlscene);
                    });
                }
                else {
                    button = new LevelButton(image_locked, image_locked, (a++));
                }
                add(button, j, i);
            }
        }
    }
}

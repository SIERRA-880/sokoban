package sokoban.UI.Widgets;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import sokoban.UI.Scenes.LevelScene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static javafx.geometry.Pos.CENTER;

public class GridLvlButtons extends GridPane {
    //Grid that contains the different lvl buttons

    public GridLvlButtons() {
        String nom_button_selected = "build/resources/main/textures/Default/Buttons/levelMenu/levelButton_";
        String nom_button_unselected = "build/resources/main/textures/Default/Buttons/levelMenu/levelButtonOver_";
        Assign(nom_button_selected, nom_button_unselected);
        setHgap(69);
        setVgap(69);
        setAlignment(CENTER);


        //choisisez celui que vous voulez !
        setStyle("-fx-background-color: #000000;");
        //setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));

    }

    public void Assign(String nom_button_selected, String nom_button_unselected) {
        int[] lock = {1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int a=1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                Image image_selected = null, image_unselected = null, image_locked = null;
                LevelButton button;
                try {
                    image_selected = new Image(new FileInputStream(nom_button_selected + (a) + ".png"));
                    image_unselected = new Image(new FileInputStream(nom_button_unselected + (a) + ".png"));
                    image_locked = new Image(new FileInputStream("build/resources/main/textures/Default/Buttons/levelMenu/levelButton_locker.png"));                    
                } catch (FileNotFoundException e) {e.printStackTrace();}
                if (lock[a-1] == a) {
                    button = new LevelButton(image_selected, image_unselected, (a++));
                    button.setOnAction(e -> {LevelScene lvlscene = new LevelScene(button.getMap());
                    lvlscene.setMap(button.getMap());
                    lvlscene.setOnKeyPressed(event ->
                        lvlscene.addKeyHandler(lvlscene, button.player, button.world, event));
                    Controller.switchScene(lvlscene);
                    });
                }
                else {
                    button = new LevelButton(image_locked, image_locked, (a++));
                }
                button.setStyle("-fx-background-color: transparent;");
                add(button,j,i);
            }
        }
    }
}






package sokoban.UI;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import sokoban.Game;

import java.io.FileInputStream;

import static javafx.geometry.Pos.CENTER;

public class GridLvlButtons extends GridPane {
    //Grid that contains the different lvl buttons

    public GridLvlButtons() {
        String nom_button_selected = "build/resources/main/textures/Default/Buttons/levelMenu/levelButton_";
        String nom_button_unselected = "build/resources/main/textures/Default/Buttons/levelMenu/levelButtonOver_";

        int a = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                try {
                    Image image_selected = new Image(new FileInputStream(nom_button_selected + (a) + ".png"));
                    Image image_unselected = new Image(new FileInputStream(nom_button_unselected + (a) + ".png"));
                    LevelButton button = new LevelButton(image_selected, image_unselected, (a++));
                    button.setStyle("-fx-background-color: transparent;");
                    button.setOnAction(e -> {
                        try {
                            LevelScene lvlscene = new LevelScene(button.getMap());
                            lvlscene.setMap(button.getMap());
                            lvlscene.setOnKeyPressed(event ->{lvlscene.addKeyHandler(lvlscene,button.player,button.world,event);});
                            Game.switchScene(lvlscene);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    });
                    add(button, j, i);

                } catch (Exception ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }

                //setPadding(new Insets(0, 0, 0, 0));

            }
        }

        setHgap(69);
        setVgap(69);
        setAlignment(CENTER);

        //choisisez celui que vous voulez !
        setStyle("-fx-background-color: #000000;");
        //setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));

    }
}

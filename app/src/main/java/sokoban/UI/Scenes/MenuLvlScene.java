package sokoban.UI.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sokoban.Game;
import sokoban.ScenesEnum;
import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Controller;
import sokoban.UI.Widgets.GridLvlButtons;
import sokoban.UI.Widgets.VideoBg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * Scene displaying the Menu where a level can be selected
 */
public class MenuLvlScene extends BasicScene {
    //Scene that contains a grid of the different level buttons
   private final StackPane stackPane;

    /**
     * Contructor of MenuLvlScene
     * @param stackPane Pane type object where other layouts will be placed on
     */
    public MenuLvlScene(StackPane stackPane) {
        super(stackPane);
        this.stackPane = stackPane;

        // show all objects
        refresh();
    }

    /**
     * Methode used to refresh the GridPane containing the buttons for the different available levels
     */
    public void refresh() {

        //gridLvlButtons
        GridLvlButtons glb = new GridLvlButtons();
        stackPane.getChildren().add(glb);
        StackPane.setAlignment(glb, Pos.CENTER);

        // backButton
        try {
            BackButton bbutton = new BackButton();
            bbutton.setOnAction(e -> {
                Controller.switchScene(ScenesEnum.VIDEOSCENE);
                VideoBg.playVplayer();
                VideoScene.playMplayer();
            });
            stackPane.setStyle("-fx-background-color: #000000;");
            stackPane.getChildren().add(bbutton);
            StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
            StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the back button could not be loaded please check the file path in the MenuLvlScene");
        }
        // label
        Font f = null;
        try {
            f = Font.loadFont(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Fonts/Kenney Rocket Square.ttf"), 40);
        } catch (FileNotFoundException e) {
            Controller.alert("The label font could not be loaded please check the file path in the LevelScene");
        }
        Label selectLabel = new Label("Select a level :");
        selectLabel.setFont(f);
        selectLabel.setTextFill(Color.web("#A7F5F4"));
        stackPane.getChildren().add(selectLabel);
        StackPane.setAlignment(selectLabel, Pos.TOP_CENTER);
        StackPane.setMargin(selectLabel, new Insets(160.0, 0.0, 0.0, 0.0));
    }
}

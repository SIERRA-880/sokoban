package sokoban.UI.Scenes;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import sokoban.Game;
import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Controller;
import sokoban.UI.Widgets.GridLvlButtons;
import sokoban.UI.Widgets.VideoBg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class MenuLvlScene extends Scene {
    //Scene that contains a grid of the different level buttons
    StackPane stackPane ;

    public MenuLvlScene(StackPane stackPane) {
        super(stackPane);
        this.stackPane= stackPane;

        //cursor
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/cursor_pointerFlat.png"));
            setCursor(new ImageCursor(image));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("cursor problem");
        }

        // gridLevelButtons
        GridLvlButtons glb = new GridLvlButtons();
        stackPane.getChildren().add(glb);
        StackPane.setAlignment(glb, Pos.CENTER);

        // backButton
        BackButton bbutton = new BackButton();
        bbutton.setOnAction(e->{Controller.switchScene("VideoScene");
                                VideoBg.Vplayer.play();
                                VideoScene.Mplayer.play();});
        stackPane.setStyle("-fx-background-color: #000000;");
        stackPane.getChildren().add(bbutton);
        StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
        StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));

        // label
        Font f = null;
        try {
            f = Font.loadFont(new FileInputStream("build/resources/main/textures/Default/Fonts/Kenney Rocket Square.ttf"), 40);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fonts file not found (MenuLvlScene:44)");
        }
        Label selectLabel = new Label("Select a level :");
        selectLabel.setFont(f);
        selectLabel.setTextFill(Color.web("#A7F5F4"));
        stackPane.getChildren().add(selectLabel);
        stackPane.setAlignment(selectLabel, Pos.TOP_CENTER);
        stackPane.setMargin(selectLabel, new Insets(160.0, 0.0, 0.0, 0.0));
    }
}

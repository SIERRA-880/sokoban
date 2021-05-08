package sokoban.UI.Scenes;

import javafx.scene.ImageCursor;
import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Controller;
import sokoban.UI.Widgets.VideoBg;
import sokoban.ScenesEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CreditsScene extends BasicScene {

    public CreditsScene(StackPane stackPane) {
        super(stackPane);

        stackPane.setStyle("-fx-background-color: #000000;");

        // cursor
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/cursor_pointerFlat.png"));
            setCursor(new ImageCursor(image));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("cursor problem");
        }

        // credits 
        Font f = null;
        try {
            f = Font.loadFont(new FileInputStream("build/resources/main/textures/Default/Fonts/Kenney Rocket Square.ttf"), 20);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fonts file not found (CreditsScene:43)");
        }
        
        // gridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        grid.setHgap(20);

        //labels 
        Label l1 = new Label("Developers");
        l1.setFont(f);
        l1.setTextFill(Color.web("#FFFFFF"));
        grid.add(l1, 0, 0);

        Label l2 = new Label("Sierra-880, Tiramisu, Harbinger");
        l2.setFont(f);
        l2.setTextFill(Color.web("#FFFFFF"));
        grid.add(l2, 1, 0);

        Label l3 = new Label("BackGround Video in the main menu");
        l3.setFont(f);
        l3.setTextFill(Color.web("#FFFFFF"));
        grid.add(l3, 0, 1);

        Label l4 = new Label("https://www.youtube.com/watch?v=B02Q3cg2wtY");
        l4.setFont(f);
        l4.setTextFill(Color.web("#FFFFFF"));
        grid.add(l4, 1, 1);

        Label l5 = new Label("Music in the main menu");
        l5.setFont(f);
        l5.setTextFill(Color.web("#FFFFFF"));
        grid.add(l5, 0, 2);

        Label l6 = new Label("https://www.youtube.com/watch?v=L5pfhWye3UM");
        l6.setFont(f);
        l6.setTextFill(Color.web("#FFFFFF"));
        grid.add(l6, 1, 2);

        Label l7 = new Label("Sounds in the levels");
        l7.setFont(f);
        l7.setTextFill(Color.web("#FFFFFF"));
        grid.add(l7, 0, 3);

        Label l8 = new Label("https://opengameart.org/content/9-sci-fi-computer-sounds-and-beeps");
        l8.setFont(f);
        l8.setTextFill(Color.web("#FFFFFF"));
        grid.add(l8, 1, 3);

        Label l9 = new Label("Boxes' texture in the levels");
        l9.setFont(f);
        l9.setTextFill(Color.web("#FFFFFF"));
        grid.add(l9, 0, 4);

        Label l10 = new Label("https://opengameart.org/content/top-down-2d-metal-box");
        l10.setFont(f);
        l10.setTextFill(Color.web("#FFFFFF"));
        grid.add(l10, 1, 4);

        stackPane.getChildren().add(grid);
        StackPane.setAlignment(grid, Pos.CENTER);

        // backButton
        try {
            BackButton bbutton = new BackButton();
            bbutton.setOnAction(e -> {
                Controller.switchScene(ScenesEnum.VIDEOSCENE);
                VideoBg.Vplayer.play();
                VideoScene.Mplayer.play();
            });
            stackPane.getChildren().add(bbutton);
            StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
            StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));
        }catch (FileNotFoundException e) {
            Controller.alert("The image of the back button could not be loaded please check the file path in the CreditScene",
                    ScenesEnum.VIDEOSCENE);
        }
    }
}

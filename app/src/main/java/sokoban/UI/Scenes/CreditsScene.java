package sokoban.UI.Scenes;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.ImageCursor;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Controller;
import sokoban.UI.Widgets.VideoBg;
import sokoban.UI.Scenes.VideoScene;

import sokoban.Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CreditsScene extends Scene {

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
        
        // gridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        grid.setHgap(20);

        //labels 
        Label l1 = new Label("Developers");
        l1.setTextFill(Color.web("#FFFFFF"));
        l1.setStyle("-fx-font: 24 arial;");
        grid.add(l1, 0, 0);

        Label l2 = new Label("Sierra-880, Tiramisu, Harbinger");
        l2.setTextFill(Color.web("#FFFFFF"));
        l2.setStyle("-fx-font: 24 arial;");
        grid.add(l2, 1, 0);

        Label l3 = new Label("BackGround Video in the main menu");
        l3.setTextFill(Color.web("#FFFFFF"));
        l3.setStyle("-fx-font: 24 arial;");
        grid.add(l3, 0, 1);

        Label l4 = new Label("https://www.youtube.com/watch?v=B02Q3cg2wtY");
        l4.setTextFill(Color.web("#FFFFFF"));
        l4.setStyle("-fx-font: 24 arial;");
        grid.add(l4, 1, 1);

        Label l5 = new Label("Music in the main menu");
        l5.setTextFill(Color.web("#FFFFFF"));
        l5.setStyle("-fx-font: 24 arial;");
        grid.add(l5, 0, 2);

        Label l6 = new Label("https://www.youtube.com/watch?v=L5pfhWye3UM");
        l6.setTextFill(Color.web("#FFFFFF"));
        l6.setStyle("-fx-font: 24 arial;");
        grid.add(l6, 1, 2);

        Label l7 = new Label("Sounds in the levels");
        l7.setTextFill(Color.web("#FFFFFF"));
        l7.setStyle("-fx-font: 24 arial;");
        grid.add(l7, 0, 3);

        Label l8 = new Label("https://opengameart.org/content/9-sci-fi-computer-sounds-and-beeps");
        l8.setTextFill(Color.web("#FFFFFF"));
        l8.setStyle("-fx-font: 24 arial;");
        grid.add(l8, 1, 3);

        Label l9 = new Label("Boxes' texture in the levels");
        l9.setTextFill(Color.web("#FFFFFF"));
        l9.setStyle("-fx-font: 24 arial;");
        grid.add(l9, 0, 4);

        Label l10 = new Label("https://opengameart.org/content/top-down-2d-metal-box");
        l10.setTextFill(Color.web("#FFFFFF"));
        l10.setStyle("-fx-font: 24 arial;");
        grid.add(l10, 1, 4);

        stackPane.getChildren().add(grid);
        stackPane.setAlignment(grid, Pos.CENTER);

        // backButton
        BackButton bbutton = new BackButton();
        bbutton.setOnAction(e->{Controller.switchToVideoScene();
            VideoBg.Vplayer.play();
            VideoScene.Mplayer.play();});
        stackPane.getChildren().add(bbutton);
        StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
        StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));
    }
}

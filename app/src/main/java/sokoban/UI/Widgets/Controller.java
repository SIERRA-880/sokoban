package sokoban.UI.Widgets;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import sokoban.Game;
import sokoban.UI.Scenes.VideoScene;

import java.io.FileNotFoundException;

public class Controller {

    public static void switchScene(Scene scene) {
        Game.window.setScene(scene);
        Game.window.setFullScreen(true);
    }

    public static BorderPane Bordermenu(GridLvlButtons gridLvlButtons) {
        // borderPane
        BorderPane borderPane = new BorderPane();

        // grid 
        borderPane.setCenter(gridLvlButtons);
        BorderPane.setAlignment(gridLvlButtons, Pos.CENTER);

        // backButton
        BackButton button = new BackButton(new VideoScene(new StackPane()));
        borderPane.setStyle("-fx-background-color: #000000;");
        borderPane.setTop(button);
        BorderPane.setAlignment(button,Pos.TOP_LEFT);
        BorderPane.setMargin(button, new Insets(20.0, 0.0, 0.0, 20.0));

        return borderPane;
    }
}

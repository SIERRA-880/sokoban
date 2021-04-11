package sokoban.UI.Widgets;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import sokoban.Game;
import sokoban.UI.Scenes.VideoScene;

import java.io.FileNotFoundException;


public class Controller {

    public static void switchScene(Scene scene) {
        Game.window.setScene(scene);
        Game.window.setFullScreen(true);
    }
    public static void setBlurr(Scene scene){

    }

    public static BorderPane Bordermenu(GridLvlButtons gridLvlButtons) {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridLvlButtons);
        BorderPane.setAlignment(gridLvlButtons, Pos.CENTER);
        Label label = new Label("Choisisez votre niveau");
        BackButton button = new BackButton(new VideoScene(new VideoBg("build/resources/main/textures/Default/Videos/cyber_loop.mp4")));
        borderPane.setStyle("-fx-background-color: #000000;");
        borderPane.setTop(button);
        BorderPane.setAlignment(button,Pos.TOP_LEFT);
        BorderPane.setMargin(button, new Insets(20.0, 0.0, 0.0, 20.0));
        return borderPane;
    }
}

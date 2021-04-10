package sokoban.UI.Widgets;

import javafx.geometry.Pos;
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

    public static BorderPane Bordermenu(GridLvlButtons gridLvlButtons) {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridLvlButtons);
        BorderPane.setAlignment(gridLvlButtons, Pos.CENTER);
        BackButton button = null;
        Label label = new Label("Choisisez votre niveau");
        try {
            button = new BackButton(new VideoScene(
                    new VideoBg("build/resources/main/textures/Default/Videos/cyber_loop.mp4")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        borderPane.setStyle("-fx-background-color: #000000;");
        borderPane.setTop(button);
        BorderPane.setAlignment(button,Pos.TOP_LEFT);
        //borderPane.setTop(label);
        //BorderPane.setAlignment(label,Pos.TOP_CENTER);

        return borderPane;
    }

//truc changé
}

package sokoban.UI.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import sokoban.Game;

import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Controller;
import sokoban.UI.Widgets.OptionPane;
import sokoban.UI.Widgets.VideoBg;

public class OptionScene extends Scene {

    public OptionScene(){
        super(Game.pane);
        Game.pane.setStyle("-fx-background-color: lightblue;");
        OptionPane optionPane = new OptionPane();
        Game.pane.getChildren().add(optionPane);
        StackPane.setMargin(optionPane, new Insets(200.0, 0.0, 0.0, 20.0));

        // backButton
        BackButton bbutton = new BackButton();
        bbutton.setOnAction(e->{Controller.switchScene("VideoScene");
                                VideoBg.Vplayer.play();
                                VideoScene.Mplayer.play();});
        Game.pane.getChildren().add(bbutton);
        StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
    }
}

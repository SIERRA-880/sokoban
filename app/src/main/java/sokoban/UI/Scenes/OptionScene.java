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
import sokoban.UI.Widgets.KeyBindingPane;

public class OptionScene extends Scene {

    public OptionScene(){
        super(Game.pane);
        Game.pane.setStyle("-fx-background-color: #000000;");
        OptionPane optionPane = new OptionPane();
        Game.pane.getChildren().add(optionPane);
        StackPane.setMargin(optionPane, new Insets(200.0, 0.0, 0.0, 20.0));

        // backButton
        BackButton bbutton = new BackButton();
        bbutton.setOnAction(e->{Controller.switchScene("VideoScene");
                                VideoBg.Vplayer.play();
                                VideoScene.Mplayer.play();});
        Game.pane.getChildren().add(bbutton);
        StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));
        StackPane.setAlignment(bbutton, Pos.TOP_LEFT);

        // keyBind
        KeyBindingPane kbp = new KeyBindingPane();
        Game.pane.getChildren().add(kbp);
        StackPane.setMargin(kbp, new Insets(20.0, 0.0, 0.0, 500.0));
    }
}

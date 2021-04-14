package sokoban.UI.Scenes;

import javafx.scene.Scene;
import sokoban.Game;
import sokoban.UI.Widgets.OptionPane;
import javafx.scene.layout.StackPane;
import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Controller;
import sokoban.UI.Widgets.VideoBg;
import sokoban.UI.Scenes.VideoScene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import static javafx.scene.layout.StackPane.setAlignment;
import static javafx.scene.layout.StackPane.setMargin;

public class OptionScene extends Scene {

    public OptionScene(){
        super(Game.pane);
        Game.pane.setStyle("-fx-background-color: #000000;");
        OptionPane optionPane = new OptionPane();
        Game.pane.getChildren().add(optionPane);
        Game.pane.setMargin(optionPane, new Insets(200.0, 0.0, 0.0, 20.0));

        // backButton
        BackButton bbutton = new BackButton();
        bbutton.setOnAction(e->{Controller.switchToVideoScene();
            VideoBg.Vplayer.play();
            VideoScene.Mplayer.play();});
        Game.pane.getChildren().add(bbutton);
        Game.pane.setAlignment(bbutton, Pos.TOP_LEFT);
    }
}

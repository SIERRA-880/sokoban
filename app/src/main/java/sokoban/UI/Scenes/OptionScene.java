package sokoban.UI.Scenes;

import javafx.scene.Scene;
import sokoban.Game;
import sokoban.UI.Widgets.OptionPane;

public class OptionScene extends Scene {

    public OptionScene(){
        super(Game.pane);
        Game.pane.getChildren().add(new OptionPane());
    }

}

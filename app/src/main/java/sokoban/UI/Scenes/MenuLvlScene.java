package sokoban.UI.Scenes;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import sokoban.UI.Widgets.*;

public class MenuLvlScene extends Scene {
    //Scene that contains a grid of the different level buttons

    public MenuLvlScene() throws Exception {

        super(new GridLvlButtons(), 640, 640, Color.BLACK);

    }



}

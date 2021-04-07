package sokoban.UI.Scenes;

import javafx.scene.Scene;
import sokoban.UI.Widgets.MovingBg;

public class BgScene extends Scene {

    public BgScene(MovingBg bg){
        super(bg);
    }
    public BgScene(MovingBg bg , int X, int Y){
        super(bg,X,Y);
    }
}

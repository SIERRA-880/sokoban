package sokoban.UI.Widgets;

import sokoban.Game;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.Engine.Objects.Level;

import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LevelButton extends ImageButton {

    int nlevel;
    Image locked;

    /**
     * This widget is a button that will start a game's level.
     * 
     * @param selected is the image when de mouse is over the button.
     * @param unselected is the image when de mouse is not over the button.
     * @param level is the number of the level.
     */
    public LevelButton(String selected, String unselected, int nlevel) {
        super(selected, unselected);
        this.nlevel = nlevel;
    }

    public void getMap() {
        Game.level.setLevel("map" + nlevel);
    }
}

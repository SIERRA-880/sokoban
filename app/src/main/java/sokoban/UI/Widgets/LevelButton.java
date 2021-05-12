package sokoban.UI.Widgets;

import sokoban.Engine.Tools.MoveLogger;
import sokoban.Game;

import java.io.FileNotFoundException;

public class LevelButton extends ImageButton {

   private final int nlevel;
    /**
     * This widget is a button that will start a game's level.
     * 
     * @param selected is the image when de mouse is over the button.
     * @param unselected is the image when de mouse is not over the button.
     * @param nlevel is the number of the level.
     */
    public LevelButton(String selected, String unselected, int nlevel) throws FileNotFoundException {
        super(selected, unselected);
        this.nlevel = nlevel;
    }

    public void setMap() {
        Game.level.setLevel("map" + nlevel);
        MoveLogger.createFile(nlevel + "");
    }
}

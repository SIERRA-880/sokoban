package sokoban.UI.Widgets;

import java.io.FileNotFoundException;
import sokoban.Game;

public class BackButton extends ImageButton {

    /**
     * BackButton is an ImageButton with specifics textures
     */
    public BackButton() throws FileNotFoundException {
        super("build/resources/main/textures/"+Game.resourcePack+"/Buttons/levelMenu/levelButton_back.png",
                "build/resources/main/textures/"+Game.resourcePack+"/Buttons/levelMenu/levelButtonOver_back.png");
    }
}

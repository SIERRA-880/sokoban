package sokoban.UI.Scenes;

import sokoban.ScenesEnum;
import javafx.scene.layout.StackPane;

/**
 * Scene displaying a loaded map
 */
public class LoadScene extends LevelScene {
    /**
     * Contructor of LoadScene
     * @param stackPane Pane type object where other layouts will be placed on
     * @param previousScene Scene type object that refers to the previous scene
     */
    public LoadScene(StackPane stackPane, ScenesEnum previousScene) {
        super(stackPane, previousScene);
    }
}

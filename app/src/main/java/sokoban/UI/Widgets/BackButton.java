package sokoban.UI.Widgets;

public class BackButton extends ImageButton {

    /**
     * An instance of this button will switch between the current scene and
     * the previous one (given in the parameters).
     *
     *
     */
    public BackButton() {
        super("build/resources/main/textures/Default/Buttons/levelMenu/levelButton_back.png",
                "build/resources/main/textures/Default/Buttons/levelMenu/levelButtonOver_back.png");

    }
}

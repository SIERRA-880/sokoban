package sokoban.UI.Widgets;

import javafx.scene.layout.VBox;
import sokoban.Game;
import sokoban.ScenesEnum;
import sokoban.UI.Scenes.VideoScene;

import java.io.FileNotFoundException;

/**
 * Layout in form of a Vbox that contains the buttons in the side menu that apears in the start scene
 */
public class SideMenu extends VBox {

    /**
     * Constructor of SideMenu
     */
    public SideMenu() {
        super();
        setPrefWidth(200);
        getChildren().addAll(PlayButton(), ArcadeButton(), OptionsButton(), CreditsButton(), ExitButton());
        setStyle("-fx-background-color: transparent;");
        setTranslateX(-200);
    }

    /**
     * Methode used to create the play button that leads to the Menu level scene
     * @return the play button
     */
    public ImageButton PlayButton() {
        // play button
        try {
            String image_selected = "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButton_play.png";
            String image_unselected = "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButtonOver_play.png";
            ImageButton button = new ImageButton(image_selected, image_unselected);
            button.setOnAction(e -> {
                VideoBg.stopVplayer();
                VideoScene.stopMplayer();
                Controller.switchScene(ScenesEnum.MENULVLSCENE);
            });
            return button;
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the play button could not be loaded" +
                    " please check the file path in SideMenu.PlayButton()");
            return null;
        }

    }

    /**
     * Methode used to create the arcade button that leads to the arcade scene
     * @return the arcade button
     */
    public ImageButton ArcadeButton() {
        // arcade button
        try {
            String image_selected = "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButton_arcade.png";
            String image_unselected = "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButtonOver_arcade.png";
            ImageButton button = new ImageButton(image_selected, image_unselected);
            //Still to do
            button.setOnAction(e -> {
                VideoBg.stopVplayer();
                VideoScene.stopMplayer();
                Controller.switchScene(ScenesEnum.ARCADESCENE);
            });
            return button;
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the Arcade button could not be loaded " +
                    "please check the file path in SideMenu.ArcadeButton()");
            return null;
        }
    }

    /**
     * Mehtode used to create the play button that leads to the option scene
     * @return the option button
     */
    public ImageButton OptionsButton() {
        // options button
        try {
            String image_selected = "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButton_options.png";
            String image_unselected = "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButtonOver_options.png";
            ImageButton button = new ImageButton(image_selected, image_unselected);
            button.setOnAction(e -> {
                VideoBg.stopVplayer();
                VideoScene.stopMplayer();
                Controller.switchScene(ScenesEnum.OPTIONSCENE);
            });
            return button;
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the option Button could not be loaded" +
                    " please check the file path in SideMenu.OptionButton()");
            return null;
        }
    }

    /**
     * Mehtode used to create the credit button that leads to the credit scene
     * @return the credit button
     */
    public ImageButton CreditsButton() {
        // credits button
        try {
            String image_selected = "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButton_credits.png";
            String image_unselected = "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButtonOver_credits.png";
            ImageButton button = new ImageButton(image_selected, image_unselected);
            button.setOnAction(e -> {
                VideoBg.stopVplayer();
                VideoScene.stopMplayer();
                Controller.switchScene(ScenesEnum.CREDITSSCENE);
            });
            return button;
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the credits button could not be loaded " +
                    "please check the file path in SideMenu.CreditsButton()");
            return null;
        }
    }
    /**
     * Mehtode used to create the exit button that exits the game
     * @return the exit button
     */
    public ImageButton ExitButton() {
        // exit button
        try {
            String image_selected = "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButton_exit.png";
            String image_unselected = "build/resources/main/textures/" + Game.resourcePack + "/Buttons/mainMenu/mainButtonOver_exit.png";
            ImageButton button = new ImageButton(image_selected, image_unselected);
            button.setOnAction(e -> System.exit(0));
            return button;
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the exit button could not be loaded " +
                    "please check the file path in SideMenu.ExitButton()");
            return null;
        }
    }
}

package sokoban.UI.Widgets;

import javafx.scene.layout.VBox;
import sokoban.ScenesEnum;
import sokoban.UI.Scenes.VideoScene;
import sokoban.Game;

import java.io.FileNotFoundException;

public class SideMenu extends VBox {

    public SideMenu() {
        super();
        setPrefWidth(200);
        getChildren().addAll(PlayButton(), ArcadeButton(), OptionsButton(), CreditsButton(), ExitButton());
        setStyle("-fx-background-color: transparent;");
        setTranslateX(-200);
    }

    public ImageButton PlayButton() {
        // play button
        try {
            String image_selected = "build/resources/main/textures/"+Game.resourcePack+"/Buttons/mainMenu/mainButton_play.png";
            String image_unselected = "build/resources/main/textures/"+Game.resourcePack+"/Buttons/mainMenu/mainButtonOver_play.png";
            ImageButton button = new ImageButton(image_selected, image_unselected);
            button.setOnAction(e -> {
                VideoBg.Vplayer.stop();
                VideoScene.Mplayer.stop();
                Controller.switchScene(ScenesEnum.MENULVLSCENE);
            });
            return button;
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the play button could not be loaded" +
                            " please check the file path in SideMenu.PlayButton()",
                    ScenesEnum.VIDEOSCENE);
            return null;
        }

    }

    public ImageButton ArcadeButton() {
        // arcade button
        try {
            String image_selected = "build/resources/main/textures/"+Game.resourcePack+"/Buttons/mainMenu/mainButton_arcade.png";
            String image_unselected = "build/resources/main/textures/"+Game.resourcePack+"/Buttons/mainMenu/mainButtonOver_arcade.png";
            ImageButton button = new ImageButton(image_selected, image_unselected);
            //Still to do
            button.setOnAction(e -> {
                VideoBg.Vplayer.stop();
                VideoScene.Mplayer.stop();
                Controller.switchScene(ScenesEnum.ARCADESCENE);
            });
            return button;
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the Arcade button could not be loaded " +
                            "please check the file path in SideMenu.ArcadeButton()",
                    ScenesEnum.VIDEOSCENE);
            return null;
        }
    }

    public ImageButton OptionsButton() {
        // options button
        try {
            String image_selected = "build/resources/main/textures/"+Game.resourcePack+"/Buttons/mainMenu/mainButton_options.png";
            String image_unselected = "build/resources/main/textures/"+Game.resourcePack+"/Buttons/mainMenu/mainButtonOver_options.png";
            ImageButton button = new ImageButton(image_selected, image_unselected);
            button.setOnAction(e -> {
                VideoBg.Vplayer.stop();
                VideoScene.Mplayer.stop();
                Controller.switchScene(ScenesEnum.OPTIONSCENE);
            });
            return button;
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the option Button could not be loaded" +
                            " please check the file path in SideMenu.OptionButton()",
                    ScenesEnum.VIDEOSCENE);
            return null;
        }
    }

    public ImageButton CreditsButton() {
        // credits button
        try {
            String image_selected = "build/resources/main/textures/"+Game.resourcePack+"/Buttons/mainMenu/mainButton_credits.png";
            String image_unselected = "build/resources/main/textures/"+Game.resourcePack+"/Buttons/mainMenu/mainButtonOver_credits.png";
            ImageButton button = new ImageButton(image_selected, image_unselected);
            button.setOnAction(e -> {
                VideoBg.Vplayer.stop();
                VideoScene.Mplayer.stop();
                Controller.switchScene(ScenesEnum.CREDITSSCENE);
            });
            return button;
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the credits button could not be loaded " +
                            "please check the file path in SideMenu.CreditsButton()",
                    ScenesEnum.VIDEOSCENE);
            return null;
        }
    }

    public ImageButton ExitButton() {
        // exit button
        try {
            String image_selected = "build/resources/main/textures/"+Game.resourcePack+"/Buttons/mainMenu/mainButton_exit.png";
            String image_unselected = "build/resources/main/textures/"+Game.resourcePack+"/Buttons/mainMenu/mainButtonOver_exit.png";
            ImageButton button = new ImageButton(image_selected, image_unselected);
            button.setOnAction(e -> System.exit(0));
            return button;
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the exit button could not be loaded " +
                            "please check the file path in SideMenu.ExitButton()",
                    ScenesEnum.VIDEOSCENE);
            return null;
        }
    }
}

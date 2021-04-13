package sokoban.UI.Widgets;


import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import sokoban.UI.Scenes.MenuLvlScene;
import sokoban.UI.Scenes.VideoScene;



public class SideMenu extends VBox {

    public SideMenu() {
        super();
        setPrefWidth(200);
        getChildren().addAll(PlayButton(), ArcadeButton(), OptionsButton(), ExitButton());
        setStyle("-fx-background-color: transparent;");
        setTranslateX(-200);

    }

    public ImageButton PlayButton() {
        // play button
        String image_selected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButton_play.png";
        String image_unselected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver_play.png";
        ImageButton button = new ImageButton(image_selected, image_unselected);
        button.setOnAction(e -> {
            VideoBg.Vplayer.stop();
            VideoScene.Mplayer.stop();
            Controller.switchToMenuLvlScene();
        });
        button.setStyle("-fx-background-color: transparent;");
        return button;
    }

    public ImageButton ArcadeButton() {
        // arcade button
        String image_selected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButton_arcade.png";
        String image_unselected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver_arcade.png";
        ImageButton button = new ImageButton(image_selected, image_unselected);
        //Still to do
        /*button.setOnAction(e->{ VideoBg.Vplayer.stop();
                    VideoScene.Mplayer.stop()
                    ;Controller.switchScene());*/
        button.setStyle("-fx-background-color: transparent;");
        return button;
    }

    public ImageButton OptionsButton() {
        // options button
        String image_selected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButton_options.png";
        String image_unselected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver_options.png";
        ImageButton button = new ImageButton(image_selected, image_unselected);
        //Still to do
        /*button.setOnAction(e->{  VideoBg.Vplayer.stop();
            VideoScene.Mplayer.stop();
        Controller.switchScene())};*/
        button.setStyle("-fx-background-color: transparent;");
        return button;
    }

    public ImageButton ExitButton() {
        // exit button
        String image_selected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButton_exit.png";
        String image_unselected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver_exit.png";
        ImageButton button = new ImageButton(image_selected, image_unselected);
        button.setOnAction(e -> System.exit(0));
        button.setStyle("-fx-background-color: transparent;");
        return button;
    }
}



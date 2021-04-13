package sokoban.UI.Scenes;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import sokoban.UI.Widgets.VideoBg;
import sokoban.UI.Widgets.ImageButton;
import sokoban.UI.Widgets.Controller;

public class VideoScene extends Scene {

    public MediaPlayer Mplayer;
    Media media;
    String image_selected;
    String image_unselected;
    ImageButton button;
    Media music = new Media(new File("build/resources/main/textures/Default/Sounds/menus/retroWave.wav").toURI().toString());

    public VideoScene(StackPane stackPane) {
        super(stackPane);

        // video
        VideoBg vb = new VideoBg("build/resources/main/textures/Default/Videos/cyber_loop.mp4");
        stackPane.getChildren().add(vb);

        // cursor
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/cursor_pointerFlat.png"));
            setCursor(new ImageCursor(image));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("cursor problem");
        }

        // music
        Mplayer = new MediaPlayer(music);
        Mplayer.setCycleCount(MediaPlayer.INDEFINITE);
        Mplayer.setVolume(0.1);

        // play button
        image_selected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButton_play.png";
        image_unselected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver_play.png";
        button = new ImageButton(image_selected, image_unselected);
        button.setOnAction(e-> {Mplayer.stop(); Controller.switchScene(new MenuLvlScene());});
        button.setStyle("-fx-background-color: transparent;");
        stackPane.getChildren().add(button);
        stackPane.setAlignment(button, Pos.TOP_LEFT);
        stackPane.setMargin(button, new Insets(400.0, 0.0, 0.0, 80.0));

        // arcade button
        image_selected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButton_arcade.png";
        image_unselected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver_arcade.png";
        button = new ImageButton(image_selected, image_unselected);
        //button.setOnAction(e->Controller.switchScene());
        button.setStyle("-fx-background-color: transparent;");
        stackPane.getChildren().add(button);
        stackPane.setAlignment(button, Pos.TOP_LEFT);
        stackPane.setMargin(button, new Insets(500.0, 0.0, 0.0, 80.0));

        // options button
        image_selected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButton_options.png";
        image_unselected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver_options.png";
        button = new ImageButton(image_selected, image_unselected);
        //button.setOnAction(e->Controller.switchScene());
        button.setStyle("-fx-background-color: transparent;");
        stackPane.getChildren().add(button);
        stackPane.setAlignment(button, Pos.TOP_LEFT);
        stackPane.setMargin(button, new Insets(600.0, 0.0, 0.0, 80.0));

        // exit button
        image_selected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButton_exit.png";
        image_unselected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver_exit.png";
        button = new ImageButton(image_selected, image_unselected);
        button.setOnAction(e->System.exit(0));
        button.setStyle("-fx-background-color: transparent;");
        stackPane.getChildren().add(button);
        stackPane.setAlignment(button, Pos.TOP_LEFT);
        stackPane.setMargin(button, new Insets(700.0, 0.0, 0.0, 80.0));
    }
}

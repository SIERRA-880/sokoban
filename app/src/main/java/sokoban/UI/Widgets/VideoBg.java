package sokoban.UI.Widgets;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import sokoban.UI.Scenes.BgScene;
import sokoban.UI.Scenes.MenuLvlScene;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VideoBg extends StackPane {

    public MediaPlayer Vplayer;
    Media media;
    String image_selected;
    String image_unselected;
    ImageButton button;

    public VideoBg(String pathVideo) {
        super();
        media = new Media(new File(pathVideo).toURI().toString());
        Vplayer = new MediaPlayer(media);
        Vplayer.setCycleCount(MediaPlayer.INDEFINITE);
        Vplayer.setMute(true);
        MediaView mv = new MediaView(Vplayer);
        getChildren().add(mv);
        setAlignment(mv, Pos.CENTER);
        Vplayer.play();

        // play button
        image_selected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButton_play.png";
        image_unselected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver_play.png";
        button = new ImageButton(image_selected, image_unselected);
        button.setOnAction(e->Controller.switchScene(new MenuLvlScene()));
        button.setStyle("-fx-background-color: transparent;");
        getChildren().add(button);
        setAlignment(button, Pos.TOP_LEFT);
        setMargin(button, new Insets(400.0, 0.0, 0.0, 80.0));

        // arcade button
        image_selected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButton_arcade.png";
        image_unselected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver_arcade.png";
        button = new ImageButton(image_selected, image_unselected);
        //button.setOnAction(e->Controller.switchScene());
        button.setStyle("-fx-background-color: transparent;");
        getChildren().add(button);
        setAlignment(button, Pos.TOP_LEFT);
        setMargin(button, new Insets(500.0, 0.0, 0.0, 80.0));

        // options button
        image_selected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButton_options.png";
        image_unselected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver_options.png";
        button = new ImageButton(image_selected, image_unselected);
        //button.setOnAction(e->Controller.switchScene());
        button.setStyle("-fx-background-color: transparent;");
        getChildren().add(button);
        setAlignment(button, Pos.TOP_LEFT);
        setMargin(button, new Insets(600.0, 0.0, 0.0, 80.0));

        // exit button
        image_selected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButton_exit.png";
        image_unselected = "build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver_exit.png";
        button = new ImageButton(image_selected, image_unselected);
        button.setOnAction(e->System.exit(0));
        button.setStyle("-fx-background-color: transparent;");
        getChildren().add(button);
        setAlignment(button, Pos.TOP_LEFT);
        setMargin(button, new Insets(700.0, 0.0, 0.0, 80.0));
    }
}

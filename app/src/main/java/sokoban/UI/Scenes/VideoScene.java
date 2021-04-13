package sokoban.UI.Scenes;

import javafx.animation.TranslateTransition;
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
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.util.Duration;
import sokoban.UI.Widgets.SideMenu;
import sokoban.UI.Widgets.VideoBg;
import sokoban.UI.Widgets.ImageButton;


import static javafx.scene.layout.StackPane.setAlignment;
import static javafx.scene.layout.StackPane.setMargin;

public class VideoScene extends Scene {

    public static MediaPlayer Mplayer;
    public static VideoBg vb;

    public static Media music = new Media(new File("build/resources/main/textures/Default/Sounds/menus/retroWave.wav").toURI().toString());

    public VideoScene(StackPane stackPane) {
        super(stackPane);

        // video
        vb = new VideoBg("build/resources/main/textures/Default/Videos/cyber_loop.mp4");
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

        //side menu
        AtomicBoolean shown = new AtomicBoolean(false);
        SideMenu sideMenu = new SideMenu();
        sideMenu.prefHeightProperty().bind(stackPane.heightProperty());
        TranslateTransition menuTranslation = new TranslateTransition(Duration.millis(500), sideMenu);
        menuTranslation.setFromX(-200);
        menuTranslation.setToX(80);
        stackPane.getChildren().add(sideMenu);
        setAlignment(sideMenu, Pos.TOP_LEFT);
        setMargin(sideMenu, new Insets(400, 0.0, 0.0, 0));
        setOnMouseClicked(evt -> {
            if (!shown.get()) {
                menuTranslation.setRate(1);
                menuTranslation.play();
                shown.set(true);
            } else {
                menuTranslation.setRate(-1);
                menuTranslation.play();
                shown.set(false);
            }
        });
    }
}

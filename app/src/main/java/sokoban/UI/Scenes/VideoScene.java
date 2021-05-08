package sokoban.UI.Scenes;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import sokoban.UI.Widgets.SideMenu;
import sokoban.UI.Widgets.VideoBg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicBoolean;

import static javafx.scene.layout.StackPane.setAlignment;
import static javafx.scene.layout.StackPane.setMargin;

public class VideoScene extends BasicScene {

    public static MediaPlayer Mplayer;
    public static VideoBg vb;
    public static Media music = new Media(new File("build/resources/main/textures/Default/Sounds/menus/retroWave.wav").toURI().toString());

    public VideoScene(StackPane stackPane) {
        super(stackPane);

        // video
        vb = new VideoBg("build/resources/main/textures/Default/Videos/cyber_loop.mp4");
        stackPane.getChildren().add(vb);

        // music
        Mplayer = new MediaPlayer(music);
        Mplayer.setCycleCount(MediaPlayer.INDEFINITE);
        Mplayer.setVolume(0.1);

        // label
        Font f = null;
        Font f2 = null;
        try {
            f = Font.loadFont(new FileInputStream("build/resources/main/textures/Default/Fonts/Kenney Rocket Square.ttf"), 100);
            f2 = Font.loadFont(new FileInputStream("build/resources/main/textures/Default/Fonts/Kenney Rocket Square.ttf"), 20);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Label selectLabel = new Label("sokoban");
        selectLabel.setFont(f);
        selectLabel.setTextFill(Color.web("#A7F5F4"));
        stackPane.getChildren().add(selectLabel);
        stackPane.setAlignment(selectLabel, Pos.TOP_RIGHT);
        stackPane.setMargin(selectLabel, new Insets(150.0, 100.0, 0.0, 0.0));
        Label startLabel = new Label("Click on the screen to start");
        startLabel.setFont(f2);
        startLabel.setTextFill(Color.web("#A7F5F4"));
        stackPane.getChildren().add(startLabel);
        stackPane.setAlignment(startLabel, Pos.TOP_RIGHT);
        stackPane.setMargin(startLabel, new Insets(250.0, 100.0, 0.0, 0.0));

        //side menu
        AtomicBoolean shown = new AtomicBoolean(false);
        SideMenu sideMenu = new SideMenu();
        sideMenu.prefHeightProperty().bind(stackPane.heightProperty());
        TranslateTransition menuTranslation = new TranslateTransition(Duration.millis(500), sideMenu);
        menuTranslation.setFromX(-200);
        menuTranslation.setToX(80);
        stackPane.getChildren().add(sideMenu);
        setAlignment(sideMenu, Pos.TOP_LEFT);
        setMargin(sideMenu, new Insets(300, 0.0, 0.0, 0));
        setOnMouseClicked(evt -> {
            if (!shown.get()) {
                menuTranslation.setRate(1.5);
                menuTranslation.play();
                shown.set(true);
            } else {
                if (evt.getButton().equals(MouseButton.PRIMARY) && evt.getClickCount() == 3) {
                    RotateTransition rt = new RotateTransition(Duration.millis(2000), sideMenu);
                    rt.setFromAngle(0);
                    rt.setToAngle(360);
                    rt.setCycleCount(1);
                    rt.setAxis(new Point3D(0, 0, 1));

                    rt.play();
                } else {

                    menuTranslation.setRate(-1.5);
                    menuTranslation.play();
                    shown.set(false);
                }
            }
        });
    }
}

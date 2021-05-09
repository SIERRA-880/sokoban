package sokoban.UI.Scenes;

import javafx.scene.effect.Bloom;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import sokoban.Game;
import sokoban.UI.Widgets.SideMenu;
import sokoban.UI.Widgets.VideoBg;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicBoolean;

import static javafx.scene.layout.StackPane.setAlignment;
import static javafx.scene.layout.StackPane.setMargin;

public class VideoScene extends BasicScene {

    public static Boolean bomb;
    public static MediaPlayer Mplayer;
    public static VideoBg vb;
    public static Media music = new Media(new File("build/resources/main/textures/" + Game.resourcePack + "/Sounds/menus/retroWave.wav").toURI().toString());
    public VideoScene(StackPane stackPane) {
        super(stackPane);

        // video
        vb = new VideoBg("build/resources/main/textures/" + Game.resourcePack + "/Videos/cyber_loop.mp4");
        stackPane.getChildren().add(vb);

        // music
        Mplayer = new MediaPlayer(music);
        Mplayer.setCycleCount(MediaPlayer.INDEFINITE);
        Mplayer.setVolume(0.1);

        // label
        Font f = null;
        Font f2 = null;

        // Setting Threshold



        try {
            f = Font.loadFont(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Fonts/Kenney Rocket Square.ttf"), 100);
            f2 = Font.loadFont(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Fonts/Kenney Rocket Square.ttf"), 20);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Label selectLabel = new Label("sokoban");
        selectLabel.setFont(f);
        Bloom bloom = new Bloom();
        bloom.setThreshold(0.8);
        selectLabel.setEffect(bloom);
        selectLabel.setTextFill(Color.web("#A7F5F4"));
        stackPane.getChildren().add(selectLabel);
        setAlignment(selectLabel, Pos.TOP_RIGHT);
        setMargin(selectLabel, new Insets(150.0, 100.0, 0.0, 0.0));
        Label startLabel = new Label("Click on the screen to start");
        startLabel.setFont(f2);
        startLabel.setTextFill(Color.web("#A7F5F4"));
        stackPane.getChildren().add(startLabel);
        setAlignment(startLabel, Pos.TOP_RIGHT);
        setMargin(startLabel, new Insets(250.0, 100.0, 0.0, 0.0));

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

        TextField textField = new TextField();
        textField.setVisible(false);
        // stackPane.getChildren().add(textField);
        System.out.println(textField.getText());

        setOnMouseClicked(evt -> {
            if (!shown.get()) {

                String showSound = new File("build/resources/main/textures/" + Game.resourcePack + "/Sounds/level/teleport.wav").toURI().toString();
                AudioClip audioClip= new AudioClip(showSound);
                audioClip.setVolume(0.1);

                menuTranslation.setRate(1.5);
                menuTranslation.play();
                shown.set(true);
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), event -> startLabel.setVisible(true)),
                        new KeyFrame(Duration.seconds(0.1), event -> startLabel.setVisible(false)));
                timeline.setCycleCount(2);
                timeline.play();
                audioClip.play();
                startLabel.setVisible(false);
            } else {
                if (evt.getButton().equals(MouseButton.PRIMARY) && evt.getClickCount() == 3) {
                    RotateTransition rt = new RotateTransition(Duration.millis(2000), sideMenu);
                    rt.setFromAngle(0);
                    rt.setToAngle(360);
                    rt.setCycleCount(1);
                    rt.setAxis(new Point3D(0, 0, 1));

                    rt.play();
                } else {
                    String showSound =new File( "build/resources/main/textures/" + Game.resourcePack + "/Sounds/level/openDoors.wav").toURI().toString();
                    AudioClip audioClip= new AudioClip(showSound);
                    audioClip.setVolume(0.1);
                    TranslateTransition menuTranslation2 = new TranslateTransition(Duration.millis(500), sideMenu);
                    menuTranslation2.setFromX(80);
                    menuTranslation2.setToX(-200);
                    menuTranslation2.setRate(1.5);
                    menuTranslation2.play();
                    shown.set(true);
                    audioClip.play();
                    shown.set(false);
                    startLabel.setVisible(true);
                }
            }
        });
    }
}

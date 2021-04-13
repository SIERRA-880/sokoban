package sokoban.UI.Widgets;

import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoBg extends StackPane {

    public static MediaPlayer Mplayer;
    public MediaPlayer Vplayer;
    Media media;
    String image_selected;
    String image_unselected;
    ImageButton button;
    Media music = new Media(new File("build/resources/main/textures/Default/Sounds/menus/retroWave.wav").toURI().toString());

    public VideoBg(String pathVideo) {
        super();
        AtomicBoolean shown = new AtomicBoolean(false);
        byte i = 1;
        media = new Media(new File(pathVideo).toURI().toString());
        Vplayer = new MediaPlayer(media);
        Vplayer.setCycleCount(MediaPlayer.INDEFINITE);
        Vplayer.setMute(true);
        MediaView mv = new MediaView(Vplayer);
        getChildren().add(mv);
        setAlignment(mv, Pos.CENTER);
        Vplayer.play();

        // music
        Mplayer = new MediaPlayer(music);
        Mplayer.setCycleCount(MediaPlayer.INDEFINITE);
        Mplayer.setVolume(0.1);

        //side menu
        SideMenuPane sideMenuPane = new SideMenuPane();
        sideMenuPane.prefHeightProperty().bind(this.heightProperty());
        TranslateTransition menuTranslation = new TranslateTransition(Duration.millis(500), sideMenuPane);
        menuTranslation.setFromX(-200);
        menuTranslation.setToX(80);
        getChildren().add(sideMenuPane);
        setAlignment(sideMenuPane, Pos.TOP_LEFT);
        setMargin(sideMenuPane, new Insets(300, 0.0, 0.0, 0));
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

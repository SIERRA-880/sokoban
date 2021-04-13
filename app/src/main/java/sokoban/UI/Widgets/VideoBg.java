package sokoban.UI.Widgets;

import javafx.geometry.Pos;

import javafx.scene.layout.StackPane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;


public class VideoBg extends StackPane {

    public static MediaPlayer Vplayer;
    Media media;

    /**
     * This widgets display a video(mp4 format) in a stackPane.
     *
     * @param pathVideo is the path of the video that will be displayed.
     */
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
    }
}

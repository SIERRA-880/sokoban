package sokoban.UI.Widgets;

import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class VideoBg extends Group {
    public MediaPlayer Vplayer;
    Media media;

    public VideoBg(String pathVideo) {
        super();
        media = new Media(new File(pathVideo)
                .toURI().toString());
        Vplayer = new MediaPlayer(media);
        Vplayer.setCycleCount(MediaPlayer.INDEFINITE);
        Vplayer.setMute(true);
        //Vplayer.setRate(0.5);
        System.out.println(Vplayer.getRate());
        MediaView mv = new MediaView(Vplayer);
        getChildren().add(mv);
        Vplayer.play();


    }

}

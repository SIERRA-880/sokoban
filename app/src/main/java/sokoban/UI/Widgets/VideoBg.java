package sokoban.UI.Widgets;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import sokoban.UI.Scenes.BgScene;
import sokoban.UI.Scenes.MenuLvlScene;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
        ButtonPlay();
        Vplayer.play();


    }
    public void ButtonPlay() {
        Image image_selected = null,image_unselected=null;
        try {
            image_selected = new Image(
                    new FileInputStream("build/resources/main/textures/Default/Buttons/mainMenu/mainButton_play.png"));
            image_unselected = new Image(
                    new FileInputStream("build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver_play.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Public void Button dans MovingBg.java");
        }
        ImageButton button=null;
        try {
            button = new ImageButton(image_selected, image_unselected);
        }catch (FileNotFoundException e){e.printStackTrace();}
        button.setOnAction(e->{ Controller.switchScene(new MenuLvlScene()); BgScene.player.stop();});
        button.setStyle("-fx-background-color: transparent;");
        getChildren().add(button);
    }

}

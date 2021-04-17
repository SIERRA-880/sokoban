package sokoban.UI.Widgets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javafx.util.Duration;

public class MovingBg extends Pane {

    private final ImageView background1;
    private final ImageView background2;
    private Image bgImg, bgImg2;

    public MovingBg(String image) {
        super();
        try {
            bgImg = new Image(new FileInputStream(image));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        background1 = new ImageView(bgImg);
        background2 = new ImageView(bgImg);
        setTransition(background1, background2);
    }

    public MovingBg(String image1, String image2) {
        super();
        try {
            bgImg = new Image(new FileInputStream(image1));
            bgImg2 = new Image(new FileInputStream(image2));
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        background1 = new ImageView(bgImg);
        background2 = new ImageView(bgImg2);
        setTransition(background1, background2);
    }

    public void setTransition(ImageView bg1, ImageView bg2) {
        TranslateTransition trans1 = new TranslateTransition(Duration.seconds(10), bg1);
        trans1.setFromX(900);
        trans1.setToX(0);
        trans1.setInterpolator(Interpolator.LINEAR);
        trans1.setCycleCount(Animation.INDEFINITE);
        TranslateTransition trans2 = new TranslateTransition(Duration.seconds(10), bg2);
        trans2.setFromX(0);
        trans2.setToX(-450);
        trans2.setCycleCount(Animation.INDEFINITE);
        trans2.setInterpolator(Interpolator.LINEAR);
        ParallelTransition parTrans = new ParallelTransition(trans2,trans1);
        parTrans.play();
        getChildren().addAll(bg2);
    }

    public Image getBgImg() {
        return bgImg;
    }

    public ImageView getBacground2() {
        return background2;
    }

    public ImageView getBackground1() {
        return background1;
    }

    public Image getBgImg2() {
        return bgImg2;
    }
}
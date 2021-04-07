package sokoban;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import sokoban.UI.Scenes.BgScene;
import sokoban.UI.Scenes.MenuLvlScene;
import sokoban.UI.Widgets.MovingBg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Game extends Application {
    //Main class that launches the game
    public static Stage window;

    public static void main(String[] args)  {

        launch(args);
    }


    @Override
    public void start(Stage primaryStage)  {
        window = primaryStage;
        window.setTitle("Sokoban");

        //MenuLvlScene menuLvlScene = new MenuLvlScene();
        BgScene bgScene= new BgScene(new MovingBg("build/resources/main/textures/Default/Menus/background.jpg"));

        window.setScene(bgScene);
        // Window
        window.setFullScreen(true);
        window.setFullScreenExitKeyCombination(KeyCombination.keyCombination(String.valueOf(KeyCode.F11)));
        window.show();
        /* 
        primaryStage.setTitle("DRIFT STAGE");
        Pane game = new Pane();
        Scene gameScene = new Scene(game, 1000, 740);
        Image bgImg = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/background.jpg"));
        ImageView background = new ImageView(bgImg);
        game.getChildren().add(background);

        Image bgImg2 = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/background.jpg"));
        ImageView background2 = new ImageView(bgImg2);
        game.getChildren().add(background2);
        background2.setRotationAxis(Rotate.Y_AXIS);
        background2.setRotate(180);
        //background2.setX(300);

        TranslateTransition trans1 = new TranslateTransition(Duration.seconds(10),background);
        trans1.setFromX(0);
        trans1.setToX(900);
        trans1.setCycleCount(Animation.INDEFINITE);
        trans1.setInterpolator(Interpolator.LINEAR);


        TranslateTransition trans2 = new TranslateTransition(Duration.seconds(10),background2);
        trans2.setFromX(-900);
        trans2.setToX(0);
        trans2.setCycleCount(Animation.INDEFINITE);
        trans2.setInterpolator(Interpolator.LINEAR);
        trans2.setAutoReverse(false);

        ParallelTransition parTrans = new ParallelTransition(trans2);
        parTrans.play();
        primaryStage.setScene(gameScene);
        primaryStage.show()
        */
    }
}
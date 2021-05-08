package sokoban.UI.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import sokoban.Game;
import sokoban.ScenesEnum;

import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.Controller;
import sokoban.UI.Widgets.OptionPane;
import sokoban.UI.Widgets.VideoBg;
import sokoban.UI.Widgets.KeyBindingPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class OptionScene extends BasicScene {


    public OptionScene(StackPane stackPane){
        super(stackPane);
        OptionPane optionPane = new OptionPane();
        stackPane.getChildren().add(optionPane);
        StackPane.setMargin(optionPane, new Insets(200.0, 0.0, 0.0, 20.0));

        // backButton
        BackButton bbutton = new BackButton();
        bbutton.setOnAction(e->{Controller.switchScene(ScenesEnum.VIDEOSCENE);
                                VideoBg.Vplayer.play();
                                VideoScene.Mplayer.play();});
        stackPane.getChildren().add(bbutton);
        StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));
        StackPane.setAlignment(bbutton, Pos.TOP_LEFT);

        // keyBind
        KeyBindingPane kbp = new KeyBindingPane();
        stackPane.getChildren().add(kbp);
        StackPane.setMargin(kbp, new Insets(20.0, 0.0, 0.0, 500.0));
        bbutton.setOnAction(e -> {
            Controller.switchScene(ScenesEnum.VIDEOSCENE);
            VideoBg.Vplayer.play();
            VideoScene.Mplayer.play();
        });
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/" +
                    "cursor_pointerFlat.png"));  //pass in the image path
            setCursor(new ImageCursor(image));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("cursor problem");
        }
        //LayerPane
        Game.pane.getChildren().add(bbutton);
        StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
        AnchorPane pane = new AnchorPane();
        setOnMousePressed(event -> {
            try {
                Image image = new Image(new FileInputStream("build/resources/main/textures/" +
                        "Default/Cells/explosion.png"));
                setCursor(new ImageCursor(image));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        setOnMouseReleased(event -> {
            try {
                Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/" +
                        "cursor_pointerFlat.png"));  //pass in the image path
                setCursor(new ImageCursor(image));
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("cursor problem");
            }
        });

    }
}

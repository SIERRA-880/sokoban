package sokoban.UI.Scenes;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

import sokoban.UI.Widgets.BackButton;
import sokoban.UI.Widgets.GridLvlButtons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static javafx.scene.layout.StackPane.*;

public class MenuLvlScene extends Scene {
    //Scene that contains a grid of the different level buttons

    public MenuLvlScene(StackPane stackPane) {
        super(stackPane);

        //cursor
        try {
            Image image = new Image(new FileInputStream("build/resources/main/textures/Default/Menus/cursor_pointerFlat.png"));
            setCursor(new ImageCursor(image));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("cursor problem");
        }
       
        // gridLevelButtons
        GridLvlButtons glb = new GridLvlButtons();
        stackPane.getChildren().add(glb);
        setAlignment(glb, Pos.CENTER);

        // backButton
        BackButton bbutton = new BackButton(new VideoScene(new StackPane()));
        bbutton.setOnMouseReleased(e->VideoScene.Mplayer.play());
        stackPane.setStyle("-fx-background-color: #000000;");
        stackPane.getChildren().add(bbutton);
        setAlignment(bbutton, Pos.TOP_LEFT);
        setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));
    }
}

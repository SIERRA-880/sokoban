package sokoban.UI.Widgets;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import sokoban.Game;

/**
 * This widget is a button with a texture (image). It needs 2 images
 * the first is the texture of the button when de mouse is over it and
 * the second is displayed when the mouse is not over the button.
 */
public class ImageButton extends Button {

    private String buttonSound = new File("build/resources/main/textures/" + Game.resourcePack + "/Sounds/menus/tic.wav").toURI().toString();
    private AudioClip tic = new AudioClip(buttonSound);

    /**
     * Constructor of Image button
     * @param selected   is a string corresponding to a file path that leads to the image shown when de mouse is over the button.
     * @param unselected is a string corresponding to a file path that leads to the image shown when de mouse is not over the button.
     * @throws FileNotFoundException throws an exception when the file path of the images are not found
     */
    public ImageButton(String selected, String unselected) throws FileNotFoundException {

        Image imSelected = new Image(new FileInputStream(selected));
        Image imUnselected = new Image(new FileInputStream(unselected));

        setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");
        setMinSize(imSelected.getWidth(), imSelected.getHeight());
        BackgroundImage finalImSelected = new BackgroundImage(imSelected, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        BackgroundImage finalImUnselected = new BackgroundImage(imUnselected, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backgroundSelected = new Background(finalImSelected);
        Background backgroundUnselected = new Background(finalImUnselected);
        setOnMouseEntered(e -> {
            setBackground(backgroundUnselected);
            if(OptionPane.soundCBoxIsSelected()) {
                tic.play();
            }
            setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #EA470D;");
        });
        setOnMouseExited(e -> {
            setBackground(backgroundSelected);
            setStyle("-fx-font: 28 sans-serif-bold; -fx-text-fill: #A7F5F4;");
        });
        setPadding(new Insets(0, 0, 0, 0));
        setBackground(backgroundSelected);
    }

}

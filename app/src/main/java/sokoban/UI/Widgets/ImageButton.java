package sokoban.UI.Widgets;

import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageButton extends Button {

    Image locked ;

    /**
     * This widget is a button with a texture (image). It need 2 images
     * the first is the texture of the button when de mouse is over it and 
     * the second is displayed when the mouse is not over the button.
     * 
     * @param selected is the image when de mouse is over the button.
     * @param unselected is the image when de mouse is not over the button.
     */
    public ImageButton(final Image selected, final Image unselected) throws FileNotFoundException {
        locked = new Image(new FileInputStream("build/resources/main/textures/Default/Buttons/levelMenu/levelButton_locker.png"));
        setStyle("-fx-background-color: transparent;");
        setMaxSize(100, 100);
        final ImageView iv = new ImageView(selected);
        this.getChildren().add(iv);
        this.setOnMouseEntered(e -> iv.setImage(unselected));
        this.setOnMouseExited(e -> iv.setImage(selected));
        setPadding(new Insets(0, 0, 0, 0));
        setGraphic(iv);
    }
}

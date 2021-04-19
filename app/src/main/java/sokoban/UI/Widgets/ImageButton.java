package sokoban.UI.Widgets;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
public class ImageButton extends Button {

    Image locked;

    /**
     * This widget is a button with a texture (image). It need 2 images
     * the first is the texture of the button when de mouse is over it and
     * the second is displayed when the mouse is not over the button.
     *
     * @param selected   is a string corresponding to a file path that leads to the image shown when de mouse is over the button.
     * @param unselected is a string corresponding to a file path that leads to the image shown when de mouse is not over the button.
     */
    public ImageButton(String selected, String unselected) {
        Image imSelected = null, imUnselected = null;
        try {
            locked = new Image(new FileInputStream("build/resources/main/textures/Default/Buttons/levelMenu/levelButton_locker.png"));
            imSelected = new Image(new FileInputStream(selected));
            imUnselected = new Image(new FileInputStream(unselected));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Files " + selected + " and " + unselected + "not found ");
            System.exit(1);
        }
        setMinSize(imSelected.getWidth(), imSelected.getHeight());
        BackgroundImage finalImSelected = new BackgroundImage(imSelected,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        BackgroundImage finalImUnselected = new BackgroundImage(imUnselected, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backgroundSelected = new Background(finalImSelected);
        Background backgroundUnselected = new Background(finalImUnselected);
        setOnMouseEntered(e -> setBackground(backgroundUnselected));
        setOnMouseExited(e -> setBackground(backgroundSelected));
        setPadding(new Insets(0, 0, 0, 0));
        setBackground(backgroundSelected);
    }

    public ImageButton(String path) {
        Image image = null;
        try {
            image = new Image(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        setStyle("-fx-background-color: transparent;");
        setMaxSize(100, 100);
        final ImageView iv = new ImageView(image);
        this.getChildren().add(iv);
        setPadding(new Insets(0, 0, 0, 0));
        setGraphic(iv);
    }
}

package sokoban.UI.Widgets;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Files "+ selected +" and "+ unselected +"not found ");
            System.exit(1);
        }
        setStyle("-fx-background-color: transparent;");
        setMaxSize(100, 100);
        final ImageView iv = new ImageView(imSelected);
        this.getChildren().add(iv);
        Image finalImSelected = imSelected;
        Image finalImUnselected = imUnselected;
        this.setOnMouseEntered(e -> iv.setImage(finalImUnselected));
        this.setOnMouseExited(e -> iv.setImage(finalImSelected));
        setPadding(new Insets(0, 0, 0, 0));
        setGraphic(iv);
    }
}

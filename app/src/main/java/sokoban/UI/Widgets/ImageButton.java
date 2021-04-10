package sokoban.UI.Widgets;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//idée tiré de stackOverflow https://stackoverflow.com/questions/10518458/javafx-create-custom-button-with-image
public class ImageButton extends Button {
    //Type of button that contains an image
    Image locked ;

    public ImageButton(final Image selected, final Image unselected) throws FileNotFoundException {
        locked = new Image(
                new FileInputStream("build/resources/main/textures/Default/Buttons" +
                        "/levelMenu/levelButton_locker.png"));
        setStyle("-fx-background-color: transparent;");

        setMaxSize(100, 100);
        final ImageView iv = new ImageView(selected);
        this.getChildren().add(iv);
//truc changé
        this.setOnMouseEntered(e -> iv.setImage(unselected));

        this.setOnMouseExited(e -> iv.setImage(selected));

        setPadding(new Insets(0, 0, 0, 0));
        setGraphic(iv);
    }


}


package sokoban.UI.Widgets;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//idée tiré de stackOverflow https://stackoverflow.com/questions/10518458/javafx-create-custom-button-with-image
public class ImageButton extends Button{
    //Tyoe of button that contains an image
    public ImageButton(final Image selected, final Image unselected)  {

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


package sokoban.UI;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
//idée tiré de stackOverflow https://stackoverflow.com/questions/10518458/javafx-create-custom-button-with-image
public class ImageButton extends Button {

    public ImageButton(final Image selected , final Image unselected) {

        setMaxSize(64, 64);
        final ImageView iv = new ImageView(selected);
        this.getChildren().add(iv);

        iv.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent evt) {
                iv.setImage(unselected);
            }
        });
        iv.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent evt) {
                iv.setImage(selected);
            }
        });

        super.setGraphic(iv);
    }
}


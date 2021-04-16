package sokoban.UI.Widgets;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static javafx.scene.paint.Color.WHITE;

public class SliderLabel extends BorderPane {
    public Slider slider;

    public SliderLabel(double min, double max, double value, double tickValue, String text) {
        super();

        slider = new Slider(min, max, value);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(tickValue);

        Image image = null;
        try {
            image = new Image(new FileInputStream("build/resources/main/textures/Default/Buttons/mainMenu/mainButtonOver.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(113);
        imageView.setPreserveRatio(true);

        Label label = new Label(text);
        label.setFont(Font.font("Segoe UI Light", 14));
        //label.setStyle("-fx-background-color : white");
        label.setTextFill(WHITE);

        setRight(slider);
        setAlignment(slider, Pos.CENTER_LEFT);
        setCenter(new StackPane(imageView,label));
    }

}

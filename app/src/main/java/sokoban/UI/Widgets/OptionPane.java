package sokoban.UI.Widgets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import sokoban.Game;
import javafx.geometry.Pos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static sokoban.UI.Scenes.VideoScene.Mplayer;

public class OptionPane extends VBox {

    public OptionPane() {
        super(8);
        setStyle("-fx-background-color: transparent;");
        setFillWidth(false);
        Brightness();
        Sound();
    }

    public void Brightness() {

        Slider slider = new Slider(-0.6, 0.6, 0.1);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(0.1);
        ColorAdjust colorAdjust = new ColorAdjust();
        slider.setValue(colorAdjust.getBrightness());
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
                                            colorAdjust.setBrightness(slider.getValue());
                                            Game.pane.setEffect(colorAdjust);});
        getChildren().add(new Button("BRIGHTNESS"));
        getChildren().add(slider);
    }

    public void Sound() {
        //Button sound = new Button("SOUND");

        Slider slider = new Slider(0, 1, 0.1);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(0.1);
        slider.setValue(Mplayer.getVolume());
        slider.setOnMousePressed(e -> Mplayer.play());
        slider.setOnMouseReleased(event ->Mplayer.stop());
        slider.valueProperty().addListener((observable, oldValue, newValue) ->
            Mplayer.setVolume(slider.getValue()));
        getChildren().add(new javafx.scene.control.Button("SOUND"));
        getChildren().add(slider);
    }
}

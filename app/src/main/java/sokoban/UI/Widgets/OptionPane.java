package sokoban.UI.Widgets;

import static sokoban.UI.Scenes.VideoScene.Mplayer;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import sokoban.Game;

import javax.swing.*;
import java.io.FileNotFoundException;

public class OptionPane extends VBox {
    public static CheckBox exposion = new CheckBox("EXPLOSION") ;
    public OptionPane() {
        super(8);
        setStyle("-fx-background-color: transparent;");

        setFillWidth(false);
        SliderLabel sliderLabelbrightness = new SliderLabel(-0.6,0.6,0.1,0.1,"BRIGHTNESS");
        Brightness(sliderLabelbrightness.slider);
        SliderLabel sliderLabelsound = new SliderLabel(0,1,0.1,0.1,"SOUND");
        Sound(sliderLabelsound.slider);
        getChildren().addAll(sliderLabelsound,sliderLabelbrightness,exposion);


        //Sound();
    }

    public void Brightness(Slider slider) {

       /* Slider slider = new Slider(-0.6, 0.6, 0.1);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(0.1);*/
        ColorAdjust colorAdjust = new ColorAdjust();
        slider.setValue(colorAdjust.getBrightness());
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
                                            colorAdjust.setBrightness(slider.getValue());
                                            Game.pane.setEffect(colorAdjust);});
        /*getChildren().add(new Button("BRIGHTNESS"));
        getChildren().add(slider);*/
    }

    public void Sound(Slider slider) {
        //Button sound = new Button("SOUND");

        /*slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(0.1);*/
        slider.setValue(Mplayer.getVolume());
        slider.setOnMousePressed(e -> Mplayer.play());
        slider.setOnMouseReleased(event ->Mplayer.stop());
        slider.valueProperty().addListener((observable, oldValue, newValue) ->
            Mplayer.setVolume(slider.getValue()));
       /* getChildren().add(new javafx.scene.control.Button("SOUND"));
        getChildren().add(slider);*/
    }
}

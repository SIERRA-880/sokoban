package sokoban.UI.Widgets;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sokoban.Game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static sokoban.UI.Scenes.VideoScene.Mplayer;

public class OptionPane extends VBox {
    public static CheckBox soundCheckBox = new CheckBox();
    public static CheckBox explosionCheckBox = new CheckBox();

    public static Slider slider = new Slider(0, 100, 10);

    public OptionPane() {
        super(8);

        setSpacing(30);
        setPrefWidth(400);
        setMaxWidth(700);
        setFillWidth(false);
        VBox sliderLabelbrightness = SliderLabel(0, 100, 10, 10, "BRIGHTNESS", font());
        Brightness((Slider) sliderLabelbrightness.getChildren().get(1));
        VBox sliderLabelsound = SliderLabel(0, 100, 10, 10, "MUSIC", font());
        Sound((Slider) sliderLabelsound.getChildren().get(1));
        getChildren().addAll(sliderLabelsound, sliderLabelbrightness);
        //sound effect checkboxes
        getChildren().addAll(soundEffectbox(font()), explosionBoxSlider(font()));




        explosionCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> Controller.setExplosion(explosionCheckBox.isSelected()));

    }

    public void Brightness(Slider slider) {


        ColorAdjust colorAdjust = new ColorAdjust();
        slider.setValue((colorAdjust.getBrightness() + 0.6) * 100);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            colorAdjust.setBrightness((slider.getValue() / 100) - 0.6);
            Controller.setBrightness(colorAdjust);
        });
    }

    public void Sound(Slider slider) {
        slider.setValue(Mplayer.getVolume() * 100);
        slider.setOnMousePressed(e -> Mplayer.play());
        slider.setOnMouseReleased(event -> Mplayer.stop());
        slider.valueProperty().addListener((observable, oldValue, newValue) ->
                Mplayer.setVolume(slider.getValue() / 100));
        slider.setValue(Mplayer.getVolume() * 100);

    }

    public void explosionSound(Slider slider) {
        slider.setValue(Controller.audioClip.getVolume() * 10);
        slider.valueProperty().addListener((observable, oldValue, newValue) ->
                Controller.audioClip.setVolume(slider.getValue() / 100));
        slider.setValue(Controller.audioClip.getVolume() * 10);
    }

    public VBox soundEffectbox(Font f) {
        VBox vbox = new VBox();
        Label label = new Label("SOUND EFFECTS");
        soundCheckBox.setSelected(true);
        //

        // soundCheckBox.getStylesheets().add("app/build/resources/main/CheckB.scss");


        //
        label.setFont(f);
        label.setTextFill(Color.web("#A7F5F4"));
        //vbox.setSpacing(30);
        vbox.getChildren().add(label);

        vbox.getChildren().add(soundCheckBox);
        vbox.setPrefWidth(800);
        vbox.setFillWidth(false);
        return vbox;

    }

    public VBox explosionBoxSlider(Font f) {
        VBox vBox = new VBox();
        Label label1 = new Label("EXPLOSION EFFECTS");
        label1.setFont(f);
        label1.setTextFill(Color.web("#A7F5F4"));
        vBox.getChildren().add(label1);
        explosionCheckBox.setSelected(false);
        vBox.getChildren().add(explosionCheckBox);

        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(10);

        explosionSound(slider);
        VBox vBox1 = new VBox(slider);
        vBox1.setMaxWidth(530);
        vBox.getChildren().add(vBox1);
        vBox.setPrefWidth(700);



        return vBox;

    }

    public VBox SliderLabel(double min, double max, double value, double tickValue, String text, Font f) {
        VBox vBox = new VBox();
        // vBox.setSpacing(30);

        Slider slider = new Slider(min, max, value);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(tickValue);

        Label label = new Label(text);
        label.setFont(f);
        vBox.setPrefWidth(400);
        vBox.setFillWidth(true);
        label.setTextFill(Color.web("#A7F5F4"));
        vBox.getChildren().addAll(label, slider);


        return vBox;

    }

    public Font font() {
        Font f = null;
        try {
            f = Font.loadFont(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Fonts/Kenney Rocket Square.ttf"), 40);
        } catch (FileNotFoundException e) {
            Controller.alert("Fonts file not found (OptionPane:98)");
        }
        return f;
    }
}

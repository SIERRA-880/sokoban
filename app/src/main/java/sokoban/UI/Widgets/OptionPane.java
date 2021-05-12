package sokoban.UI.Widgets;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sokoban.Game;
import sokoban.UI.Scenes.VideoScene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Pane containing the main elements of the Option scene
 */
public class OptionPane extends VBox {
    private static final CheckBox soundCheckBox = new CheckBox();
    private static final CheckBox explosionCheckBox = new CheckBox();
    private static final Slider slider = new Slider(0, 100, 10);

    /**
     * Constructor of OptionPane
     */
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

    /**
     * Methode used to get the font used to write
     *
     * @return a specific Font type objet used for labels
     */
    public static Font font() {
        Font f = null;
        try {
            f = Font.loadFont(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Fonts/Kenney Rocket Square.ttf"), 40);
        } catch (FileNotFoundException e) {
            Controller.alert("Fonts file not found (OptionPane:98)");
        }
        return f;
    }

    /**
     * Methode that verifies if the soundCheckBox is selected or not
     *
     * @return a Boolean that indicates if the soundCheckBox is selected or not
     */
    public static Boolean soundCBoxIsSelected() {
        return soundCheckBox.isSelected();
    }

    /**
     * Methode used to get the value of the slider
     *
     * @return the slider's value
     */
    public static double getSliderVlue() {
        return slider.getValue();
    }

    /**
     * Methode used to make the Slider slider used to change the game's brightness
     *
     * @param slider Slider type object that changes the game's brightness
     */
    public void Brightness(Slider slider) {


        ColorAdjust colorAdjust = new ColorAdjust();
        slider.setValue((colorAdjust.getBrightness() + 0.6) * 100);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            colorAdjust.setBrightness((slider.getValue() / 100) - 0.6);
            Controller.setBrightness(colorAdjust);
        });
    }

    /**
     * Mehtode used to make the Slider slider used to change the game's sound
     *
     * @param slider Slider that changes the game's sound
     */
    public void Sound(Slider slider) {
        slider.setValue(VideoScene.getMplayerVolume() * 100);
        slider.setOnMousePressed(e -> VideoScene.playMplayer());
        slider.setOnMouseReleased(event -> VideoScene.stopMplayer());
        slider.valueProperty().addListener((observable, oldValue, newValue) ->
                VideoScene.setMplayerVolume(slider.getValue() / 100));
        slider.setValue(VideoScene.getMplayerVolume() * 100);

    }

    /**
     * Mehtode used to make the Slider slider used to change the explosions sound
     *
     * @param slider Slider that changes the explosions sound
     */
    public void explosionSound(Slider slider) {
        slider.setValue(Controller.getAudioClipVolume() * 10);
        slider.valueProperty().addListener((observable, oldValue, newValue) ->
                Controller.setAudioClipVolume(slider.getValue() / 100));
        slider.setValue(Controller.getAudioClipVolume() * 10);
    }

    /**
     * Mehtode used to make the layout that contains the soundCheckBox and its description in a label
     *
     * @param f Font in which the description will be written in
     * @return A VBox type object containing the, soundCheckBox and its description
     */
    public VBox soundEffectbox(Font f) {
        soundCheckBox.setSelected(true);
        VBox vbox = new VBox();
        Label label = new Label("SOUND EFFECTS");
        label.setFont(f);
        label.setTextFill(Color.web("#A7F5F4"));
        vbox.getChildren().add(label);

        vbox.getChildren().add(soundCheckBox);
        vbox.setPrefWidth(800);
        vbox.setFillWidth(false);
        return vbox;

    }

    /**
     * Mehtode used to make the layout that contains the explosionCheckBox and the slider
     * controlling its volume and its description in a label
     *
     * @param f Font in which the description will be written in
     * @return A VBox type object containing th explosionCheckBox and the slider and a description
     */
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

    /**
     * Methode used to make a slider and a label describing its use
     *
     * @param min       Minimum value of the slider
     * @param max       Maximum value of the slider
     * @param value     Value of the initial slider value
     * @param tickValue Indicates after how many units a tick mark will appear
     * @param text      Description on the slider
     * @param f         Font in which the description is written
     * @return A VBox type object containing a slider and its description
     */
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
}

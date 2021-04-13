package sokoban.UI.Widgets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import sokoban.Game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static sokoban.UI.Scenes.VideoScene.Mplayer;

public class OptionPane extends StackPane {
    GridPane gridPane = new GridPane();

    public OptionPane() {
        super();
       // gridPane.setStyle("-fx-background-color: transparent;");
        Brightness();
        Sound();
        /*try {
            BackgroundImage myBI = new BackgroundImage(new Image(new FileInputStream("build/resources/main/textures/Default" +
                    "/Menus/background4.jpg"), 32, 32, false, true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            gridPane.setBackground(new Background(myBI));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        getChildren().add(gridPane);
        setStyle("-fx-background-color: BLUE");
    }

    public void Brightness() {
        /*ImageButton brightness = new ImageButton("build/resources/main/textures/Default/Buttons/mainMenu/mainButton.png");
        brightness.setText("BRIGHTNESS");*/

        Slider slider = new Slider(-0.6, 0.6, 0.1);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(0.1);
        ColorAdjust colorAdjust = new ColorAdjust();
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            colorAdjust.setBrightness(slider.getValue());
            Game.pane.setEffect(colorAdjust);
        });
        gridPane.add(new Button("BRIGHTNESS"), 0, 0);
        gridPane.add(slider, 0, 2);
    }

    public void Sound() {
        //Button sound = new Button("SOUND");

        Slider slider = new Slider(0, 1, 0.1);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(0.1);
        slider.setOnMousePressed(e -> Mplayer.play());
        slider.setOnMouseReleased(event -> Mplayer.stop());
        slider.valueProperty().addListener((observable, oldValue, newValue) ->
            Mplayer.setVolume(slider.getValue()));
        gridPane.add(new javafx.scene.control.Button("SOUND"), 1, 0);
        gridPane.add(slider, 1, 2);
    }
}


package sokoban.UI.Widgets;

import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import sokoban.UI.Widgets.ImageButton;
import sokoban.Game;

public class KeyBinding extends HBox {

    public ImageButton button;
    
    public KeyBinding(String text, KeyCode key) {
        super();

        // font
        Font f = null;
        try {
            f = Font.loadFont(new FileInputStream("build/resources/main/textures/Default/Fonts/Kenney Rocket Square.ttf"), 40);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fonts file not found (CreditsScene:43)");
        }

        // label
        Label label = new Label(text);  
        label.setFont(f);
        label.setTextFill(Color.web("#A7F5F4"));

        // button
        button = new ImageButton("build/resources/main/textures/Default/Buttons/levelMenu/levelButton_empty.png",
                                             "build/resources/main/textures/Default/Buttons/levelMenu/levelButtonOver_empty.png");
        String btnText = key.toString();
        button.setText(key.toString());
        button.setStyle("-fx-font: 22 arial; -fx-text-fill: #A7F5F4;");

        // placement
        getChildren().add(button);
        getChildren().add(label);
    }
}


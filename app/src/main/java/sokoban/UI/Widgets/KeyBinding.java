package sokoban.UI.Widgets;

import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import sokoban.ScenesEnum;
import sokoban.UI.Widgets.ImageButton;
import sokoban.Game;

public class KeyBinding extends HBox {

    public ImageButton button;
    
    public KeyBinding(String text, KeyCode key) {
        super();

        // font
        Font f = null;
        try {
            f = Font.loadFont(new FileInputStream("build/resources/main/textures/"+Game.resourcePack+"/Fonts/Kenney Rocket Square.ttf"), 40);
        }
        catch (FileNotFoundException e) {
             Controller.alert("Fonts file not found (CreditsScene:43)",ScenesEnum.OPTIONSCENE);
        }

        // label
        Label label = new Label(text);  
        label.setFont(f);
        label.setTextFill(Color.web("#A7F5F4"));
        getChildren().add(label);
        // button
        try {
            button = new ImageButton("build/resources/main/textures/"+Game.resourcePack+"/Buttons/levelMenu/levelButton_empty.png",
                    "build/resources/main/textures/"+Game.resourcePack+"/Buttons/levelMenu/levelButtonOver_empty.png");
            String btnText = key.toString();
            button.setText(key.toString());
            getChildren().add(button);
        }catch (FileNotFoundException e){ Controller.alert("The image of the button could not be loaded please check the file path in KeyBinding",
                ScenesEnum.OPTIONSCENE);}

    }
}


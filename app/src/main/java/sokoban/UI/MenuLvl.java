package sokoban.UI;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import sokoban.Engine.Objects.*;
import java.io.InputStream;

import java.awt.*;
import java.io.FileInputStream;

public class MenuLvl extends GridPane{

    String nom_button_selected="build/resources/main/textures/Default/Buttons/levelMenu/levelButton_";
    String nom_button_unselected="build/resources/main/textures/Default/Buttons/levelMenu/levelButtonOver_";


    public MenuLvl() throws Exception {
        super();
        // addKeyListener(this);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                Image image_selected = new Image(new FileInputStream(nom_button_selected +(i+1) + ".png"));
                Image image_unselected =new Image(new FileInputStream(nom_button_unselected +(i+1)+ ".png"));
                this.add(new ImageButton(image_selected,image_unselected), i,j);
            }

        }
    }


}

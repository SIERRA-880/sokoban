package sokoban.UI;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;

public class MenuLvl extends GridPane {

    //String nom_button_selected="build/resources/main/textures/Default/Buttons/levelMenu/levelButton_";
    //String nom_button_unselected="build/resources/main/textures/Default/Buttons/levelMenu/levelButtonOver_";
    String nom_button_selected = "build/resources/main/textures/Default/Buttons/levelMenu/buttonTeste.png";


    public MenuLvl() throws Exception {
        super();

        // addKeyListener(this);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Image image_selected = new Image(new FileInputStream(nom_button_selected /*+(i+1)+".png"*/));
                Image image_unselected = new Image(new FileInputStream(nom_button_selected /*+(i+1)+".png"*/));
                this.add(new ImageButton(image_selected, image_unselected), i, j);
              // setPadding(new Insets(0, 0, 0, 0));

            }


        }
        setHgap(30); //horizontal gap in pixels => that's what you are asking for
        setVgap(60);


    }


}

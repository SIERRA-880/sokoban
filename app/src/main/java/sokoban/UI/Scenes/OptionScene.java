package sokoban.UI.Scenes;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import sokoban.ScenesEnum;
import sokoban.UI.Widgets.*;

import java.io.FileNotFoundException;


public class OptionScene extends BasicScene {


    public OptionScene(StackPane stackPane) {
        super(stackPane);
        // backButton
        BackButton bbutton = null;
        try {
            bbutton = new BackButton();
            bbutton.setOnAction(e -> {
                Controller.switchScene(ScenesEnum.VIDEOSCENE);
                VideoBg.Vplayer.play();
                VideoScene.Mplayer.play();
            });
            stackPane.getChildren().add(bbutton);
            StackPane.setMargin(bbutton, new Insets(20.0, 0.0, 0.0, 20.0));
            StackPane.setAlignment(bbutton, Pos.TOP_LEFT);
        } catch (FileNotFoundException e) {
            Controller.alert("The image of the back button could not be loaded please check the file path in the OptionScene");
        }

        // keyBind
        KeyBindingPane kbp = new KeyBindingPane();
        stackPane.getChildren().add(kbp);
        StackPane.setMargin(kbp, new Insets(300, 50.0, 0, 0.0));
        stackPane.setAlignment(kbp,Pos.TOP_RIGHT);
        if (bbutton != null) {
            bbutton.setOnAction(e -> {
                Controller.switchScene(ScenesEnum.VIDEOSCENE);
                VideoBg.Vplayer.play();
                VideoScene.Mplayer.play();
            });
        }

        OptionPane optionPane = new OptionPane();
        stackPane.getChildren().add(optionPane);
        StackPane.setMargin(optionPane, new Insets(200.0, 0.0, 0.0, 20.0));

    }


}



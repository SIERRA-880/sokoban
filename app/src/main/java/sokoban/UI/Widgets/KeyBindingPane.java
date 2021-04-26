package sokoban.UI.Widgets;

import javafx.scene.layout.VBox;

import sokoban.Game;
import sokoban.UI.Widgets.ImageButton;
import sokoban.UI.Widgets.KeyBinding;

public class KeyBindingPane extends VBox {

    public KeyBindingPane() {
        super(40.0);

        // up
        KeyBinding kb1 = new KeyBinding("  up", Game.up);

        kb1.button.setOnAction(e -> {setOnKeyPressed (k -> {Game.up = k.getCode();
                                                            kb1.button.setText(k.getCode().toString());});});  
        getChildren().add(kb1);

        // left
        KeyBinding kb2 = new KeyBinding("  left", Game.left);
        kb2.button.setOnAction(e -> {setOnKeyPressed (k -> {Game.left = k.getCode();
                                                            kb2.button.setText(k.getCode().toString());});});  
        getChildren().add(kb2);

        // down
        KeyBinding kb3 = new KeyBinding("  down", Game.down);
        kb3.button.setOnAction(e -> {setOnKeyPressed (k -> {Game.down = k.getCode();
                                                            kb3.button.setText(k.getCode().toString());});});  
        getChildren().add(kb3);

        //right
        KeyBinding kb4 = new KeyBinding("  right", Game.right);
        kb4.button.setOnAction(e -> {setOnKeyPressed (k -> {Game.right = k.getCode();
                                                            kb4.button.setText(k.getCode().toString());});});  
        getChildren().add(kb4);
    }
}
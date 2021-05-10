package sokoban.UI.Widgets;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sokoban.Game;

public class KeyBindingPane extends GridPane {

    public KeyBindingPane() {
        super();
        setHgap(40);
        setVgap(40);
        // up
        KeyBinding kb1 = new KeyBinding("  up", Game.up);

        kb1.button.setOnAction(e -> setOnKeyPressed(k -> {
            Game.up = k.getCode();
            kb1.button.setText(k.getCode().toString());
        }));


        // left
        KeyBinding kb2 = new KeyBinding("  left", Game.left);
        kb2.button.setOnAction(e -> setOnKeyPressed(k -> {
            Game.left = k.getCode();
            kb2.button.setText(k.getCode().toString());
        }));

        // down
        KeyBinding kb3 = new KeyBinding("  down", Game.down);
        kb3.button.setOnAction(e -> setOnKeyPressed(k -> {
            Game.down = k.getCode();
            kb3.button.setText(k.getCode().toString());
        }));
       // getChildren().add(kb3);

        //right
        KeyBinding kb4 = new KeyBinding("  right", Game.right);
        kb4.button.setOnAction(e -> setOnKeyPressed(event -> {
            System.out.println(event.getCode());
            event.consume();
        }));
        getChildren().addAll(kb1,kb2,kb3,kb4);
        GridPane.setRowIndex(kb1,0);
        GridPane.setColumnIndex(kb1,1);
        GridPane.setRowIndex(kb2,1);
        GridPane.setColumnIndex(kb2,0);
        GridPane.setRowIndex(kb3,1);
        GridPane.setColumnIndex(kb3,1);
        GridPane.setRowIndex(kb4,1);
        GridPane.setColumnIndex(kb4,2);

        setAlignment(Pos.TOP_RIGHT);



    }
}

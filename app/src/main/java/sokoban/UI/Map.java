package sokoban.UI;
import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.util.concurrent.ExecutionException;

import javafx.scene.input.KeyCode;
import sokoban.Engine.Objects.*;
import javafx.scene.input.KeyEvent;
import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;
import sokoban.Engine.Tools.*;

public class Map extends GridPane {
    World world;
    public Map(World world) throws Exception{
        super();
       // addKeyListener(this);
        this.world=world;

        }
    public void showMap() throws Exception {
        Cell[][] cell = world.getMap();
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                Image image = new Image(new FileInputStream(cell[i][j].getCellTexture()));
                this.add(new ImageView(image), j, i, 1, 1);
            }

        }
    }
}




            /*grid.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.Q) {
                    player.move('q',world);
                    world.upDate();
                    showMap(grig,world);
                    ke.consume(); // <-- stops passing the event to next node
                }
            }
        });*



   /* public void keyPressed(KeyEvent args0){

    }*/


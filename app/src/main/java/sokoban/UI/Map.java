package sokoban.UI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import sokoban.Engine.Objects.*;

import java.io.FileInputStream;

public class Map extends GridPane {
    World world;

    public Map(World world) throws Exception {
        super();
        // addKeyListener(this);
        this.world = world;

    }

    public void showMap() throws Exception {

        this.getChildren().clear();


        MatrixCase[][] matrix = world.getMap();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Cell cell = matrix[i][j].getCell(); 
                Image image = new Image(new FileInputStream(cell.getCellTexture()));
                this.add(new ImageView(image), j, i, 1, 1);
            }

        }
    }
}


package sokoban.UI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import sokoban.Engine.Objects.Cell;
import sokoban.Engine.Objects.MatrixCase;
import sokoban.Engine.Objects.World;

import java.io.FileInputStream;

import static javafx.geometry.Pos.CENTER;

public class Map extends GridPane {
    World world;

    public Map(World world) throws Exception {
        super();
        this.world = world;
        setAlignment(CENTER);


    }

    public void showMap() throws Exception {

        //clean up
        this.getChildren().clear();
        //refresh
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




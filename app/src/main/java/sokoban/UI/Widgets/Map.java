package sokoban.UI.Widgets;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import sokoban.Engine.Objects.Cell;
import sokoban.Engine.Objects.MatrixCase;
import sokoban.Engine.Objects.World;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static javafx.geometry.Pos.CENTER;

public class Map extends GridPane {

    World world;

    /**
     * A Map is a grid where each case is a game's cell from a matrix 
     * stored in a world object.
     *
     * @param world world object from the game engine.
     */
    public Map(World world)  {
        super();
        this.world = world;
        setAlignment(CENTER);
        setStyle("-fx-background-color: #000000;");
    }

    public void showMap() {
        //clean up
        this.getChildren().clear();
        //refresh
        MatrixCase[][] matrix = world.getMap();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Cell cell = matrix[i][j].getCell();
                Image image = null;
                try {
                    image = new Image(new FileInputStream(cell.getCellTexture()));
                } 
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                this.add(new ImageView(image), j, i, 1, 1);
            }
        }
    }
}

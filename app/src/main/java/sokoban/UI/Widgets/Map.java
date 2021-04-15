package sokoban.UI.Widgets;

import static javafx.geometry.Pos.CENTER;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import sokoban.Game;
import sokoban.Engine.Objects.Cell;
import sokoban.Engine.Objects.MatrixCase;

public class Map extends GridPane {

    /**
     * A Map is a grid where each case is a game's cell from a matrix 
     * stored in a world object.
     */
    public Map()  {
        super();
        setAlignment(CENTER);
    }

    public void showMap() {
        //clean up
        this.getChildren().clear();
        //refresh
        MatrixCase[][] matrix = Game.level.world.getMap();
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

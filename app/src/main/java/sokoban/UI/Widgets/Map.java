package sokoban.UI.Widgets;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import sokoban.Engine.Objects.Cell;
import sokoban.Engine.Objects.MatrixCase;
import sokoban.Game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static javafx.geometry.Pos.CENTER;

/**
 * Map is a grid where each case is a game's cell from a matrix
 * stored in a world object.
 */
public class Map extends GridPane {

    private Image ground = null;
    private Image empty = null;
    private Image wall = null;
    private Image player = null;
    private Image box = null;
    private Image target = null;
    private Image boxOnTarget = null;

    /**
     * Constructor of Map
     */
    public Map() {
        super();
        setAlignment(CENTER);
        try {
            ground = new Image(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Cells/ground.png"));
            empty = new Image(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Cells/empty.png"));
            wall = new Image(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Cells/wall.png"));
            box = new Image(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Cells/box.png"));
            target = new Image(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Cells/target.png"));
            player = new Image(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Cells/player_down.png"));
            boxOnTarget = new Image(new FileInputStream("build/resources/main/textures/" + Game.resourcePack + "/Cells/boxOnTarget.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Controller.alert("image file not found (Map.java:36-42)");
        }
    }

    public void showMap() {
        //clean up
        this.getChildren().clear();
        // LevelScene.label1.setVisible(false);
        //refresh
        MatrixCase[][] matrix = Game.level.world.getMap();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Cell cell = matrix[i][j].getCell();
                switch (cell.getCellType()) {
                    case CELL:
                        this.add(new ImageView(ground), j, i, 1, 1);
                        break;
                    case EMPTY:
                        this.add(new ImageView(empty), j, i, 1, 1);
                        break;
                    case WALL:
                        this.add(new ImageView(wall), j, i, 1, 1);
                        break;
                    case PLAYER:
                        try {
                            player = new Image(new FileInputStream(cell.getCellTexture()));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            System.out.println("texture not found (Map.java:66)");
                        }
                        this.add(new ImageView(player), j, i, 1, 1);
                        break;
                    case BOX:
                        this.add(new ImageView(box), j, i, 1, 1);
                        break;
                    case TARGET:
                        this.add(new ImageView(target), j, i, 1, 1);
                        break;
                    case BOXONTARGET:
                        this.add(new ImageView(boxOnTarget), j, i, 1, 1);
                        break;
                }
            }
        }
    }
}

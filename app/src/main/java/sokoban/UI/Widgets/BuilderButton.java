package sokoban.UI.Widgets;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import sokoban.CellsEnum;
import sokoban.Game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Button that represent a cell in the BuilderScene and can change skin depending on the user's actions
 */

public class BuilderButton extends Button {

    private final int x;
    private final int y;
    private final String ground;
    private final String wall;
    private final String box;
    private final String target;
    private final String player;
    private final String empty;
    private Image imSelected = null;

    /**
     * Contructor of BuilderButton
     * @param selected string containing the file path of the new button's skin
     * @param x X coordinate in the builder grid
     * @param y Y coordinate in the builder grid
     */
    public BuilderButton(String selected, int x, int y) {
        this.x = x;
        this.y = y;
        changeImg(selected);

        ground = "build/resources/main/textures/" + Game.resourcePack + "/Cells/ground.png";
        empty = "build/resources/main/textures/" + Game.resourcePack + "/Cells/empty.png";
        wall = "build/resources/main/textures/" + Game.resourcePack + "/Cells/wall.png";
        box = "build/resources/main/textures/" + Game.resourcePack + "/Cells/box.png";
        target = "build/resources/main/textures/" + Game.resourcePack + "/Cells/target.png";
        player = "build/resources/main/textures/" + Game.resourcePack + "/Cells/player_down.png";
    }

    /**
     * Methode used to change the appearance of the Builder button
     * @param selected string containing the file path of the new button's skin
     */
    public void changeImg(String selected) {
        try {
            imSelected = new Image(new FileInputStream(selected));
        } catch (FileNotFoundException e) {
          Controller.alert("Imge file could not be loaded please check BuilderButton:53");
        }
        setMinSize(imSelected.getWidth(), imSelected.getHeight());
        BackgroundImage finalImSelected = new BackgroundImage(imSelected, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backgroundSelected = new Background(finalImSelected);
        setBackground(backgroundSelected);
    }

    /**
     * Methode used to change a cell type in the builder grid
     * @param cell new cell that will replace the previous on
     * @param map map that is displayed in the Builder scene
     */
    public void changeCell(CellsEnum cell, String[][] map) {
        switch (cell) {
            case CELL:
                changeImg(ground);
                map[y][x] = " ";
                break;
            case WALL:
                changeImg(wall);
                map[y][x] = "#";
                break;
            case EMPTY:
                changeImg(empty);
                map[y][x] = "_";
                break;
            case TARGET:
                changeImg(target);
                map[y][x] = ".";
                break;
            case BOX:
                changeImg(box);
                map[y][x] = "$";
                break;
            case PLAYER:
                changeImg(player);
                map[y][x] = "@";
                break;
        }
    }
}

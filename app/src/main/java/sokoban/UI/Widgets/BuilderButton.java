package sokoban.UI.Widgets;

import javafx.scene.control.Button;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import sokoban.CellsEnum;
import sokoban.Game;

public class BuilderButton extends Button {

    private int x, y;
    private String ground;
    private String wall;
    private String box;
    private String target;
    private String player;
    private String empty;
    private Image imSelected = null;

    public BuilderButton(String selected, int x, int y) {
        this.x = x;
        this.y = y;
        changeImg(selected);

            ground = "build/resources/main/textures/"+Game.resourcePack+"/Cells/ground.png";
            empty = "build/resources/main/textures/"+Game.resourcePack+"/Cells/empty.png";
            wall = "build/resources/main/textures/"+Game.resourcePack+"/Cells/wall.png";
            box = "build/resources/main/textures/"+Game.resourcePack+"/Cells/box.png";
            target = "build/resources/main/textures/"+Game.resourcePack+"/Cells/target.png";
            player = "build/resources/main/textures/"+Game.resourcePack+"/Cells/player_down.png";
    }

    public void changeImg(String selected) {
        try {
            imSelected = new Image(new FileInputStream(selected));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        setMinSize(imSelected.getWidth(), imSelected.getHeight());
        BackgroundImage finalImSelected = new BackgroundImage(imSelected,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backgroundSelected = new Background(finalImSelected);
        setBackground(backgroundSelected);
    }

    public void changeCell(CellsEnum cell, String[][] map) {
        switch(cell) {
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

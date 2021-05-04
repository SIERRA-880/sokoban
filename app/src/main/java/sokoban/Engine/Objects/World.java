package sokoban.Engine.Objects;

import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;

import java.util.Arrays;
import java.util.ArrayList;

public class World {
    
    public int width;
    public int height;
    private MatrixCase[][] cellsArray;
    private Player player;
    private ArrayList<Target> targetsList = new ArrayList<Target>();
    private ArrayList<Box> boxesList = new ArrayList<Box>();

    public World(int width, int height, Player player) {
        this.width = width;
        this.height = height;
        this.player = player;
    }

    public void setMap(MatrixCase[][] matrix) {
        cellsArray = matrix;
    }

    public void setWall(int[] pos) {
        Wall wall = new Wall(pos, "/Cells/wall.png");
        MatrixCase wallCase = new MatrixCase(wall, wall);
        cellsArray[pos[1]][pos[0]] = wallCase;
    }

    public MatrixCase[][] getMap() {
        return cellsArray;
    }
    
    public void setTargetsList(ArrayList<Target> targetsList) {
        this.targetsList = targetsList;
    }

    public void setBoxesList(ArrayList<Box> boxesList) {
        this.boxesList = boxesList;
    }

    /**
     * This method is called when the user want to change the map layout.
     * 
     * @param file a string containing the path to the map
     */
    public void mapChanger(String file) {
        width = MapLoader.getSize(file)[0];
        height = MapLoader.getSize(file)[1];
        Builder.init(MapLoader.load(file), player, this, width, height);
    }

    /**
     * Prints the matrix representing the map cell by cell in a terminal
     */
    public void printMap() {
        for (int line=0; line<height; line++) {
            for (int column=0; column<width; column++) {
                System.out.print(cellsArray[line][column].getCell().getTermTexture()); 
            }
            System.out.println("");
        }
    }

    /**
     * 
     * @param pos an array [x,y]
     * @return reference to the {@link sokoban.Engine.Objects.Cell} at the given positions
     */
    public Cell searchCell(int[] pos) {
        return cellsArray[pos[1]][pos[0]].getCell();
    }

    public Cell searchBox(int[] pos) {
        return cellsArray[pos[1]][pos[0]].getCell();
    }

    public Cell[] getNearbyCells(int[] pos) {
        int x = pos[0];
        int y = pos[1];
        int[] up = {x, y-1};
        int[] left = {x-1, y};
        int[] down = {x, y+1};
        int[] right = {x+1, y};
        Cell[] nearbyCellsArray = {searchCell(up), searchCell(left), searchCell(right), searchCell(down)};
        return nearbyCellsArray;
    }

    public void moveCell(Cell cell, int[] oldPos, int[] newPos) {
        cellsArray[oldPos[1]][oldPos[0]].remove();
        cellsArray[newPos[1]][newPos[0]].add(cell);
    }

    /**
     * This methods compare positions of all {@link sokoban.Engine.Objects.Target}'s positions and {@link sokoban.Engine.Objects.Box}'s positions.
     * If all {@link sokoban.Engine.Objects.Target} contains a {@link sokoban.Engine.Objects.Box}, the method returns true.
     * 
     * @return false by default, true if the level is completed (all boxes on targets)
     */
    public boolean winCondition() {
        int counter = 0;
        for (Target target : targetsList) {
            for (Box box : boxesList) {
                int[] targetPos = target.getCellPos();
                int[] boxPos = box.getCellPos();
                if (targetPos[0]==boxPos[0] && targetPos[1]==boxPos[1]) {
                    counter++;
                }
            }
        }
        if (counter == targetsList.size()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(cellsArray); 
    }
}

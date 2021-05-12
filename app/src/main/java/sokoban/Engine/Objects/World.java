package sokoban.Engine.Objects;

import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Object representing the world of a sokoban level
 */
public class World {
    
    public int width;
    public int height;
    private MatrixCase[][] cellsArray;
    private Player player;
    private ArrayList<Target> targetsList = new ArrayList<Target>();
    private ArrayList<Box> boxesList = new ArrayList<Box>();

    /**
     * @param width width of the world
     * @param height height of the world
     * @param player player moving in the world
     */
    public World(int width, int height, Player player) {
        this.width = width;
        this.height = height;
        this.player = player;
    }

    /**
     * Store a matric in cellsArray world's attribute 
     * @param matrix matrix representing the map
     */
    public void setMap(MatrixCase[][] matrix) {
        cellsArray = matrix;
    }

    /**
     * Replace the cell at the given position by a wall
     * @param pos position of the cell to replace
     */
    public void setWall(int[] pos) {
        Wall wall = new Wall(pos, "/Cells/wall.png");
        MatrixCase wallCase = new MatrixCase(wall, wall);
        cellsArray[pos[1]][pos[0]] = wallCase;
    }

    /**
     * @return the matrix representing the map
     */
    public MatrixCase[][] getMap() {
        return cellsArray;
    }
    
    /**
     * Store the given target list into world's targetList attribute
     * @param targetList Arraylist of all targets on the map
     */
    public void setTargetsList(ArrayList<Target> targetsList) {
        this.targetsList = targetsList;
    }

    /**
     * Store the given box list into world's boxesList attribute
     * @param boxesList Arraylist of all boxes on the map
     */
    public void setBoxesList(ArrayList<Box> boxesList) {
        this.boxesList = boxesList;
    }

    /**
     * This method is called when the user want to change the map layout.
     * @param file a string containing the path to the map
     */
    public void mapChanger(String file) {
        width = MapLoader.getSize(file)[0];
        height = MapLoader.getSize(file)[1];
        Builder.init(MapLoader.load(file), player, this, width, height);
    }

    /**
     * Print the matrix representing the map cell by cell in a terminal
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
     * Search for a cell at the given position in the matrix representing the map
     * @param pos Array of int containing coordinates (x, y)
     * @return reference to the {@link sokoban.Engine.Objects.Cell} at the given positions
     */
    public Cell searchCell(int[] pos) {
        return cellsArray[pos[1]][pos[0]].getCell();
    }

    /**
     * Search for a box at the given position in the matrix representing the map
     * @param pos Array of int containing coordinates (x, y)
     * @return reference to the {@link sokoban.Engine.Objects.Cell} at the given positions
     */
    public Cell searchBox(int[] pos) {
        return cellsArray[pos[1]][pos[0]].getCell();
    }

    /**
     * @param pos Array of int containing coordinates (x, y)
     * @return Array filled of the fout cell's neighbor's
     */
    public Cell[] getNearbyCells(int[] pos) {
        int x = pos[0];
        int y = pos[1];
        int[] up = {x, y-1};
        int[] left = {x-1, y};
        int[] down = {x, y+1};
        int[] right = {x+1, y};
        Cell[] nearbyCellsArray;
        nearbyCellsArray = new Cell[]{searchCell(up), searchCell(left), searchCell(right), searchCell(down)};
        return nearbyCellsArray;
    }

    /**
     * Move a cell from a position to an other
     * @param cell cell that will be moved
     * @param oldPos Array of int containing initial coordinates of the cell
     * @param newPos Array of int containing new coordinates of the cell
     */
    public void moveCell(Cell cell, int[] oldPos, int[] newPos) {
        cellsArray[oldPos[1]][oldPos[0]].remove();
        cellsArray[newPos[1]][newPos[0]].add(cell);
    }

    /**
     * Check if a level is completed
     * @return false by default, true if the level is completed (all boxes on targets)
     */
    public boolean winCondition() {
        int counter = 0;
        
        // for each target it checks if there is a box on it
        for (Target target : targetsList) {
            for (Box box : boxesList) {
                int[] targetPos = target.getCellPos();
                int[] boxPos = box.getCellPos();
                if (targetPos[0]==boxPos[0] && targetPos[1]==boxPos[1]) {
                    counter++;
                }
            }
        }
        return counter == targetsList.size();
    }

    @Override
    public String toString() {
        return Arrays.deepToString(cellsArray); 
    }
}

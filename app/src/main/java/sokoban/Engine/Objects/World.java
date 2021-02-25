package sokoban.Engine.Objects;

import sokoban.Engine.Tools.Builder;
import sokoban.Engine.Tools.MapLoader;

import java.util.Arrays;

public class World {
    
    private int width;
    private int height;
    private Cell[][] cellsArray;
    private Cell[] cellsList;
    private Player player;
    
    public World(int width, int height, Player player) {
        this.width = width;
        this.height = height;
        this.player = player;
    }
    
    public void setList(Cell[] list) {
        cellsList = list;
    }
    
    public Cell[] getList() {
        return cellsList;
    }
    
    public void setMap(Cell[][] matrix) {
        cellsArray = matrix;
    }
    
    public Cell[][] getMap() {
        return cellsArray;
    }
    
    /**
     * This method is called when the user want to change the map layout in the terminal.
     * 
     * @param file a string containing the path of a map
     */
    public void mapChanger(String file) {
        int[] size = MapLoader.getSize(file);
        setList(Builder.init(MapLoader.load(file), player, size[0], size[1]));
        setMap(Builder.build(getList(), size[0], size[1]));
    }
    
    /**
     * Prints the matrix representing the map cell by cell in a terminal
     */
    public void printMap() {
        for (int line=0; line<height; line++) {
            for (int column=0; column<width; column++) {
                System.out.print(cellsArray[line][column].getCellTexture()); 
            }
            System.out.println("");
        }
    }
    
    public Cell searchCell(int[] pos) {
        return cellsArray[pos[1]][pos[0]];
    }
    
    public Cell searchBox(int[] pos) {
        return cellsArray[pos[1]][pos[0]];
    }
    
    public void switchCellsPos(Cell cell1, Cell cell2) {
        int[] save = new int[2];
        save[0] = cell1.getCellPos()[0];
        save[1] = cell1.getCellPos()[1];
        cellsArray[save[1]][save[0]] = cell2;
        cellsArray[cell2.getCellPos()[1]][cell2.getCellPos()[0]] = cell1;
        cell1.setCellPos(cell1.getCellPos());
        cell2.setCellPos(save);
    }
    
    /**
     * 
     * 
     * @return false by default, true if the level is completed (all boxes on targets)
     */
    public boolean winCondition() {
        return false;
    }
    
    public void upDate() {
        setMap(Builder.build(cellsList, width, height));
    }
    
    @Override
    public String toString() {
        return Arrays.deepToString(cellsArray); 
    }
    
}
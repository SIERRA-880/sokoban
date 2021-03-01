package sokoban.Engine.Tools;

import sokoban.Engine.Objects.*;

import java.util.ArrayList;

public class Builder {
    
    /**
     * This method fills an array with corresponding objects on the proper position.
     * The method works in two steps.
     * First step: it fills the array with empty cells.
     * Second step: it adds to empty cells the object corresponding to the position
     * 
     * You can call the method using sokoban.Engine.Tools.MapLoader methods for mapConfig, width and height
     * 
     * @param mapConfig string containing the initial configuration of the map
     * @param player Player object created in sokoban.Game before calling this method
     * @param world World object created in sokoban.Game
     * @param width an integer equals to the width of the map
     * @param height an integer eauqls to the height of the map
     * @return an array cellsList containing Cell objects
     */
    public static Cell[] init(String mapConfig, Player player, World world, int width, int height) {
        int index = 0;
        
        // array filled with all objects
        Cell[] cellsList = new Cell[(width*height)*2];
        // lists of targets and boxes
        ArrayList<Target> targetsList = new ArrayList<Target>();
        ArrayList<Box> boxesList = new ArrayList<Box>();
        
        for (int line=0; line<height; line++) {
            for (int column=0; column<width; column++) {
                int[] pos = {column, line};
                Cell cell = new Cell(pos, "build/resources/main/Textures/Cells/ground.png", false, false);
                cellsList[index++] = cell;
            }
        }
        int n = 0;
        for (int line=0; line<height; line++) {
            for (int column=0; column<width; column++) {
                char cellType = mapConfig.charAt(n++);
                int[] pos = {column, line};
                if (cellType == ' ') {
                    Cell cell = new Cell(pos, "build/resources/main/Textures/Cells/ground.png", false, false);
                    cellsList[index++] = cell;
                }
            }
        }
        n = 0;
        for (int line=0; line<height; line++) {
            for (int column=0; column<width; column++) {
                char cellType = mapConfig.charAt(n++);
                int[] pos = {column, line};
                if (cellType == '.') {
                    Target target = new Target(pos, "build/resources/main/Textures/Cells/ground.png");
                    cellsList[index++] = target;
                    targetsList.add(target);
                }
            }
        }
        n = 0;
        for (int line=0; line<height; line++) {
            for (int column=0; column<width; column++) {
                char cellType = mapConfig.charAt(n++);
                int[] pos = {column, line};
                if (cellType == '$') {
                    Box box = new Box(pos, "build/resources/main/Textures/Cells/ground.png");
                    cellsList[index++] = box;
                    boxesList.add(box);
                }
            }
        }
        n = 0;
        for (int line=0; line<height; line++) {
            for (int column=0; column<width; column++) {
                char cellType = mapConfig.charAt(n++);
                int[] pos = {column, line};
                if (cellType == '@') {
                    player.setCellPos(pos);
                    cellsList[index++] = player;
                }
            }
        }
        n = 0;
        for (int line=0; line<height; line++) {
            for (int column=0; column<width; column++) {
                char cellType = mapConfig.charAt(n++);
                int[] pos = {column, line};
                if (cellType == '#') {
                    Wall wall = new Wall(pos, "build/resources/main/Textures/Cells/wall.png");
                    cellsList[index++] = wall;
                }
            }
        }
        world.setTargetsList(targetsList);
        world.setBoxesList(boxesList);
        return cellsList;
    }

    /**
     * 
     * 
     * You can call the method using sokoban.Engine.Tools.MapLoader methods width and height
     * 
     * @param cellsList 
     * @param height an integer equals to the height of the map
     * @param width an integer equals to the width of the map
     * @return a matrix filled with Cell objects
     */
    public static Cell[][] build(Cell[] cellsList, int height, int width) {
        /**This method return a matrix where each value is a cell object
        * It needs a list of all objects to place in the matrix, the width
        * and the height of the matrix.
        */
        Cell[][] mapMatrix = new Cell[height][width]; 	
        for (int n=0; n<cellsList.length; n++) {
            int x = cellsList[n].getCellPos()[0];
            int y = cellsList[n].getCellPos()[1];
            mapMatrix[y][x] = cellsList[n];
        }
        return mapMatrix;
    }
}

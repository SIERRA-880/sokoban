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
    public static void init(String mapConfig, Player player, World world, int width, int height) {
        
        // array filled with all objects
        MatrixCase[][] cellsMatrix = new MatrixCase[height][width];
        // lists of targets and boxes
        ArrayList<Target> targetsList = new ArrayList<Target>();
        ArrayList<Box> boxesList = new ArrayList<Box>();
        
        int n = 0;
        for (int line=0; line<height; line++) {
            for (int column=0; column<width; column++) {
                char cellType = mapConfig.charAt(n++);
                int[] pos = {column, line};

                switch (cellType) {
                    case ' ':
                        Cell cell = new Cell(pos, "/Cells/ground.png", false, false);
                        MatrixCase cellCase = new MatrixCase(cell, cell);
                        cellsMatrix[line][column] = cellCase;
                        break;

                    case '.':
                        Target target = new Target(pos, "/Cells/target.png");
                        MatrixCase targetCase = new MatrixCase(target, target);
                        cellsMatrix[line][column] = targetCase;
                        targetsList.add(target);
                        break;

                    case '$':
                        Box box = new Box(pos, "/Cells/box.png");
                        Cell cell1 = new Cell(pos, "/Cells/ground.png", false, false);
                        MatrixCase boxCase = new MatrixCase(box, cell1);
                        cellsMatrix[line][column] = boxCase;
                        boxesList.add(box);
                        break;

                    case '@':
                        player.setCellPos(pos);
                        Cell cell2 = new Cell(pos, "/Cells/ground.png", false, false);
                        MatrixCase playerCase = new MatrixCase(player, cell2);
                        cellsMatrix[line][column] = playerCase;
                        break;

                    case '#':
                        Wall wall = new Wall(pos, "/Cells/wall.png");
                        MatrixCase wallCase = new MatrixCase(wall, wall);
                        cellsMatrix[line][column] = wallCase;
                        break;

                    case '_':
                        Empty empty = new Empty(pos, "/Cells/empty.png");
                        MatrixCase emptyCase = new MatrixCase(empty, empty);
                        cellsMatrix[line][column] = emptyCase;
                        break;

                    default:
                        break;
                }
            }
        }
        world.setTargetsList(targetsList);
        world.setBoxesList(boxesList);
        world.setMap(cellsMatrix);
    }

}

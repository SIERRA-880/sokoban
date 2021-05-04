package sokoban.Engine.Tools;

import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.World;
import sokoban.Engine.Objects.Target;
import sokoban.Engine.Objects.Box;
import sokoban.Engine.Objects.Wall;
import sokoban.Engine.Objects.Empty;
import sokoban.Engine.Objects.Cell;
import sokoban.Engine.Objects.MatrixCase;

import sokoban.CellsEnum;

import java.util.ArrayList;

public class Builder {
    
    /**
     * This build a map for a given World with a given String.
     * Each character of the String will be a cell on the map.
     * 
     * @param mapConfig string containing the initial configuration of the map
     * @param player Player object created in sokoban.Game before calling this method
     * @param world World object created in sokoban.Game
     * @param width an integer equals to the width of the map
     * @param height an integer eauqls to the height of the map
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
                        Cell cell = new Cell(pos, CellsEnum.CELL, "/Cells/ground.png", false, false);
                        MatrixCase cellCase = new MatrixCase(cell, cell);
                        cellsMatrix[line][column] = cellCase;
                        break;

                    case '-':
                        Cell cell0 = new Cell(pos, CellsEnum.CELL, "/Cells/ground.png", false, false);
                        MatrixCase cellCase0 = new MatrixCase(cell0, cell0);
                        cellsMatrix[line][column] = cellCase0;
                        break;

                    case '.':
                        Target target = new Target(pos, "/Cells/target.png");
                        MatrixCase targetCase = new MatrixCase(target, target);
                        cellsMatrix[line][column] = targetCase;
                        targetsList.add(target);
                        break;

                    case '$':
                        Box box = new Box(pos, "/Cells/box.png");
                        Cell cell1 = new Cell(pos, CellsEnum.CELL, "/Cells/ground.png", false, false);
                        MatrixCase boxCase = new MatrixCase(box, cell1);
                        cellsMatrix[line][column] = boxCase;
                        boxesList.add(box);
                        break;

                    case '@':
                        player.setCellPos(pos);
                        Cell cell2 = new Cell(pos, CellsEnum.CELL, "/Cells/ground.png", false, false);
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

                    case '*':
                        Target starTarget = new Target(pos, "/Cells/target.png");
                        Box starBox = new Box(pos, "/Cells/box.png");
                        MatrixCase starCase = new MatrixCase(starBox, starTarget);
                        cellsMatrix[line][column] = starCase;
                        boxesList.add(starBox);
                        targetsList.add(starTarget);
                        break;

                    case '+':
                        Target plusTarget = new Target(pos, "/Cells/target.png");
                        player.setCellPos(pos);
                        MatrixCase plusCase = new MatrixCase(player, plusTarget);
                        cellsMatrix[line][column] = plusCase;
                        targetsList.add(plusTarget);
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

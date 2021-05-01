package sokoban.Engine.Tools.Generation;

import sokoban.Engine.Objects.MatrixCase;
import sokoban.Engine.Objects.Wall;
import sokoban.Engine.Objects.Cell;

import sokoban.CellsEnum;

import java.util.Random;

public class MapGenerator {

    /**
     * This method create a matrix of MatrixCase representing the map and fills the border with Walls.
     *
     * @param width is the width of our future map
     * @param height is the height of our future map
     */
    public static MatrixCase[][] mkMap(int width, int height) {
        MatrixCase[][] cellsMatrix = new MatrixCase[height][width];
        for (int line=0; line<height; line++) {
            for (int column=0; column<width; column++) {
                int[] pos = {column, line};
                if (line==0 || line==height-1 || column==0 || column==width-1) {
                    Wall wall = new Wall(pos, "/Cells/wall.png");
                    MatrixCase wallCase = new MatrixCase(wall, wall);
                    cellsMatrix[line][column] = wallCase;
                }
                else {
                   Cell cell = new Cell(pos, CellsEnum.CELL, "/Cells/ground.png", false, false);
                   MatrixCase groundCase = new MatrixCase(cell, cell);
                   cellsMatrix[line][column] = groundCase;
                }
            }
        }
        return cellsMatrix;
    }

    public static MatrixCase[][] mkWalls(MatrixCase[][] map, int difficulty) {
        MatrixCase[][] wallsMap = map;
        Random random = new Random();
        int spawnRate = 15;
        switch (difficulty) {
            case 2:
                spawnRate = 17;
                break;
            case 3:
                spawnRate = 20;
                break;
            default:
                break;
        }
        for (int line=0; line<map.length; line++) {
            for (int column=0; column<map[line].length; column++) {
               Cell cell = map[line][column].getCell(); 
               if (!(cell.getTermTexture()=='#')) {
                   if (spawnRate >= random.nextInt(100)+1) {
                       int[] pos = {column, line};
                       Wall wall = new Wall(pos, "/Cells/wall.png");
                       MatrixCase wallCase = new MatrixCase(wall, wall);
                       wallsMap[line][column] = wallCase;
                   }
               }
            }
        }
        return wallsMap;
    }

    public static MatrixCase[][] generate(int width, int height, int difficulty) {
        MatrixCase[][] map = mkWalls(mkMap(width, height), difficulty);
        return map;
    }
}

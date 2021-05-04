package sokoban.Engine.Tools.Generation;

import sokoban.Engine.Objects.MatrixCase;
import sokoban.Engine.Objects.Wall;
import sokoban.Engine.Objects.Cell;
import sokoban.Engine.Objects.World;
import sokoban.Engine.Objects.Player;
import sokoban.Engine.Objects.Level;

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

                // if current cell is a border
                if (line==0 || line==height-1 || column==0 || column==width-1) {
                    Wall wall = new Wall(pos, "/Cells/wall.png");
                    MatrixCase wallCase = new MatrixCase(wall, wall);
                    cellsMatrix[line][column] = wallCase;
                }

                // if current cell is a center cell
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

        // for each cell that is not a wall it try to spawn a new wall
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

    /**
     * Give a random ground cell's position
     *
     * @param world current working world
     * @return pos int array of a random ground cell position
     */
    public static int[] rngPos(World world) {
        Random random = new Random();
        boolean stop = true;
        int[] pos = new int[2];
        while (stop) { 
            pos[0] = random.nextInt(world.width);
            pos[1] = random.nextInt(world.height);
            if (!world.searchCell(pos).collisions() && pos[0]!=0 && pos[1]!=0) {
                stop = false;     
            }
        }
        return pos;
    }

    public static Level generate(int width, int height, int difficulty) {
        // player
        int[] pos = {0, 0};
        Player player = new Player(pos, "/Cells/player_down.png");

        // world
        World world = new World(width, height, player);
        MatrixCase[][] map = mkWalls(mkMap(width, height), difficulty);
        Wall wall  = new Wall(pos, "/Cells/wall.png");
        MatrixCase playerCase = new MatrixCase(player, wall);
        map[pos[1]][pos[0]] = playerCase; 
        world.setMap(map);

        // move player 
        int[] newPos = rngPos(world);
        world.moveCell(player, pos, newPos); 
        player.setCellPos(newPos);

        // level
        Level level = new Level();
        level.setWorld(world);
        level.setPlayer(player);
        level.setNLevel(0);

        // pathfinding
        int[] start = {1, 1};
        int[] end = {8, 8};
        PathFinder.find(world, start, end);

        return level;
    }
}

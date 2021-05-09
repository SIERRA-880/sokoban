package sokoban.Engine.Tools.Generation;

import sokoban.Engine.Objects.*;
import sokoban.CellsEnum;
import sokoban.Game;

import java.util.Random;
import java.util.ArrayList;

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

    public static void mvBox(World world, Player player) {
        // arrayLists
        ArrayList<Target> targetList = new ArrayList<Target>();
        ArrayList<Box> boxesList = new ArrayList<Box>();

        for (int nb = Game.genBox; nb > 0; nb--) {
            // make a box and a target 
            MatrixCase[][] map = world.getMap();
            int[] rng = rngPos(world);
            int[] pos = {rng[0], rng[1]};
            int[] tPos = {rng[0], rng[1]};
            Target target  = new Target(tPos, "/Cells/target.png");
            Box box  = new Box(pos, "/Cells/box.png");
            MatrixCase boxCase = new MatrixCase(box, target);
            map[pos[1]][pos[0]] = boxCase; 
            targetList.add(target);
            boxesList.add(box);

            int[] iPos = box.getCellPos();
            for (int nm = 0; nm<10; nm++) {
                boolean playerNextToBox = false;
                Cell[] nearbyCells = world.getNearbyCells(box.getCellPos());
                int n = 0;

                // check if there's a path to the box
                for (Cell cell : nearbyCells) {
                    n+=1;

                    // move the player if a path is found 
                    if (PathFinder.find(world, player.getCellPos(), cell.getCellPos())) {
                        world.moveCell(player, player.getCellPos(), cell.getCellPos());
                        player.setCellPos(cell.getCellPos());
                        playerNextToBox = true;
                        break;
                    }
                    
                    // if there's no path to the box
                    else if (n==4 && !playerNextToBox) {
                        break;
                    }
                }

                if (playerNextToBox) {
                     int o = 0;
                     Cell[] playerNearbyCells = world.getNearbyCells(player.getCellPos());
                     String direction = "up";
                     for (Cell cell1 : playerNearbyCells) {
                         if (cell1.getCellType() == CellsEnum.BOX) {
                             switch(o) {
                                 case 0:
                                     direction = "down";
                                     break;
                                 case 1:
                                     direction = "right";
                                     break;
                                 case 2:
                                     direction = "left";
                                     break;
                                 case 3:
                                     direction = "up";
                                     break;
                             }
                         }
                         o+=1;
                     }
                     player.pull(direction, world);
                }

                /*
                // remove the box if there's no path to the box
                for (int e=checkList.size()-1; e>=0; e--) {
                    MatrixCase[][] wmap = world.getMap();
                    Box rmBox = boxesList.get(checkList.get(e));
                    int[] boxPos = rmBox.getCellPos();
                    Cell cell = new Cell(boxPos, CellsEnum.CELL, "/Cells/ground.png", false, false);
                    MatrixCase cellCase = new MatrixCase(cell, cell);
                    wmap[boxPos[1]][boxPos[0]] = cellCase;
                    boxesList.remove(checkList.get(e));
                }
                */
            }
        }
        world.setTargetsList(targetList);
        world.setBoxesList(boxesList);
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

        // box
        mvBox(world, player);

        // level
        Level level = new Level();
        level.setWorld(world);
        level.setPlayer(player);
        level.setNLevel(0);

        return level;
    }
}

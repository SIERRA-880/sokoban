package sokoban.Engine.Objects;

import sokoban.Engine.Tools.MoveLogger;
import sokoban.CellsEnum;

/**
 * Object representing a cell that can move or be moved.
 */
public class MoveableCell extends Cell {

    boolean boxMoved = false;

    /**
     * @param pos Array of int containing the position of the cell (x, y)
     * @param cellType type of cell {@link sokoban.CellsEnum}
     * @param texture String filepath of the cell's png texture
     * @param hardCollision determine if the cell is crossable or not
     * @param softCollision determine if the cell is pushable or not
     */
    public MoveableCell(int[]  pos, CellsEnum cellType, String texture, boolean hardCollision, boolean softCollision) {
        super(pos, cellType, texture, hardCollision, softCollision);	
    }

    /**
     * @param direction String (up, down, right, left) for the direction
     * @param world current working world
     * @return true if the {@link sokoban.Engine.Objects.Cell} is movable and move 
     * a {@link sokoban.Engine.Objects.Box} if necessary
     */
    public boolean isMoveable(String direction, World world) {

        // getting the nextCell from the world
        int[] nextPos = getNextPos(direction);
        Cell nextCell;
        nextCell = world.searchCell(nextPos);

        // if next cell is not crossable
        if (nextCell.hardCollision()) {
            return false;
        } 

        // if next cell is pushable i.e. Box
        else if (nextCell.softCollision()) {
            int[] nextNextPos = nextCell.getNextPos(direction);
            Cell nextNextCell = world.searchCell(nextNextPos);

            // if next next cell has collisions
            if (nextNextCell.collisions()) {
                return false;
            }

            // if next next cell hasn't collisions
            else {

                // move the next cell
                world.moveCell(nextCell, nextCell.getCellPos(), nextNextPos);
                nextCell.setCellPos(nextNextPos);
                boxMoved = true;

                // change next cell's texture if it moves on a target or gets away of a target
                if (nextNextCell.getCellType() == CellsEnum.TARGET) {
                    nextCell.setCellType(CellsEnum.BOXONTARGET);
                }
                else {
                    nextCell.setCellType(CellsEnum.BOX);
                }
                return true;
            }
        } 

        // if next cell hasn't collisions
        else {
            boxMoved = false;
            return true;
        }
    }

    /**
     * Moves the {@link sokoban.Engine.Objects.MoveableCell} in the given direction and logs movements (see {@link sokoban.Engine.Tools.MoveLogger}).
     * @param direction String (up, down, right, left) for the direction
     * @param world is the current working world
     * @return a boolean indicating if a box has been moved or not
     */
    public boolean move(String direction, World world) {

        // if the move can be done in the given direction 
        if (isMoveable(direction, world)) {
            int[] nextPos = getNextPos(direction);
            world.moveCell(this, this.getCellPos(), nextPos);
            setCellPos(nextPos);

            // logging movements
            if (boxMoved) {
                MoveLogger.logMovement(direction.toUpperCase().charAt(0));
                return true;
            }
            else {
                MoveLogger.logMovement(direction.toLowerCase().charAt(0));
            }
        }

        // if the move can't be done
        return false;
    }

    /**
     * Pull a box in the given direction
     * @param direction String (up, down, right, left) for the direction.
     * @param world is the current working world.
     * @return true if the box is pulled 
     */
    public boolean pull(String direction, World world) {
        String oppositeDirection = "";
        switch (direction) {
            case "up":
                oppositeDirection = "down";
                break;
            case "down":
                oppositeDirection = "up";
                break;
            case "right":
                oppositeDirection = "left";
                break;
            case "left":
                oppositeDirection = "right";
                break;
            default:
                break;
        }

        // getting cells and cells' postions
        int[] nextPos = getNextPos(direction);
        int[] boxPos = getNextPos(oppositeDirection);
        int[] playerPos = this.getCellPos();
        Cell nextCell = world.searchCell(nextPos);
        Cell boxCell = world.searchCell(boxPos);

        // if the previous cell is a box and the next cell has no collisions
        if (world.searchCell(boxPos) instanceof Box && (!nextCell.hardCollision() && !nextCell.softCollision())) { 

            // moving cells and changing positions 
            Cell box = world.searchBox(boxPos);
            world.moveCell(this, playerPos, nextPos);
            world.moveCell(box, boxPos, playerPos);
            boxCell.setCellType(CellsEnum.BOX);
            box.setCellPos(playerPos);
            setCellPos(nextPos);
            return true;
        }
        return false;
    }
}

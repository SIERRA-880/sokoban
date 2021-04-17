package sokoban.Engine.Objects;

import sokoban.Engine.Tools.MoveLogger;

public class MoveableCell extends Cell {

    boolean boxMoved = false;

    public MoveableCell(int[]  pos, String texture, boolean hardCollision, boolean softCollision) {
    super(pos, texture, hardCollision, softCollision);	
    }

    /**
     * 
     * @param direction char (z,q,s,d) representing (up,left,down,right) direction
     * @param world
     * @return true if the {@link sokoban.Engine.Objects.Cell} is movable. That doesn't mean that it can actually be moved ! See {@link sokoban.Engine.Objects.Cell#hardCollision()} and {@link sokoban.Engine.Objects.Cell#softCollision()}
     */
    public boolean isMoveable(String direction, World world) {
        int[] nextPos = getNextPos(direction);
        Cell nextCell;

        // test of the type of the next cell :
        nextCell = world.searchCell(nextPos);

        if (nextCell.hardCollision()) {
            return false;
        } 
        else if (nextCell.softCollision()) {
            // if the next cell can be pushed check the following :
            int[] nextNextPos = nextCell.getNextPos(direction);
            Cell nextNextCell = world.searchCell(nextNextPos);
            if (nextNextCell.hardCollision() || nextNextCell.softCollision()) {
                return false;
            }
            else {
                world.moveCell(nextCell, nextCell.getCellPos(), nextNextPos);
                nextCell.setCellPos(nextNextPos);
                boxMoved = true;
                return true;
            }
        } 
        else {
            boxMoved = false;
            return true;
        }
    }

    /**
     * Moves the {@link sokoban.Engine.Objects.Cell} from initial position to next position using ({@link sokoban.Engine.Objects.Cell#getNextPos(String)}) to find it.
     * and return true if a box has been moved.
     * @param direction char (z,q,s,d) representing (up,left,down,right) direction
     * @param world
     */
    public boolean move(String direction, World world) {
        /** This method change the cell's position depending on the given direction */
        if (isMoveable(direction, world)) {
            int[] nextPos = getNextPos(direction);
            world.moveCell(this, this.getCellPos(), nextPos);
            setCellPos(nextPos);
            if (boxMoved) {
                MoveLogger.logMovement(direction.toUpperCase().charAt(0));
                return true;
            }
            else {
                MoveLogger.logMovement(direction.toLowerCase().charAt(0));
            }
        }
        return false;
    }

    public void pull(String direction, World world) {
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
        int[] nextPos = getNextPos(direction);
        int[] boxPos = getNextPos(oppositeDirection);
        int[] playerPos = this.getCellPos();
        Cell nextCell = world.searchCell(nextPos);
        if (world.searchCell(boxPos) instanceof Box && (!nextCell.hardCollision() && !nextCell.softCollision())) { 
            Cell box = world.searchBox(boxPos);
            world.moveCell(this, playerPos, nextPos);
            world.moveCell(box, boxPos, playerPos);
            box.setCellPos(playerPos);
            setCellPos(nextPos);
        }
    }
}

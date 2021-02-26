package sokoban.Engine.Objects;

public class MoveableCell extends Cell {

    public MoveableCell(int[]  pos, char texture, boolean hardCollision, boolean softCollision) {
        super(pos, texture, hardCollision, softCollision);	
    }

    /**
     * 
     * @param direction char (z,q,s,d) representing (up,left,down,right) direction
     * @param world
     * @return true if the {@link sokoban.Engine.Objects.Cell} is movable. That doesn't mean that it can actually be moved ! See {@link sokoban.Engine.Objects.Cell#hardCollision()} and {@link sokoban.Engine.Objects.Cell#softCollision()}
     */
    public boolean isMoveable(char direction, World world) {
        int[] nextPos = getNextPos(direction);
        Cell nextCell;

        // test of de type of the next cell :
        if (world.searchCell(nextPos) instanceof Box) {
            nextCell = world.searchBox(nextPos);
        } else {
            nextCell = world.searchCell(nextPos);
        }

        if (nextCell.hardCollision()) {
            return false;
        } else if (nextCell.softCollision()) {
            // if the next cell can be pushed check the following :
            int[] nextNextPos = nextCell.getNextPos(direction);
            Cell nextNextCell = world.searchCell(nextNextPos);
            if (nextNextCell.hardCollision() || nextNextCell.softCollision()) {
                return false;
            } else {
                nextCell.setCellPos(nextNextPos);
                return true;
            }
        } else {
            return true;
        }
    }

    /**
     * Moves the {@link sokoban.Engine.Objects.Cell} from initial position to next position using ({@link sokoban.Engine.Objects.Cell#getNextPos(char)}) to find it.
     * @param direction char (z,q,s,d) representing (up,left,down,right) direction
     * @param world
     */
    public void move(char direction, World world) {
        /** This method change the cell's position depending on the given direction */
        if (isMoveable(direction, world)) {
            int[] nextPos = getNextPos(direction);
            setCellPos(nextPos);
            System.out.println(this);
        }
    }
}
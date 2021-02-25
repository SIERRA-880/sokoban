package Objects;

public class MoveableCell extends Cell {
    
    public MoveableCell(int[]  pos, char texture, boolean hardCollision, boolean softCollision) {
        super(pos, texture, hardCollision, softCollision);	
    }
    public boolean isMoveable(char direction, World world) {
        int[] nextPos = getNextPos(direction);
        Cell nextCell;
        
        // test of de type of the next cell :
        if (world.searchCell(nextPos) instanceof Box) {
            nextCell = world.searchBox(nextPos);
        }
        else {
            nextCell = world.searchCell(nextPos);
        }
        
        // check the collisions :
        if (nextCell.hardCollision()) {
            // if the next cell cannot be gone trough :
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
                nextCell.setCellPos(nextNextPos);
                return true;
            }
        }
        else {
            return true;
        }
    }
    
    public void move(char direction, World world) {
        /** This method change the cell's position depending on the given direction */
        if (isMoveable(direction, world)) {
            int[] nextPos = getNextPos(direction);
            setCellPos(nextPos);
            System.out.println(this);
        }
    }
}
package Objects;

public class Cell {
    
    private int[] pos;
    private char texture;
    private boolean hardCollision;
    private boolean softCollision;
    
    public Cell(int[] pos, char texture, boolean hardCollision, boolean softCollision) {
        this.pos = pos;
        this.texture = texture;	
        this.hardCollision = hardCollision;
        this.softCollision = softCollision;
        
    }
    
    public int[] getCellPos() {
        /** return cell's position */
        return pos;
    }
    
    public void setCellPos(int[] newPos) {
        /** set the given cell's position */
        pos[0] = newPos[0];
        pos[1] = newPos[1];
    }
    
    public int[] getNextPos(char direction) {
        /** return cell's position if it  would be moved in the given direction */
        int[] nextPos = new int[2];
        if (direction == 'z') {
            nextPos[0] = pos[0];
            nextPos[1] = pos[1]-1;
        }
        else if (direction == 'q') {
            nextPos[0] = pos[0]-1;
            nextPos[1] = pos[1];
        }
        else if (direction == 's') {
            nextPos[0] = pos[0];
            nextPos[1] = pos[1]+1;
        }
        else if (direction == 'd') {
            nextPos[0] = pos[0]+1;
            nextPos[1] = pos[1];
        }
        else {
            nextPos[0] = pos[0];
            nextPos[1] = pos[1];
        }
        return nextPos;
    }
    
    public char getCellTexture() {
        /** return cell's texture */
        return texture;
    }
    
    public boolean hardCollision() {
        /** return true if the cell can't be gone trough */
        return hardCollision;
    }
    
    public boolean softCollision() {
        /** return true if the cell can be pushed */
        return softCollision;
    }
    
    @Override
    public String toString() {
        return texture + " " + pos[0] + " " + pos[1];
    }
}
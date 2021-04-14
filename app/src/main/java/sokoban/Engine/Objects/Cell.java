package sokoban.Engine.Objects;

/**
 * Object representing a cell on the map
 */
public class Cell {

    private int[] pos;
    protected String texture;
    private boolean hardCollision;
    private boolean softCollision;
    private char termTexture = ' ';
    private String resourcePack = "build/resources/main/textures/Default";

    public Cell(int[] pos, String texture, boolean hardCollision, boolean softCollision) {
        this.pos = pos;
        this.texture = resourcePack + texture;
        this.hardCollision = hardCollision;
        this.softCollision = softCollision;

    }

    /**
     * 
     * @return position of the {@link sokoban.Engine.Objects.Cell}
     */
    public int[] getCellPos() {
        return pos;
    }

    /**
     * Set the given position to the current {@link sokoban.Engine.Objects.Cell}
     * 
     * @param newPos
     */
    public void setCellPos(int[] newPos) {
        pos[0] = newPos[0];
        pos[1] = newPos[1];
    }

    /**
     * 
     * @param direction String (up,left,down,right) direction
     * @return the position of the {@link sokoban.Engine.Objects.Cell} if the player wants to move it in the given direction
     */
    public int[] getNextPos(String direction) {
        int[] nextPos = new int[2];
        if (direction == "up") {
            nextPos[0] = pos[0];
            nextPos[1] = pos[1]-1;
        }
        else if (direction == "left") {
            nextPos[0] = pos[0]-1;
            nextPos[1] = pos[1];
        }
        else if (direction == "down") {
            nextPos[0] = pos[0];
            nextPos[1] = pos[1]+1;
        }
        else if (direction == "right") {
            nextPos[0] = pos[0]+1;
            nextPos[1] = pos[1];
        }
        else {
            nextPos[0] = pos[0];
            nextPos[1] = pos[1];
        }
        return nextPos;
    }
    
    /**
     * 
     * @return the texture of the {@link sokoban.Engine.Objects.Cell}
     */
    public String getCellTexture() {
        return texture;
    }

    /**
     * @return the character of the {@link sokoban.Engine.Objects.Cell}
     */
    public char getTermTexture() {
        return termTexture;
    }

    /**
     * Method used to access the value of the private variable hardCollision.
     *
     * @return true if the {@link sokoban.Engine.Objects.Cell} cannot be pushed or passes through ({@link sokoban.Engine.Objects.Box} against {@link sokoban.Engine.Objects.Wall})
     */
    public boolean hardCollision() {
        return hardCollision;
    }

    /**
     * Method used to access the value of the private variable hardCollision.
     *
     * @return true if there is a soft colision ({@link sokoban.Engine.Objects.Player} pushing {@link sokoban.Engine.Objects.Box})
     */
    public boolean softCollision() {
        return softCollision;
    }

    /**
     * Method used to set a given resource pack as current resource pack.
     * @param resourcePack is the path to the resource pack's folder.
     */
    public void setResourcePack(String resourcePack) {
        this.resourcePack = resourcePack;
    }
    
    @Override
    public String toString() {
        return texture + " " + pos[0] + " " + pos[1];
    }
}

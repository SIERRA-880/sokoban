package sokoban.Engine.Objects;

import sokoban.CellsEnum;

/**
 * Object representing a sokoban box
 */
public class Box extends MoveableCell {

    private char termTexture = '$';
    
    /**
     * @param pos Array of int containing coordinates (x, y) 
     * @param texture String filepath of the box's png texture 
     */
    public Box(int[] pos, CellsEnum cellType, String texture) {
        super(pos, cellType, texture, false, true);
    }

    /**
     * @return the character of the {@link sokoban.Engine.Objects.Cell}
     */
    @Override
    public char getTermTexture() {
        return termTexture;
    }
}

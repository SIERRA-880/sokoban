package sokoban.Engine.Objects;

import sokoban.CellsEnum;

/** 
 * Object representing a sokoban empty cell
 */
public class Empty extends Cell {

    private char termTexture = ' ';
    /**
     * @param pos Array of int containing coordinates (x, y)
     * @param texture String filepath of the empty cell's png texture
     */
    public Empty(int[] pos, String texture) {
        super(pos, CellsEnum.EMPTY, texture, false, false);
    }

    /**
     * @return the character of the {@link sokoban.Engine.Objects.Cell}
     */
    @Override
    public char getTermTexture() {
        return termTexture;
    }
}

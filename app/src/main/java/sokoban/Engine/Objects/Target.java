package sokoban.Engine.Objects;

import sokoban.CellsEnum;

/**
 * object representing a sokoban target cell
 */
public class Target extends Cell {

    private char termTexture = '.';

    /**
     * @param pos Array of int containing coordinates (x, y)
     * @param texture String filepath for target's png texture
     */
    public Target(int[] pos, String texture) {
        super(pos, CellsEnum.TARGET, texture, false, false);
    }

    /**
     * @return the character of the {@link sokoban.Engine.Objects.Cell}
     */
    @Override
    public char getTermTexture() {
        return termTexture;
    }
}

package sokoban.Engine.Objects;

import sokoban.CellsEnum;

/**
 * Object representing a sokoban wall
 */
public class Wall extends Cell {

    private char termTexture = '#';

    /** 
     * @param pos Array of int containing coordinates (x, y)
     * @param texture String filepath for wall's png texture
     */
    public Wall(int[] pos, String texture) {
        super(pos, CellsEnum.WALL, texture, true, false);
    }

    /**
     * @return the character of the {@link sokoban.Engine.Objects.Cell}
     */
    @Override
    public char getTermTexture() {
        return termTexture;
    }
}

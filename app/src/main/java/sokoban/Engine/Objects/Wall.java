package sokoban.Engine.Objects;

import sokoban.CellsEnum;

public class Wall extends Cell {

    private char termTexture = '#';

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

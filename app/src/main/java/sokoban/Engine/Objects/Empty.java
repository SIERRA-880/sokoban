package sokoban.Engine.Objects;

import sokoban.CellsEnum;

public class Empty extends Cell {

    private char termTexture = ' ';

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

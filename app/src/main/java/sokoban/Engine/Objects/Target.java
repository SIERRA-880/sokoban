package sokoban.Engine.Objects;

import sokoban.CellsEnum;

public class Target extends Cell {

    private char termTexture = '.';

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

package sokoban.Engine.Objects;

import sokoban.CellsEnum;

public class Box extends MoveableCell {

    private char termTexture = '$';
    
    public Box(int[] pos, String texture) {
        super(pos, CellsEnum.BOX, texture, false, true);
    }

    /**
     * @return the character of the {@link sokoban.Engine.Objects.Cell}
     */
    @Override
    public char getTermTexture() {
        return termTexture;
    }
    
}

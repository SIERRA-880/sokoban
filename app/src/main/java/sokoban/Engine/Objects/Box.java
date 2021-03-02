package sokoban.Engine.Objects;

public class Box extends MoveableCell {

    private char termTexture = '$';
    
    public Box(int[] pos, String texture) {
        super(pos, texture, false, true);
    }

    /**
     * @return the character of the {@link sokoban.Engine.Objects.Cell}
     */
    @Override
    public char getTermTexture() {
        return termTexture;
    }
    
}

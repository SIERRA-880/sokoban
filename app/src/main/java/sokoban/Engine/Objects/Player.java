package sokoban.Engine.Objects;

public class Player extends MoveableCell {
    
    private char termTexture = '@';

    public Player(int[] pos, String texture) {
        super(pos, texture, false, false);
    }

    /**
     * @return the character of the {@link sokoban.Engine.Objects.Cell}
     */
    @Override
    public char getTermTexture() {
        return termTexture;
    }
    
}

package sokoban.Engine.Objects;

public class Box extends MoveableCell {
    
    public Box(int[] pos, String texture) {
        super(pos, texture, false, true);
    }
    
}

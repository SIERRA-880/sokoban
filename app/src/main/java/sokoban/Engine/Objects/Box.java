package sokoban.Engine.Objects;

public class Box extends MoveableCell {
    
    public Box(int[] pos, char texture) {
        super(pos, texture, false, true);
    }
    
}
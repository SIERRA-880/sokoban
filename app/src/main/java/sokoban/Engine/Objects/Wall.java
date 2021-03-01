package sokoban.Engine.Objects;

public class Wall extends Cell {
    
    public Wall(int[] pos, String texture) {
        super(pos, texture, true, false);
    }
}

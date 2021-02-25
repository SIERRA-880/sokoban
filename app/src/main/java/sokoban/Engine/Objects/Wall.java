package sokoban.Engine.Objects;

public class Wall extends Cell {
    
    public Wall(int[] pos, char texture) {
        super(pos, texture, true, false);
    }
}
package Objects;

public class Pointer {
    
    public int[] pos;
    public Cell cell;
    
    public Pointer(Cell cell, int[] pos) {
        this.cell = cell;
        this.pos = pos;
    }
}
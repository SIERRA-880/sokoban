package sokoban.Engine.Objects;

public class MatrixCase {

    Cell cell1;
    Cell cell2;

    public MatrixCase(Cell cell1, Cell cell2) {
        this.cell1 = cell1;
        this.cell2 = cell2;
    }

    public void add(Cell cell) {
        cell1 = cell;
    }

    public void remove() {
        cell1 = cell2;
    }

    public Cell getCell() {
        return cell1;
    }
}

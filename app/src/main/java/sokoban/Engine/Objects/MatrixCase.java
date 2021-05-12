package sokoban.Engine.Objects;

/**
 * Object representing a matrix's case containing 2 {@link sokoban.Engine.Objects.Cell}
 */
public class MatrixCase {

    Cell cell1;
    Cell cell2;

    /**
     * @param cell1 is the {@link sokoban.Engine.Objects.Cell} on top.
     * @param cell2 is the {@link sokoban.Engine.Objects.Cell} on bottom.
     */
    public MatrixCase(Cell cell1, Cell cell2) {
        this.cell1 = cell1;
        this.cell2 = cell2;
    }

    /**
     * @param cell is the new cell on top.
     */
    public void add(Cell cell) {
        cell1 = cell;
    }

    /**
     * copy the bottom cell to the top cell.
     */
    public void remove() {
        cell1 = cell2;
    }

    /**
     * @return the top cell.
     */
    public Cell getCell() {
        return cell1;
    }
}

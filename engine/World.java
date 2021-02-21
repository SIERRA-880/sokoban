import java.util.*;

public class World {

	private int width;
	private int height;
	private Cell[][] cellsArray;
	private Cell[] cellsList;
	
	public World(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void setList(Cell[] list) {
		cellsList = list;
	}

	public Cell[] getList() {
		return cellsList;
	}

	public void setMap(Cell[][] matrix) {
		cellsArray = matrix;
	}
	
	public void printMap() {
		/**This print the matrix cell by cell in the terminal
		 */
		for (int line=0; line<height; line++) {
    	for (int column=0; column<width; column++) {
				System.out.print(cellsArray[line][column].getCellTexture()); 
			}
			System.out.println("");
		}
	}

	public Cell searchCell(int[] pos) {
		return cellsArray[pos[1]][pos[0]];
	}

	public Cell searchBox(int[] pos) {
		return cellsArray[pos[1]][pos[0]];
	}

	public void switchCellsPos(Cell cell1, Cell cell2) {
		int[] save = new int[2];
		save[0] = cell1.getCellPos()[0];
		save[1] = cell1.getCellPos()[1];
		cellsArray[save[1]][save[0]] = cell2;
		cellsArray[cell2.getCellPos()[1]][cell2.getCellPos()[0]] = cell1;
		cell1.setCellPos(cell1.getCellPos());
		cell2.setCellPos(save);
	}

	public boolean winCondition() {
		return false;
	}

	public void upDate() {
		setMap(Builder.build(cellsList, width, height));
	}

	@Override
	public String toString() {
		return Arrays.deepToString(cellsArray); 
	}
	
}

import java.util.*;

public class World {

	private int width;
	private int height;
	private Pointer[][] cellsArray;
	
	public World(int width, int height) {
		this.width = width;
		this.height = height;
		this.cellsArray = new Pointer[height][width];
	}

	public void mkMap(String config) {
		/**This method create a matrix where each value
		 * represents a Cell of the world.
		 */
		int n = 0;
		for (int line=0; line<height; line++) {
			for (int column=0; column<width; column++) {
				int[] pos = {line, column};
				char cellType = config.charAt(n++);
				Cell cell = addCell(cellType,  pos);
				Pointer pointer = new Pointer(cell, cell.getCellPos());
				cellsArray[line][column] = pointer;
			}
		}
	}

	public void printMap() {
		for (int line=0; line<height; line++) {
    	for (int column=0; column<width; column++) {
      	System.out.print(cellsArray[line][column].cell.getCellTexture());
			}
			System.out.println("");
		}
	}

	public Cell addCell(char type, int[] pos) {
		if (type== ' ') {
			return new Cell(pos, ' ', false, false);
		}
		else if (type == '#') {
			return new Wall(pos, '#');
		}
		else {
			return new Cell(pos, '!', false, false);  
		}
	}

	public void mkCell(Cell newCell) {
	}

	public void searchCell(Cell cell) {
	}

	public void update() {
	}

	public boolean winCondition() {
		return false;
	}
	
}

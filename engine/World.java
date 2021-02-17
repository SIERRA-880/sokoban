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

	public void mkMap(String config, Player player) {
		/**This method create a matrix where each value
		 * represents a Cell of the world.
		 * Empty cells and walls are generate with the file's configuration (config)
		 * layer is generate with his pos attribute
		 */
		int n = 0;
		for (int line=0; line<height; line++) {
			for (int column=0; column<width; column++) {
				int[] pos = {line, column};
				char cellType = config.charAt(n++);
				if (pos[0]==player.getCellPos()[0] && pos[1]==player.getCellPos()[1]) {
					Pointer pointer = new Pointer(player, player.getCellPos());
					cellsArray[line][column] = pointer;
				}
				else {
					Cell cell = addCell(cellType,  pos);
					Pointer pointer = new Pointer(cell, cell.getCellPos());
					cellsArray[line][column] = pointer;
				}
			}
		}
	}

	public void printMap() {
		/**This print the matrix cell by cell in the terminal
		 */
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

	public Cell searchCell(int[] pos) {
		return cellsArray[pos[0]][pos[1]].cell;
	}

	public void update(String config, Player player) {
		mkMap(config, player);
		printMap();
	}

	public boolean winCondition() {
		return false;
	}
	
}

import java.util.*;

public class World {

	private int width;
	private int height;
	private Cell[][] cellsArray;
	
	public World(int width, int height) {
		this.width = width;
		this.height = height;
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
		return cellsArray[pos[0]][pos[1]];
	}

	public void update(String config, Player player) {
		setMap(Builder.build(config, player, 10, 10));
		printMap();
	}

	public boolean winCondition() {
		return false;
	}
	
}

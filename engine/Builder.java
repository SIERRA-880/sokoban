
public class Builder {

	public static Cell[][] build(String mapConfig, Player player, int width, int height) {
		/**This method take a file, a player object and dimensions 
		 * to return a matrix where each value is a cell object
		 */
		Cell[][] mapMatrix = new Cell[height][width]; 	
		int n = 0;

		for (int line=0; line<height; line++) {

			for (int column=0; column<width; column++) {
				int[] pos = {column, line};
				char cellType = mapConfig.charAt(n++);
				
				if (line==player.getCellPos()[1] && column==player.getCellPos()[0]) {
					mapMatrix[line][column] = player;
				}
				else if (cellType == ' ') {
					Cell cell = new Cell(pos, ' ', false, false);
					mapMatrix[line][column] = cell;
				}
				else if (cellType == '#') {
					Wall wall = new Wall(pos, '#');
					mapMatrix[line][column] = wall;
				}
				else if (cellType == '.') {
					Target target = new Target(pos, '.');
					mapMatrix[line][column] = target;
				}
				else if (cellType == '$') {
					Box box = new Box(pos, '$');
					mapMatrix[line][column] = box;
				}
				else {
					Cell unknow = new Cell(pos, '!', false, false);
					mapMatrix[line][column] = unknow;
				}
			}
		}
		return mapMatrix;
	}
}

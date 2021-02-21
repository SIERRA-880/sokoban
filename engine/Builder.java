
public class Builder {

	public static Cell[] innit(String mapConfig, Player player, int width, int height) {
		int index = 0;
		
		Cell[] cellsList = new Cell[(width*height)*2];
		
		for (int line=0; line<height; line++) {
			for (int column=0; column<width; column++) {
				int[] pos = {column, line};
				Cell cell = new Cell(pos, ' ', false, false);
				cellsList[index++] = cell;
			}
		}
		int n = 0;
		for (int line=0; line<height; line++) {
			for (int column=0; column<width; column++) {
				char cellType = mapConfig.charAt(n++);
				int[] pos = {column, line};
				if (cellType == ' ') {
					Cell cell = new Cell(pos, ' ', false, false);
					cellsList[index++] = cell;
				}
			}
		}
		n = 0;
		for (int line=0; line<height; line++) {
			for (int column=0; column<width; column++) {
				char cellType = mapConfig.charAt(n++);
				int[] pos = {column, line};
				if (cellType == '.') {
					Target target = new Target(pos, '.');
					cellsList[index++] = target;
				}
			}
		}
		n = 0;
		for (int line=0; line<height; line++) {
			for (int column=0; column<width; column++) {
				char cellType = mapConfig.charAt(n++);
				int[] pos = {column, line};
				if (cellType == '$') {
					Box box = new Box(pos, '$');
					cellsList[index++] = box;
				}
			}
		}
		n = 0;
		for (int line=0; line<height; line++) {
			for (int column=0; column<width; column++) {
				char cellType = mapConfig.charAt(n++);
				int[] pos = {column, line};
				if (cellType == '@') {
					player.setCellPos(pos);
					cellsList[index++] = player;
				}
			}
		}
		n = 0;
		for (int line=0; line<height; line++) {
			for (int column=0; column<width; column++) {
				char cellType = mapConfig.charAt(n++);
				int[] pos = {column, line};
				if (cellType == '#') {
					Wall wall = new Wall(pos, '#');
					cellsList[index++] = wall;
				}
			}
		}
		return cellsList;	
	}

	public static Cell[][] build(Cell[] cellsList, int height, int width) {
		/**This method take a file, a player object and dimensions 
		 * to return a matrix where each value is a cell object
		 */
		Cell[][] mapMatrix = new Cell[height][width]; 	
		for (int n=0; n<cellsList.length; n++) {
			int x = cellsList[n].getCellPos()[0];
			int y = cellsList[n].getCellPos()[1];
			mapMatrix[y][x] = cellsList[n];
		}
		return mapMatrix;
	}

}

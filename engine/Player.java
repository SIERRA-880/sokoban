
public class Player extends Cell {

	public Player(int[] pos, char texture) {
		super(pos, texture, false, false);
	}

	public boolean isMoveable(int[] nextCellPos, World world) {
		Cell nextCell = world.searchCell(nextCellPos);
		if (!nextCell.hardCollision()) {
			return true;
		}
		else {
			return false;
		}
	}

	public void move(char direction, World world) {
		int[] nextPos = new int[2];
		if (direction == 'z') {
			nextPos[0] = getCellPos()[0]-1;
			nextPos[1] = getCellPos()[1];
		}
		else if (direction == 'q') {
			nextPos[0] = getCellPos()[0];
			nextPos[1] = getCellPos()[1]-1;
		}
		else if (direction == 's') {
			nextPos[0] = getCellPos()[0]+1;
			nextPos[1] = getCellPos()[1];
		}
		else if (direction == 'd') {
			nextPos[0] = getCellPos()[0];
			nextPos[1] = getCellPos()[1]+1;
		}
		if (isMoveable(nextPos, world)) {
			setCellPos(nextPos);
		}
		System.out.println("Player position : " + getCellPos()[0] + getCellPos()[1]);
	}
}

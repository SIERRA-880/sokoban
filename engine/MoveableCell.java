
public class MoveableCell extends Cell {

	public MoveableCell(int[]  pos, char texture, boolean hardCollision, boolean softCollision) {
		super(pos, texture, hardCollision, softCollision);	
	}
	public boolean isMoveable(char direction, World world) {
		int[] nextPos = getNextPos(direction);
		Cell nextCell;
		if (world.searchCell(nextPos) instanceof Box) {
			nextCell = world.searchBox(nextPos);
		}
		else {
			nextCell = world.searchCell(nextPos);
		}

		if (nextCell.hardCollision()) {
			return false;
		}
		else if (nextCell.softCollision()) {
			int[] nextNextPos = nextCell.getNextPos(direction);
			Cell nextNextCell = world.searchCell(nextNextPos);
			if (nextNextCell.hardCollision() || nextNextCell.softCollision()) {
				return false;
			}
			else {
				nextCell.setCellPos(nextNextPos);
				return true;
			}
		}
		else {
			return true;
		}
	}

	public void move(char direction, World world) {
		if (isMoveable(direction, world)) {
			int[] nextPos = getNextPos(direction);
			setCellPos(nextPos);
			System.out.println(this);
		}
	}
}

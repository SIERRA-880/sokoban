
public class Player extends Cell {

	public Player(int[] pos, String texture) {
		super(pos, texture, false, false);
	}

	public boolean isMoveable(Cell nextCell) {
		return true;
	}

	public void move(int[] nextCasePos, World world) {
	}
}

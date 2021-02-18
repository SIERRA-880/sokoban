
public class Player extends MoveableCell {

	public Player(int[] pos, char texture) {
		super(pos, texture, false, false);
	}

	public void move(char direction, World world) {
		/**This method will first search the position of the cell where the
		 * player want to move and check if the cell is free or not.
		 * Then it will change the player's position 
		 */
		int[] nextPos = new int[2];
		if (direction == 'z') {
			nextPos[0] = getCellPos()[0];
			nextPos[1] = getCellPos()[1]-1;
		}
		else if (direction == 'q') {
			nextPos[0] = getCellPos()[0]-1;
			nextPos[1] = getCellPos()[1];
		}
		else if (direction == 's') {
			nextPos[0] = getCellPos()[0];
			nextPos[1] = getCellPos()[1]+1;
		}
		else if (direction == 'd') {
			nextPos[0] = getCellPos()[0]+1;
			nextPos[1] = getCellPos()[1];
		}
		if (isMoveable(nextPos, world)) {
			setCellPos(nextPos);
		}
	}
}

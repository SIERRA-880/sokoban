
public class Box extends Cell {

	public Box(int[] pos, char texture) {
		super(pos, texture, false, true);
	}

	public boolean isMoveable(int[] nextCasePos, World world) {
		return false;
		 	
	}
}

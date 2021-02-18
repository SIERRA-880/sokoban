
public class MoveableCell extends Cell {

	public MoveableCell(int[]  pos, char texture, boolean hardCollision, boolean softCollision) {
		super(pos, texture, hardCollision, softCollision);	
	}
	
	public boolean isMoveable(int[] nextCellPos, World world) {
		if (!world.searchCell(nextCellPos).hardCollision()) {
			return true;
		}
		else {
			return false;
		}
	}	
	
}

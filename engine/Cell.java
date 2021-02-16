
public class Cell {
	
	private int[] pos;
	private char texture;
	private boolean hardCollision;
	private boolean softCollision;

	public Cell(int[] pos, char texture, boolean hardCollision, boolean softCollision) {
		this.pos = pos;
		this.texture = texture;	
		this.hardCollision = hardCollision;
		this.softCollision = softCollision;

	}

	public int[] getCellPos() {
		return pos;
	}

	public char getCellTexture() {
		return texture;
	}

	public boolean hardCollision() {
		return hardCollision;
	}

	public boolean softCollision() {
		return softCollision;
	}
}

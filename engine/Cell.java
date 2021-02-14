
public class Cell {
	
	private int[] pos;
	private String texture;
	private boolean hardCollision;
	private boolean softCollision;

	public Cell(int[] pos, String texture, boolean hardCollision, boolean softCollision) {
		this.pos = pos;
		this.texture = texture;	
		this.hardCollision = hardCollision;
		this.softCollision = softCollision;

	}

	public int[] getCellPos() {
		return pos;
	}

	public String getCellTexture() {
		return texture;
	}

	public boolean hardCollision() {
		return hardCollision;
	}

	public boolean softCollision() {
		return softCollision;
	}
}

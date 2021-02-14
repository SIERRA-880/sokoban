
public class Game {

	public static void main(String[] args) {
		int[] pos = {1, 1};
		Player player = new Player(pos, "X");
		System.out.println(player.texture);
		System.out.println(player.pos[0] + " " + player.pos[1]);	
	}

}

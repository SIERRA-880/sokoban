
public class Game {
	public static String map = "###########        ## # ## # ##    #   ##        ## #   # ###  #     ##     # ### #     ############";

	public static void main(String[] args) {
		World world = new World(10, 10);
		world.mkMap(map);
		world.printMap();
	}

}

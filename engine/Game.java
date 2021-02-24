import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		//String map = "########### .   .  ## # ## # ## $  #   ## $ $    ## #   # ### @#     ## . $ #.### #     ############";
		String map;
		if (args.length > 0) {
			map = MapLoader.load(args[0]);
		}
		else {
			map = MapLoader.load("map1.txt");
		}

		int[] pos = {0, 0};
		Player player = new Player(pos, '@');

		World world = new World(10, 10, player);
		world.setList(Builder.innit(map, player, 10, 10));
		world.setMap(Builder.build(world.getList(), 10, 10));

		Scanner input = new Scanner(System.in);
		boolean replay = true;
		while (replay) {
			world.upDate();
			world.printMap();
			char direction = input.next().charAt(0);
			switch (direction) {
				case 'z' : player.move(direction, world); 
									 break;
				case 'q' : player.move(direction, world);
									 break;
				case 's' : player.move(direction, world);
									 break;
				case 'd' : player.move(direction, world);
									 break;
				case '1' : world.mapChanger("map1.txt");
									 break;
				case '2' : world.mapChanger("map2.txt");
									 break;
				case '!' : replay=false;
								   break;
					
				default : System.out.println("Give a correct direction please.");
									break;
			}
		}
	}
}

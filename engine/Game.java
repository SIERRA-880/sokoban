import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		String map = "########### .   .  ## # ## # ## $  #   ## $ $    ## #   # ### @#     ## . $ #.### #     ############";

		int[] pos = {0, 0};
		Player player = new Player(pos, '@');

		World world = new World(10, 10);
		world.setList(Builder.innit(map, player, 10, 10));
		world.setMap(Builder.build(world.getList(), 10, 10));
		world.printMap();

		Scanner input = new Scanner(System.in);
		boolean replay = true;
		while (replay) {
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
				case '!' : replay=false;
								   break;
					
				default : System.out.println("Give a correct direction please.");
									break;
			}
			world.upDate();
			world.printMap();
		}
	}
}

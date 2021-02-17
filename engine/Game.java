import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		String map = "###########        ## # ## # ##    #   ##        ## #   # ###  #     ##     # ### #     ############";
		int[] pos = {1, 1};
		char texture = '@';
		Player player = new Player(pos, texture);
		World world = new World(10, 10);
		world.mkMap(map, player);
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
			world.update(map, player);
		}
	}

	/*
	public void mainLoop() {
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
						
				default : System.out.println("Give a correct direction please.");
									 break;
			}
		}
	}*/

}

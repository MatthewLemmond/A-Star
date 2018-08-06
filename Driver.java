
import java.util.Random;
import java.util.Scanner;

public class Driver {
	private static Random rand = new Random();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Game game;
		int startX;
		int startY;
		int goalX;
		int goalY;
		if(args.length == 4) {
			startX = Integer.parseInt(args[0]);
			startY = Integer.parseInt(args[1]);
			goalX = Integer.parseInt(args[2]);
			goalY = Integer.parseInt(args[3]);
			if(boundCheck(startX, startY, goalX, goalY)) {
				game = new Game(startX, startY, goalX, goalY);
			}
			else {
				System.out.println("Enter 4 space separated integers from 0 to " + (Game.BOARD_HEIGHT - 1)
						+ "\nOR\nEnter -1 to have the game randomly generate a board:");
				int input = -1;
				input = scanner.nextInt();
				if(input != -1) {
					startX = input;
					startY = scanner.nextInt();
					goalX = scanner.nextInt();
					goalY = scanner.nextInt();
				}
				if (boundCheck(startX, startY, goalX, goalY)){
					game = new Game(startX,startY,goalX,goalY);
				}
				else {
					game = generateRandomGame(false, false);
				}
			}
		}
		else {
			game = generateRandomGame(false, true);
		}
		game.printBoard();
		AStarSearch.findPath(game);
		game.printBoard();
	}

	private static boolean boundCheck(int startX, int startY, int goalX, int goalY) {
		return !(startX >= Game.BOARD_HEIGHT || startY >= Game.BOARD_WIDTH 
				|| goalX >= Game.BOARD_HEIGHT || goalY > Game.BOARD_WIDTH);
	}
	
	private static Game generateRandomGame(boolean wrongBounds, boolean printMessage) {
		if(printMessage) {
			if(wrongBounds) {
				System.out.println("One of your arguments supplied is out of bounds,"
						+ "\nPlease check your arguments and try again.");
			}
			else {
				System.out.println("Please supply 4 Integer arguments from 0 to 14:"
						+ "\nStartX, StartY, GoalX, GoalY.");
			}
		}
		System.out.println("Now generating random start and goal positions...");
		Game temp = new Game(new Node(rand.nextInt(Game.BOARD_HEIGHT), rand.nextInt(Game.BOARD_WIDTH), true, false, false),
				new Node(rand.nextInt(Game.BOARD_HEIGHT), rand.nextInt(Game.BOARD_WIDTH), false, true, false));
		return temp;
	}

}

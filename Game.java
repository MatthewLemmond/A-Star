import java.util.ArrayList;

public class Game {

	/* PRIVATE FIELDS */
	final static public int BOARD_WIDTH = 15;
	final static public int BOARD_HEIGHT = 15;
	private Node[][] board = new Node[BOARD_HEIGHT][BOARD_WIDTH];
	private Node start;
	private Node goal;
	private int startX;
	private int startY;
	private int goalX;
	private int goalY;

	public Game(int startX, int startY, int goalX, int goalY) {
		this.setStartX(startX);
		this.setStartY(startY);
		this.setGoalX(goalX);
		this.setGoalY(goalY);
		setStart(new Node(startX, startY, true, false, false));
		setGoal(new Node(goalX, goalY, false, true, false));
		generateBoard();
		for(Node[] arr : board) {
			for(Node n : arr) {
				n.calcDistToStart(startX, startY);
				n.calcDistToGoal(goalX, goalY);
			}
		}
	}
	
	public Game(Node start, Node goal) {
		setStart(start);
		setGoal(goal);
		startX = start.getX();
		startY = start.getY();
		goalX = goal.getX();
		goalY = goal.getY();
		generateBoard();
		for(Node[] arr : board) {
			for(Node n : arr) {
				n.calcDistToStart(startX, startY);
				n.calcDistToGoal(goalX, goalY);
			}
		}
	}

	public void generateBoard() {
		for(int i = 0; i < BOARD_HEIGHT; i++) {
			for(int j = 0; j < BOARD_WIDTH; j++) {
				board[i][j] = new Node(j, i, isStart(i,j), isGoal(i,j), isBlocked(i,j));
				board[i][j].calcDistToGoal(goalX, goalY);
			}
		}
	}

	/* GETTERS AND SETTERS */
	public Node getStart() {
		return getAtIndex(getStartX(), getStartY());
	}
	
	public void setStart(Node start) {
		this.start = start;
	}
	
	public Node getGoal() {
		return getAtIndex(getGoalX(), getGoalY());
	}
	
	public void setGoal(Node goal) {
		this.goal = goal;
	}
	
	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getGoalX() {
		return goalX;
	}

	public void setGoalX(int goalX) {
		this.goalX = goalX;
	}

	public int getGoalY() {
		return goalY;
	}

	public void setGoalY(int goalY) {
		this.goalY = goalY;
	}

	public Node getAtIndex(int i, int j) {
		if(i >= BOARD_HEIGHT || j >= BOARD_WIDTH)
			return null;
		return board[i][j];
	}

	public void printBoard() {
		for(int i = 0; i < BOARD_HEIGHT; i++) {
			System.out.print("[");
			for(int j = 0; j < BOARD_WIDTH; j++) {
				System.out.print(getAtIndex(i,j));
			}
			System.out.println("]");
		}
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		for(int i = 0; i < BOARD_HEIGHT; i++) {
			buf.append("[");
			for(int j = 0; j < BOARD_WIDTH; j++) {
				buf.append(getAtIndex(i,j));
			}
			buf.append("]\n");
		}
		return buf.toString();
	}
	
	public ArrayList<Node> getNeighbors(Node node) {
		ArrayList<Node> temp = new ArrayList<>();
		if(node.getX() > 0) {
			temp.add(getAtIndex(node.getX()-1, node.getY()));
		}
		if(node.getY() > 0) {
			temp.add(getAtIndex(node.getX(), node.getY()-1));
		}
		if(node.getX() < 14) {
			temp.add(getAtIndex(node.getX()+1, node.getY()));
		}
		if(node.getY() < 14) {
			temp.add(getAtIndex(node.getX(), node.getY()+1));
		}
		return temp;
	}

	/* PRIVATE HELPER METHODS */
	private boolean isStart(int i, int j) {
		return (getStartX() == i && getStartY() == j);
	}

	private boolean isGoal(int i, int j) {
		return (getGoalX() == i && getGoalY() == j);
	}
	
	private boolean isBlocked(int i, int j) {
		return Math.random() <= .1 && !isStart(i,j) && !isGoal(i,j);
	}

}

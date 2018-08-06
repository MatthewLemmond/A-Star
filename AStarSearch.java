import java.util.ArrayList;
import java.util.PriorityQueue;

public class AStarSearch {
	
	public static ArrayList<Node> findPath(Game game) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(10, new AStarComparator());
		ArrayList<Node> visited = new ArrayList<>();
		frontier.add(game.getStart());
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.isGoal()) {
				System.out.println("Path Found!");
				return visited;
			}
			for(Node n : game.getNeighbors(current)) {
				if(!n.isBlocked())
					frontier.add(n);
			}
			visited.add(current);
		}
		System.out.println("No Path Found...");
		return visited;
	}
}

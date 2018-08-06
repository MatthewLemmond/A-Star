import java.util.Comparator;

public class AStarComparator implements Comparator<Node> {

	@Override
	public int compare(Node arg0, Node arg1) {
		return (arg0.getDistToStart() + arg0.getDistToGoal()) - (arg1.getDistToStart() + arg1.getDistToGoal());
	}

}

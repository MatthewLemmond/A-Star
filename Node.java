
public class Node {
	/* PRIVATE FIELDS */
	private int x;
	private int y;
	private boolean isStart;
	private boolean isGoal;
	private boolean isBlocked;
	private boolean isPath;
	private int distToStart;
	private int distToGoal;
	
	public Node(int x, int y, boolean isStart, boolean isGoal, boolean isBlocked) {
		this.setX(x);
		this.setY(y);
		this.setStart(isStart);
		this.setGoal(isGoal);
		this.setBlock(isBlocked);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	public boolean isGoal() {
		return isGoal;
	}

	public void setGoal(boolean isGoal) {
		this.isGoal = isGoal;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlock(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
	public boolean isPath() {
		return isPath;
	}
	
	public void setPath(boolean isPath) {
		this.isPath = isPath;
	}
	
	public int getDistToStart() {
		return distToStart;
	}
	
	public void calcDistToStart(int startX, int startY) {
		distToStart = Math.abs(this.getX() - startX) + Math.abs(this.getY() - startY);
	}
	
	public int getDistToGoal() {
		return distToGoal;
	}
	
	public void calcDistToGoal(int goalX, int goalY) {
		this.distToGoal = Math.abs(this.getX() - goalX) + Math.abs(this.getY() - goalY);
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		if(isStart) {
			buf.append(" S ");
		}
		else if(isGoal) {
			buf.append(" G ");
		}
		else if(isBlocked) {
			buf.append(" X ");
		}
		else if(isPath) {
			buf.append(" + ");
		}
		else {
			buf.append(" - ");
		}
		return buf.toString();
	}
}

package toCheckIfGivenFourPointsFormASquare;

public class Point implements Comparable<Point>{
	private int x;
	private int y;
	
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
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

	@Override
	public int compareTo(Point o) {
		if (this.x == o.x && this.y == o.y) return 0;
		else if (this.x < o.x && this.y < o.y) return -1;
		else return 1;
	}
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}
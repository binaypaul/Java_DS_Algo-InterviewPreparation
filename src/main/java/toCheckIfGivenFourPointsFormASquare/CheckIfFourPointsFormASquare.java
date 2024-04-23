package toCheckIfGivenFourPointsFormASquare;

public class CheckIfFourPointsFormASquare {
	public boolean isSquare(Point ...points) {
		boolean isSquare = false;
		int la = 0, lb = 0, lc = 0;
		Point a = null, aX = null, aY = null, aXY = null;
		if (points.length == 4) {
			outer: for (int i = 0; i < 4 ; i++) {
				System.out.println("points[i]: " + points[i].toString());
				Point tempAX = null, tempAY = null;
				for (int j = 0; j < 4 ; j++) {
					if (i != j) {
						System.out.println("points[j]: " + points[j].toString());
						if (points[i].getX() != points[j].getX() && points[i].getY() == points[j].getY()) {
							la = points[i].getX() - points[j].getX();
							la = (la < 0) ? la * -1 : la;
							tempAX = points[j];
						} else if (points[i].getX() == points[j].getX() && points[i].getY() != points[j].getY()) {
							lc = points[i].getY() - points[j].getY();
							lc = (lc < 0) ? lc * -1 : lc;
							tempAY = points[j];
						}
						if (la == lc && la != 0) {
							lb = (int) Math.sqrt(Math.pow(la, 2) + Math.pow(lc, 2));
							a = points[i];
							aX = tempAX;
							aY = tempAY;
							break outer;
						}
					}
				}
			}
		if (a != null && aX != null && aY != null) {
			for (Point point : points) {
				if (!(point.equals(a)||point.equals(aX)||point.equals(aY))) {
					aXY = point;
					break;
				}
			}
			if (aXY != null) {
				if (aXY.getX() != aY.getX() && aXY.getY() == aY.getY()) {
					la = aXY.getX() - aY.getX();
					la = (la < 0) ? la * -1 : la;
				} else if (aXY.getY() != aX.getY() && aXY.getX() == aX.getX()) {
					lc = aXY.getY() - aY.getY();
					lc = (lc < 0) ? lc * -1 : lc;
				}
				if (la == lc) {
					int lb1 = (int) Math.sqrt(Math.pow(la, 2) + Math.pow(lc, 2));
					if (lb == lb1) {
						isSquare = true;
					}
				}
			}
		}
		}
		return isSquare;
	}
	
	public static void main(String[] args) {
		Point a = new Point (22, 12);
		Point aX = new Point (12, 22);
		Point aXY = new Point (22,22);
		Point aY = new Point (12,12);
		System.out.println("Square formed by the points: " + new CheckIfFourPointsFormASquare().isSquare(a,aXY,aX,aY));
	}
}

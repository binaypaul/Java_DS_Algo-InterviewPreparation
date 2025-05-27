package DataStructure.Concepts.Matrix;

/* You are an avid rock collector who lives in southern California. Some rare and desirable rocks just became available in New York, so you are planning a cross-country road trip. There are several other rare rocks that you could pick up along the way. You have been given a grid filled with numbers, representing the number of rare rocks available in various cities across the country. Your objective is to find the optimal path from So_Cal to New_York that would allow you to accumulate the most rocks along the way.

Note.txt: You can only travel either north (up) or east (right).
b) Consider adding some additional tests in doTestsPass().
c) Implement optimalPath() correctly.
d) Here is an example:
^
{{0, 0, 0, 0, 5}, New_York (finish) N
{0, 1, 1, 1, 0},
So_Cal (start) {2, 0, 0, 0, 0}} S
v
The total for this example would be 10 (2+0+1+1+1+0+5).	*/
public class AvidRockCollectorProblem {

	public static void main(String[] args) {
		Integer[][] grid= new Integer[][]	{{0, 0, 0, 0, 5},						//N
											 {0, 1, 1, 1, 0},					//W		//E
											 {2, 0, 0, 0, 0}};						//S
		findOptimalPath(grid);
	}
	
	public static void findOptimalPath(Integer[][] grid) {
		AvidRockCollector avidRockCollector = new AvidRockCollector(grid);
	}

}

class AvidRockCollector {
	private Integer [][] grid;
	private int outerArrLength, innerArrLength, upIndex;
	public AvidRockCollector(Integer [][] grid) {
		this.grid = grid;
		this.outerArrLength = grid.length;
		this.innerArrLength = grid[0].length;
		this.upIndex = outerArrLength-1;
	}
	private int sum = 0, rightIndex = 0;
	
	public int findPath() {
		goUp();
		goUp();
		System.out.println("final: ");
		printGrid();
		return sum;
	}
	
	private void goUp() {
		System.out.println("In goUp");
		System.out.println("-======================================================");
		System.out.println("1) upIndex:" + upIndex + ", rightIndex:" + rightIndex + ". value: " + grid[upIndex][rightIndex]);
		printGrid();
		System.out.println();
		sum = sum + grid[upIndex][rightIndex];
		System.out.println("sum: " + sum);
		System.out.println("-======================================================");
		if(upIndex-1 >=0 && grid[upIndex-1][rightIndex] != null) {
			System.out.println("In goUp, in if");
			upIndex--;
			goUp();
		} else {
			System.out.println("In goUp, in else");
			grid[upIndex][rightIndex] = null;
			if(rightIndex+1 <= innerArrLength-1) {
				rightIndex++;
				goRight();
			}
		}
	}
	
	private void goRight() {
		System.out.println("In goRight");
		System.out.println("-======================================================");
		System.out.println("2) upIndex:" + upIndex + ", rightIndex:" + rightIndex + ". value: " + grid[upIndex][rightIndex]);
		printGrid();
		System.out.println();
		sum = sum + grid[upIndex][rightIndex];
		System.out.println("sum: " + sum);
		System.out.println("-======================================================");
		if(upIndex-1 >=0 && grid[upIndex-1][rightIndex] != null) {
			System.out.println("In goRight, in if");
			upIndex--;
			goUp();
		} else {
			System.out.println("In goRight, in else");
//			grid[upIndex][rightIndex] = null;
			if(rightIndex+1 <= innerArrLength-1) {
				rightIndex++;
				goRight();
			}
		}
	}
	
	public void printGrid() {
		for (Integer[] integers : grid) {
			System.out.println();
			for (Integer integers2 : integers) {
				System.out.print(integers2 + ", ");
			}
		}
	}
}
package Concepts.Polymorphism;

public class MethodOverloading {

}

class MethodOverLoadingTester {
	public int add() {
		return 1;
	}
	
//	public float add() {	//error, as having different return type doesn't cause method overloading.
//		return 1.0f;
//	}
	
	public int add(int x) {
		return x;
	}
	
	public int add(float x) {	//parameter with different type cause method overloading.
		int y = (int) x;
		return y;
	}
	
	public int add(int x, int y) {	//different number/count of parameter cause method overloading.
		return x + y;
	}
}
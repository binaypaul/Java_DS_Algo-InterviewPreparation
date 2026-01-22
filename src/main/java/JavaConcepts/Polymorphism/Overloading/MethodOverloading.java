package JavaConcepts.Polymorphism.Overloading;

public class MethodOverloading {
	public int add() {
		return 1;
	}
    //! error, as having different return type doesn't cause method overloading.
//	public float add(int x) {
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
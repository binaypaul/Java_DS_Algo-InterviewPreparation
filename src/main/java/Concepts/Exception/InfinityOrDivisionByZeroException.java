package Concepts.Exception;

public class InfinityOrDivisionByZeroException {

	public static void main(String[] args) {
		DivisionByZero d = new DivisionByZero();
		d.doubleDivisionByZero();
		System.out.println();
		d.intDivisionByZero();
	}

}

class DivisionByZero {
	public void intDivisionByZero() {
		final int i = Integer.MAX_VALUE;
		int x = i/0;
		System.out.println(x);
	}
	
	public void doubleDivisionByZero() {
		final double d = Double.MAX_VALUE;
		double infi = d/0;
		System.out.println(infi);
	}
}
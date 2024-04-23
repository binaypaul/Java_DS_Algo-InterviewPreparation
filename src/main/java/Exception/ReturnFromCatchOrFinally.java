package Exception;

public class ReturnFromCatchOrFinally {

	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.divisionByZero());
		
	}

}
class A {
	public int divisionByZero() {
		try {
			System.out.println("In try");
			int x = 10/0;
			System.exit(0);
			return 1;
		} catch (ArithmeticException e) {
			e.getMessage();
			System.out.println("In catch");
			System.exit(0);
			return 2;
		} finally {
			System.out.println("In finally");
			System.exit(0);
			return 3;
		}
	}
}
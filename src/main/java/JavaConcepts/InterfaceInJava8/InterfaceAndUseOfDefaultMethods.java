package JavaConcepts.InterfaceInJava8;

public class InterfaceAndUseOfDefaultMethods implements A, B{
	public static void main(String[] args) {
		InterfaceAndUseOfDefaultMethods i = new InterfaceAndUseOfDefaultMethods();
		i.call();
		i.add();	//call to overridden add() in this class
		i.addA();	//call to addA() in A
		i.addB();	//call to addB() in B
		A.staticMethod();
		B.staticMethod();
		staticMethod();
	}
	
	static void staticMethod() {
		System.out.println("In InterfaceAndUseOfDefaultMethods staticMethod");
	}
	
	public void call() {
		A.super.addA();	//call to addA() in A
		B.super.addB();	//call to addB() in B
		A.super.add();	//call to add() in A
	}
	
	@Override
	public void add() {
		B.super.add();	//call to add() in B
	}
}

interface A {
	default void add() {
		System.out.println("In A add");
	}
	
	default void addA() {
		System.out.println("In A addA");
	}
	
	static void staticMethod() {
		System.out.println("In A staticMethod");
	}
}

interface B {
	default void add() {
		System.out.println("In B add");
	}

	default void addB() {
		System.out.println("In B addB");
	}
	
	static void staticMethod() {
		System.out.println("In B staticMethod");
	}
}